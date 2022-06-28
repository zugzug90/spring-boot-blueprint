#set( $symbol_double_quote = '"' )
#set( $regex = "([a-z])([A-Z]+)")
#set( $replacement = "$1_$2")
#set( $tableName = $firstModel.replaceAll($regex, $replacement).toLowerCase())
CREATE SCHEMA IF NOT EXISTS $symbol_double_quote${dbName}$symbol_double_quote;

--CREATE EXTENSION fuzzystrmatch SCHEMA public;

CREATE TABLE IF NOT EXISTS ${tableName} (
    id                                   serial CONSTRAINT ${tableName}_primary_key PRIMARY KEY,
    name                                 varchar(64) NOT NULL,
	date_created                         TIMESTAMP,
    date_updated                         TIMESTAMP,
	CONSTRAINT ${tableName}_name_unique  UNIQUE(name)
);