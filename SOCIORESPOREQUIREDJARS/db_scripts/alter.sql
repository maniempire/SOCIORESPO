alter table profile add foreign key (profile_user_id) references user (user_id);

alter table social_media_key add foreign key (smk_user_id) references user (user_id);

alter table debate add foreign key (debate_user_id) references user (user_id);

alter table debate_details add foreign key (dd_user_id) references user (user_id);

alter table debate_details add foreign key (dd_debate_id) references debate (debate_id);

alter table post add foreign key (post_user_id) references user (user_id);