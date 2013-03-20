package com.tara.trackingtara;

import java.util.HashMap;
import java.util.Map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tara.trackingtara.utilities.Logger;
import com.tara.trackingtara.utilities.MarketUtils;

public class GoogleCampaignTrackingReceiver extends BroadcastReceiver {
    // Debug tag
    public static final String DEBUG_TAG = "TRACKING TARA/GoogleCampaignTackingReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
	handleAnalytics(context, intent);
    }
    
    public static void handleAnalytics(Context context, Intent intent) {
	Logger.i(DEBUG_TAG, "onReceive GoogleCampaignTrackingReceiver");
	Bundle extras = intent.getExtras();

	// Workaround for Android security issue:
	// http://code.google.com/p/android/issues/detail?id=16006
	try {
	    // final Bundle extras = intent.getExtras();
	    if (extras != null) {
		extras.containsKey(null);
	    }
	} catch (final Exception e) {
	    return;
	}

	Map<String, String> referralParams = new HashMap<String, String>();

	// Return if this is not the right intent.
	if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) { //$NON-NLS-1$
	    Logger.i(DEBUG_TAG, "intent doesnt equal INSTALL REFERRER");
	    return;
	}

	String referrer = intent.getStringExtra("referrer"); //$NON-NLS-1$
	Logger.i(DEBUG_TAG, "referrer from intent is %s", referrer);
	if (referrer == null || referrer.length() == 0) {
	    return;
	}

	// try { // Remove any url encoding
	//			referrer = URLDecoder.decode(referrer, "x-www-form-urlencoded"); //$NON-NLS-1$
	// } catch (UnsupportedEncodingException e) {
	// return;
	// }

	// Parse the query string, extracting the relevant data
	String[] params = referrer.split("&"); // $NON-NLS-1$
	for (String param : params) {
	    String[] pair = param.split("="); // $NON-NLS-1$
	    referralParams.put(pair[0], pair[1]);
	}

	MarketUtils.storeReferralParams(context, referralParams);
	// Set Context before using EasyTracker. Note that the SDK will use
	// the
	// application context.
	// EasyTracker.getInstance().setContext(context);
	// EasyTracker.getTracker().setCampaign(arg0)
	// EasyTracker.getTracker().setReferrer(arg0)

	// Pass along to google
	// AnalyticsReceiver receiver = new AnalyticsReceiver();
	// receiver.onReceive(context, intent);
    }
}
