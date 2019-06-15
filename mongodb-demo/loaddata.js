for(var i = 0;i<100000;i++){
	db.users.insert(
		{
			"name"  : "user"+i,
			"created" : new Date()
		}
	);
}

