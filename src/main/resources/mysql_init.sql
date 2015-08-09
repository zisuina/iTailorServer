CREATE database myserver;
show databases;
use myserver;
grant all privileges on myserver.* to 'hunters'@'%' identified by 'hunters';
grant all privileges on myserver.* to 'hunters'@'localhost' identified by 'hunters';
flush privileges;
exit;
mysql -u hunters -p
use myserver;
show tables;
