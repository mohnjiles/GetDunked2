package com.jt.getdunked2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QPopup extends Fragment {
	
	TextView tvPassiveName;
	ImageView ivPassiveIcon;
	TextView tvHeader1;
	TextView tvHeader2;
	TextView tvHeader3;
	TextView tvHeader4;
	TextView tvHeader5;
	TextView tvValue1;
	TextView tvValue2;
	TextView tvValue3;
	TextView tvValue4;
	TextView tvValue5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View V = inflater.inflate(R.layout.activity_q_popup, container, false);
    	
    	int position = ChampsActivity.myInt;
    	
    	
		
		tvPassiveName = (TextView)V.findViewById(R.id.tvPassiveName);
		ivPassiveIcon = (ImageView)V.findViewById(R.id.imageView1);
		tvHeader1 = (TextView)V.findViewById(R.id.tvHeader1);
		tvHeader2 = (TextView)V.findViewById(R.id.tvHeader2);
		tvHeader3 = (TextView)V.findViewById(R.id.tvHeader3);
		tvHeader4 = (TextView)V.findViewById(R.id.tvHeader4);
		tvHeader5 = (TextView)V.findViewById(R.id.tvHeader5);
		tvValue1 = (TextView)V.findViewById(R.id.tvValue1);
		tvValue2 = (TextView)V.findViewById(R.id.tvValue2);
		tvValue3 = (TextView)V.findViewById(R.id.tvValue3);
		tvValue4 = (TextView)V.findViewById(R.id.tvValue4);
		tvValue5 = (TextView)V.findViewById(R.id.tvValue5);
		
		
		switch (position) {
			case 0:
				SetStuff("Orb of Deception", R.drawable.orb_of_deception, "Range", "Cooldown");
				break;
		}  	
        return V;       
    }

	public void SetStuff(String abilityName, int abilityIcon, String header1, String header2) {
		
		tvPassiveName.setText(abilityName);
		ivPassiveIcon.setImageResource(abilityIcon);
		tvHeader1.setText(header1);
		tvHeader2.setText(header2);
		
	}
}




/*public class QPopup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passive_popup);
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_q_popup, menu);
		return true;
	}
	


}*/
