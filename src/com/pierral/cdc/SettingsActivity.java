package com.pierral.cdc;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;

public class SettingsActivity extends PreferenceActivity {

	@TargetApi(14)
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// Permet de gérer le mode paysage sur tablette
		if(getResources().getBoolean(R.bool.portrait_only)){
			setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}else {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		}
        addPreferencesFromResource(R.layout.settings);
        

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
        	ActionBar actionBar = getActionBar();
        	actionBar.setDisplayHomeAsUpEnabled(true);
        }
	}


   	public boolean onOptionsItemSelected(MenuItem item) {
   	    // Handle item selection
   	    switch (item.getItemId()) {
   	    case android.R.id.home:
   	    	onBackPressed();
   	    default:
   	        return super.onOptionsItemSelected(item);
   	    }
   	}
}
