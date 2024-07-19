---
tags:
  - assessment
unit: WebData
semester: 2
task: 2
duedate: 2024-09-13
---
# Assessment Files
- [Marking Criteria](AssessmentFiles/ICTPRG553_554_AT2_MC_TQM_v3.pdf)
- [Portfolio of Evidence](AssessmentFiles/ICTPRG553_554_AT2_PE_TQM_v3.pdf)
	- Project Scenario
	- Project Requirements
- [Sample Data](AssessmentFiles/ICTPRG553_554_WeatherData_Readings_2022/SensorData_Final_NoWind.json)
# Submission Files
- [Documentation](AssessmentFiles/UptownIT__REST_API_NoSQL_Template_V1.docx)
- Project folder
# Outline
- Develop a MongoDB REST API to interact with a large dataset of raw climate data.
- The client wants to use raw climate data to run student projects to analyse climate data collected using network of IoT sensors.
- Access and manipulation of data.
- Authentication and authorisation of request.
- The client will be designing their own client.
- Client requires API documentation.
- Teacher acts as the project manager of UptownIT.
## API functionality requirements
- [ ] Insert a new reading for a weather station
- [ ] Administrators can create a new user account with a specified level of access
- [ ] Insert multiple sensor readings for single station
- [ ] Find the maximum precipitation recorded in the last 5 Months for a specific sensor, returning the sensor name, reading date / time and the precipitation value
- [ ] Find the temperature, atmospheric pressure, radiation, and precipitation recorded by a specific station at a given date and time
- [ ] Find the maximum Temp(C) recorded for all stations for a given Date / Time range (start and finish date) returning the Sensor Name, reading date / time and the Temperature value
- [ ] Create a query that includes an index key
- [ ] Delete a user by ID
- [ ] Administrators can remove a range of created user accounts based on a date range
- [ ] Admin users can correct errors in the dataset
- [ ] Administrators can upgrade or downgrade multiple users that were created in batches (upgrading or downgrading an entire group of students)
