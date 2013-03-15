package com.jt.getdunked2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
 
class HttpRequestTask extends AsyncTask<Context, Void, String> {

    private Context context;

    protected String doInBackground(Context... contextParam) {
        context = contextParam[0];
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://api.elophant.com/v2/NA/summoner/Sk%C3%B6gul?key=eS4XmrLVhc7EhPson8dV");
        HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        String html = "";
        InputStream in = null;
		try {
			in = response.getEntity().getContent();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder str = new StringBuilder();
        String line = null;
        try {
			while((line = reader.readLine()) != null)
			{
			    str.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        html = str.toString();
        return html;
     }

}