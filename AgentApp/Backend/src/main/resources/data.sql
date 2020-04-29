--SCRIPT FOR ADDING DEFAULT DATA TO AGENT APP

--CLIENT
insert into client(email, name, surname)
    values('mika@maildrop.cc', 'mika', 'mikic');
insert into client(email, name, surname)
   values('pera@maildrop.cc', 'pera', 'peric');

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

--COMMENTS
insert into comment(id, content, is_approved, client_email,advert_id)
    values(1, 'odlicna ponuda', true, 'mika@maildrop.cc', 1);
insert into comment(id, content, is_approved, client_email,advert_id)
    values(2, 'super cena', true, 'pera@maildrop.cc', 1);
insert into comment(id, content, is_approved, client_email,advert_id)
    values(3, 'lose je jako', false, 'mika@maildrop.cc', 1);
