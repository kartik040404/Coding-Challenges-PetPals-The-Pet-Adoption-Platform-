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

insert into donations (donationid, donorname, donationtype, donationamount, donationitem, donationdate) values
(1, 'john doe', 'cash', 100.00, null, '2024-03-01 10:00:00'),
(2, 'jane smith', 'item', null, 'dog food', '2024-03-02 11:30:00'),
(3, 'alice johnson', 'cash', 250.50, null, '2024-03-03 14:15:00'),
(4, 'bob williams', 'item', null, 'cat toys', '2024-03-04 09:45:00'),
(5, 'charlie brown', 'cash', 75.00, null, '2024-03-05 16:20:00'),
(6, 'david clark', 'item', null, 'leashes', '2024-03-06 12:10:00'),
(7, 'emma white', 'cash', 300.00, null, '2024-03-07 08:30:00'),
(8, 'frank hall', 'item', null, 'dog beds', '2024-03-08 13:40:00'),
(9, 'grace adams', 'cash', 50.00, null, '2024-03-09 15:10:00'),
(10, 'henry baker', 'item', null, 'pet shampoo', '2024-03-10 17:00:00');

select * from donations;

insert into adoptionevents (eventid, eventname, eventdate, location) values
(1, 'spring adoption fair', '2024-03-15 10:00:00', 'central park'),
(2, 'puppy adoption day', '2024-03-20 12:00:00', 'city shelter'),
(3, 'cat lovers event', '2024-03-25 14:00:00', 'community center'),
(4, 'rescue pet meet-up', '2024-04-01 09:00:00', 'downtown plaza'),
(5, 'summer adoption fest', '2024-04-10 11:30:00', 'pet store'),
(6, 'senior pet adoption', '2024-04-15 13:00:00', 'retirement home'),
(7, 'kitten adoption day', '2024-04-20 15:30:00', 'animal rescue center'),
(8, 'dog adoption weekend', '2024-04-25 10:45:00', 'city park'),
(9, 'special needs pet adoption', '2024-05-01 08:00:00', 'town hall'),
(10, 'holiday pet fair', '2024-05-10 12:00:00', 'shopping mall');

select * from adoptionevents;

insert into participants (participantid, participantname, participanttype, eventid) values
(1, 'happy tails shelter', 'shelter', 1),
(2, 'john doe', 'adopter', 2),
(3, 'safe paws rescue', 'shelter', 3),
(4, 'jane smith', 'adopter', 4),
(5, 'furry friends haven', 'shelter', 5),
(6, 'alice johnson', 'adopter', 6),
(7, 'bob williams', 'adopter', 7),
(8, 'rescue me foundation', 'shelter', 8),
(9, 'grace adams', 'adopter', 9),
(10, 'paws and claws shelter', 'shelter', 10);

select * from participants;

insert into pets (petid, name, age, breed, type, available) values
(1, 'buddy', 3, 'golden retriever', 'dog', 1),
(2, 'whiskers', 2, 'persian', 'cat', 1),
(3, 'rocky', 4, 'bulldog', 'dog', 0),
(4, 'luna', 1, 'siamese', 'cat', 1),
(5, 'max', 5, 'german shepherd', 'dog', 0),
(6, 'bella', 2, 'beagle', 'dog', 1),
(7, 'shadow', 6, 'maine coon', 'cat', 0),
(8, 'daisy', 3, 'labrador', 'dog', 1),
(9, 'tiger', 4, 'bengal', 'cat', 1),
(10, 'oliver', 2, 'ragdoll', 'cat', 0);

select * from pets;

insert into shelters (shelterid, name, location) values
(1, 'happy paws shelter', '123 main st, cityville'),
(2, 'safe haven rescue', '456 elm st, townsville'),
(3, 'furry friends home', '789 oak st, villagetown'),
(4, 'paws and claws shelter', '101 pine ave, metrocity'),
(5, 'rescue me sanctuary', '202 maple dr, suburbia'),
(6, 'pet haven', '303 birch ln, countryside'),
(7, 'forever home shelter', '404 cedar rd, downtown'),
(8, 'companion animal rescue', '505 willow ct, uptown'),
(9, 'loving paws foundation', '606 spruce blvd, midtown'),
(10, 'second chance shelter', '707 fir ave, eastside');

select * from shelters;