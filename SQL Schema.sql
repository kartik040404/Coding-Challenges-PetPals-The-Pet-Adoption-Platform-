-- 1. create and use database
create database if not exists pet_adoption;
use pet_adoption;

-- 2. create table for shelters
create table if not exists shelters (
    shelterid int primary key,
    name varchar(255),
    location varchar(255)
);

-- 3. create table for pets
create table if not exists pets (
    petid int primary key,
    name varchar(255),
    age int,
    breed varchar(255),
    type varchar(50),
    available bit,
    shelterid int,
    foreign key (shelterid) references shelters(shelterid)
);

-- 4. create table for donations
create table if not exists donations (
    donationid int primary key,
    donorname varchar(255),
    donationtype varchar(50),
    donationamount decimal(10,2),
    donationitem varchar(255),
    donationdate datetime
);

-- 5. create table for adoption events
create table if not exists adoptionevents (
    eventid int primary key,
    eventname varchar(255),
    eventdate datetime,
    location varchar(255),
    petid int,
    foreign key (petid) references pets(petid)
);

-- 6. create table for participants
create table if not exists participants (
    participantid int primary key,
    participantname varchar(255),
    participanttype varchar(50),
    eventid int,
    foreign key (eventid) references adoptionevents(eventid)
        on delete cascade
        on update cascade
);
