package fr.eql.ai110.laserre.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai110.laserre.idao.GenericIDAO;

public abstract class GenericDAO<T> implements GenericIDAO<T> {
	
	@PersistenceContext(unitName = "LaSerreParisPU")  
	protected EntityManager em;
	
	public T add(T t) {
		em.persist(t);
		return t;
	}
	
	public boolean delete(T t) {
		boolean isRemoved;
		try {
			t = em.merge(t);
			em.remove(t);
			isRemoved = true;
		} catch (Exception e) {
			e.printStackTrace();
			isRemoved = false;
		}
		return isRemoved;
	}

	public T update(T t) {
		em.merge(t);
		return t;
	}
	
	public T getById(int id) {
		T t = null;
		try {
		String className= ((ParameterizedType) getClass().
		getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
		Class<?> clazz;
		clazz = Class.forName(className);
		t = (T) em.find(clazz, id);
		}catch (Exception e) {
		e.printStackTrace();
		}
		return t;
	}
	
	public List<T> getAll() {
		List<T> objects = null;
		try {
		String className= ((ParameterizedType) getClass().
		getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
		Class<?> clazz;
		clazz = Class.forName(className);
		Query query = em.createQuery("FROM " + clazz.getName());
		objects = query.getResultList();
		}catch (Exception e) {
		e.printStackTrace();
		}
		return objects;
	}
}
