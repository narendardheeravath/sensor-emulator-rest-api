package io.egen.emulator.rules.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import io.egen.sensor.emulator.SensorApplication;
import io.egen.sensor.emulator.domain.Metric;
import io.egen.sensor.emulator.rules.RuleExecutor;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SensorApplication.class, loader = AnnotationConfigContextLoader.class)
public class RulesEngineTest {

	@Autowired
	RuleExecutor ruleExecutor;

	@Test
	public void testRules() {
		Metric metric = new Metric();
		metric.setTimeStamp(System.currentTimeMillis());
		metric.setValue(123);
		ruleExecutor.fireRules(metric);
	}

	
}
