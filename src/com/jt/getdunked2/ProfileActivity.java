package com.jt.getdunked2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileActivity extends FragmentActivity {

	public class StatsInfo {
		
		public String kills;
	}
	// url to make request
	public static String url = "";
	 
	// JSON Node names
	private static final String TAG_SUMMONER_NAME = "name";
	private static final String TAG_ACCTID = "acctId";
	private static final String TAG_PROFILEICONID = "profileIconId";
	private static final String TAG_SUMMONER_LEVEL = "summonerLevel";
	private static final String TAG_SUCCESS = "success";
	
    static String KEY_RANKED = "song"; // parent node
    static String KEY_SKIN_INDEX = "id";
    static String KEY_SUB_TYPE = "title";
    static String KEY_TEAM_ID = "artist";
    static String KEY_GAME_TYPE = "duration";
    static String KEY_QUEUE_TYPE = "thumb_url";
    static String KEY_RESULT = "result";
    static String KEY_KILLS = "1";
    static String KEY_DEATHS = "1";
    static String KEY_ASSISTS = "1";
    static String KEY_STAT_TYPE = "1";
    static String KEY_VALUE = "1";
    
	 
	String summName = "noob";
	String summLevel = "fail";
	String ranked = "derp";
	public static String acctId = "";
	TextView tvSummName;
	public static String value;
	ListView lv;
	TextView tvKills;
	
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Button btnSearch = (Button) findViewById(R.id.btnSearch);
		btnSearch.setOnClickListener(myhandler);
		lv = (ListView) findViewById(R.id.listViewStats);
		tvKills = (TextView) findViewById(R.id.tvKills);
		
	}
	
	View.OnClickListener myhandler = new View.OnClickListener() {
	    public void onClick(View v) {
			TextView tvDebug = (TextView) findViewById(R.id.tvDebug);
			
			EditText etSearch = (EditText) findViewById(R.id.etSearch);
	    	String summonerUrl = "http://api.elophant.com/v2/NA/summoner/" + etSearch.getText().toString() + "?key=eS4XmrLVhc7EhPson8dV";
	    	
	    	JSONClient client = new JSONClient();
			client.execute(summonerUrl);

	    }
	  };

