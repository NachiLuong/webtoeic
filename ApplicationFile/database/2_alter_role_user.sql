use toeiconline;
alter table user add roleid bigint;

alter table user add constraint fk_user_role foreign key (roleid) references role(roleid);