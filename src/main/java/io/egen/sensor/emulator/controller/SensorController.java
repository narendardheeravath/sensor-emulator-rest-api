package io.egen.sensor.emulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.sensor.emulator.domain.Alerts;
import io.egen.sensor.emulator.domain.Metric;
import io.egen.sensor.emulator.service.ISensorService;

@RestController
public class SensorController {


	@Autowired
	ISensorService sensorService;

	@RequestMapping("/create1")
	public Metric create(@RequestParam(value = "timeStamp") long timeStamp, @RequestParam(value = "value") long value) {
		Metric metric = sensorService.create(timeStamp, value);
		return metric;
	}

	/**
	 * create – this is the API that will consume data from the sensor emulator
	 * 
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Metric send(@RequestBody String value) {
		Metric metric = sensorService.send(value);
		return metric;
	}

	/**
	 * ad – reads all the metrics stored in your database
	 * 
	 * @return
	 */
	@RequestMapping("/readMetrics")
	public List<Metric> readAllMetrics() {
		List<Metric> readAllMetrics = sensorService.readAllMetrics();
		return readAllMetrics;
	}
    /**
     * read – reads all alerts that are stored in the database
     * @return
     */
	@RequestMapping("/readAlerts")
	public List<Alerts> readAlerts() {
		List<Alerts> alerts = sensorService.readAlerts();
		return alerts;
	}

	/**
	 * readByTimeRange – reads all the metrics that were created between the
	 * given two timestamps
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("/readMetricsByTimeRange")
	public List<Metric> readMetricsByTimeRange(@RequestParam(value = "startTime") long startTime,
			@RequestParam(value = "endTime") long endTime) {
		List<Metric> readAllMetrics = sensorService.readMetricsByTimeRange(startTime, endTime);
		return readAllMetrics;
	}

	/**
	 * readByTimeRange – reads all alerts that are created between the given two
	 * timestamps
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("/readAlertsByTimeRange")
	public List<Alerts> readAlertsByTimeRange(@RequestParam(value = "startTime") long startTime,
			@RequestParam(value = "endTime") long endTime) {
		List<Alerts> alerts = sensorService.readAlertsByTimeRange(startTime, endTime);
		return alerts;
	}
}
