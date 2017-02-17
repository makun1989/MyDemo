package com.makun.chapter21;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenHouseSchedule {

	private volatile boolean light = false;

	private volatile boolean water = false;

	private String thremostat = "Day";

	public String getThremostat() {
		return thremostat;
	}

	public void setThremostat(String thremostat) {
		this.thremostat = thremostat;
	}

	ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);

	public void schedule(Runnable event, long delay) {
		schedule.schedule(event, delay, TimeUnit.MILLISECONDS);
	}

	public void repeat(Runnable event, long initialDelay, long period) {
		schedule.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
	}

	class LightOn implements Runnable {

		@Override
		public void run() {
			System.out.println("Tunning on light ..");
			light = true;
		}

	}

	class LightOff implements Runnable {

		@Override
		public void run() {
			System.out.println("Tunning off light ..");
			light = false;
		}

	}

	class WaterOn implements Runnable {

		@Override
		public void run() {
			System.out.println("Tunning on water");
			water = true;
		}

	}

	class WaterOff implements Runnable {

		@Override
		public void run() {
			System.out.println("Tunning off water");
			water = false;
		}

	}
	
	class ThremostatNight implements Runnable {

		@Override
		public void run() {
			System.out.println("Thremostat to night setting.");
			thremostat = "Night";
		}

	}

	class ThremostatDay implements Runnable {

		@Override
		public void run() {
			System.out.println("Thremostat to day setting.");
			thremostat = "Day";
		}

	}

	class Bell implements Runnable {

		@Override
		public void run() {
			System.out.println("Bing...");
		}

	}

	class Terminate implements Runnable {

		@Override
		public void run() {
			System.out.println("Terminating..");
			schedule.shutdownNow();

			new Thread() {
				public void run() {
					for (DataPoint d : data) {
						System.out.println(d);
					}
				};
			}.start();
		}

	}

	static class DataPoint {
		final Calendar time;
		final float temperature;
		final float humidity;

		public DataPoint(Calendar time, float temperature, float humidity) {
			this.time = time;
			this.temperature = temperature;
			this.humidity = humidity;
		}

		@Override
		public String toString() {
			return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
		}

	}

	private Calendar lastTime = Calendar.getInstance();

	{
		lastTime.set(Calendar.MINUTE, 30);
		lastTime.set(Calendar.SECOND, 00);
	}

	private float lastTemp = 65.0f;
	private int tempDirection = +1;
	private float lastHumidity = 50.f;
	private int humidityDirection = +1;
	private Random rand = new Random();
	List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

	class CollectData implements Runnable {

		@Override
		public void run() {
			System.out.println("Collecting Data.");
			synchronized (GreenHouseSchedule.class) {
				lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
				if (rand.nextInt(5) == 4) {
					tempDirection = -tempDirection;
				}
				lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
				if (rand.nextInt(5) == 4) {
					humidityDirection = -humidityDirection;
				}
				lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();

				data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
			}
		}
	}

	public static void main(String[] args) {
		GreenHouseSchedule gh = new GreenHouseSchedule();
		gh.schedule(gh.new Terminate(), 9000);
		gh.repeat(gh.new Bell(), 0, 1000);
		gh.repeat(gh.new ThremostatNight(), 0, 2000);
		gh.repeat(gh.new LightOn(), 0, 200);
		gh.repeat(gh.new LightOff(), 0, 400);
		gh.repeat(gh.new WaterOn(), 0, 600);
		gh.repeat(gh.new WaterOff(), 0, 800);
		gh.repeat(gh.new ThremostatDay(), 0, 1400);
		gh.repeat(gh.new CollectData(), 500, 500);
	}
}
