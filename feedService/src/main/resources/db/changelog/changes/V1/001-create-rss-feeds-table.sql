--liquibase formatted sql
--changeset aditya:001

create table feed(
    id bigserial,
    rss_url varchar(255),
    link varchar(255),
    title varchar(255),
    description varchar(255),
    lang varchar(255),
    img varchar(255),
    source_name varchar(100),
    source_source_homepage varchar(255),
    etag varchar(255),
    lastModified timestamp,
    lastFetechedAt timestamp,
    status varchar(255),
    createdAt timestamp,
    createdBy varchar(255),
    createdBy_user_id varchar(255),
    follow_count bigint

);

--rollback DROP TABLE feed