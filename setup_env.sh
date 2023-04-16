#! /usr/bin/env bash

# Run as root, obviously

apt update

echo "Installing OpenJDK 17"
apt install openjdk-17-jdk-headless -y

echo "Testing Java install"
java --version

MVN_TAR=`ls | grep "apache-maven*`

if [[ -z "$MVN_TAR" ]]; then
  echo "Maven tar not found. Downloading Maven 3.9.1"
  apt install wget -y
  wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz

  MVN_TAR=`ls | grep "apache-maven*"`

  else
    echo "Found maven tar: ${MVN_TAR}"
fi

echo "Extracting $MVN_TAR"
tar -xvf $MVN_TAR
rm $MVN_TAR
MVN_DIR=`ls | grep "apache-maven*"`
echo "Maven directory: $MVN_DIR"
echo "Moving maven to /opt"
mv $MVN_DIR /opt/
ls /opt

echo "Updating PATH"
M2_HOME="/opt/$MVN_DIR"

echo "M2_HOME: ${M2_HOME}"
echo "PATH=\"$M2_HOME/bin:$PATH\"" >> ~/.profile

cat ~/.profile

echo "Testing maven install"
mvn --version
echo "Environment set up"