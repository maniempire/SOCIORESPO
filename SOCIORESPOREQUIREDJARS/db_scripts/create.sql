create table user (
user_id int not null Primary key auto_increment,
user_email_id varchar(64),
user_password varchar(64),
user_status varchar(64)
);

create table profile (
profile_id int not null Primary key auto_increment,
profile_user_id int,
first_name varchar(64),
last_name varchar(64),
gender varchar(64),
phone_no varchar(64),
email_id varchar(64),
date_of_birth date,
voter_id varchar(64)
);


create table social_media_key (
smk_id int not null Primary key auto_increment,
smk_user_id int,
smk_facebook_key varchar(64),
smk_linkedin_key varchar(64),
smk_twitter_key varchar(64),
smk_twitter_token varchar(64),
smk_twitter_verifier varchar(64)
);

create table debate(
debate_id int not null Primary key auto_increment,
debate_user_id int,
debate_content text,
debate_date date
);



create table debate_details(
dd_id int not null Primary key auto_increment,
dd_user_id int,
dd_debate_id int,
dd_message text,
dd_description text,
dd_start_date date
);


create table tags(
tags_id int not null Primary key auto_increment,
tags_name varchar(64),
tags_description text,
tags_start_date datetime
);

create table post(
post_id int not null Primary key auto_increment,
post_user_id int,
post_content text,
post_start_date datetime
);