/****************** GET recent_games *****************************************************/	  
		public class JSONClientTwo extends AsyncTask<String, Void, JSONObject>{
		    /*public JSONClient(Context context, GetJSONListener listener){
		        this.getJSONListener = listener;
		        curContext = context;
		    }*/
		    private String convertStreamToString(InputStream is) {
		        /*
		         * To convert the InputStream to String we use the BufferedReader.readLine()
		         * method. We iterate until the BufferedReader return null which means
		         * there's no more data to read. Each line will appended to a StringBuilder
		         * and returned as String.
		         */
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		        StringBuilder sb = new StringBuilder();

		        String line = null;
		        try {
		            while ((line = reader.readLine()) != null) {
		                sb.append(line + "\n");
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                is.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }

		        return sb.toString();
		    }


		    public JSONObject connect(String url)
		    {
		        HttpClient httpclient = new DefaultHttpClient();

		        // Prepare a request object
		        HttpGet httpget = new HttpGet(url); 

		        // Execute the request
		        HttpResponse response;
		        try {
		            response = httpclient.execute(httpget);
		            // Examine the response status
		            Log.i("Praeda",response.getStatusLine().toString());

		            // Get hold of the response entity
		            HttpEntity entity = response.getEntity();

		            if (entity != null) {

		                // A Simple JSON Response Read
		                InputStream instream = entity.getContent();
		                String result= convertStreamToString(instream);

		                // A Simple JSONObject Creation
		                JSONObject json=new JSONObject(result);

		                // Closing the input stream will trigger connection release
		                instream.close();

		                return json;
		            }


		        } catch (ClientProtocolException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (JSONException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }

		        return null;
		    }
	/*	    @Override
		    public void onPreExecute() {
		        progressDialog = new ProgressDialog(curContext);
		        progressDialog.setMessage("Loading..Please wait..");
		        progressDialog.setCancelable(false);
		        progressDialog.setIndeterminate(true);
		        progressDialog.show();

		    }*/

		    @Override
		    protected JSONObject doInBackground(String... urls) {
		        return connect(urls[0]);
		    }

		    @Override
		    protected void onPostExecute(JSONObject json ) {

		    	

		    	
		        TextView tvSummLevel = (TextView) ProfileActivity.this.findViewById(R.id.tvSummonerLevel);
		        TextView tvDebug = (TextView) ProfileActivity.this.findViewById(R.id.tvDebug);
		        TextView tvKills = (TextView) findViewById(R.id.tvScoreKills); // duration
		        TextView tvDeaths = (TextView) findViewById(R.id.tvScoreDeaths);
		        ArrayList<HashMap<String, String>> listForStuff = new ArrayList<HashMap<String, String>>();
		        try {
		        	JSONObject jObj = json.getJSONObject("data");
		        	JSONArray jArray = jObj.getJSONArray("gameStatistics");
		        	
		        	
		        	
		        	for (int i = 0; i < jArray.length(); i++) {
		        		
		        		JSONObject obj = jArray.getJSONObject(i);
		        		
		        		JSONArray arrayStats = obj.getJSONArray("statistics");
		        		int count = arrayStats.length();
		        		String kills = "";
		        		for (int j = 0; j < count; j++)
		        		{
		        			
		        			JSONObject value = arrayStats.getJSONObject(j);
		        			kills = value.getString("value");
		        			
		        			
		        		}
		        		HashMap<String, String> map = new HashMap<String, String>();
		        		map.put(KEY_KILLS, kills);
		        		 
		        		listForStuff.add(map);
		        		//summonerNames.add(gamesMap);
		        		
		        	}
		        	
/*	        		for (int k = 0; k < statsArray.length(); k++)
	        		{
	        			HashMap<String, String> statsMap = new HashMap<String, String>();
	        			//statType = new String[statsArray.length()];
	        			value = new String[statsArray.length()];
	        			
	        			JSONObject jObjStats = statsArray.getJSONObject(k);
	        			
	        			//statType[k] = jObjStats.getString("statType");
	        			
	        			
	        			statsMap.put(KEY_KILLS, value[26]);
	        			statsMap.put(KEY_DEATHS, value[8]);
	        			summonerNames.add(statsMap);
	        		}*/
		        }
				catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        LazyAdapter adapter = new LazyAdapter(ProfileActivity.this, listForStuff);
		        lv.setAdapter(adapter);
     
		    }
		}
		
		
		
public class ListviewAdapter extends BaseAdapter
{
    public List<StatsInfo> list;
    Activity activity;

    public ListviewAdapter(Activity activity, List<StatsInfo> listForSearchConcepts) {
        super();
        this.activity = activity;
        this.list = listForSearchConcepts;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
        TextView txtFourth;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  activity.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.custom_list_view, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.tvKills);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.tvDeaths);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        StatsInfo statInfo = list.get(position);
        holder.txtFirst.setText(statInfo.kills);

        return convertView;
    }
}

  
/********************** GET summoner ********************************************************/
	public class JSONClient extends AsyncTask<String, Void, JSONObject>{
	    /*public JSONClient(Context context, GetJSONListener listener){
	        this.getJSONListener = listener;
	        curContext = context;
	    }*/
	    private String convertStreamToString(InputStream is) {
	        /*
	         * To convert the InputStream to String we use the BufferedReader.readLine()
	         * method. We iterate until the BufferedReader return null which means
	         * there's no more data to read. Each line will appended to a StringBuilder
	         * and returned as String.
	         */
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        StringBuilder sb = new StringBuilder();

	        String line = null;
	        try {
	            while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        return sb.toString();
	    }


	    public JSONObject connect(String url)
	    {
	        HttpClient httpclient = new DefaultHttpClient();

	        // Prepare a request object
	        HttpGet httpget = new HttpGet(url); 

	        // Execute the request
	        HttpResponse response;
	        try {
	            response = httpclient.execute(httpget);
	            // Examine the response status
	            Log.i("Praeda",response.getStatusLine().toString());

	            // Get hold of the response entity
	            HttpEntity entity = response.getEntity();

	            if (entity != null) {

	                // A Simple JSON Response Read
	                InputStream instream = entity.getContent();
	                String result= convertStreamToString(instream);

	                // A Simple JSONObject Creation
	                JSONObject json=new JSONObject(result);

	                // Closing the input stream will trigger connection release
	                instream.close();

	                return json;
	            }


	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (JSONException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }
/*	    @Override
	    public void onPreExecute() {
	        progressDialog = new ProgressDialog(curContext);
	        progressDialog.setMessage("Loading..Please wait..");
	        progressDialog.setCancelable(false);
	        progressDialog.setIndeterminate(true);
	        progressDialog.show();

	    }*/

	    @Override
	    protected JSONObject doInBackground(String... urls) {
	        return connect(urls[0]);
	    }

	    @Override
	    protected void onPostExecute(JSONObject json ) {

	        tvSummName = (TextView) ProfileActivity.this.findViewById(R.id.tvSummonerName);
	    	//JSONClientTwo clientTwo = new JSONClientTwo();
	    	TextView tvDebug  = (TextView) ProfileActivity.this.findViewById(R.id.tvDebug);
	        try {
	        	JSONObject jObj = json.getJSONObject("data");
				summName = jObj.getString(TAG_SUMMONER_NAME);
				summLevel = jObj.getString(TAG_SUMMONER_LEVEL);
				acctId = jObj.getString(TAG_ACCTID);
				
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			tvSummName.setText(summName + "\n" + summLevel);
			String gamesUrl = "http://api.elophant.com/v2/na/recent_games/" + acctId + "?key=eS4XmrLVhc7EhPson8dV";
			tvDebug.setText(gamesUrl);
			JSONClientTwo clientTwo = new JSONClientTwo();
			clientTwo.execute(gamesUrl);
	    }
	}
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase();
			case 1:
				return getString(R.string.title_section2).toUpperCase();
			case 2:
				return getString(R.string.title_section3).toUpperCase();
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy t)ext.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return textView;
		}
	}

}


	
	