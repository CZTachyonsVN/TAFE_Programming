# Semester 2
## Notes
```dataview
TABLE unit, cluster, week
FROM #notes 
WHERE contains(file.folder, "Semester2")
sort cluster, unit, week
```
## **Assessments**
```dataview
TABLE unit as "unit/cluster", task, duedate as "due date"
FROM #assessment  
WHERE contains(file.folder, "Semester2")
sort duedate asc
```
