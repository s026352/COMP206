#! /bin/bash
# BohanWang 261023725 ENGU1 bohan.wang@mail.mcgill.ca
# check input if its 2
if [ $# -ne 2 ]
then
	echo "ERROR: Expected two input parameters."
	echo "Usage: ./backup.bash <backupdirectory> <fileordirtobackup>"
	exit 1

fi
# check directory 1
if [ ! -d $1 ]
then
	echo "Error: The directory "$1" does not exist."
	exit 2
fi
# check input 2
if [ ! -e $2 ]
then
	echo "Error: "$2" does not exist."
	exit 2
fi
# check the location of 2 files
if [ $2 -ef $1 ]
then
	echo "Error: Two files are in the same directory"
	exit 2
fi
#name of the final file
filename="$(basename $2).$(date +%Y%m%d).tar"
#path of the final file
filepath="$1/$filename"
#the override condition for the file
if [ -f $filepath ]
then 
	read -p "Backup file '$filepath' already exists. Overwrite? (y/n): " choice
	if [ $choice != "y" ]
	then
		exit 3	
	fi
fi

# tar the file in to input 2 and named it as filepath
tar -cvf $filename -P $2 >/dev/null
mv $filename $filepath
exit 0




