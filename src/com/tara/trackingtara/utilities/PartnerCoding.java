package com.tara.trackingtara.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

public class PartnerCoding {
    private static final String DEBUG_TAG = "TRACKING_TARA/PartnerCoding";
    public static final String PARTNER_CODE_DELIMITER = "#@!@";
    public static String AD_SERVER_URL_TEST = "http://adserver-demo.amobee.com/upsteed/wap/adrequest"; // Amobee
												       // test
    public static String AD_SERVER_URL = "http://accuprod.amobee.com/upsteed/wap/adrequest"; // Amobee
											     // live
    public static final int AD_REFRESH_INTERVAL_0 = 0;
    public static final int AD_REFRESH_INTERVAL_30 = 30;
    public static final String TREMOR_ADSPACE_PRODUCTION = "372891";
    public static final String TREMOR_ADSPACE_TEST = "test";

    public static class PartnerCodes {

	public static final String PARTNER_CODE_FILE_NAME = "accuwx_pcode";
	public static final String PARTNER_CODE_ANDROIDLITE_FILE_NAME = "accuwx_androidlite_pcode";

	// SDK
	public static final String GOOGLE_PARTNER_CODE = "androidflagship3";

	public static final String O2_PARTNER_CODE = "androido2";
	public static final String BOUYGUES_PARTNER_CODE = "androidbouygues";
	public static final String BARNES_AND_NOBLE_PARTNER_CODE = "androidbarnesandnoble";
	public static final String HTC_PARTNER_CODE = "androidhtc";

	public static final String CISCO_PARTNER_CODE = "androidcisco";
	public static final String SONY_ERICSSON_PARTNER_CODE = "androidsonyericsson";
	public static final String MICROMAX_PARTNER_CODE = "androidmicromax";
	public static final String COBY_PARTNER_CODE = "androidcoby";

	public static final String ORANGE_PARTNER_CODE = "androidorange";
	public static final String NTELOS_PARTNER_CODE = "androidntelos";
	public static final String US_CELLULAR_PARTNER_CODE = "androiduscellular";
	public static final String GETJAR_PARTNER_CODE = "androidgetjar";

	public static final String ZTE_PARTNER_CODE = "androidzte";
	public static final String METRO_PCS_PARTNER_CODE = "androidmetropcs";
	public static final String HUAWEI_PARTNER_CODE = "androidhuawei";
	public static final String PANTECH_PARTNER_CODE = "androidpantech";

	public static final String SPRINT_XAD_PARTNER_CODE = "androidsprintxad";
	public static final String SAMSUNG_PARTNER_CODE = "androidsamsung";
	public static final String NOOK_PARTNER_CODE = "androidflagnook";
	public static final String LENOVO_PARTNER_CODE = "androidlenovo";

	public static final String VODAFONE_PARTNER_CODE = "androidvodafone";
	public static final String DELL_PARTNER_CODE = "androiddell";
	public static final String VIEWSONIC_PARTNER_CODE = "androidviewsonic";
	public static final String FUJITSU_PARTNER_CODE = "androidfujitsu";

	public static final String STREAMTV_PARTNER_CODE = "androidstreamtv";
	public static final String TCL_PARTNER_CODE = "tcl";
	public static final String AMAZON_PARTNER_CODE = "androidamazonv2";
	public static final String ATT_PARTNER_CODE = "androidatt";

	public static final String FUHU_PARTNER_CODE = "androidfuhu";
	public static final String MOBILE_WEAVER_PARTNER_CODE = "androidmobileweaver";
	public static final String TMOBILE_PARTNER_CODE = "androidtmobile";
	public static final String DOCOMO_PARTNER_CODE = "androiddocomo";

	public static final String VERIZON_PARTNER_CODE = "androidverizon";
	public static final String TRACPHONE_PARTNER_CODE = "androidtracfone";
	public static final String POCKETBOOK_USA_PARTNER_CODE = "androidpocketbookusa";
	public static final String GROUP_SENSE_PARTNER_CODE = "androidgroupsense";

