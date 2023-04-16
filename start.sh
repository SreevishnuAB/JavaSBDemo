#! /usr/bin/env bash
DIR=`pwd`
docker run -it -v $DIR:/sb -p 5000:8080 sb-docker