package com.qoros.videodemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONActivity extends AppCompatActivity {

    String ApiUrl = "http://api.openweathermap.org/data/2.5/weather?q=London&&appid=c39704b2f50e32c92b81932749308943";
    EditText cityName;
    TextView resultTextView;

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls){
            try{
                String result = "";
                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);
                int data = reader.read();
                while (data != -1){
                    result += (char) data;
                    data = reader.read();
                }

                return result;


            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            try
            {
                String mainweather = "";
                float max = 0;
                float min = 0;
                JSONObject jsonObject = new JSONObject(s);
                String weatherInfo = jsonObject.getString("weather");
                Log.i("Weather content",weatherInfo);

                JSONArray arr = new JSONArray(weatherInfo);

                for (int i=0;i<arr.length();i++){
                    JSONObject jsonPart = arr.getJSONObject(i);
                    Log.i("JSON","main " + jsonPart.getString("main"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }

            Log.i("Weather","Post result" +s );

        }
    }

    protected void submit(View view){

        String city = cityName.getText().toString();

        Log.i("Json","inside submit");
        DownloadTask task = new DownloadTask();
        task.execute(ApiUrl);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        cityName = (EditText) findViewById(R.id.cityEditText);
        resultTextView = (TextView) findViewById(R.id.weatherTextView);




    }
}

