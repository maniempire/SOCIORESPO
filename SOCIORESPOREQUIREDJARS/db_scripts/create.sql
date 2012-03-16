drop table Profile;

drop table social_media_key;

drop table debate_details;

drop table debate;

drop table tags;

drop table user;

create table user (
user_id int not null Primary key,
user_name varchar(64),
User_password varchar(64),
User_status varchar(64)
);

create table Profile (
pf_id int not null Primary key,
pf_user_id int,
first_name varchar(64),
last_name varchar(64),
gender varchar(64) ,
phone_no varchar(64),
email_id varchar(64),
date_of_birth date,
Voter_id varchar(64)
);


create table social_media_key (
smk_id int not null Primary key,
smk_user_id int,
smk_key varchar(64));



create table debate(
debate_id int not null Primary key,
debate_user_id int,
debate_content text,
debate_date date);



create table debate_details(
dd_id int not null Primary key,
dd_user_id int,
dd_debate_id int,
dd_message text,
dd_description text,
dd_start_date date);


create table tags(
tags_id int not null Primary key,
tags_name varchar(64),
tags_description text,
tags_start_date date);