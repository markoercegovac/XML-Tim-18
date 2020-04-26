--SCRIPT FOR ADDING DEFAULT DATA TO AGENT APP

--CAR BRAND
insert into car_brand(id, name, is_removed) values(1, "BMW", FALSE);
insert into car_brand(id, name, is_removed) values(2, "AUDI", FALSE);
insert into car_brand(id, name, is_removed) values(3, "PORSCHE", FALSE);
insert into car_brand(id, name, is_removed) values(4, "YUGO", FALSE);
insert into car_brand(id, name, is_removed) values(5, "LAMBORGHINI", FALSE);
insert into car_brand(id, name, is_removed) values(6, "TOYOTA", FALSE);
insert into car_brand(id, name, is_removed) values(7, "FERRARI", FALSE);
insert into car_brand(id, name, is_removed) values(8, "FIAT", FALSE);

--ADVERTS
insert into advert(id, is_active) values(1, true);

--GRADES
insert into grade(id, grade, advert_id) values(1, 3, 1);
insert into grade(id, grade, advert_id) values(2, 3, 1);
insert into grade(id, grade, advert_id) values(3, 5, 1);
