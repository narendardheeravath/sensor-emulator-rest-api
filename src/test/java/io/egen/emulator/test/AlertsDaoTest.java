package io.egen.emulator.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import io.egen.sensor.emulator.SensorApplication;
import io.egen.sensor.emulator.domain.Alerts;
import io.egen.sensor.emulator.morphia.dao.impl.AlertsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SensorApplication.class, loader = AnnotationConfigContextLoader.class)
public class AlertsDaoTest {

	@Autowired
	AlertsDAO alertsDAO;

	@Test
	public void saveAlerts() {
		Alerts alerts = new Alerts();
		alerts.setTimeStamp(System.currentTimeMillis());
		alerts.setValue(12);
		alertsDAO.saveAlerts(alerts);
	}

	@Test
	public void readAllalerts() {
	 List<Alerts> readAllAlerts = alertsDAO.readAllAlerts();
		for (Alerts alerts : readAllAlerts) {
			System.out.println(alerts.getTimeStamp());
		}
	}

	@Test
	public void readAllMetricsByTimeRange() {

		 List<Alerts> readAllAlerts = alertsDAO.readAlertsByTimeRange(1471680843247l, 1471680843247l);
		 for (Alerts alerts : readAllAlerts) {
				System.out.println(alerts.getTimeStamp());
			}

	}

}
