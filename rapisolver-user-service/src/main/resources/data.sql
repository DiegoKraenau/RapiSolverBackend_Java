INSERT INTO roles(id, can_publish, name )
VALUES (1, false , 'CUSTOMER');

INSERT INTO roles(id, can_publish, name)
VALUES (2, false , 'SUPPLIER');

INSERT INTO locations(id,address,city,state,country)
VALUES (1,'Jr Monte Algarrobo 102','Surco','Lima','Peru');

INSERT INTO locations(id,address,city,state,country)
VALUES (2,'Jr El Sol 365','Lince','Lima','Peru');

INSERT INTO users(id,user_type,birthdate,email,first_name,last_name,password,phone,random_column,comercial_name,role_id,location_id)
VALUES (1,'CUSTOMER','2000-08-20','jesus@gmail.com','Jesus','Duran','password','994093785','','',1,1);

INSERT INTO users(id,user_type,birthdate,email,first_name,last_name,password,phone,random_column,comercial_name,role_id,location_id)
VALUES (2,'SUPPLIER','1994-10-13','diego@gmail.com','Diego','Kraenau','password','994093123','','',2,2);

