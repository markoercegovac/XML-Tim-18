--PREDEFINED REQUESTS

insert into advert_copy(advert_copy_id, advert_end_date, owner_email) values
    (101, '2021-05-10 00:00:00.0', 'pera@maildrop.cc'),
    (102, '2021-06-10 00:00:00.0', 'pera@maildrop.cc'),
    (103, '2021-06-10 00:00:00.0', 'pera@maildrop.cc'),
    (104, '2021-06-10 00:00:00.0', 'pera@maildrop.cc'),
    (105, '2021-06-10 00:00:00.0', 'mika@maildrop.cc'),
    (106, '2021-07-10 00:00:00.0', 'mika@maildrop.cc');

insert into car_reserved_date(car_reserved_date_id, advert_copy_id, start_date, end_date) values
    (201, 101, '2020-06-3 13:30:00.0', '2020-06-5 18:00:00.0'),
    (202, 101, '2020-06-10 13:30:00.0', '2020-06-15 08:00:00.0'),
    (203, 101, '2020-06-21 09:30:00.0', '2020-06-22 00:00:00.0'),
    (204, 102, '2020-05-30 13:30:00.0', '2020-06-1 00:10:00.0'),
    (205, 102, '2020-06-3 20:00:00.0', '2020-06-5 18:00:00.0'),
    (206, 103, '2020-06-8 11:30:00.0', '2020-06-11 00:10:00.0'),
    (207, 103, '2020-06-21 09:30:00.0', '2020-06-22 00:00:00.0'),
    (208, 104, '2020-05-30 13:30:00.0', '2020-06-1 00:10:00.0'),
    (209, 104, '2020-06-3 20:00:00.0', '2020-06-5 18:00:00.0');

insert into request_bundle(request_bundle_id, owner_email, requesting_user_email, advert_state, approved_date_and_time, creation_date_and_time, price_with_discount) values
    (301, 'pera@maildriop.cc', 'jela@maildrop.cc', 'PENDING', NULL, '2020-05-30 12:35:00.0', 256.30);

insert into request(request_id, advert_copy_id, request_bundle_id, start_reservation_date, end_reservation_date) values
    (401, 101, 301, '2020-06-03 12:00:00.0', '2020-06-10 13:00:00.0'),
    (402, 102, 301, '2020-06-03 12:00:00.0', '2020-06-10 18:00:00.0');