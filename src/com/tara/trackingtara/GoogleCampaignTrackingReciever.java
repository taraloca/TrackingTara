package com.tara.trackingtara;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class GoogleCampaignTrackingReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
	// Workaround for Android security issue:
	// http://code.google.com/p/android/issues/detail?id=16006
	try {
	    final Bundle extras = intent.getExtras();
	    if (extras != null) {
		extras.containsKey(null);
	    }
	} catch (final Exception e) {
	    return;
	}

	Map<String, String> referralParams = new HashMap<String, String>();

	// Return if this is not the right intent.
	if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) { //$NON-NLS-1$
	    return;
	}

	String referrer = intent.getStringExtra("referrer"); //$NON-NLS-1$
	if (referrer == null || referrer.length() == 0) {
	    return;
	}

	try { // Remove any url encoding
	    referrer = URLDecoder.decode(referrer, "x-www-form-urlencoded"); //$NON-NLS-1$
	} catch (UnsupportedEncodingException e) {
	    return;
	}

	// Parse the query string, extracting the relevant data
	String[] params = referrer.split("&"); // $NON-NLS-1$
	for (String param : params) {
	    String[] pair = param.split("="); // $NON-NLS-1$
	    referralParams.put(pair[0], pair[1]);
	}

	GoogleCampaignTrackingReciever.storeReferralParams(context, referralParams);
    }

    private final static String[] EXPECTED_PARAMETERS = { "utm_source", "utm_medium", "utm_term", "utm_content",
	    "utm_campaign" };
    private final static String PREFS_FILE_NAME = "ReferralParamsFile";

    /*
     * Stores the referral parameters in the app's sharedPreferences. Rewrite
     * this function and retrieveReferralParams() if a different storage
     * mechanism is preferred.
     */
    public static void storeReferralParams(Context context, Map<String, String> params) {
	SharedPreferences storage = context.getSharedPreferences(GoogleCampaignTrackingReciever.PREFS_FILE_NAME,
		Context.MODE_PRIVATE);
	SharedPreferences.Editor editor = storage.edit();

	for (String key : GoogleCampaignTrackingReciever.EXPECTED_PARAMETERS) {
	    String value = params.get(key);
	    if (value != null) {
		editor.putString(key, value);
	    }
	}

	editor.commit();
    }

    /*
     * Returns a map with the Market Referral parameters pulled from the
     * sharedPreferences.
     */
    public static Map<String, String> retrieveReferralParams(Context context) {
	HashMap<String, String> params = new HashMap<String, String>();
	SharedPreferences storage = context.getSharedPreferences(GoogleCampaignTrackingReciever.PREFS_FILE_NAME,
		Context.MODE_PRIVATE);

	for (String key : GoogleCampaignTrackingReciever.EXPECTED_PARAMETERS) {
	    String value = storage.getString(key, null);
	    if (value != null) {
		params.put(key, value);
	    }
	}
	return params;
    }
}