	public static final String ANDROID_PIT_PARTNER_CODE = "androidpit";
	public static final String MEDION_PARTNER_CODE = "androidmedion";
	public static final String TOSHIBA_PARTNER_CODE = "androidtoshiba";
	public static final String AMOBEE_TEST_PARTNER_CODE = "androidamobeetest";
	public static final String WALMART_PARTNER_CODE = "HKCTablet";
	public static final String ANDROID_LITE_PARTNER_CODE = "androidlite";

	public static final String ACER_PARTNER_CODE = "androidacer";

	public static final String PARTNER_CODE = "androidlitetrackingtara";

    }

    public static HashMap<String, String> PartnerCode_AdSpace = new HashMap<String, String>();
    static {

	// SDK Codes
	PartnerCode_AdSpace.put(PartnerCodes.GOOGLE_PARTNER_CODE, new String("23569"));

	PartnerCode_AdSpace.put(PartnerCodes.O2_PARTNER_CODE, new String("22686"));
	PartnerCode_AdSpace.put(PartnerCodes.BOUYGUES_PARTNER_CODE, new String("22688"));
	PartnerCode_AdSpace.put(PartnerCodes.BARNES_AND_NOBLE_PARTNER_CODE, new String("22690"));
	PartnerCode_AdSpace.put(PartnerCodes.HTC_PARTNER_CODE, new String("22692"));

	PartnerCode_AdSpace.put(PartnerCodes.CISCO_PARTNER_CODE, new String("22694"));
	PartnerCode_AdSpace.put(PartnerCodes.SONY_ERICSSON_PARTNER_CODE, new String("22696"));
	PartnerCode_AdSpace.put(PartnerCodes.MICROMAX_PARTNER_CODE, new String("22698"));
	PartnerCode_AdSpace.put(PartnerCodes.COBY_PARTNER_CODE, new String("22700"));

	PartnerCode_AdSpace.put(PartnerCodes.ORANGE_PARTNER_CODE, new String("22670"));
	PartnerCode_AdSpace.put(PartnerCodes.NTELOS_PARTNER_CODE, new String("22672"));
	PartnerCode_AdSpace.put(PartnerCodes.US_CELLULAR_PARTNER_CODE, new String("22674"));
	PartnerCode_AdSpace.put(PartnerCodes.GETJAR_PARTNER_CODE, new String("22676"));

	PartnerCode_AdSpace.put(PartnerCodes.ZTE_PARTNER_CODE, new String("22678"));
	PartnerCode_AdSpace.put(PartnerCodes.METRO_PCS_PARTNER_CODE, new String("22680"));
	PartnerCode_AdSpace.put(PartnerCodes.HUAWEI_PARTNER_CODE, new String("22682"));
	PartnerCode_AdSpace.put(PartnerCodes.PANTECH_PARTNER_CODE, new String("22684"));

	PartnerCode_AdSpace.put(PartnerCodes.SPRINT_XAD_PARTNER_CODE, new String("22782"));
	PartnerCode_AdSpace.put(PartnerCodes.SAMSUNG_PARTNER_CODE, new String("22634"));
	PartnerCode_AdSpace.put(PartnerCodes.NOOK_PARTNER_CODE, new String("22636"));
	PartnerCode_AdSpace.put(PartnerCodes.LENOVO_PARTNER_CODE, new String("22638"));

	PartnerCode_AdSpace.put(PartnerCodes.VODAFONE_PARTNER_CODE, new String("22640"));
	PartnerCode_AdSpace.put(PartnerCodes.DELL_PARTNER_CODE, new String("22642"));
	PartnerCode_AdSpace.put(PartnerCodes.VIEWSONIC_PARTNER_CODE, new String("22644"));
	PartnerCode_AdSpace.put(PartnerCodes.FUJITSU_PARTNER_CODE, new String("22646"));

	PartnerCode_AdSpace.put(PartnerCodes.STREAMTV_PARTNER_CODE, new String("22648"));
	PartnerCode_AdSpace.put(PartnerCodes.TCL_PARTNER_CODE, new String("22650"));
	PartnerCode_AdSpace.put(PartnerCodes.AMAZON_PARTNER_CODE, new String("22652"));
	PartnerCode_AdSpace.put(PartnerCodes.ATT_PARTNER_CODE, new String("22654"));

	PartnerCode_AdSpace.put(PartnerCodes.FUHU_PARTNER_CODE, new String("22656"));
	PartnerCode_AdSpace.put(PartnerCodes.MOBILE_WEAVER_PARTNER_CODE, new String("22658"));
	PartnerCode_AdSpace.put(PartnerCodes.TMOBILE_PARTNER_CODE, new String("22660"));
	PartnerCode_AdSpace.put(PartnerCodes.DOCOMO_PARTNER_CODE, new String("22662"));

	PartnerCode_AdSpace.put(PartnerCodes.VERIZON_PARTNER_CODE, new String("22664"));
	PartnerCode_AdSpace.put(PartnerCodes.TRACPHONE_PARTNER_CODE, new String("22666"));
	PartnerCode_AdSpace.put(PartnerCodes.POCKETBOOK_USA_PARTNER_CODE, new String("22668"));
	PartnerCode_AdSpace.put(PartnerCodes.GROUP_SENSE_PARTNER_CODE, new String("23102"));

	PartnerCode_AdSpace.put(PartnerCodes.ANDROID_PIT_PARTNER_CODE, new String("23104"));
	PartnerCode_AdSpace.put(PartnerCodes.MEDION_PARTNER_CODE, new String("23185"));
	PartnerCode_AdSpace.put(PartnerCodes.TOSHIBA_PARTNER_CODE, new String("23196"));
	PartnerCode_AdSpace.put(PartnerCodes.AMOBEE_TEST_PARTNER_CODE, new String("22761"));
	PartnerCode_AdSpace.put(PartnerCodes.WALMART_PARTNER_CODE, new String("23282"));
	PartnerCode_AdSpace.put(PartnerCodes.ANDROID_LITE_PARTNER_CODE, new String("23319"));

	PartnerCode_AdSpace.put(PartnerCodes.ACER_PARTNER_CODE, new String("23649"));
    };

