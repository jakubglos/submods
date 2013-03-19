db.pubActions.remove();

/*var pubs = db.pubs.find();
pubs.forEach( function(pub) {
	db.pubActions.insert([
		{name:"Mega akcia",description:"Všetko zadarmo!",validFrom:new Date("Feb 1, 2013"),validTo:new Date("Apr 3, 2013"),pubId:pub["_id"],validDate:new Date("Apr 2, 2013"),logo:"/assets/images/actionImage.jpg"},
		{name:"Neplatna akcia",description:"Všetko zadarmo!",validFrom:new Date("Feb 1, 2012"),validTo:new Date("Apr 3, 2012"),pubId:pub["_id"],validDate:new Date("Apr 2, 2012"),logo:"/assets/images/actionImage.jpg"}
	]);
});*/

var pubs = db.pubs.find();

pubs.forEach( function(pub) {
	switch(pub["name"]) {
		case "Antinori":
			db.pubActions.insert([
				{name:"AKCIA",description:"Tento týždeň akcia Jameson 2€!",validFrom:new Date("Feb 1, 2013"),validTo:new Date("Apr 3, 2013"),pubId:pub["_id"],validDate:new Date("Apr 2, 2013"),logo:"/assets/images/actionImage.jpg"}
			]);
			break;
		case "Lochness":
			db.pubActions.insert([
				{name:"AKCIA",description:"K 1+1 Becherovka zdarma!",validFrom:new Date("Feb 1, 2013"),validTo:new Date("Apr 3, 2013"),pubId:pub["_id"],validDate:new Date("Apr 2, 2013"),logo:"/assets/images/actionImage.jpg"}
			]);
			break;
		case "Infinity rock cafe":
			db.pubActions.insert([
				{name:"AKCIA",description:"3 + 1 Absolut vodka gratis!",validFrom:new Date("Feb 1, 2013"),validTo:new Date("Apr 3, 2013"),pubId:pub["_id"],validDate:new Date("Apr 2, 2013"),logo:"/assets/images/actionImage.jpg"}
			]);
			break;
		case "Sky bar":
			db.pubActions.insert([
				{name:"AKCIA",description:"Absolut vodka dnes len za 2,10€!",validFrom:new Date("Feb 1, 2013"),validTo:new Date("Apr 3, 2013"),pubId:pub["_id"],validDate:new Date("Apr 2, 2013"),logo:"/assets/images/actionImage.jpg"}
			]);
			break;
	}
});