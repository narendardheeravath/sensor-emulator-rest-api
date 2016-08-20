# sensor-emulator-rest-api

Steps to execute project

1.  Make sure that MongoDb is installed on machine before executing project
     1.1. Download the MongoDb form https://www.mongodb.com/download-center#community
     1.2. Install the MongoDb once download is complete
     1.3. Run mongod.exe from C:\Program Files\MongoDB\Server\3.2\bin through commond prompt
2. Run the /sensor-emulator-rest-api/src/main/java/io/egen/sensor/emulator/SensorApplication.java as SpringBootApplication
     2.1. Make sure that we have to pass VM Argument while running the SensorApplication.java and below is VM arguments
        -Dbase.value=150
3. SpringBootApplication SensorApplication deployed into server and all rest end points are available to consume by Emulator once deployement is successful. and port is 8080 by default
     3.1. Below are the rest end points which exposed as Metric APIs using Spring MVC,

			1. create – this is the API that will consume data from the sensor emulator
 					post- http://localhost:8080/create

			2. read – reads all the metrics stored in your database
  					http://localhost:8080/readMetrics
  
			3. readByTimeRange – reads all the metrics that were created between the given two timestamps
                   http://localhost:8080/readMetricsByTimeRange?startTime=1234&endTime=12345

	3.2. Exposed the below Alert APIs using Spring MVC

			1. read – reads all alerts that are stored in the database
					http://localhost:8080/readAlerts

			2. readByTimeRange – reads all alerts that are created between the given two timestamps
 					http://localhost:8080/readAlertsByTimeRange?startTime=1234&endTime=12345

4. Run the Emulator.java which I copied in same project as Java Application
     4.1 Make sure that we have to pass VM Argument while running the SensorApplication.java and below is VM arguments
        -Dbase.value=150 -Dapi.url=http://localhost:8080
        
        
5.  We can monitor the data by calling rest api - readMetrics and readAlerts
     http://localhost:8080/readAlerts
     http://localhost:8080/readMetrics
     1. Below is sample output from rest end point
