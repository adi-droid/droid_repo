package com.app.weatherapp.interfaces;

import org.json.JSONObject;


//Interface to check API callback
public interface APIStatus {

    void OnSuccess(JSONObject response);

    void OnFail();
}
