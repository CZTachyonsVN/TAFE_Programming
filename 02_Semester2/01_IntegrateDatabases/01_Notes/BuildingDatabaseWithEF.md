---
tags:
  - notes
unit: IntegrateDatabases
semester: 2
week: 3
---
# Steps
1. Open NuGet console
2. Enter the following two commands
	1. add-migration \<migration name>
	2. update-database
# How it works
The Entity Framework will find any DbSet objects from DbContext class and set up tables from the objects that are mapped onto those collections