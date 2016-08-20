package io.egen.sensor.emulator.domain;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

/**
 * 
 * @author Narendar 
 *  Sensor data which send to DB
 *
 */
@Entity("alerts")
@Indexes(
    @Index(value = "timeStamp", fields = @Field("timeStamp"))
)
public class Alerts {
    @Id
	private long timeStamp;
    @Property
	private float value;
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
}
