#!/bin/bash

echo "Starting the deployment"
echo " Fetching the contents of output.txt"

cat output.txt >> /var/www/html/index.html

rm output.txt