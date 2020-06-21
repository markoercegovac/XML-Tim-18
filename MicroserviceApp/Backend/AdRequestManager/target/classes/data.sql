--PREDEFINED REQUESTS

insert into advert_copy(advert_copy_id, advert_end_date, owner_email) values
    (101, '2021-05-10 00:00:00', 'pera@maildrop.cc'),
    (102, '2021-06-10 00:00:00', 'pera@maildrop.cc'),
    (103, '2021-06-10 00:00:00', 'pera@maildrop.cc'),
    (104, '2021-06-10 00:00:00', 'pera@maildrop.cc'),
    (105, '2021-05-10 00:00:00', 'pera@maildrop.cc'),
    (106, '2021-06-10 00:00:00', 'pera@maildrop.cc'),
    (107, '2021-06-10 00:00:00', 'pera@maildrop.cc'),
    (108, '2021-06-10 00:00:00', 'pera@maildrop.cc'),
    (109, '2021-06-10 00:00:00', 'mika@maildrop.cc'),
    (110, '2021-07-10 00:00:00', 'mika@maildrop.cc');

insert into car_reserved_date(car_reserved_date_id, start_date, end_date) values
    (201, '2020-06-3 13:30:00', '2020-06-5 18:00:00'),
    (202, '2020-06-10 13:30:00', '2020-06-15 08:00:00'),
    (203, '2020-06-21 09:30:00', '2020-06-22 00:00:00'),
    (204, '2020-05-30 13:30:00', '2020-06-1 00:10:00'),
    (205, '2020-06-3 20:00:00', '2020-06-5 18:00:00'),
    (206, '2020-06-8 11:30:00', '2020-06-11 00:10:00'),
    (207, '2020-06-21 09:30:00', '2020-06-22 00:00:00'),
    (208, '2020-05-30 13:30:00', '2020-06-1 00:10:00'),
    (209, '2020-06-3 20:00:00', '2020-06-5 18:00:00');

insert into request_bundle(request_bundle_id, owner_email, requesting_user_email, advert_state, creation_date_and_time, price_with_discount) values
    (301, 'pera@maildrop.cc', 'jela@maildrop.cc', 'PENDING', '2020-05-30 12:35:00', 256.30),
    (302, 'pera@maildrop.cc', 'jela@maildrop.cc', 'APPROVED', '2020-05-30 12:35:00', 256.30),
    (303, 'pera@maildrop.cc', 'jela@maildrop.cc', 'PENDING', '2020-08-30 12:00:00', 256.30),
    (304, 'pera@maildrop.cc', 'jela@maildrop.cc', 'PENDING', '2020-08-30 12:00:00', 256.30),
    (305, 'pera@maildrop.cc', 'jela@maildrop.cc', 'PENDING', '2020-08-30 12:00:00', 256.30),
    (306, 'pera@maildrop.cc', 'jela@maildrop.cc', 'APPROVED', '2020-09-30 12:00:00', 256.30);

insert into request(request_id, start_reservation_date, end_reservation_date) values
    (401, '2020-06-03 12:00:00', '2020-06-10 13:00:00'),
    (402, '2020-06-03 12:00:00', '2020-06-10 18:00:00'),
    (403, '2020-06-03 12:00:00', '2020-06-10 18:00:00'),
    (404, '2020-06-03 12:00:00', '2020-06-10 18:00:00'),
    (405, '2020-06-03 12:00:00', '2020-06-10 13:00:00'),
    (406, '2020-06-03 12:00:00', '2020-06-10 18:00:00'),
    (407, '2020-06-03 12:00:00', '2020-06-10 18:00:00'),
    (408, '2020-06-03 12:00:00', '2020-06-10 18:00:00');

insert into request_bundle_requests(request_bundle_request_bundle_id, requests_request_id) values
    (301, 401),
    (301, 402),
    (302, 403),
    (303, 404),
    (304, 405),
    (305, 406),
    (305, 407),
    (306, 408);

insert into advert_copy_requests(advert_copy_advert_copy_id, requests_request_id) values
    (101, 401),
    (102, 402),
    (103, 403),
    (104, 404),
    (105, 405),
    (106, 406),
    (107, 407),
    (108, 408);