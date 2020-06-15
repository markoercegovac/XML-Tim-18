-- CLIENT COPY
insert into client_copy(email, city, company_name, company_registration_number, is_banned, is_removed, name, surname, password, role, state, street, street_number)
values("pera@maildrop.cc", null, null, null, null, null, null, null, null, null, null, null, null);
insert into client_copy(email, city, company_name, company_registration_number, is_banned, is_removed, name, surname, password, role, state, street, street_number)
values("mika@maildrop.cc", null, null, null, null, null, null, null, null, null, null, null, null);

-- CAR BRAND
insert into car_brand(id, name, is_removed) values(1, "BMW", FALSE);
insert into car_brand(id, name, is_removed) values(2, "AUDI", FALSE);
insert into car_brand(id, name, is_removed) values(3, "PORSCHE", FALSE);
insert into car_brand(id, name, is_removed) values(4, "YUGO", FALSE);
insert into car_brand(id, name, is_removed) values(5, "LAMBORGHINI", FALSE);
insert into car_brand(id, name, is_removed) values(6, "TOYOTA", FALSE);
insert into car_brand(id, name, is_removed) values(7, "FERRARI", FALSE);
insert into car_brand(id, name, is_removed) values(8, "FIAT", FALSE);
insert into car_brand(id, name, is_removed) values(9, "GOLF", FALSE);

-- CAR MODEL
insert into car_model(id, model_name, is_removed) values(1, "R8", FALSE);
insert into car_model(id, model_name, is_removed) values(2, "MACAN", FALSE);
insert into car_model(id, model_name, is_removed) values(3, "PUNTO", FALSE);
insert into car_model(id, model_name, is_removed) values(4, "5", FALSE);

-- CAR MODEL_BRAND
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(8,3);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(2,1);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(9,4);

-- CAR FUEL
insert into car_fuel_type(id, fuel_type,is_removed) values(1,"DIESEL",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(2,"PETROL",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(3,"PETROL-HYBRID",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(4,"DIESEL-HYBRID",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(5,"FULL-ELECTRIC",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(6,"HYDROGEN",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(7,"OTHER",FALSE);

-- CAR CLASS
insert into car_class(id, class_name, is_removed) values(1, "S", FALSE);
insert into car_class(id, class_name, is_removed) values(2, "A", FALSE);
insert into car_class(id, class_name, is_removed) values(3, "B", FALSE);

-- CAR TRANSMISSION
insert into car_transmission_type(id, transmission_type,is_removed) values(1,"MANUAL",FALSE);
insert into car_transmission_type(id, transmission_type,is_removed) values(2,"AUTOMATIC",FALSE);

-- CONCRETE CAR
insert into concrete_car(id, car_brand_id, car_class_id, car_fuel_type_id, car_model_id, car_transmission_type_id)
values(101, 1, 1, 1, 1, 1);
insert into concrete_car(id, car_brand_id, car_class_id, car_fuel_type_id, car_model_id, car_transmission_type_id)
values(102, 2, 2, 2, 2, 2);
insert into concrete_car(id, car_brand_id, car_class_id, car_fuel_type_id, car_model_id, car_transmission_type_id)
values(103, 3, 3, 3, 3, 3);

-- OWNERS CAR
insert into owners_car (id, children_sit_number,client_email, concrete_car_id, is_insurance, travel_distance_constraint , traveled_unit, mileage)
values(201, 3, 'pera@maildrop.cc', 101, true, 250, 0, 2000.0);
insert into owners_car (id, children_sit_number,client_email, concrete_car_id, is_insurance, travel_distance_constraint , traveled_unit, mileage)
values(202, 3, 'pera@maildrop.cc', 102, false, 360, 0, 20054654.33);
insert into owners_car (id, children_sit_number,client_email, concrete_car_id, is_insurance, travel_distance_constraint , traveled_unit, mileage)
values(203, 3, 'pera@maildrop.cc', 103, false, null, 0, 180000.55);

-- PRICE
insert into price(id, discount, distance_overflow_price, insurance_price, is_removed,name, price_per_day)
values(301, null, null, 25, false, "SUPER CENA 1", 25);

-- ADVERT
insert into advert(id, description, end_of_advert, is_active, profile_picture, start_of_advert, client_email, client_id, owners_car_id, price_id, profile_picture)
values(501, "THE BEST", "2021-05-13 00:00:00", true, null, "2020-05-13 00:00:00", null, null, 201, 301, "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD//gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcgSlBFRyB2ODApLCBxdWFsaXR5ID0gOTAK/9sAQwADAgIDAgIDAwMDBAMDBAUIBQUEBAUKBwcGCAwKDAwLCgsLDQ4SEA0OEQ4LCxAWEBETFBUVFQwPFxgWFBgSFBUU/9sAQwEDBAQFBAUJBQUJFA0LDRQUFBQU");
insert into advert(id, description, end_of_advert, is_active, profile_picture, start_of_advert, client_email, client_id, owners_car_id, price_id)
values(502, "THE BEST", "2021-05-13 00:00:00", false, null, "2020-05-13 00:00:00", null, null, 201, 301);
