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