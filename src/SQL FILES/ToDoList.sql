
create table todolist
(
listcode int identity(100,1), 
status char(5),
listdate char(15) not null,
listdescription varchar(200)not null,
notes varchar(500)
)
select * from todolist



