package com.livesource.app.client.utilities;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;

public class ConvertJson {

	public static String convertToString(JSONValue value) {

		if (value != null && value.isString() != null) {

			return value.isString().stringValue();
		}

		return null;
	}

	public static String convertToNumber(JSONValue value) {

		if (value != null && value.isNumber() != null) {

			return value.isNumber().toString();
		}

		return null;
	}
	
	public static JSONArray convertToArray(JSONValue value) {

		if (value != null && value.isArray() != null) {

			return value.isArray();
		}

		return null;
	}

}
