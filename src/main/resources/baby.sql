create user 'hunters'@'%' IDENTIFIED BY 'hunters';
create user 'hunters'@'localhost' IDENTIFIED BY 'hunters';
use mysql;
select user,host,password from user where user='hunters';
grant all privileges on *.* to 'hunters'@'localhost' identified by 'hunters';