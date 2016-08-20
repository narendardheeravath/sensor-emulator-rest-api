package io.egen.sensor.emulator.morphia.dao;

import java.util.List;

import io.egen.sensor.emulator.domain.Alerts;

/***
 * 
 * @author Narendar
 * 
 *         To store data using
 *
 */

public interface IAlertsDAO {

	public void saveAlerts(Alerts alerts) ;

	public List<Alerts> readAllAlerts();

	public List<Alerts> readAlertsByTimeRange(long startTime, long endTime);

}
