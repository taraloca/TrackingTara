package com.tara.trackingtara;

import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.tara.trackingtara.utilities.Constants;
import com.tara.trackingtara.utilities.Logger;
import com.tara.trackingtara.utilities.MarketUtils;
import com.tara.trackingtara.utilities.PartnerCoding;

public class MainActivity extends Activity {
	private static final String DEBUG_TAG = "TRACKING_TARA/MainActivity";
	private boolean mIsFromLite = false;
	private MainActivity mSelf;
	private TextView mUtmSource;
	private TextView mUtmMedium;
	private TextView mUtmCampaign;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GoogleCampaignTrackingReceiver.handleAnalytics(this, getIntent());
		setContentView(R.layout.activity_main);
		Logger.i(DEBUG_TAG, "onCreate()");
		mSelf = this;
		
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
		Logger.i(DEBUG_TAG, "onStart()");
		EasyTracker.getInstance().activityStart(this);
		
		// from 1.11
//		EasyTracker.getInstance().setContext(mSelf);
//		EasyTracker.getTracker().trackView(getClass().getSimpleName());
		Map<String, String> retrieveReferralParams = MarketUtils.retrieveReferralParams(this);
		// if (true) {
		Logger.i(DEBUG_TAG, "referralParams isEmpty? " + Boolean.toString(retrieveReferralParams.isEmpty()));
		if (!retrieveReferralParams.isEmpty()) {
			if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean(
					Constants.Preferences.AL_REPORTED_GOOGLE_ANALYTICS, false)) {
				mIsFromLite = true;
				String utmSource = retrieveReferralParams.get(Constants.ReferrerParameters.WithoutMarkup.UTM_SOURCE);
				String utmMedium = retrieveReferralParams.get(Constants.ReferrerParameters.WithoutMarkup.UTM_MEDIUM);
				String utmCampaign = retrieveReferralParams
						.get(Constants.ReferrerParameters.WithoutMarkup.UTM_CAMPAIGN);
				Logger.i(DEBUG_TAG, "utmSource = " + utmSource + " utmMedium = " + utmMedium + " utmCampaign " + utmCampaign);

				Map<String, String> params = MarketUtils.retrieveReferralParams(mSelf);
				String campaign = null;
				String referrer = null;

				for (String key : Constants.REFERRER_EXPECTED_PARAMETERS) {
					String value = params.get(key);
					if (key.equals(Constants.ReferrerParameters.WithoutMarkup.UTM_CAMPAIGN)) {
						if (value != null) {
							campaign = value;
						}
					} else if (key.equals(Constants.ReferrerParameters.WithoutMarkup.REFERRER)) {
						referrer = value;
					}
				}
				// Set Context before using EasyTracker. Note that the SDK will
				// use the
				// application context.
				// EasyTracker.getInstance().setContext(mSelf);
				// if (!TextUtils.isEmpty(campaign)) {
				// EasyTracker.getTracker().setCampaign(campaign);
				// }
				// if (!TextUtils.isEmpty(referrer)) {
				// EasyTracker.getTracker().setReferrer(referrer);
				// }
			}
		}
		init();

	}

	@Override
	protected void onStop() {
		super.onStop();
		EasyTracker.getInstance().activityStop(this);
		Logger.i(DEBUG_TAG, "onStop() partner code in TrackingTara is %s", PartnerCoding.getPartnerCode(mSelf));
	}

	private void init() {
		mUtmSource = (TextView) findViewById(R.id.utmSourceValue);
		mUtmMedium = (TextView) findViewById(R.id.utmMediumValue);
		mUtmCampaign = (TextView) findViewById(R.id.utmCampaignValue);

		Map<String, String> params = MarketUtils.retrieveReferralParams(mSelf);

		String source = "";
		String medium = "";
		String campaign = "";

		for (String key : Constants.REFERRER_EXPECTED_PARAMETERS) {
			String value = params.get(key);
			if (key.equals(Constants.ReferrerParameters.WithoutMarkup.UTM_SOURCE)) {
				if (value != null) {
					source = value;
				}
			} else if (key.equals(Constants.ReferrerParameters.WithoutMarkup.UTM_MEDIUM)) {
				medium = value;
			} else if (key.equals(Constants.ReferrerParameters.WithoutMarkup.UTM_CAMPAIGN)) {
				campaign = value;
			}
		}
		
		mUtmSource.setText(source);
		mUtmMedium.setText(medium);
		mUtmCampaign.setText(campaign);
	}

}
