create table sy_user (
  id                            bigint auto_increment not null,
  username                      varchar(100),
  password                      varchar(100),
  create_time                   datetime(6) not null,
  update_time                   datetime(6) not null,
  constraint pk_sy_user primary key (id)
);

