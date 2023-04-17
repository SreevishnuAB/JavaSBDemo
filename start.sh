#! /usr/bin/env bash
DIR=`pwd`
docker run --name sb_docker -it -v $DIR:/sb -p 5000:8080 sb-docker