[{"timeStamp":1471680843247,"value":12.0},{"timeStamp":1471690963363,"value":150.0},{"timeStamp":1471691097515,"value":151.0},{"timeStamp":1471691147062,"value":152.0},{"timeStamp":1471691162626,"value":153.0},{"timeStamp":1471691167682,"value":154.0},{"timeStamp":1471691172729,"value":155.0},{"timeStamp":1471691177797,"value":156.0},{"timeStamp":1471691182831,"value":157.0},{"timeStamp":1471691187887,"value":158.0},{"timeStamp":1471691192929,"value":159.0},{"timeStamp":1471691197969,"value":160.0},{"timeStamp":1471691203025,"value":161.0},{"timeStamp":1471691208073,"value":162.0},{"timeStamp":1471691213143,"value":163.0},{"timeStamp":1471691218201,"value":164.0},{"timeStamp":1471691228304,"value":166.0},{"timeStamp":1471691233345,"value":167.0},{"timeStamp":1471691238401,"value":168.0},{"timeStamp":1471691243440,"value":169.0},{"timeStamp":1471691248476,"value":170.0},{"timeStamp":1471691253548,"value":171.0},{"timeStamp":1471691638851,"value":150.0},{"timeStamp":1471691646507,"value":151.0},{"timeStamp":1471691651553,"value":152.0},{"timeStamp":1471691656597,"value":153.0},{"timeStamp":1471691661664,"value":154.0},{"timeStamp":1471691666712,"value":155.0},{"timeStamp":1471691671766,"value":156.0},{"timeStamp":1471691676832,"value":157.0},{"timeStamp":1471691681879,"value":158.0},{"timeStamp":1471691686928,"value":159.0},{"timeStamp":1471691691967,"value":160.0},{"timeStamp":1471691697035,"value":161.0},{"timeStamp":1471691702136,"value":162.0},{"timeStamp":1471691700990,"value":150.0},{"timeStamp":1471691707326,"value":163.0},{"timeStamp":1471691712359,"value":164.0},{"timeStamp":1471691816819,"value":150.0},{"timeStamp":1471691822790,"value":151.0},{"timeStamp":1471691827836,"value":152.0},{"timeStamp":1471691832890,"value":153.0},{"timeStamp":1471691837945,"value":154.0},{"timeStamp":1471691842990,"value":155.0},{"timeStamp":1471691848021,"value":156.0},{"timeStamp":1471691853055,"value":157.0},{"timeStamp":1471691858095,"value":158.0},{"timeStamp":1471691863129,"value":159.0},{"timeStamp":1471691868177,"value":160.0},{"timeStamp":1471691873215,"value":161.0},{"timeStamp":1471691878251,"value":162.0},{"timeStamp":1471691883293,"value":163.0},{"timeStamp":1471691888330,"value":164.0},{"timeStamp":1471692866628,"value":150.0},{"timeStamp":1471692873150,"value":151.0},{"timeStamp":1471692878501,"value":152.0},{"timeStamp":1471692883568,"value":153.0},{"timeStamp":1471692888617,"value":154.0},{"timeStamp":1471692893665,"value":155.0},{"timeStamp":1471692898711,"value":156.0},{"timeStamp":1471692903773,"value":157.0},{"timeStamp":1471692908821,"value":158.0},{"timeStamp":1471692913849,"value":159.0},{"timeStamp":1471692918901,"value":160.0},{"timeStamp":1471692923932,"value":161.0},{"timeStamp":1471692928989,"value":162.0},{"timeStamp":1471692934021,"value":163.0},{"timeStamp":1471692939053,"value":164.0},{"timeStamp":1471692949122,"value":166.0},{"timeStamp":1471692954179,"value":167.0},{"timeStamp":1471692959232,"value":168.0},{"timeStamp":1471692964266,"value":169.0},{"timeStamp":1471692969312,"value":170.0},{"timeStamp":1471692974356,"value":171.0},{"timeStamp":1471692979450,"value":172.0},{"timeStamp":1471692984517,"value":173.0},{"timeStamp":1471693083255,"value":150.0},{"timeStamp":1471693089102,"value":151.0},{"timeStamp":1471693094155,"value":152.0},{"timeStamp":1471693099228,"value":153.0},{"timeStamp":1471693104268,"value":154.0},{"timeStamp":1471693109310,"value":155.0},{"timeStamp":1471693114342,"value":156.0},{"timeStamp":1471693119376,"value":157.0},{"timeStamp":1471693124412,"value":158.0},{"timeStamp":1471693129444,"value":159.0},{"timeStamp":1471693134486,"value":160.0},{"timeStamp":1471693139521,"value":161.0},{"timeStamp":1471693144556,"value":162.0},{"timeStamp":1471693149585,"value":163.0},{"timeStamp":1471693697649,"value":150.0},{"timeStamp":1471693703644,"value":151.0},{"timeStamp":1471693708717,"value":152.0},{"timeStamp":1471693713761,"value":153.0},{"timeStamp":1471693718808,"value":154.0},{"timeStamp":1471693723896,"value":155.0},{"timeStamp":1471693728963,"value":156.0},{"timeStamp":1471693734012,"value":157.0},{"timeStamp":1471693739059,"value":158.0},{"timeStamp":1471693744097,"value":159.0},{"timeStamp":1471693749138,"value":160.0},{"timeStamp":1471693754175,"value":161.0},{"timeStamp":1471693759209,"value":162.0},{"timeStamp":1471693764241,"value":163.0},{"timeStamp":1471694683209,"value":150.0},{"timeStamp":1471694689150,"value":151.0},{"timeStamp":1471694694227,"value":152.0},{"timeStamp":1471694699672,"value":153.0},{"timeStamp":1471694704726,"value":154.0},{"timeStamp":1471694709780,"value":155.0},{"timeStamp":1471694714820,"value":156.0},{"timeStamp":1471694719879,"value":157.0},{"timeStamp":1471694724930,"value":158.0},{"timeStamp":1471694729967,"value":159.0},{"timeStamp":1471694735031,"value":160.0},{"timeStamp":1471694740076,"value":161.0},{"timeStamp":1471694745107,"value":162.0},{"timeStamp":1471694750148,"value":163.0},{"timeStamp":1471694755201,"value":164.0},{"timeStamp":1471694765276,"value":166.0},{"timeStamp":1471694770331,"value":167.0},{"timeStamp":1471694775399,"value":168.0},{"timeStamp":1471694780434,"value":169.0},{"timeStamp":1471694785464,"value":170.0},{"timeStamp":1471694790529,"value":171.0},{"timeStamp":1471697406499,"value":150.0},{"timeStamp":1471697412931,"value":151.0},{"timeStamp":1471697417984,"value":152.0},{"timeStamp":1471697423040,"value":153.0},{"timeStamp":1471697428090,"value":154.0},{"timeStamp":1471697433126,"value":155.0},{"timeStamp":1471697438173,"value":156.0},{"timeStamp":1471697443216,"value":157.0},{"timeStamp":1471697448251,"value":158.0},{"timeStamp":1471697453472,"value":159.0},{"timeStamp":1471697458946,"value":160.0},{"timeStamp":1471697463981,"value":161.0},{"timeStamp":1471697469012,"value":162.0},{"timeStamp":1471697474066,"value":163.0},{"timeStamp":1471697479122,"value":164.0},{"timeStamp":1471697489172,"value":166.0},{"timeStamp":1471724540037,"value":150.0},{"timeStamp":1471724546354,"value":151.0},{"timeStamp":1471724551428,"value":152.0},{"timeStamp":1471724556529,"value":153.0},{"timeStamp":1471724561600,"value":154.0}]

6. Used MongoDB as your datastore with two collections

     1. metrics – stores the data that comes from sensor - MetricDAO

     2. alerts – stores the alerts that were created by the rules - AlertDAO
7. Unit Testing
           1. SensorControllerTests is to test the rest controller which exposed as rest api
           3. RulesEngineTest is to do unit testing for rule engine by firing the both rules using easy rules.
           3. AlertsDaoTest and MetricsDaoTest is to insert the metrics and alerts into MongoDb using Morphia frameworks on collections and also reading metrics and alerts by time stamp
           4.  # sensor-emulator - Emulator.java
           
           
           
# sensor-emulator - Emulator.java
Simple java program that acts like a sensor and sends information (in JSON format) every 5 seconds. Sample data looks like this,

```json
{
  "timeStamp": "1458062848734", 
  "value": "153"
}
``` 

where timeStamp indicates when this data was sent and the value indicates a metric.
           

