package fr.eql.ai110.laserre.idao;

import java.util.List;

public interface GenericIDAO<T> {

	T add(T t);
	boolean delete(T t);
	T update(T t);
	T getById(int id);
	List<T> getAll();
	
}
