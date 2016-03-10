package com.app.weatherapp.models;

import java.io.Serializable;

public class WeatherData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long dateInMillis;
	private double dayTemp;
	private double minTemp;
	private double maxTemp;
	private double nightTemp;
	private double eveTemp;
	private double mornTemp;
	private double pressure;
	private double windSpeed;
	private int humidity;
	private int clouds;
	private double rain;
	private String weatherDescription;
	
	public long getDateInMillis() {
		return dateInMillis;
	}
	
	public void setDateInMillis(long dateInMillis) {
		this.dateInMillis = dateInMillis;
	}
	
	public double getDayTemp() {
		return dayTemp;
	}
	
	public void setDayTemp(double dayTemp) {
		this.dayTemp = dayTemp;
	}
	
	public double getMinTemp() {
		return minTemp;
	}
	
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	
	public double getMaxTemp() {
		return maxTemp;
	}
	
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	public double getNightTemp() {
		return nightTemp;
	}
	
	public void setNightTemp(double nightTemp) {
		this.nightTemp = nightTemp;
	}
	
	public double getEveTemp() {
		return eveTemp;
	}
	
	public void setEveTemp(double eveTemp) {
		this.eveTemp = eveTemp;
	}
	
	public double getMornTemp() {
		return mornTemp;
	}
	
	public void setMornTemp(double mornTemp) {
		this.mornTemp = mornTemp;
	}
	
	public double getPressure() {
		return pressure;
	}
	
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	public double getWindSpeed() {
		return windSpeed;
	}
	
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public int getHumidity() {
		return humidity;
	}
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	public int getClouds() {
		return clouds;
	}
	
	public void setClouds(int clouds) {
		this.clouds = clouds;
	}
	
	public double getRain() {
		return rain;
	}
	
	public void setRain(double rain) {
		this.rain = rain;
	}
	
	public String getWeatherDescription() {
		return weatherDescription;
	}
	
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
