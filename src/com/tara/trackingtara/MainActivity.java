package com.tara.trackingtara;

import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.tara.trackingtara.utilities.Constants;
import com.tara.trackingtara.utilities.Logger;
import com.tara.trackingtara.utilities.MarketUtils;
import com.tara.trackingtara.utilities.PartnerCoding;

public class MainActivity extends Activity {
    private MainActivity mSelf;
    private TextView mUtmSource;
    private TextView mUtmMedium;
    private TextView mUtmCampaign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Logger.i(this, "onCreate()");
	mSelf = this;

	boolean isFromAndroidLite = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(
		Constants.Preferences.IS_FROM_ANDROID_LITE, false);

	if (isFromAndroidLite) {
	    Toast.makeText(this, "you made it to the full application", Toast.LENGTH_LONG).show();
	    // Vibrate the phone
	    Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
	    vibrator.vibrate(2000);
	    PreferenceManager.getDefaultSharedPreferences(this).edit()
		    .putBoolean(Constants.Preferences.IS_FROM_ANDROID_LITE, true).commit();

	    // Call setContext() here so that we can access EasyTracker to
	    // update campaign information before activityStart() is called.
	    PartnerCoding.checkPartnerCode(mSelf);

	    EasyTracker.getInstance().setContext(mSelf);
	    EasyTracker
		    .getTracker()
		    .setCampaign(
			    "utm_campaign=androidlite_campaign_v20&utm_source=androidlite_source_v20&utm_medium=androidlite_medium_v20&utm_term=androidlite_term_v20&utm_content=androidlite_content_v20");
	    PreferenceManager.getDefaultSharedPreferences(this).edit()
		    .putBoolean(Constants.Preferences.IS_FROM_ANDROID_LITE, false).commit();
	    
	    Logger.i(this, "isFromAndroidLite %s with partner code %s", Boolean.toString(isFromAndroidLite),
			PartnerCoding.getPartnerCode(mSelf));
	}
	init();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
    }

    @Override
    public void onStart() {
	super.onStart();
	Logger.i(this, "onStart()");
	EasyTracker.getInstance().activityStart(this);

    }

    @Override
    protected void onStop() {
	super.onStop();
	EasyTracker.getInstance().activityStop(this);
	Logger.i(this, "onStop() partner code in TrackingTara is %s", PartnerCoding.getPartnerCode(mSelf));
    }

    private void init() {
	mUtmSource = (TextView) findViewById(R.id.utmSourceValue);
	mUtmMedium = (TextView) findViewById(R.id.utmMediumValue);
	mUtmCampaign = (TextView) findViewById(R.id.utmCampaignValue);
	mUtmSource.setText(PartnerCoding.getPartnerCode(mSelf));

    }

}
