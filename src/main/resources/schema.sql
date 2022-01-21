
create table catagory
(
    id int auto_increment
        primary key,
    description varchar(1000) null,
    duration double not null,
    name varchar(255) null,
    price double not null
);

create table contact_us
(
    id int auto_increment
        primary key,
    comment varchar(255) null,
    name varchar(255) null
);

create table customer
(
    id int auto_increment
        primary key,
    email varchar(255) null,
    fullname varchar(255) null,
    password varchar(255) null,
    phone double not null
);

create table applied_policy
(
    id int auto_increment
        primary key,
    customer_id int not null,
    customer_name varchar(255) null,
    date varchar(255) null,
    policy varchar(255) null,
    status varchar(255) null,
    constraint FKjoh5cvcvc41cppoe3tfssck3p
        foreign key (customer_id) references customer (id)
);

create table policy
(
    id int auto_increment
        primary key,
    catagory varchar(255) null,
    name varchar(255) null,
    premium double not null,
    tenure double not null
);

create table question
(
    id int auto_increment
        primary key,
    comment varchar(255) null,
    customer_id int not null,
    customer_name varchar(255) null,
    date varchar(255) null,
    question varchar(255) null,
    constraint FKa3ve3tjhe55cny9owsh3q8pjv
        foreign key (customer_id) references customer (id)
);


