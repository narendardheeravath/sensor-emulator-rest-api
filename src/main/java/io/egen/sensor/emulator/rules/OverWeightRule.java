package io.egen.sensor.emulator.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.egen.sensor.emulator.domain.Alerts;
import io.egen.sensor.emulator.domain.Metric;
import io.egen.sensor.emulator.morphia.dao.IAlertsDAO;
import io.egen.sensor.emulator.morphia.dao.IMetricDAO;

/**
 * 
 * @author Narendar
 * 
 *         To check the OverWeightRule---Detects under weight – if the weight of
 *         the person drops below 10% of his base weight Create a new alert and
 *         save it in MongoDB
 *
 */

@Component
@Rule(name = "OverWeightRule", description = "if the weight of the person drops above 10% of his base weight, then create the new alerts")
public class OverWeightRule {
	@Autowired
	IAlertsDAO alertsDAO;
	@Autowired
	IMetricDAO metricDAO;
	/**
	 * The user input which represents the data that the rule will operate on.
	 */
	private Metric metric;

	/**
	 * OverWeightRuleDetects under weight
	 * 
	 * @return
	 */
	@Condition
	public boolean checkUnderWeight() {
		String baseValue = System.getProperty("base.value");
		int base_weight = 150;
		if(baseValue!=null)
		{
			 base_weight =Integer.parseInt(baseValue);;
		}
		int base_weight10PEr = (base_weight * 10) / 100;
		float percentageChange = metric.getValue() - base_weight10PEr;
		if (percentageChange > base_weight) {
			return true;
		}
		return false;
	}

	/**
	 * Create a new alert and save it in MongoDB
	 * 
	 * @throws Exception
	 */
	@Action
	public void addAlertsForUnderWeight() throws Exception {
		Alerts alerts = new Alerts();
		alerts.setTimeStamp(metric.getTimeStamp());
		alerts.setValue(metric.getValue());
		alertsDAO.saveAlerts(alerts);
	}

	public Metric getMetric() {
		return metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}

}