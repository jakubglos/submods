db.pubs.remove();

var drinks = db.drinks.find();

db.pubs.insert([
	{drinks:[drinks[0]["_id"],drinks[1]["_id"],drinks[2]["_id"],drinks[3]["_id"],drinks[4]["_id"]],name:"Antinori",street:"Ventúrska",number:"14",city:"Bratislava",telephone:["+421 917 676 000"],web:"www.antinori.sk",loc:[48.1430423,17.106588200000033],photoUrl:"/assets/images/pub/antinori.png",photoUrlBig:"/assets/images/pub/antinoriB.png"}
	,{drinks:[drinks[0]["_id"],drinks[1]["_id"],drinks[2]["_id"],drinks[3]["_id"],drinks[4]["_id"]],name:"Lochness",street:"Sedlárska",number:"4",city:"Bratislava",telephone:["+421 918 246 623"],web:"www.lochnesspub.sk",loc:[48.1436943,17.10689160000004],photoUrl:"/assets/images/pub/lochness.png",photoUrlBig:"/assets/images/pub/lochnessB.png"}
	,{drinks:[drinks[0]["_id"],drinks[1]["_id"],drinks[2]["_id"],drinks[3]["_id"],drinks[4]["_id"]],name:"Infinity rock cafe",street:"Michalská",number:"9",city:"Bratislava",telephone:["+421 902 160 060"],web:"www.musicbar.sk",loc:[48.1447345,17.106661799999983],photoUrl:"/assets/images/pub/infiniti.png",photoUrlBig:"/assets/images/pub/infinitiB.png"}
	,{drinks:[drinks[0]["_id"],drinks[1]["_id"],drinks[2]["_id"],drinks[3]["_id"],drinks[4]["_id"]],name:"Sky bar",street:"Hviezdoslavovo nám.",number:"7",city:"Bratislava",telephone:["+421 2 5441 1244"],web:"www.skybar.sk",loc:[48.1411786,17.10726299999999],photoUrl:"/assets/images/pub/sky.png",photoUrlBig:"/assets/images/pub/skyB.png"}
])

db.pubs.ensureIndex({loc : "2d"});