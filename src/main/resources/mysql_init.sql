CREATE database hunters;
show databases;
use hunters;
grant all privileges on hunters.* to 'hunters'@'%' identified by 'hunters';
grant all privileges on hunters.* to 'hunters'@'localhost' identified by 'hunters';
flush privileges;
