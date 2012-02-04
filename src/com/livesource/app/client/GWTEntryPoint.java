package com.livesource.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.googlecode.gwttouch.client.OrientationAwareLayoutPanel;
import com.googlecode.gwttouch.client.transitions.SimpleTransitionPanel;
import com.livesource.authentication.client.AnchorLogout;
import com.livesource.authentication.client.Utilities.EncryptText;
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

		SimpleTransitionPanel resizableRoot = new SimpleTransitionPanel();
		OrientationAwareLayoutPanel.get().add(resizableRoot);

		ApplicationVariables.homePanel.clear();

		resizableRoot.setWidget(ApplicationVariables.homePanel);

		if (livesourceUser == null || livesourceUser.equals("null")) {

			GithubLoginVerifyer.authenticate(Location.getParameter("code"));
			// final String error = Location.getParameter("error_reason");

			ApplicationVariables.homePanel.add(new LoginGithubButton());

		} else {

			ApplicationVariables.homePanel.add(new AnchorLogout());

			// RequestGetEntity.get(livesourceUser,true,true);
		}

	}
}
