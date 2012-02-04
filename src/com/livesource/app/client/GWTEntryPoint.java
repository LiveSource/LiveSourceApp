package com.livesource.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;
import com.livesource.authentication.client.EncryptText;
import com.livesource.authentication.client.github.GithubLoginVerifyer;
import com.livesource.authentication.client.github.LoginGithubButton;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @Architecture
 */
public class GWTEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		String livesourceUser = EncryptText.decrypt(Cookies
				.getCookie("livesourceUser"));

		if (livesourceUser == null || livesourceUser.equals("null")) {

			GithubLoginVerifyer.authenticate(Location.getParameter("code"));
			// final String error = Location.getParameter("error_reason");
		} else {

			// RequestGetEntity.get(livesourceUser,true,true);
		}

		RootPanel rootPanel = RootPanel.get();

		rootPanel.setSize("100%", "100%");

		rootPanel.add(new LoginGithubButton());

	}
}
