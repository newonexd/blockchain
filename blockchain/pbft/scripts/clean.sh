#!/usr/bin/env bash

docker stop $(docker container ls -aq)
docker container rm $(docker container ls -aq)
docker volume rm $(docker volume ls -q)
docker network rm $(docker network ls -q)
docker image rm $(docker image ls | awk '{print $3}' | grep 'node*')

cd ..
mvn clean