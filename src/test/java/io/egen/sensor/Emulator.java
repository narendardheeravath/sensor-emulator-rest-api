/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.egen.sensor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.egen.sensor.emulator.SensorApplication;

/**
 * @author Narendar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SensorApplication.class)
@WebAppConfiguration
public class Emulator {
	private static int interval_in_ms = 5000;
	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void emulatorTest() throws Exception {

		int base_weight;
		try {
			base_weight = Integer.parseInt(System.getProperty("base.value"));
		} catch (NumberFormatException e) {
			throw new IllegalStateException("Invalid value for VM argument base.value");
		}

		final String url = System.getProperty("api.url");
		if (url == null) {
			throw new IllegalStateException("Missing VM argument api.url");
		}

		int anomaly_1 = 30000;
		int anomaly_2 = -90;

		while (true) {
			int start_weight = base_weight;

			// increasing the weight up by 30 till 190
			for (int i = 0; i < 30; i++) {
				postSend(url, start_weight++);
			}

			// decreasing the weight up by 15 till 175
			for (int i = 0; i < 15; i++) {
				postSend(url, start_weight--);
			}

			postSend(url, anomaly_1);

			// decreasing the weight up by 15 till 160
			for (int i = 0; i < 15; i++) {
				postSend(url, start_weight--);
			}

			postSend(url, anomaly_2);
		}

	}

	private void postSend(String url, int value) throws Exception {
		String json = "{\"timeStamp\": \"" + String.valueOf(System.currentTimeMillis()) + "\", \"value\": \"" + value
				+ "\"}";
		this.mockMvc
				.perform(post("http://localhost:8080/create").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print());
		Thread.sleep(interval_in_ms);
	}

}
