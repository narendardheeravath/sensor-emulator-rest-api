package io.egen.sensor.emulator.morphia.dao;

import java.util.List;

import io.egen.sensor.emulator.domain.Metric;

/***
 * 
 * @author Narendar F To store data using
 *
 */

public interface IMetricDAO {

	/**
	 * save metrics
	 * 
	 * @param metric
	 */
	public void saveMetrics(Metric metric);

	/**
	 * get the metric based on time
	 * 
	 * @param timeStamp
	 * @return
	 */
	public Metric getMetric(long timeStamp);

	/**
	 * read all metrics
	 * 
	 * @return
	 */
	public List<Metric> readAllMetrics();

	/**
	 * read the sensor metrics by time range
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Metric> readMetricsByTimeRange(long startTime, long endTime);
}
