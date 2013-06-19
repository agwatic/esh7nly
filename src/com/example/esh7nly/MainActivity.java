package com.example.esh7nly;

import android.net.Uri;
import android.util.Log;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText t1;
	public String prefix = "#102*";
	Button charge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1 = (EditText) findViewById(R.id.editText1);
		charge = (Button) findViewById(R.id.button1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio0:
	            if (checked){
	                prefix = "#102*";
	            	}
	            	break;
	        case R.id.radio1:
	            if (checked){
	            	prefix = "*"+"858"+"*";
	                //prefix = "#858*";
	                
	            }
	            break;
	        case R.id.radio2:
	            if (checked){
	            	prefix = "*" +"556"+"*";
	                //prefix = "#556*";
	                
	            }
	            break;
	        case R.id.button1:
	        	tv.setText(prefix);
	        	break;
	    }
	}
	
	public void onButtonClicked(View v){
		switch(v.getId()){
		case R.id.button1:
			String number = prefix+t1.getText().toString().trim()+Uri.encode("#");
			Intent intentCall = new Intent();
			intentCall.setAction(Intent.ACTION_CALL);
			intentCall.setData(Uri.parse("tel:"+number));
			startActivity(intentCall);
			tv.setText("Done");
			break;
		
		}
		
	}
}
