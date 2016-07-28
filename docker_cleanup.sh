#!/bin/bash
docker kill $(docker ps -q)
docker rm -fv $(docker ps -a -q)
docker rmi -f $(docker images -q -f dangling=true)
docker rmi -f $(docker images -q)