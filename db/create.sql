CREATE DATABASE minidb;
CREATE USER 'admin'@'%' IDENTIFIED BY 'passme';
GRANT ALL ON minidb.* TO 'admin';