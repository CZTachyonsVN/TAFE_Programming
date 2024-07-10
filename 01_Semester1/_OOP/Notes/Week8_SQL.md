---
noteID: b589caf3-607f-45d0-9053-6fb32869a567
---
- Global language for relational database systems
- Different DBMS expand on standard SQL
# SQL
## DDL (Data Definition Language)
Defines database schema
- **CREATE** = creates a database and/or objects within it
- **DROP** = removes objects form a database
- **ALTER** = alter a structure of the database
- **TRUNKATE** = remove all records from a table
- **COMMENT** = adds comments to the data dictionary
- **RENAME** = renames an existing object
## DQL (Data Query Language)
Statements that perform queries on the database.
- **SELECT** = retrieve data from database
## DML (Data Manipulation Language)
Controls manipulation and access to data and to the database.
- **INSERT** =  inserts data into a table
- **UPDATE** = update existing data within a table
- **DELETE** = delete records from a table
- **LOCK** = prevent concurrent use of resources by different transactions
- **EXPLAIN PLAN** = describes access path to data
## DCL (Data Control Language)
Manages the rights and permissions of controls in the database system.
- **GRANT** = gives user access privileges
- **REVOKE** = withdraws privileges
## TCL (Transaction Control Language)
Grouping of tasks into one unit of execution. It is either executed successfully or fails without execution.
- **BEGIN** = start a transaction
- **COMMIT** = commits a transaction
- **ROLLBACK** = aborts any changes in the case any errors occur
- **SAVEPOINT** = sets a point within a transaction to which a rollback falls back to without undoing the entire transaction