package com.gc.util;

public class API {
	private String weather;
	private double temp_f;
	private String feelslike_f;
	private String precip_today_in;
	private String icon;
	private String relative_humidity;
	private String windchill_f;
	private String wind_gust_mph;
	private String icon_URL;
	private String cityState;
	
	
	// the empty constructor API
	public API () {
		
	}
	
	// the overloaded constructor API
	public API(String weather, double temp_f, String feelslike_f, String precip_today_in, String icon,
			String relative_humidity, String windchill_f, String wind_gust_mph, String icon_URL, String cityState) {
		//super();
		this.weather = weather;
		this.temp_f = temp_f;
		this.feelslike_f = feelslike_f;
		this.precip_today_in = precip_today_in;
		this.icon = icon;
		this.relative_humidity = relative_humidity;
		this.windchill_f = windchill_f;
		this.wind_gust_mph = wind_gust_mph;
		this.icon_URL = icon_URL;
		this.cityState = cityState;
	}
	// the getters and setters

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public double getTemp_f() {
		return temp_f;
	}

	public void setTemp_f(double temp_f) {
		this.temp_f = temp_f;
	}

	public String getFeelslike_f() {
		return feelslike_f;
	}

	public void setFeelslike_f(String feelslike_f) {
		this.feelslike_f = feelslike_f;
	}

	public String getPrecip_today_in() {
		return precip_today_in;
	}

	public void setPrecip_today_in(String precip_today_in) {
		this.precip_today_in = precip_today_in;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(String relative_humidity) {
		this.relative_humidity = relative_humidity;
	}

	public String getWindchill_f() {
		return windchill_f;
	}

	public void setWindchill_f(String windchill_f) {
		this.windchill_f = windchill_f;
	}

	public String getWind_gust_mph() {
		return wind_gust_mph;
	}

	public void setWind_gust_mph(String wind_gust_mph) {
		this.wind_gust_mph = wind_gust_mph;
	}

	public String getIcon_URL() {
		return icon_URL;
	}

	public void setIcon_URL(String icon_URL) {
		this.icon_URL = icon_URL;
	}
	
	public String getCityState() {
		return cityState;
		
	}
	
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	@Override
	public String toString() {
		return "API [weather=" + weather + ", temp_f=" + temp_f + ", feelslike_f=" + feelslike_f + ", precip_today_in="
				+ precip_today_in + ", icon=" + icon + ", relative_humidity=" + relative_humidity + ", windchill_f="
				+ windchill_f + ", wind_gust_mph=" + wind_gust_mph + ", icon_URL=" + icon_URL + ", full" + cityState + "]";
	}
	
	
	
	
	

}
