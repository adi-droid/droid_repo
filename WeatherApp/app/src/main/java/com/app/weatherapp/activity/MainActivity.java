package com.app.weatherapp.activity;


import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.app.weatherapp.R;

import com.app.weatherapp.adapters.WeatherAdapter;
import com.app.weatherapp.interfaces.APIStatus;
import com.app.weatherapp.models.WeatherData;
import com.app.weatherapp.utility.GetWeatherInfoTask;
import com.app.weatherapp.utility.NetworkAvailablity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) 
public class MainActivity extends AppCompatActivity implements OnClickListener {

	
    private EditText cityEditText;
    
    private Button getWeatherBtn;
    
    private ListView weatherListView;
    
    //list adapter
    private WeatherAdapter adapter;
    
    //data collection
    private ArrayList<WeatherData> dataList = new ArrayList<WeatherData>();
    
    private String queryStr;
    
    private ProgressDialog progressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //progress dialog initialize
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        //Finding view id's
        getWeatherBtn = (Button) findViewById(R.id.getWeatherBtn);
        cityEditText = (EditText) findViewById(R.id.cityNameEt);
        weatherListView = (ListView) findViewById(R.id.weatherList);
        getWeatherBtn.setOnClickListener(this);

        //setting up adapter
        adapter = new WeatherAdapter(this, dataList);
        weatherListView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.getWeatherBtn:
                queryStr = cityEditText.getText().toString().trim();

                if (queryStr.length() != 0) {

                	//Network check
                  if(NetworkAvailablity.chkStatus(this)){
                	  
                	dataList.clear();
                	  
                    if (progressDialog != null && !progressDialog.isShowing())
                        progressDialog.show();

                    //API call
                    GetWeatherInfoTask weatherInfoTask = new GetWeatherInfoTask(new APIStatus() {
                    	
                        @Override
                        public void OnSuccess(JSONObject response) {
                        	
                            if (progressDialog != null && progressDialog.isShowing())
                                progressDialog.dismiss();

                            if (response != null) {

                                JSONArray jsonArray = response.optJSONArray("list");

                                if (jsonArray != null && jsonArray.length()!=0) {

                                    for (int i = 0; i < jsonArray.length(); i++) {

                                    	JSONObject dataObj = jsonArray.optJSONObject(i);
                                    	
                                        WeatherData weatherData = new WeatherData();
                                        
                                        if(dataObj.has("pressure"))
                                        	weatherData.setPressure(dataObj.optDouble("pressure"));
                                        
                                        if(dataObj.has("humidity"))
                                        	weatherData.setHumidity(dataObj.optInt("humidity"));
                                        
                                        if(dataObj.has("dt"))
                                        	weatherData.setDateInMillis(dataObj.optLong("dt"));
                                        
                                        if(dataObj.has("speed"))
                                        	weatherData.setWindSpeed(dataObj.optDouble("speed"));
                                        
                                        if(dataObj.has("clouds"))
                                        	weatherData.setClouds(dataObj.optInt("clouds"));
                                        
                                        if(dataObj.has("rain"))
                                        	weatherData.setRain(dataObj.optLong("rain"));
                                        
                                        JSONObject temperature = dataObj.optJSONObject("temp");

                                        if (temperature != null) {
                                        	if(temperature.has("day"))
                                              weatherData.setDayTemp(temperature.optDouble("day"));
                                        	if(temperature.has("morn"))
                                              weatherData.setMornTemp(temperature.optDouble("morn"));
                                        	if(temperature.has("eve"))
                                              weatherData.setEveTemp(temperature.optDouble("eve"));
                                        	if(temperature.has("night"))
                                              weatherData.setNightTemp(temperature.optDouble("night"));
                                        	if(temperature.has("min"))
                                               weatherData.setMinTemp(temperature.optDouble("min"));
                                        	if(temperature.has("max"))
                                                weatherData.setMaxTemp(temperature.optDouble("max"));
                                        }
                                        
                                        JSONArray weatherArray = dataObj.optJSONArray("weather");
                                        
                                        if(weatherArray!=null && weatherArray.length()!=0){
                                        	                      
                                        	JSONObject weatherObj = weatherArray.optJSONObject(0);
                                        	weatherData.setWeatherDescription(weatherObj.optString("description"));
             
                                        }
                                        
                                        dataList.add(weatherData);

                                    }
                                    adapter.notifyDataSetChanged();

                                }

                            } else {
                                Toast.makeText(MainActivity.this, "Data not found", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void OnFail() {
                            if (progressDialog != null && progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Data not found", Toast.LENGTH_LONG).show();
                        }
                    }, queryStr);

                    weatherInfoTask.execute();
                    
                	}else{
                		Toast.makeText(this, "Please check your network connection", Toast.LENGTH_LONG).show();
                	}
                  
                } else {
                    Toast.makeText(this, "Please enter city name", Toast.LENGTH_LONG).show();
                }

                break;

            default:
                break;
        }
    }
}
