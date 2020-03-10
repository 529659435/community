create table comment
(
	id BIGINT auto_increment,
	parent_id BIGINT not null,
	Type int not null,
	commentator int not null,
	gmt_create bigint not null,
	gmt_modified bigint not null,
	like_count bigint not null,
	content varchar(1024),
			constraint comment_pk
		primary key (id)

);

