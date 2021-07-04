#!/bin/sh

DB_NAME=storedatabase.db
SCHEMA_FILE=schema.sqlite
DATA_FILE=test_data.sqlite

echo "remove old database"
if [ -e $DB_NAME ] 
then 
        rm $DB_NAME
fi

# sqlite3 -batch $DB_NAME $(cat $SCHEMA_FILE)
echo "creating new database"
cat $SCHEMA_FILE | sqlite3 -batch $DB_NAME
echo "database created"
echo "populating data"
cat $DATA_FILE | sqlite3 -batch $DB_NAME
echo "data populated"
