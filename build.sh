#!/bin/sh
git pull
mgmt_process=`ps -ef | grep cactusschool-mgmtms | awk '$8=="java" {print $2}'`
echo $mgmt_process
kill -9 $mgmt_process
echo "Running application has been stopped. Starting the application again"
mvn -DskipTests=true clean install
java -jar target/cactusschool-mgmtms-1.0.jar &