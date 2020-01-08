#!/bin/bash
echo "Enter the number: "
read n
if [ $n -lt 10 ];
then
echo "It is a one digit number"
else
echo "It is a two digit number"
fi
