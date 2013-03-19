// Pubs geospatial index
db.pubs.ensureIndex ( { loc : "2d" } );

// Unique indexes

// Search indexes
// TODO: verify consistency
db.users.ensureIndex ( { username : 1, firstName : 1, lastName : 1, gender : 1, birthDate : 1 } ); // dobuducna
db.pubs.ensureIndex ( { name : 1, city : 1, street : 1, number : 1 } ); // dobuducna
db.feeds.ensureIndex ( { created : -1, userId : 1, feedType : 1 } );
db.checkins.ensureIndex ( { created : -1, userId : 1, pubId : 1, state : 1 } );
db.pubActions.ensureIndex ( { validFrom : -1, validTo : -1, pubId : 1 } );
db.drinks.ensureIndex ( { name : 1, drinkType : 1, price : 1 } );
db.vouchers.ensureIndex ( { toUserId : 1, drinkId : 1, consumedTime : 1, validUntil : 1 } );
db.userDevices.ensureIndex ( { userId : 1 } );
