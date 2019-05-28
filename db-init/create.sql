drop table if exists link CASCADE ;
create table link (link_id varchar(255) not null, create_at timestamp, url varchar(255) not null, primary key (link_id));
