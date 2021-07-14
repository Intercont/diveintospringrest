CREATE TABLE customer (
	id bigint not null auto_increment,
    name varchar(60) not null,
    email varchar(255) not null,
    telephone varchar(255) not null,
    primary key (id)
);