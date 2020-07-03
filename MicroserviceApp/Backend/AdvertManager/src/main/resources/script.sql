-- -- CLIENT COPY
 insert into client_copy(id, email, city, company_name, company_registration_number, is_banned, is_removed, name, surname, password, role, state, street, street_number)
 values(101, "pera@com", null, null, null, false, false, null, null, null, null, null, null, null);
 insert into client_copy(id, email, city, company_name, company_registration_number, is_banned, is_removed, name, surname, password, role, state, street, street_number)
 values(102, "marko@com", null, null, null, false, false, null, null, null, null, null, null, null);
 insert into client_copy(id, email, city, company_name, company_registration_number, is_banned, is_removed, name, surname, password, role, state, street, street_number)
 values(103, "zika@com", null, null, null, false, false, null, null, null, null, null, null, null);

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

-- ADVERT
insert into concrete_car(id, children_sit_number, name_of_car, travel_distance_constraint, year, car_brand_id, car_class_id, car_fuel_type_id, car_model_id, car_transmission_type_id)
values(1, 0, "AUDI:R8", 0, "1993", 2, 1, 2, 1, 1);

insert into price(id, discount, distance_overflow_price, insurance_price, is_removed, name, price_name, price_per_day)
values(2, 0, 54634, 543, 0, "BEST", "BEST", 4254);

insert into picture(id, is_deleted, path, picture)
values(5, 0, "Fiat-Panda.jpg", null);
insert into picture(id, is_deleted, path, picture)
values(7, 0, "0b6c5512fddb-1920x1080.jpg", null);
insert into picture(id, is_deleted, path, picture)
values(8, 0, "2221212118446761600x1060.jpg", null);

insert into advert(id, description, end_of_advert, is_active, profile_picture, start_of_advert, concrete_car_id, price_id)
values(6, "FIAT", "2020-07-31 00:00:00.0", 1, "Fiat-Panda.jpg", "2020-07-09 00:00:00.0", 1, 2);

insert into advert_picture_set(advert_id, picture_set_id)
values(6, 7);
insert into advert_picture_set(advert_id, picture_set_id)
values(6, 8);