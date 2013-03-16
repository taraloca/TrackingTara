package com.tara.trackingtara.utilities;

import android.util.Log;

public class Logger {

	public static void i(String tag, String string) {
		if (Constants.PackageProperties.IS_DEBUGGABLE) {
			Log.i(tag, string);
		}
	}
	
	public static void i(String tag, String string, Object...args) {
		i(tag, String.format(string, args));
	}
	
	public static void d(String tag, String string) {
		if (Constants.PackageProperties.IS_DEBUGGABLE) {
			Log.d(tag, string);
		}
	}
	
	public static void d(String tag, String string, Object...args) {
		d(tag, String.format(string, args));
	}
	
	public static void e(String tag, String string) {
		if (Constants.PackageProperties.IS_DEBUGGABLE) {
			Log.e(tag, string);
		}
	}
	
	public static void e(String tag, String string, Throwable t) {
	    if (Constants.PackageProperties.IS_DEBUGGABLE) {
		    Log.e(tag, string, t);
	    }
	}
	
	public static void e(String tag, String string, Object...args) {
		e(tag, String.format(string, args));
	}
	
	public static void i(Object tag, String string) {
		i(tag.getClass().getSimpleName(), string);
	}
	
	public static void i(Object tag, String string, Object...args) {
		i(tag.getClass().getSimpleName(), String.format(string, args));
	}
	
	public static void d(Object tag, String string) {
		d(tag.getClass().getSimpleName(), string);
	}
	
	public static void d(Object tag, String string, Object...args) {
		d(tag.getClass().getSimpleName(), String.format(string, args));
	}
	
	public static void e(Object tag, String string) {
		e(tag.getClass().getSimpleName(), string);
	}
	
	public static void e(Object tag, String string, Object...args) {
		e(tag.getClass().getSimpleName(), String.format(string, args));
	}
	
	public static void d(Object tag) {
		d(tag.getClass().getSimpleName(), getMethodName(4));
	}
	
	public static void i(Object tag) {
		i(tag.getClass().getSimpleName(), getMethodName(4));
	}
	
	public static void e(Object tag) {
		e(tag.getClass().getSimpleName(), getMethodName(4));
	}
	
	public static String getMethodName(final int depth) {
	  return Thread.currentThread().getStackTrace()[depth].getMethodName();
	}
	
}
