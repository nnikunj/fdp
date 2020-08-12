#!/bin/sh
cd FDP
mvn clean install -DskipTests=true 
cd ..
docker build . --tag fdp-app:1.0.0
rm -rf target/fdp-app.tar.gz
docker save fdp-app:1.0.0 | gzip > target/fdp-app.tar.gz
