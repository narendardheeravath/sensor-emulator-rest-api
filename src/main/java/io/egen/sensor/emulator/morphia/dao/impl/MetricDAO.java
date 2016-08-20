package io.egen.sensor.emulator.morphia.dao.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import io.egen.sensor.emulator.common.DatabaseUtil;
import io.egen.sensor.emulator.domain.Metric;
import io.egen.sensor.emulator.morphia.dao.IMetricDAO;
/***
 * 
 * @author Narendar 
 * F
 * To store data using 
 *
 */
@Repository
public class MetricDAO implements IMetricDAO{

	
	/**
	 * save metrics
	 * @param metric
	 */
	public void saveMetrics(Metric metric) {
		Datastore datastore = new DatabaseUtil().getDatabase();
		datastore.save(metric);

	}
	/**
	 *  get the metric based on time
	 * @param timeStamp
	 * @return
	 */
	public Metric getMetric(long timeStamp) {
		Metric metric = new Metric();
		Datastore datastore = new DatabaseUtil().getDatabase();
		Query<Metric> query = datastore.createQuery(Metric.class).field("timeStamp").equal(timeStamp);
		List<Metric> metrics = query.asList();
		if(metrics.size()>0){
			 metric = metrics.get(0);
		}
		return metric;

	}
	/**
	 * read all metrics
	 * @return
	 */
	public List<Metric> readAllMetrics() {
		Datastore datastore = new DatabaseUtil().getDatabase();
		Query<Metric> query = datastore.createQuery(Metric.class);
		List<Metric> sensorDatas = query.asList();
		return sensorDatas;

	}
   /**
    *    read the sensor metrics by time range
    * @param startTime
    * @param endTime
    * @return
    */
	public List<Metric> readMetricsByTimeRange(long startTime, long endTime) {
		Datastore datastore = new DatabaseUtil().getDatabase();
		List<Metric> sensorDatas = datastore.createQuery(Metric.class).field("timeStamp").lessThanOrEq(endTime)
				.field("timeStamp").greaterThanOrEq(startTime).asList();
		return sensorDatas;

	}
	
	

}
