#!/bin/sh

DB_NAME=storedatabase.db
SCHEMA_FILE=schema.sqlite

if [ -e $DB_NAME ] 
then 
        rm $DB_NAME
fi

# sqlite3 -batch $DB_NAME $(cat $SCHEMA_FILE)
cat $SCHEMA_FILE | sqlite3 -batch $DB_NAME
