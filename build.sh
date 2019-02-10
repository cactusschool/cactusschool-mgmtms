#!/bin/sh
git pull
notice_process=`ps -ef | grep cactusschool-noticems | awk '$8=="java" {print $2}'`
echo $notice_process
kill -9 $notice_process
echo "Running application has been stopped. Starting the application again"
mvn -DskipTests=true clean install
java -jar target/cactusschool-noticems-1.0.jar &