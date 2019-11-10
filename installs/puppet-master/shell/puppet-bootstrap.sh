#!/usr/bin/env bash

# BEGIN ########################################################################
echo -e "-- ------------------ --\n"
echo -e "-- BEGIN BOOTSTRAPING --\n"
echo -e "-- ------------------ --\n"

# VARIABLES ####################################################################
echo -e "-- Setting global variables\n"
APACHE_CONFIG=/etc/apache2/apache2.conf
VIRTUAL_HOST=localhost
DOCUMENT_ROOT=/var/www/html

# BOX ##########################################################################
echo -e "-- Updating packages list\n"
yum update -y -qq


# JAVA #########################################################################
echo -e "-- Installing JAVA packages\n"
yum install -y openjdk-8-jdk

echo -e "-- ---------------- --"
echo -e "-- END BOOTSTRAPING --"
echo -e "-- ---------------- --"
