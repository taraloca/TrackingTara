package com.tara.trackingtara.utilities;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

public class MarketUtils {
	private static final String GOOGLE_PLATINUM = "com.accuweather.paid.android";
	public static final String GOOGLE_FREE = "com.accuweather.android";
	private static final String AMAZON_PLATINUM = "com.accuweather.amazon.paid.android";
	public static final String AMAZON_FREE = "com.accuweather.amazon.android";
	private static final String BARNES_NOBLE_EAN = "2940043875044";

	public static String createReferrer(Context context) {
		final String REFERRER = "&referrer=";

//		String utm_source_value = Constants.ReferrerParameters.UTM_SOURCE_VALUE;  // androidlite
//		String utm_medium_value = Constants.ReferrerParameters.UTM_MEDIUM_VALUE;
//		String utm_campaign_value = PartnerCoding.getPartnerCode(context);
		
		String utm_source_value = PartnerCoding.getPartnerCode(context);
		String utm_medium_value = Constants.ReferrerParameters.UTM_MEDIUM_VALUE;
		String utm_campaign_value = Constants.ReferrerParameters.UTM_SOURCE_VALUE;  // androidlite

		String referrerUrl = REFERRER + Constants.ReferrerParameters.WithMarkup.UTM_SOURCE + utm_source_value
				+ Constants.ReferrerParameters.WithMarkup.UTM_MEDIUM + utm_medium_value
				+ Constants.ReferrerParameters.WithMarkup.UTM_CAMPAIGN + utm_campaign_value;
		Logger.i(context, "createReferrer() url is " + referrerUrl);
		return referrerUrl;
	}

	/*
	 * Stores the referral parameters in the app's sharedPreferences. Rewrite
	 * this function and retrieveReferralParams() if a different storage
	 * mechanism is preferred.
	 */
	public static void storeReferralParams(Context context, Map<String, String> params) {

		SharedPreferences storage = context.getSharedPreferences(Constants.Preferences.REFERRER_PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = storage.edit();

		for (String key : Constants.REFERRER_EXPECTED_PARAMETERS) {
			String value = params.get(key);
			if (value != null) {
				editor.putString(key, value);
			}
			if (key.equals(Constants.ReferrerParameters.WithoutMarkup.UTM_CAMPAIGN)) {
				if (value != null) {
					editor.putString(Constants.Preferences.PREF_PARTNER_CODE, value);
					PartnerCoding.checkPartnerCode(context);
				}
			}
		}
		editor.commit();
	}

	/*
	 * Stores the pCode from the referral params
	 */
	public static void storePartnerCodeFromReferrer(Context context, String pCode) {
		SharedPreferences storage = context.getSharedPreferences(Constants.Preferences.REFERRER_PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = storage.edit();

		editor.putString(Constants.Preferences.PREF_PARTNER_CODE, pCode);
		PartnerCoding.checkPartnerCode(context);
		editor.commit();
	}

	/*
	 * Returns a map with the Market Referral parameters pulled from the
	 * sharedPreferences.
	 */
	public static Map<String, String> retrieveReferralParams(Context context) {
		HashMap<String, String> params = new HashMap<String, String>();
		SharedPreferences storage = context.getSharedPreferences(Constants.Preferences.REFERRER_PREFS_NAME,
				Context.MODE_PRIVATE);

		for (String key : Constants.REFERRER_EXPECTED_PARAMETERS) {
			String value = storage.getString(key, null);
			if (value != null) {
				params.put(key, value);
			}
		}
		return params;
	}

}
