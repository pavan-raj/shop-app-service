IF not EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.TABLES  WHERE TABLE_NAME='CUSTOMER')

create table customer (
       id bigint identity not null,
        address varchar(255),
        date datetime2(6),
        first_name varchar(255),
        last_name varchar(255),
        phone_number varchar(255),
        primary key clustered (id asc)
)