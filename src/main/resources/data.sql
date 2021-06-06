drop table if exists messages;
create table messages (
  id integer auto_increment,
  message varchar(256),
  primary key(id)
);