    public static String getAdSpace(Context context) {
	return (String) PartnerCode_AdSpace.get(getPartnerCode(context));
    }

    public static void checkPartnerCode(Context context) {
	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
	String pcode = null;
	FileOutputStream fos = null;
	FileInputStream fis = null;
	ObjectInputStream in = null;
	String packageName = context.getPackageName();
	File externalPath = Environment.getExternalStorageDirectory();
	boolean externalStorageAvailable = false;
	boolean externalStorageWriteable = false;
	String externalState = Environment.getExternalStorageState();

	File file = null;
	if (Environment.MEDIA_MOUNTED.equals(externalState)) {
	    // We can read and write the media
	    externalStorageAvailable = true;
	} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalState)) {
	    // We can only read the media
	    externalStorageAvailable = true;
	    externalStorageAvailable = false;
	} else {
	    // Something else is wrong. It may be one of many other states, but
	    // all we need
	    // to know is we can neither read nor write
	    externalStorageAvailable = false;
	}
	// Logger.d(DEBUG_TAG, "External Storage is available = " +
	// externalStorageAvailable);
	if (externalStorageAvailable) {
	    try {
		// composed path for 2.1 compatability
		// Logger.d(DEBUG_TAG, "External path is " +
		// context.getExternalFilesDir(null) + "/" +
		// Constants.PartnerCodes.PARTNER_CODE_FILE_NAME);
		fis = new FileInputStream(externalPath.getAbsolutePath() + "/Android/data/" + packageName + "/"
			+ PartnerCoding.PartnerCodes.PARTNER_CODE_FILE_NAME);
		// fis = new FileInputStream(context.getExternalFilesDir(null) +
		// "/" + Constants.PartnerCodes.PARTNER_CODE_FILE_NAME);
		in = new ObjectInputStream(fis);
		pcode = (String) in.readObject();
		in.close();
	    } catch (FileNotFoundException e) {
		// if (Constants.IS_DEVELOPMENT_MODE) e.printStackTrace();
		// //TODO
		// Comment out for production
		pcode = getPartnerCode(context);

		if (pcode == null) {
		    sp.edit()
			    .putString(Constants.Preferences.PREF_PARTNER_CODE, PartnerCoding.PartnerCodes.PARTNER_CODE)
			    .commit();
		    if (externalStorageAvailable) {
			file = new File(externalPath.getAbsolutePath() + "/Android/data/" + packageName);
			file.mkdirs();
			file = new File(externalPath.getAbsolutePath() + "/Android/data/" + packageName + "/",
				PartnerCoding.PartnerCodes.PARTNER_CODE_FILE_NAME);
			try {
			    fos = new FileOutputStream(file.getAbsolutePath());
			    ObjectOutputStream out = new ObjectOutputStream(fos);
			    out.writeObject(PartnerCoding.PartnerCodes.PARTNER_CODE);
			    out.close();
			} catch (FileNotFoundException e1) {
			    e1.printStackTrace();
			} catch (IOException e1) {
			    e.printStackTrace();
			}
		    }
		} else if (externalStorageAvailable) {
		    file = new File(externalPath.getAbsolutePath() + "/Android/data/" + packageName);
		    file.mkdirs();
		    file = new File(externalPath.getAbsolutePath() + "/Android/data/" + packageName + "/",
			    PartnerCoding.PartnerCodes.PARTNER_CODE_FILE_NAME);
		    try {
			fos = new FileOutputStream(file.getAbsolutePath());
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pcode);
			out.close();
		    } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		    } catch (IOException e1) {
			e.printStackTrace();
		    }
		}
	    } catch (StreamCorruptedException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    }
	} else {
	    try {
		// composed path for 2.1 compatability

		// fis = new FileInputStream(externalPath.getAbsolutePath() +
		// "/Android/data/" + packageName + "/" +
		// Constants.PartnerCodes.PARTNER_CODE_FILE_NAME);
		// Logger.d(DEBUG_TAG, "File directory is " +
		// context.getFilesDir());
		fis = new FileInputStream(context.getFilesDir() + "/"
			+ PartnerCoding.PartnerCodes.PARTNER_CODE_FILE_NAME);
		in = new ObjectInputStream(fis);
		pcode = (String) in.readObject();
		in.close();
	    } catch (FileNotFoundException e) {
		// if (Constants.IS_DEVELOPMENT_MODE) e.printStackTrace();
		pcode = getPartnerCode(context);
		if (pcode == null) {
		    sp.edit()
			    .putString(Constants.Preferences.PREF_PARTNER_CODE, PartnerCoding.PartnerCodes.PARTNER_CODE)
			    .commit();
		    file = new File(context.getFilesDir(), PartnerCoding.PartnerCodes.PARTNER_CODE_FILE_NAME);
		    try {
			fos = new FileOutputStream(file.getAbsolutePath());
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(PartnerCoding.PartnerCodes.PARTNER_CODE);
			out.close();
		    } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		    } catch (IOException e1) {
			e.printStackTrace();
		    }
		} else {
		    file = new File(context.getFilesDir(), PartnerCoding.PartnerCodes.PARTNER_CODE_FILE_NAME);
		    try {
			fos = new FileOutputStream(file.getAbsolutePath());
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pcode);
			out.close();
		    } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		    } catch (IOException e1) {
			e.printStackTrace();
		    }
		}
	    } catch (StreamCorruptedException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    }
	}
	if (getPartnerCode(context).equals("")) {
	    sp.edit().putString(Constants.Preferences.PREF_PARTNER_CODE, pcode).commit();
	}
    }

    public static String getPartnerCode(Context context) {
	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
	String pCode = sp.getString(Constants.Preferences.PREF_PARTNER_CODE, PartnerCoding.PartnerCodes.PARTNER_CODE);
	return pCode;
    }
}
