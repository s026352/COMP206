#!/bin/bash
#Bohan Wang 261023725 ENGU1 bohan.wang@mail.mcgill.ca
# check input if its 2
if [ $# -ne 2 ]
then
	echo "Error: Expected two input parameters."
	echo "Usage: ./backup.bash <backupdirectory> <fileordirtobash>"
	exit 1
fi
# check directory 1
if [ ! -d $1 ]
then
	echo "Error: Input parameter #1 "$1" is not a directory."
	exit 2
fi
# check directory 2
if [ ! -d $2 ]
then
	echo "Error: Input parameter #2 "$2" is not a directory."
	exit 2
fi
# check the location of 2 files
if [ $1 -ef $2 ]
then
  echo "Error: Two directories are pointing to the same location"
  exit 2
fi

# 2 input
dirt1=$1
dirt2=$2
# passing boolean
pass=0

#check if the file differ
for file in $(ls -p $dirt1 | grep -v "/$")
do
  if [ -f "$dirt2/$file" ]
  then
    if [ "$(diff -q "$dirt1/$file" "$dirt2/$file")" = "" ]
    then
     echo "$dirt2/$file $dirt1/$file differs"
     pass=1
   fi
 fi
done
#loop the first directory and see the missing files
for file in $(ls -p $dirt2 | grep -v "/$")
do
  if [ ! -f "$dirt1/$file" ]
  then
    echo "$dirt1/$file is missing"
    pass=1
  fi
done
#loop the second directory and see the missing files
for file in $(ls -p $dirt1 | grep -v "/$")
do
  if [ ! -f "$dirt2/$file" ]
  then
    echo "$dirt2/$file is missing"
   pass=1
  fi
done

#if not meet to any if condition, will exit 0
if [ $pass = 0 ]
then
  exit 0
else
#otherwise exit 3
  exit 3
fi







