CREATE DATABASE  IF NOT EXISTS zyb2;

CREATE USER 'zyb-site'@'localhost' IDENTIFIED BY 'site';
GRANT ALL PRIVILEGES ON *.* TO 'zyb-site'@'localhost' WITH GRANT OPTION;
CREATE USER 'zyb-site'@'%' IDENTIFIED BY 'site';
GRANT ALL PRIVILEGES ON *.* TO 'zyb-site'@'%' WITH GRANT OPTION;

use zyb2;

drop table students;

create table students(
    cid int NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) not null,
    description text not null,
    image longblob,
    imageName VARCHAR(200),
    weight int default 0 not null,
    constraint pk_students primary key(cid)
);

drop table zyb_personnel_type;

create table zyb_personnel_type(
    name VARCHAR(200) not null,
    description text not null,
    caption VARCHAR(200) not null,
    constraint pk_zyb_personnel_type primary key(name)
);

insert into zyb_personnel_type (name, description, caption) values ('advisoryboard', 'Advisory Board', 'Advisory Board');
insert into zyb_personnel_type (name, description, caption) values ('managementteam', 'Management Team', 'Management Team');
insert into zyb_personnel_type (name, description, caption) values ('trainers', 'Trainers goes here', 'Trainers');


create table zyb_personnel(
    cid int NOT NULL AUTO_INCREMENT,
    p_type VARCHAR(200) not null,
    name VARCHAR(200) not null,
    designation VARCHAR(200) not null,
    company VARCHAR(200) not null,
    image VARCHAR(200),
    item_order int default 0 not null,
    summary text,
    constraint pk_zyb_personnel primary key(cid),
    constraint fk_zyb_personnel_type foreign key (p_type) references zyb_personnel_type(name)
);

-- drop table placement_openings
create table placement_openings(
    cid int NOT NULL AUTO_INCREMENT,
    createddate timestamp,
    company VARCHAR(200),
    position VARCHAR(200),
    noofopenings int default 1 not null,
    location VARCHAR(200),
    contactperson VARCHAR(200),
    contactemail VARCHAR(200),
    contactnumber VARCHAR(200),
    jobdescription text,
    desiredprofile text,
    constraint pk_placement_openings primary key (cid)
);

alter table placement_openings add noofopenings int default 1 not null;

select * from students