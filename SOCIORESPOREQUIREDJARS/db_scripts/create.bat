@echo off

mysql -u root -proot -h localhost sociorespo < create.sql

mysql -u root -proot -h localhost sociorespo < alter.sql

echo "Rebuild Completed"

pause

exit