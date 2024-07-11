```dataview
TABLE rows.unit as "Unit", rows.cluster as "Cluster", rows.week as "Week", rows.file.link as "File"
FROM #notes 
WHERE contains(file.folder, "Semester2")
sort semester, week
group by semester as "Semester"
```

```dataview
TABLE unit, cluster, week, semester
FROM #notes 
WHERE contains(file.folder, "Semester2")
sort semester, week
```
