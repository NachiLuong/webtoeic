use toeiconline;
alter table comment add constraint fk_user_comment foreign key (userid) references user(userid);

alter table comment add constraint fk_listenguiline_comment foreign key (listenguidelineid) references listenguideline(listenguidelineid);