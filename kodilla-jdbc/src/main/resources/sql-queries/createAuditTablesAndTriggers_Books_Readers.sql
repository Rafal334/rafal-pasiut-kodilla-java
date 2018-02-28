drop table if exists BOOKS_AUD;

create table BOOKS_AUD (
	EVENT_ID int not null auto_increment,
	event_date datetime not null,
	EVENT_TYPE varchar(10) default null,
	BOOK_ID int not null,
	OLD_TITLE varchar(255),
	NEW_TITLE varchar(255),
	OLD_PUBYEAR int(4),
	NEW_PUBYEAR int(4),
	OLD_BESTSELLER bool,
	NEW_BESTSELLER bool,
	primary key (`EVENT_ID`)
);

drop trigger if exists books_insert;
drop trigger if exists books_delete;
drop trigger if exists books_update;

DELIMITER $$

create trigger books_insert after insert on books
for each row
begin
	insert into books_aud(event_date, event_type, book_id, new_title, new_pubyear, new_bestseller)
	  values(curtime(), "INSERT", new.BOOK_ID, new.TITLE, new.PUBYEAR, new.BESTSELLER);
end$$

create trigger books_delete after delete on books
for each row
begin
	insert into books_aud(event_date, event_type, book_id) values(curtime(), "DELETE", old.BOOK_ID);
end$$

create trigger books_update after update on books
for each row
begin
	insert into books_aud(event_date, event_type, book_id, new_title, new_pubyear, new_bestseller,
                        old_title, old_pubyear, old_bestseller)
	  values(curtime(), "UPDATE", old.BOOK_ID, new.TITLE, new.PUBYEAR, new.BESTSELLER,
           old.TITLE, old.PUBYEAR, old.BESTSELLER);
end$$

DELIMITER ;

drop table if exists READERS_AUD;

create table READERS_AUD (
	EVENT_ID int not null auto_increment,
	event_date datetime not null,
	EVENT_TYPE varchar(10) default null,
	READER_ID int not null,
	OLD_FIRSTNAME varchar(255),
	NEW_FIRSTNAME varchar(255),
	OLD_LASTNAME varchar(255),
	NEW_LASTNAME varchar(255),
	OLD_PESELID varchar(11),
	NEW_PESELID varchar(11),
	OLD_VIP_LEVEL varchar(20),
	NEW_VIP_LEVEL varchar(20),
	primary key (`EVENT_ID`)
);

drop trigger if exists readers_insert;
drop trigger if exists readers_delete;
drop trigger if exists readers_update;

DELIMITER $$

create trigger readers_insert after insert on readers
for each row
begin
	insert into readers_aud(event_date, event_type, reader_id, new_firstname, new_lastname, new_peselid, new_vip_level)
	  values(curtime(), "INSERT", new.reader_id, new.firstname, new.lastname, new.peselid, new.vip_level);
end$$

create trigger readers_delete after delete on readers
for each row
begin
	insert into readers_aud(event_date, event_type, reader_id) values(curtime(), "DELETE", old.reader_id);
end$$

create trigger readers_update after update on readers
for each row
begin
	insert into readers_aud(event_date, event_type, reader_id, new_firstname, new_lastname, new_peselid, new_vip_level,
                          old_firstname, old_lastname, old_peselid, old_vip_level)
	  values(curtime(), "UPDATE", old.reader_id, new.firstname, new.lastname, new.peselid, new.vip_level,
                      old.firstname, old.lastname, old.peselid, old.vip_level);
end$$

DELIMITER ;



