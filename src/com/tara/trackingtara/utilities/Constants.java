package com.tara.trackingtara.utilities;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

public class Constants {

	public static class PackageProperties {
		public static final boolean IS_DEBUGGABLE = true;

		public static class AndroidLite {
			/*
			 * set appropriately depending on Android Lite build or not.
			 */
			public static final boolean IS_ANDROIDLITE = false;

			/*
			 * change this to desired location; leave as empty string if you
			 * want "tap to launch" on empty widget
			 */
			public static final String PRELOAD_CITY = "349727";
		}
	}
	
	 public static class Actions {
		public static final String GET_FULL_APP = "com.accuweather.android.action.GET_FULL_APP";
	    }

	public static class ReferrerParameters {
		public static class WithMarkup {
			public static final String REFERRER = "&referrer=";
			public static final String UTM_SOURCE = "utm_source%3D";
			public static final String UTM_MEDIUM = "%26utm_medium%3D";
			public static final String UTM_CAMPAIGN = "%26utm_campaign%3D";
		}

		public static class WithoutMarkup {
			public static final String REFERRER = "referrer";
			public static final String UTM_SOURCE = "utm_source";
			public static final String UTM_MEDIUM = "utm_medium";
			public static final String UTM_CAMPAIGN = "utm_campaign";
		}

		public static String UTM_SOURCE_VALUE = "androidlite";
		public static String UTM_MEDIUM_VALUE = "tracking";
	}

	public static final String[] REFERRER_EXPECTED_PARAMETERS = { ReferrerParameters.WithoutMarkup.UTM_SOURCE,
			ReferrerParameters.WithoutMarkup.UTM_MEDIUM, ReferrerParameters.WithoutMarkup.UTM_CAMPAIGN };

	public static class Preferences {
		public static final String AL_REPORTED_GOOGLE_ANALYTICS = "al_reported_google_analytics";
		public static final String PREF_PARTNER_CODE = "pref_p_code";
		public static final String REFERRER_PREFS_NAME = "referral_params";
		public static final String IS_FROM_ANDROID_LITE = "is_from_android_lite";

		public static class LaunchModes {
			public static final String CURRENT = "0";
			public static final String HOME = "1";
			public static final String LAST_VIEWED = "2";
		}

		public static class PreferenceCategories {
			public static final String RATE_UPGRADE_CATEGORY = "rate_upgrade_category";
			public static final String NOTIFICATIONS_CATEGORY = "notifications_category";
		}

	}

}