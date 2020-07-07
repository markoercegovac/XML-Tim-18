--PREDEFINED MESSAGES

insert into valid_user_owner_communication(valid_communication_id, owner_email, user_email, is_deleted) values
    (101, 'zika@com', 'pera@com', false);


insert into messages(message_id, valid_communication_id, direction, header, content, creation_date, is_seen) values
    (1, 101, 'FOR_USER', 'TEST', 'Did you received this?', '2020-05-15 17:22:00', true),
    (2, 101, 'FOR_OWNER', 'TEST', 'YES!', '2020-05-15 17:22:00', true);
