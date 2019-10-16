#!/usr/bin/env bash

sh clean.sh

cd ..
mvn package -Dmaven.test.skip=true


chmod -R 777 target/
docker-compose -f ./docker/docker-compose-Pnode.yaml up -d