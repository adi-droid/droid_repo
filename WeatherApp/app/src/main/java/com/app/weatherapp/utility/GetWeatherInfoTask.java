package com.app.weatherapp.utility;

import android.os.AsyncTask;

import com.app.weatherapp.interfaces.APIStatus;
import com.djhs16.net.JSONParser;
import com.djhs16.net.JSONParser.Http;
import org.json.JSONObject;

//Common API task to get data from API
public class GetWeatherInfoTask extends AsyncTask<Void, Void, JSONObject> {

    private APIStatus apiStatus;
    //private JSONObject jsonObject;
    private static final String MODE = "json";
    private static final String COUNT = "14";
    private static final String UNITS = "metric";
    private String queryStr;
    private static final String APP_ID = "13560574c722b5260e3e4d950a305386";
    private static final String url = "&mode=" + MODE + "&units=" + UNITS + "&cnt=" + COUNT + "&appid=" + APP_ID;

    public GetWeatherInfoTask(APIStatus apiStatus, String query) {
        this.apiStatus = apiStatus;
        //this.jsonObject = jsonObject;
        this.queryStr = query;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        return new JSONParser().getJsonObjectFromHttp(Urls.URL + queryStr + url, null,Http.GET);
    }

    @Override
    protected void onPostExecute(final JSONObject response) {
    	
    	try {
			if(response!=null){
				apiStatus.OnSuccess(response);
			}else{
				 apiStatus.OnFail();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			apiStatus.OnFail();
		}
        
    }

    @Override
    protected void onCancelled() {
        apiStatus.OnFail();
    }
}