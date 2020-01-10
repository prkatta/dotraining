#!/bin/bash

read -p "Enter the name: " first last

echo $first
echo $last

echo " Name of current script : $0"

echo "First param is $1 and second param is $2"

echo "Number of params : $#"

echo "All Params $@"
