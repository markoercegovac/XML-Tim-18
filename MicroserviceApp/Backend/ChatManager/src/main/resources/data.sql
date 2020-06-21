--PREDEFINED MESSAGES

insert into valid_user_owner_communication(valid_communication_id, owner_email, user_email, is_deleted) values
    (101, 'pera@maildrop.cc', 'jela@maildrop.cc', false),
    (102, 'pera@maildrop.cc', 'mika@maildrop.cc', false),
    (103, 'pera@maildrop.cc', 'djura@maildrop.cc', false),
    (104, 'zika@maildrop.cc', 'jela@maildrop.cc', false);


insert into messages(message_id, valid_communication_id, direction, header, content, creation_date, is_seen) values
    (1, 101, 'FOR_USER', 'TEST', 'Did you received this?', '2020-05-15 17:22:00', true),
    (2, 101, 'FOR_OWNER', 'TEST', 'YES!', '2020-05-15 17:22:00', true),
    (3, 102, 'FOR_USER', 'TEST', 'Did you received this?', '2020-05-15 17:22:00', true),
    (4, 102, 'FOR_OWNER', 'TEST', 'test success', '2020-05-15 17:22:00', true),
    (5, 104, 'FOR_USER', 'TEST', 'HELLO', '2020-05-15 17:22:00', true),
    (6, 104, 'FOR_OWNER', 'TEST', 'HELLO BACK', '2020-05-15 17:22:00', true);
