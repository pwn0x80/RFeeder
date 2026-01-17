--liquibase formatted sql
--changeset aditya:002

create table feed_item(
    id bigserial PRIMARY key, 
    guid bigserial,
    title varchar(255),
    link varchar(255),
    description varchar(255),
    content text,
    author varchar(255),
    category varchar(255),
    img_url varchar(255),
    uri varchar(255),
    upvote bigint,
    downvote bigint
);

--rollback DROP TABLE feed_item;