package com.mobilebytes.games.utils;

/**
 * MathUtilities class for math methods used in games.
 * 
 * @author fredgrott
 *
 */
public class MathUtilities {
	
	public static float asFloat(Object obj, float defValue) {
		if (obj instanceof Number) return ((Number)obj).floatValue();
		return defValue;
	}
	
	public static float asFloat(Object obj) {
		return asFloat(obj, 0f);
	}
	
	public static float toRadians(float degrees) {
		return (float)(Math.PI/180) * degrees;
	}
	

}
