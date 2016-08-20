package io.egen.sensor.emulator.service;

import java.util.List;

import io.egen.sensor.emulator.domain.Alerts;
import io.egen.sensor.emulator.domain.Metric;

public interface ISensorService {
	public Metric create(long timeStamp, long value);

	/**
	 * create – this is the API that will consume data from the sensor emulator
	 * 
	 * @param value
	 * @return
	 */

	public Metric send(String value) ;

	/**
	 * ad – reads all the metrics stored in your database
	 * 
	 * @return
	 */

	public List<Metric> readAllMetrics() ;

	/**
	 * read – reads all alerts that are stored in the database
	 * 
	 * @return
	 */

	public List<Alerts> readAlerts() ;

	/**
	 * readByTimeRange – reads all the metrics that were created between the
	 * given two timestamps
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */

	public List<Metric> readMetricsByTimeRange(long startTime, long endTime);

	/**
	 * readByTimeRange – reads all alerts that are created between the given two
	 * timestamps
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */

	public List<Alerts> readAlertsByTimeRange(long startTime, long endTime) ;

}
