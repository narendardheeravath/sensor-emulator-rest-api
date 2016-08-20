package io.egen.sensor.emulator.common;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class DatabaseUtil {
	public Datastore getDatabase() {
		final Morphia morphia = new Morphia();
		morphia.mapPackage(Constants.IO_EGEN_SENSOR_EMULATOR_DOMAIN);
		final Datastore datastore = morphia.createDatastore(new MongoClient(), Constants.SENSOR_DB);
		datastore.ensureIndexes();
		return datastore;
	}
}
