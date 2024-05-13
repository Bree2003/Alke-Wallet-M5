create database if not exists alkem5;

use alkem5;

create table if not exists users(
id int primary key auto_increment,
uname varchar(20) not null,
ulastname varchar(20) not null,
uemail varchar(50) not null unique,
upassword varchar(20) not null,
ubalance decimal(10,2) not null
);


