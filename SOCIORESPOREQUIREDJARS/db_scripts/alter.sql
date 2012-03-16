alter table Profile add foreign key (pf_user_id) references user (user_id);

alter table social_media_key add foreign key (smk_user_id) references user (user_id);

alter table debate add foreign key (debate_user_id) references user (user_id);

alter table debate_details add foreign key (dd_user_id) references user (user_id);

alter table debate_details add foreign key (dd_debate_id) references debate (debate_id);