use kodilla_course;

drop table if exists STATS;

create table STATS (
	STAT_ID int auto_increment primary key,
  STAT_DATE datetime not null,
  STAT varchar(20) not null,
  VALUE int not null
);

drop view if exists BESTSELLERS_COUNT;

create view BESTSELLERS_COUNT AS
select count(*) from books where BESTSELLER = true;

drop event if exists UPDATE_BESTSELLER_STATS;

DELIMITER $$

create event UPDATE_BESTSELLER_STATS
on schedule every 1 minute
do begin
	call UpdateBestSellers();
  insert into STATS (STAT_DATE, STAT, VALUE) values(now(),"BESTSELLERS", (select * from BESTSELLERS_COUNT));
end$$

DELIMITER ;