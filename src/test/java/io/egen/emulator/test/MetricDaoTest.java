package io.egen.emulator.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import io.egen.sensor.emulator.SensorApplication;
import io.egen.sensor.emulator.domain.Metric;
import io.egen.sensor.emulator.morphia.dao.impl.MetricDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SensorApplication.class, loader = AnnotationConfigContextLoader.class)
public class MetricDaoTest {

	@Autowired
	MetricDAO metricDAO;

	@Test
	public void saveMetric() {
		Metric metric = new Metric();
		metric.setTimeStamp(System.currentTimeMillis());
		metric.setValue(12);
		metricDAO.saveMetrics(metric);
	}

	@Test
	public void readAllMetrics() {
		List<Metric> readAllMetrics = metricDAO.readAllMetrics();
		for (Metric metric : readAllMetrics) {
			System.out.println(metric.getTimeStamp());
		}
	}

	@Test
	public void readAllMetricsByTimeRange() {

		List<Metric> readAllMetrics = metricDAO.readMetricsByTimeRange(1234, 12345);
		for (Metric metric : readAllMetrics) {
			System.out.println(metric.getTimeStamp());
		}

	}

}
