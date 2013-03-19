db.users.remove();

db.users.insert([
	{firstName:"Martin",lastName:"Komora",birthDate:new Date("Jan 31, 1990"),gender:0,credit:40,email:"eva.ottova@test.test",password:hex_md5("komorakomora75"), username:"komora", photoUrl: "/assets/images/martin.jpg"}
	,{firstName:"Matej",lastName:"Rendek",birthDate:new Date("Jan 31, 1990"),gender:0,credit:40,email:"anna.read@test.test",password:hex_md5("rendekrendek19"), username:"rendek", photoUrl: "/assets/images/matej.jpg"}
	,{firstName:"Milan",lastName:"Šemelák",birthDate:new Date("Jan 31, 1990"),gender:0,credit:40,email:"martin.odersky@test.test",password:hex_md5("semelaksemelak61"), username:"semelak", photoUrl: "/assets/images/milan.jpg"}
	,{firstName:"Marek",lastName:"Čemez",birthDate:new Date("Jan 31, 1990"),gender:0,credit:40,email:"gavin.menzies@test.test",password:hex_md5("cemezcemez49"), username:"cemez"}
	,{firstName:"Vladimír",lastName:"Krajčovič",birthDate:new Date("Jan 31, 1990"),gender:0,credit:40,email:"fero.sebej@test.test",password:hex_md5("krajcovickrajcovic22"), username:"krajcovic", photoUrl: "/assets/images/vlado.jpg"}
	,{firstName:"Roman",lastName:"Babuščák",birthDate:new Date("Jan 31, 1990"),gender:0,credit:40,email:"gao.yun@test.test",password:hex_md5("romanroman30"), username:"roman", photoUrl: "/assets/images/roman-babuscak.jpg"}
	,{firstName:"Tatiana",lastName:"Takančíková",birthDate:new Date("Jan 31, 1991"),gender:1,credit:40,email:"rudo.moric@test.test",password:hex_md5("tanatana51"), username:"tana", photoUrl: "/assets/images/tatiana.jpg"}
]);