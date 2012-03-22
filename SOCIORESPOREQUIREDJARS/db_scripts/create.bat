@ echo off

mysql -u root -proot  sociorespo < drop.sql

mysql -u root -proot  sociorespo < create.sql

mysql -u root -proot  sociorespo < alter.sql

Echo
pause