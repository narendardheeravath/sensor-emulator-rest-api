package io.egen.sensor.emulator.rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.sensor.emulator.domain.Metric;
/**
 * 
 * @author Narendar
 *  Rule executor service which fire the underWeightRule and overWeightRule
 */
@Service
public class RuleExecutor {
	@Autowired
	UnderWeightRule underWeightRule;
	@Autowired
	OverWeightRule overWeightRule;

	public void fireRules(Metric metric) {
		overWeightRule.setMetric(metric);
		underWeightRule.setMetric(metric);
		RulesEngineBuilder aNewRulesEngine = RulesEngineBuilder.aNewRulesEngine();
		/**
		 * Create a rules engine and register the business rule
		 */
		RulesEngine rulesEngine = aNewRulesEngine.build();

		rulesEngine.registerRule(underWeightRule);
		rulesEngine.registerRule(overWeightRule);

		/**
		 * Fire rules
		 */
		rulesEngine.fireRules();
	}
}
