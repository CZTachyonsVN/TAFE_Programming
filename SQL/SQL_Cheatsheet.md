#sql
# Order of execution
1. FROM and JOIN
	- first pass of constraints are applied at all rows
	- unsatisfactory rows are discarded
	- cannot access aliases from SELECT
2. WHERE
	- constraints are applied to every row
	- unsatisfactory rows are discarded
	- cannot access aliases
3. GROUP BY
	- remaining rows will get grouped based on common values in the specified column
	- ideally for aggregate functions
4. HAVING
	-  constraint applied to GROUP BY rows
	- discard unsatisfactory rows
	- cannot access aliases
5. SELECT
	- computing final query
6. DISTINCT
	- duplicate rows from the remaining rows will be discarded
7. ORDER BY
	- rows are sorted 
8. LIMIT and OFFSET
	- trimming of the rows