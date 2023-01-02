create table contactlist
(
vcompany varchar(50),
vaddress varchar(75),
vname varchar(50),
vtitle varchar(50),
email varchar(40),
phone int,
mobile int,
website varchar(40),
compsize varchar(40),
keypersonal varchar(200),
addLocation varchar(200),
products varchar(200),
strength varchar(200),
award varchar(200),
postitle varchar(50),
salary varchar(20),
benifits varchar(200),
reqExp varchar(200),
meetReq varchar(200),
descrip  varchar(400),
)

select * from contactlist

sp_help temp

delete from contactlist co,

create table templ
(
vname varchar(50)
)

select * from templ
select * from contactlist

delete from contactlist
where vname = (select vname from templ)

DELETE contactlist FROM contactlist INNER JOIN templ ON contactlist.vname = templ.vname
