function calculateTotalPointsUsed() {
	return Array.from(document.querySelectorAll(".harvest-calculator")).map((node)=>{
   		const nb = node.querySelector(".badge").innerHTML;
    	const points = node.querySelector("h5").dataset.points;
    	return nb*points;
		}).reduce((a,b)=> a+b,0)
}

function calculateHarvest() {
	const display = document.querySelector("#harvest-result");
	const totalPoints = document.querySelector("#total-points");
	console.log(totalPoints)
	display.innerHTML = totalPoints.innerHTML - calculateTotalPointsUsed();

}
