package com.livesource.app.server.github;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.livesource.app.server.URLUtilities;

public class LiveSourceUserProjects {

	private static String LiveSourceGetEntityURL = "http://jsonpfy.projectnection.appspot.com/GetDataService";

	public static ArrayList<String> list(final String entityUserID) {

		String parameters = "kind=Entity&ID=" + entityUserID;

		final String jsonEntityUserString = URLUtilities.fetchURLGet(
				LiveSourceGetEntityURL, parameters);

		JSONObject jsonEntityUser = null;
		try {
			jsonEntityUser = new JSONObject(jsonEntityUserString);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return getEntityUserFavorites(jsonEntityUser);

	}

	private static ArrayList<String> getEntityUserFavorites(
			JSONObject jsonEntityUser) {

		ArrayList<String> entityFavorites = new ArrayList<String>();

		try {
			if (jsonEntityUser != null
					&& jsonEntityUser.get("entityFavorites") != null) {

				JSONArray jsonArrayFavorites = new JSONArray(jsonEntityUser
						.get("entityFavorites").toString());

				for (int i = 0; i < jsonArrayFavorites.length(); i++) {

					String favoriteEntityID = jsonArrayFavorites.get(i)
							.toString();

					favoriteEntityID = favoriteEntityID
							.replace("Entity(\"", "");
					favoriteEntityID = favoriteEntityID.replace("\")", "");

					entityFavorites.add(favoriteEntityID);
				}
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return entityFavorites;
	}

}