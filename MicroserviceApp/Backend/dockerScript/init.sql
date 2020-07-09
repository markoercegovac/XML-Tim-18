-- MYSQL SCRIPT FOR CREATING DATABASES AND USERS THAT WILL BE USED BY DOCKER COMPOSE
CREATE DATABASE IF NOT EXISTS chat_db;
CREATE DATABASE IF NOT EXISTS request_db;
CREATE DATABASE IF NOT EXISTS comment_db;
CREATE DATABASE IF NOT EXISTS advert_db;
CREATE DATABASE IF NOT EXISTS search_db;
CREATE DATABASE IF NOT EXISTS user_db;
CREATE DATABASE IF NOT EXISTS soap_db;

CREATE USER IF NOT EXISTS 'us_chat'@'%' IDENTIFIED WITH mysql_native_password BY 'password-chat';
CREATE USER IF NOT EXISTS 'us_request'@'%' IDENTIFIED WITH mysql_native_password BY 'password-request';
CREATE USER IF NOT EXISTS 'us_comment'@'%' IDENTIFIED WITH mysql_native_password BY 'password-comment';
CREATE USER IF NOT EXISTS 'us_advert'@'%' IDENTIFIED WITH mysql_native_password BY 'password-advert';
CREATE USER IF NOT EXISTS 'us_search'@'%' IDENTIFIED WITH mysql_native_password BY 'password-search';
CREATE USER IF NOT EXISTS 'us_user'@'%' IDENTIFIED WITH mysql_native_password BY 'password-user';
CREATE USER IF NOT EXISTS 'us_soap'@'%' IDENTIFIED WITH mysql_native_password BY 'password-soap';

GRANT ALL PRIVILEGES ON chat_db.* TO 'us_chat'@'%';
GRANT ALL PRIVILEGES ON request_db.* TO 'us_request'@'%';
GRANT ALL PRIVILEGES ON comment_db.* TO 'us_comment'@'%';
GRANT ALL PRIVILEGES ON advert_db.* TO 'us_advert'@'%';
GRANT ALL PRIVILEGES ON search_db.* TO 'us_search'@'%';
GRANT ALL PRIVILEGES ON user_db.* TO 'us_user'@'%';
GRANT ALL PRIVILEGES ON soap_db.* TO 'us_soap'@'%';

FLUSH PRIVILEGES;

-- SHOWS CREATED DATABASES
SHOW DATABASES;
SELECT * FROM mysql.user;
