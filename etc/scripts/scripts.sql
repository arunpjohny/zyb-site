set session AUTHORIZATION "zyb-site";

drop table students

create table students(
    cid serial,
    name varchar not null,
    description text not null,
    image bytea,
    imageName varchar,
    weight int default 0 not null,
    constraint pk_students primary key(cid)
)

create table zyb_personnel_type(
    name varchar not null,
    description text not null,
    caption varchar not null,
    constraint pk_zyb_personnel_type primary key(name)
)

insert into zyb_personnel_type (name, description, caption) values ('advisoryboard', 'Advisory Board', 'Advisory Board');
insert into zyb_personnel_type (name, description, caption) values ('managementteam', 'Management Team', 'Management Team');
insert into zyb_personnel_type (name, description, caption) values ('trainers', 'Trainers goes here', 'Trainers');


create table zyb_personnel(
    cid serial,
    p_type varchar not null,
    name varchar not null,
    designation varchar not null,
    company varchar not null,
    image varchar,
    item_order int default 0 not null,
    summary text,
    constraint pk_zyb_personnel primary key(cid),
    constraint fk_zyb_personnel_type foreign key (p_type) references zyb_personnel_type(name)
)

-- drop table placement_openings
create table placement_openings(
    cid serial,
    createddate timestamp without time zone,
    company varchar,
    position varchar,
    noofopenings int default 1 not null,
    location varchar,
    contactperson varchar,
    contactemail varchar,
    contactnumber varchar,
    jobdescription text,
    desiredprofile text,
    constraint pk_placement_openings primary key (cid)
)

alter table placement_openings add noofopenings int default 1 not null

select * from students