use toeiconline;
create table listenguideline(
                                listenguidelineid bigint not null primary key auto_increment,
                                title varchar(255) null,
                                image varchar(255) null,
                                content text null ,
                                createdate timestamp null,
                                modifiedate timestamp null
);
create table comment(
                        commentid bigint not null primary key auto_increment,
                        content text null,
                        userid BIGINT null ,
                        listenguidelineid BIGINT null ,
                        createdate timestamp null
);