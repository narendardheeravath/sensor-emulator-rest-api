uses MongoDB as your datastore with two collections

1. metrics – stores the data that comes from sensor - MetricDAO

2. alerts – stores the alerts that were created by the rules - AlertDAO

Exposed the below Metric APIs using Spring MVC,

1. create – this is the API that will consume data from the sensor emulator
  post- http://localhost:8080/create

2. read – reads all the metrics stored in your database
  http://localhost:8080/readMetrics
  
3. readByTimeRange – reads all the metrics that were created between the given two timestamps
 http://localhost:8080/readMetricsByTimeRange?startTime=1234&endTime=12345

ExposeD the below Alert APIs using Spring MVC


1. read – reads all alerts that are stored in the database
http://localhost:8080/readAlerts

2.readByTimeRange – reads all alerts that are created between the given two timestamps
 http://localhost:8080/readAlertsByTimeRange?startTime=1234&endTime=12345