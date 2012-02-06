package com.livesource.app.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.livesource.app.client.ApplicationVariables;
import com.livesource.app.client.home.Home;
import com.livesource.app.client.home.LoadingPanel;
import com.livesource.authentication.client.Utilities.ConvertJson;
import com.livesource.authentication.client.github.SetLoggedIn;

public class LoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			ApplicationVariables.mainPanel.clear();
			ApplicationVariables.mainPanel.add(new LoadingPanel());

			loginService.githubLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							SetLoggedIn.authenticated(jsonResults);
							
							JSONObject obj = (JSONObject) JSONParser.parseStrict(jsonResults);
							
							String githubUserName = ConvertJson.convertToString(obj
									.get("githubUserName"));

							ApplicationVariables.mainPanel.clear();
							ApplicationVariables.mainPanel.add(new Home(githubUserName));
						}
					});

		} else {

			ApplicationVariables.mainPanel.clear();
			ApplicationVariables.mainPanel.add(new LoginPage());
		}
	}
}
