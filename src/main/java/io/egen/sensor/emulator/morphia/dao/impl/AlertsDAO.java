package io.egen.sensor.emulator.morphia.dao.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import io.egen.sensor.emulator.common.DatabaseUtil;
import io.egen.sensor.emulator.domain.Alerts;
import io.egen.sensor.emulator.morphia.dao.IAlertsDAO;

/***
 * 
 * @author Narendar
 * 
 *         To store data using
 *
 */
@Repository
public class AlertsDAO implements IAlertsDAO{

	public void saveAlerts(Alerts alerts) {
		Datastore datastore = new DatabaseUtil().getDatabase();
		datastore.save(alerts);

	}

	public List<Alerts> readAllAlerts() {
		Datastore datastore = new DatabaseUtil().getDatabase();
		Query<Alerts> query = datastore.createQuery(Alerts.class);
		List<Alerts> alerts = query.asList();
		return alerts;

	}

	public List<Alerts> readAlertsByTimeRange(long startTime, long endTime) {
		Datastore datastore = new DatabaseUtil().getDatabase();
		List<Alerts> alerts = datastore.createQuery(Alerts.class).field("timeStamp").lessThanOrEq(endTime)
				.field("timeStamp").greaterThanOrEq(startTime).asList();
		return alerts;

	}

}
