# Semester 2
## Notes
```dataview
TABLE unit as "Unit", cluster as "Cluster", week as "Week"
FROM #notes 
WHERE contains(file.folder, "Semester2")
sort cluster, unit, week, file.cday
```
## **Assessments**
```dataview
TABLE rows.file.link as "Assessment", duedate - date(today) as "Remaining time", choice(rows.isFinished,
"☑", "☐") as Finished
FROM #assessment  
WHERE contains(file.folder, "Semester2")
group by duedate
```

```dataview
Calendar duedate
where typeof(duedate) = "date"
```
