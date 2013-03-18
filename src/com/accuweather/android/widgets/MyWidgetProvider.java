package com.accuweather.android.widgets;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.analytics.tracking.android.AnalyticsReceiver;
import com.tara.trackingtara.R;
import com.tara.trackingtara.R.id;
import com.tara.trackingtara.R.layout;
import com.tara.trackingtara.utilities.Logger;
import com.tara.trackingtara.utilities.MarketUtils;

public class MyWidgetProvider extends AppWidgetProvider {

    private static final String ACTION_CLICK = "ACTION_CLICK";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

	// Get all ids
	ComponentName thisWidget = new ComponentName(context, MyWidgetProvider.class);
	int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
	for (int widgetId : allWidgetIds) {
	    // Create some random data
	    int number = (new Random().nextInt(100));

	    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
	    Log.w("WidgetExample", String.valueOf(number));
	    // Set the text
	    remoteViews.setTextViewText(R.id.update, String.valueOf(number));

	    // Register an onClickListener
	    Intent intent = new Intent(context, MyWidgetProvider.class);

	    intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
	    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

	    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
		    PendingIntent.FLAG_UPDATE_CURRENT);
	    remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
	    appWidgetManager.updateAppWidget(widgetId, remoteViews);
	}
    }

    // @Override
    // public void onReceive(Context context, Intent intent) {
    // String action = intent.getAction();
    // if (action.equals("com.android.vending.INSTALL_REFERRER")) {
    //
    // Map<String, String> referralParams = new HashMap<String, String>();
    //
    // // Return if this is not the right intent.
    //			if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) { //$NON-NLS-1$
    // return;
    // }
    //
    //			String referrer = intent.getStringExtra("referrer"); //$NON-NLS-1$
    // if (referrer == null || referrer.length() == 0) {
    // return;
    // }
    //
    // // Parse the query string, extracting the relevant data
    // String[] params = referrer.split("&"); // $NON-NLS-1$
    // for (String param : params) {
    // String[] pair = param.split("="); // $NON-NLS-1$
    // referralParams.put(pair[0], pair[1]);
    // }
    //
    // MarketUtils.storeReferralParams(context, referralParams);
    // // Set Context before using EasyTracker. Note that the SDK will use
    // // the
    // // application context.
    // // EasyTracker.getInstance().setContext(context);
    // // EasyTracker.getTracker().setCampaign(arg0)
    // // EasyTracker.getTracker().setReferrer(arg0)
    //
    // // Pass along to google
    // // AnalyticsReceiver receiver = new AnalyticsReceiver();
    // // receiver.onReceive(context, intent);
    //
    // }
    //
    // super.onReceive(context, intent);
    // }

    public static class GoogleCampaignTrackingReceiver extends AnalyticsReceiver {
	// Debug tag
	public static final String DEBUG_TAG = "TRACKING TARA/GoogleCampaignTackingReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
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
}
