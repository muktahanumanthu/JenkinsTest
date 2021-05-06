#!/bin/bash

echo "Starting the deployment"
echo " Fetching the contents of output.txt"

rm /var/www/html/index.html
echo "adding contents of output.txt" >> /var/www/html/index.html
cat output.txt >> /var/www/html/index.html

rm output.txt
echo " Removed output.txt"