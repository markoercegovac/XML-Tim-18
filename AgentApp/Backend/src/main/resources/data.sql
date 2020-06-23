--SCRIPT FOR ADDING DEFAULT DATA TO AGENT APP

--CLIENT
insert into client(email, name, surname)
values('mika@maildrop.cc', 'mika', 'mikic'),
   ('pera@maildrop.cc', 'pera', 'peric');

--CAR BRAND
insert into car_brand(id, name, is_removed) values(1, "BMW", FALSE);
insert into car_brand(id, name, is_removed) values(2, "AUDI", FALSE);
insert into car_brand(id, name, is_removed) values(3, "PORSCHE", FALSE);
insert into car_brand(id, name, is_removed) values(4, "YUGO", FALSE);
insert into car_brand(id, name, is_removed) values(6, "TOYOTA", FALSE);
insert into car_brand(id, name, is_removed) values(7, "FERRARI", FALSE);
insert into car_brand(id, name, is_removed) values(8, "FIAT", FALSE);
insert into car_brand(id, name, is_removed) values(9, "NISSAN", FALSE);
insert into car_brand(id, name, is_removed) values(10, "PEUGEOT", FALSE);
insert into car_brand(id, name, is_removed) values(11, "GOLF", FALSE);


-- CAR CLASS
insert into car_class(id, class_name, is_removed) values(1, "S", FALSE);
insert into car_class(id, class_name, is_removed) values(2, "A", FALSE);
insert into car_class(id, class_name, is_removed) values(3, "B", FALSE);

-- CAR MODEL
insert into car_model(id, model_name, is_removed) values(1, "R8", FALSE);
insert into car_model(id, model_name, is_removed) values(2, "MACAN", FALSE);
insert into car_model(id, model_name, is_removed) values(3, "PUNTO", FALSE);
insert into car_model(id, model_name, is_removed) values(4, "5", FALSE);
insert into car_model(id, model_name, is_removed) values(5, "MICRA", FALSE);
insert into car_model(id, model_name, is_removed) values(6, "307", FALSE);
insert into car_model(id, model_name, is_removed) values(7, "PANDA", FALSE);

-- CAR TRANSMISION TYPE
insert into car_transmission_type(id, transmission_type,is_removed) values(1,"MANUAL",FALSE);
insert into car_transmission_type(id, transmission_type,is_removed) values(2,"AUTOMATIC",FALSE);

-- CAR FUEL TYPE
insert into car_fuel_type(id, fuel_type,is_removed) values(1,"DIESEL",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(2,"PETROL",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(3,"PETROL-HYBRID",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(4,"DIESEL-HYBRID",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(5,"FULL-ELECTRIC",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(6,"HYDROGEN",FALSE);
insert into car_fuel_type(id, fuel_type,is_removed) values(7,"OTHER",FALSE);

-- CAR
insert into car(id, children_sit_number, is_insurance, travel_distance_constraint, car_brand_id, car_class_id, car_fuel_type_id, car_model_id, car_transmission_type_id, mileage_id) values
(301, 2, false, 4333, 1, 1, 1, 1, 1, null),
(302, 2, false, 4333, 2, 2, 2, 2, 2, null),
(303, 2, false, 4333, 1, 1, 1, 3, 2, null);

-- PRICE
insert into price(id, name, price_per_day, discount, distance_overflow_price, insurance_price, is_removed) values
(801, "price #1", 432.4, 30, 452445, 4334, false),
(802, "price #2", 432.4, 30, 452445, 4334, false),
(803, "price #3", 432.4, 30, 452445, 4334, false),
(804, "price #4", 432.4, 30, 452445, 4334, false);  





