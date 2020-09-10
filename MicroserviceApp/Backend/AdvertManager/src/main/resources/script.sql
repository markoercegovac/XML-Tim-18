-- -- CLIENT COPY
 insert into client_copy(id, email, is_banned, is_removed, is_forbidden_advert, is_creation_enabled)
 values(101, "pera@com", false, false, false, true);
 insert into client_copy(id, email, is_banned, is_removed, is_forbidden_advert, is_creation_enabled)
 values(102, "marko@com", false, false, false, true);
 insert into client_copy(id, email,is_banned, is_removed, is_forbidden_advert, is_creation_enabled)
 values(103, "zika@com", false, false, false, true);

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
insert into car_model(id, model_name, is_removed) values(1, "M3", FALSE);
insert into car_model(id, model_name, is_removed) values(2, "R8", FALSE);
insert into car_model(id, model_name, is_removed) values(3, "911", FALSE);
insert into car_model(id, model_name, is_removed) values(4, "KORAL 55", FALSE);
insert into car_model(id, model_name, is_removed) values(5, "HURRICANE", FALSE);
insert into car_model(id, model_name, is_removed) values(6, "SUPRA", FALSE);
insert into car_model(id, model_name, is_removed) values(7, "LaFerarri", FALSE);
insert into car_model(id, model_name, is_removed) values(8, "PUNTO", FALSE);
insert into car_model(id, model_name, is_removed) values(9, "5", FALSE);

-- CAR MODEL_BRAND
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(1,1);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(2,2);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(3,3);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(4,4);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(5,5);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(5,6);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(7,7);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(8,8);
insert into car_brand_car_model_set(car_brand_id, car_model_set_id) values(9,9);

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
insert into car_class(id, class_name, is_removed) values(4, "C", FALSE);
insert into car_class(id, class_name, is_removed) values(5, "D", FALSE);

-- CAR TRANSMISSION
insert into car_transmission_type(id, transmission_type,is_removed) values(1,"MANUAL",FALSE);
insert into car_transmission_type(id, transmission_type,is_removed) values(2,"AUTOMATIC",FALSE);

-- ADVERT
--insert into concrete_car(id, children_sit_number, name_of_car, travel_distance_constraint, year, car_brand_id, car_class_id, car_fuel_type_id, car_model_id, car_transmission_type_id)
--values(1, 0, "AUDI:R8", 0, "1993", 2, 1, 2, 1, 1);
----
--insert into picture(id, is_deleted, path, picture)
--values(5, 0, "Fiat-Panda.jpg", null);
--insert into picture(id, is_deleted, path, picture)
--values(7, 0, "0b6c5512fddb-1920x1080.jpg", null);
--insert into picture(id, is_deleted, path, picture)
--values(8, 0, "2221212118446761600x1060.jpg", null);
--
--insert into advert(id, description, end_of_advert, is_active, profile_picture, start_of_advert, concrete_car_id, price_id)
--values(6, "FIAT", "2020-07-31 00:00:00.0", 1, "Fiat-Panda.jpg", "2020-07-09 00:00:00.0", 1, 2);
--
--insert into advert_picture_set(advert_id, picture_set_id)
--values(6, 7);
--insert into advert_picture_set(advert_id, picture_set_id)
--values(6, 8);
--
--insert into client_copy_adverts(client_copy_id, adverts_id)
--values(103, 6);
