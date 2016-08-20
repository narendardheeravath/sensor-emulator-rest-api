package io.egen.sensor.emulator.service.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.sensor.emulator.domain.Alerts;
import io.egen.sensor.emulator.domain.Metric;
import io.egen.sensor.emulator.morphia.dao.IAlertsDAO;
import io.egen.sensor.emulator.morphia.dao.IMetricDAO;
import io.egen.sensor.emulator.rules.RuleExecutor;
import io.egen.sensor.emulator.service.ISensorService;
@Service
public class SensorService implements ISensorService {

	@Autowired
	IMetricDAO metricDAO;
	@Autowired
	IAlertsDAO alertsDAO;
	@Autowired
	RuleExecutor ruleExecutor;

	public Metric create(long timeStamp, long value) {
		Metric metric = new Metric();
		metric.setTimeStamp(timeStamp);
		metric.setValue(value);
		metricDAO.saveMetrics(metric);
		ruleExecutor.fireRules(metric);
		return metric;
	}

	/**
	 * create – this is the API that will consume data from the sensor emulator
	 * 
	 * @param value
	 * @return
	 */

	public Metric send(String value) {
		ObjectMapper mapper = new ObjectMapper();
		Metric metric = null;
		try {
			metric = mapper.readValue(value.getBytes(), Metric.class);
			metricDAO.saveMetrics(metric);
			ruleExecutor.fireRules(metric);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return metric;
	}

	/**
	 * ad – reads all the metrics stored in your database
	 * 
	 * @return
	 */

	public List<Metric> readAllMetrics() {
		List<Metric> readAllMetrics = metricDAO.readAllMetrics();
		return readAllMetrics;
	}

	/**
	 * read – reads all alerts that are stored in the database
	 * 
	 * @return
	 */

	public List<Alerts> readAlerts() {
		List<Alerts> alerts = alertsDAO.readAllAlerts();
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

	public List<Metric> readMetricsByTimeRange(long startTime, long endTime) {
		List<Metric> readAllMetrics = metricDAO.readMetricsByTimeRange(startTime, endTime);
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

	public List<Alerts> readAlertsByTimeRange(long startTime, long endTime) {
		List<Alerts> alerts = alertsDAO.readAlertsByTimeRange(startTime, endTime);
		return alerts;
	}

}
