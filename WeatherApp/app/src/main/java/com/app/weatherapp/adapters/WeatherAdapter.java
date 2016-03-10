package com.app.weatherapp.adapters;

import java.util.ArrayList;

import com.app.weatherapp.R;
import com.app.weatherapp.models.WeatherData;
import com.app.weatherapp.utility.Utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeatherAdapter extends BaseAdapter {

	// private Context context;
	private ArrayList<WeatherData> dataList;

	private LayoutInflater inflater;

	public WeatherAdapter(Context context, ArrayList<WeatherData> data) {
		super();
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.dataList = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public WeatherData getItem(int arg0) {
		// TODO Auto-generated method stub
		return dataList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
	
		if (view == null) {

			viewHolder = new ViewHolder();

			view = inflater.inflate(R.layout.weather_item, null);

			viewHolder.cloudTv = (TextView) view.findViewById(R.id.cloudsTv);
			viewHolder.rainTv = (TextView) view.findViewById(R.id.rainTv);
			viewHolder.pressureTv = (TextView) view
					.findViewById(R.id.pressureTv);
			viewHolder.humidityTv = (TextView) view
					.findViewById(R.id.humidityTv);
			viewHolder.dayTempTv = (TextView) view.findViewById(R.id.dayTempTv);
			viewHolder.eveTempTv = (TextView) view.findViewById(R.id.eveTempTv);
			viewHolder.morningTempTv = (TextView) view
					.findViewById(R.id.morTempTv);
			viewHolder.nightTempTv = (TextView) view
					.findViewById(R.id.nightTempTv);
			viewHolder.minTempTv = (TextView) view.findViewById(R.id.minTemp);
			viewHolder.maxTempTv = (TextView) view.findViewById(R.id.maxTempTv);
			viewHolder.speedTv = (TextView) view.findViewById(R.id.windTv);
			viewHolder.weathrInfo = (TextView) view
					.findViewById(R.id.weatherType);

			view.setTag(viewHolder);

		} else {

			viewHolder = (ViewHolder) view.getTag();
		}

		WeatherData weatherData = getItem(arg0);

		viewHolder.cloudTv.setText("Clouds \n" + weatherData.getClouds() + "%");
		viewHolder.speedTv.setText("Wind \n" + weatherData.getWindSpeed()
				+ " m/s");
		viewHolder.rainTv.setText("Rain \n" + weatherData.getRain() + " mm");
		viewHolder.dayTempTv.setText("Day \n" + weatherData.getDayTemp() + " K");
		viewHolder.nightTempTv.setText("Night \n" + weatherData.getNightTemp()
				+ " K");
		viewHolder.maxTempTv.setText("Max \n" + weatherData.getMaxTemp() + " K");
		viewHolder.minTempTv.setText("Min \n" + weatherData.getMinTemp() + " K");
		viewHolder.morningTempTv.setText("Morning \n"
				+ weatherData.getMornTemp() + " K");
		viewHolder.eveTempTv.setText("Eve \n" + weatherData.getEveTemp() + " K");
		viewHolder.pressureTv.setText("Pressure " + weatherData.getPressure()
				+ " hPA");
		viewHolder.humidityTv.setText("Humidity " + weatherData.getHumidity()
				+ "%");
		viewHolder.weathrInfo.setText("Weather--"
				+ weatherData.getWeatherDescription() + "\n As on "
				+ Utility.getDateFromMillis(weatherData.getDateInMillis()));

		return view;
	}

	public class ViewHolder {

		TextView weathrInfo;
		TextView pressureTv;
		TextView humidityTv;
		TextView dayTempTv;
		TextView morningTempTv;
		TextView eveTempTv;
		TextView maxTempTv;
		TextView minTempTv;
		TextView nightTempTv;
		TextView rainTv;
		TextView speedTv;
		TextView cloudTv;

	}

}
