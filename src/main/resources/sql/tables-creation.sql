create user 'admin'@'localhost' identified by '801620651';
grant all privileges on `tempus-machina`.* to 'admin'@'localhost';

create schema if not exists `tempus-machina`;
use `tempus-machina`;

drop table if exists `review`;
drop table if exists `media`;
drop table if exists `media_type`;
drop table if exists `profile`;

create table if not exists `profile` (
    `id` int primary key auto_increment,
    `email` varchar(255) not null,
    `password` varchar(32) not null,
    `firstname` varchar(20) not null,
    `lastname` varchar(20) not null,
    `last_password_update` bigint not null,
    `created_at` bigint not null,
    `updated_at` bigint not null  
);

create table if not exists `media_type` (
    `id` int primary key auto_increment,
    `name` varchar(20) not null,
    `format` varchar(20) not null
);


create table if not exists `media` (
    `id` int primary key auto_increment,
    `media_type_id` int not null,
    `name` varchar (100) not null, 
    `links` json,
    `created_at` bigint not null,
    `updated_at` bigint not null,
    foreign key (`media_type_id`) references `media_type`(`id`)
);


create table if not exists `review` (
    `id` int primary key auto_increment,
    `profile_id` int not null,
    `media_id` int not null,
    `stars` int not null,
    `text` varchar(200) not null,
    `created_at` bigint not null,
    `updated_at` bigint not null,
    foreign key (`profile_id`) references `profile`(`id`),
    foreign key (`media_id`) references `media`(`id`)
);
