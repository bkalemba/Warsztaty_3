INSERT INTO customer(first_name,last_name) VALUES ("Beniamin","Kalemba"),("Sabina","Bubula");
INSERT INTO status(description) VALUES ("Przyjęty"),("Zatwierdzone koszty naprawy"),("W naprawie"),("Gotowy do odbioru"),("Rezygnacja");
INSERT INTO employee(first_name,last_name,address,phone,note,hour_cost) VALUES ("Andrzej","Kowal","Asd 25","52153523","Wzorowy",11.5),("Adam","Nowak","Gsag 331","2155551","Leniwy",9.30);
INSERT INTO vehicle(brand,model,year,license_plate,next_review,customer_id) VALUES ("Volkswagen","Golf",1999,"KRBLABLA",NOW(),1),("Mini","Cooper",2006,"KLIBLA",NOW(),2);
INSERT INTO orders(vehicle_id,employee_id,status_id,created,expected_start) VALUES (1,1,3,NOW(),NOW()),(2,2,3,NOW(),NOW());