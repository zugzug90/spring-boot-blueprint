#!/bin/sh

#TODO: make image tag to be parameter (?)
#cd ../; cp -r bin ./docker/; mvn clean package -DskipTests
mvn -f ../pom.xml -Dbasedir=../ clean package -DskipTests && cp ../target -r ./target && docker build -t room606/${artifactId}:${version} . ; rm -rf ./docker/target