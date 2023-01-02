 create table schedule
(
apptid int identity(1,1), 
status varchar(10),
cdate smalldatetime,
ttime char(10),
tdescription varchar(100),
vweek varchar(30),
notes varchar(3000)
 
)


select datename(weekday,cdate) from schedule
select * from schedule
del

select * from schedule order by cdate


create trigger schetrig
on schedule
for insert
As

declare @DateReported smalldatetime 
select @DateReported =cdate from schedule
insert schedule (weekname) values (datename(weekday,@DateReported))
return






declare @datestr varchar(30);
select @datestr =datename(weekday,@dateReported) from schedule
set weekname = @datestr




SELECT apptid,   FROM schedule
   order BY cdate 


select datename(weekday,getdate()+8)