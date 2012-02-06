package com.livesource.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;
import com.googlecode.gwttouch.client.OrientationAwareLayoutPanel;
import com.googlecode.gwttouch.client.transitions.SimpleTransitionPanel;
import com.livesource.app.client.login.LoginVerifyer;

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

		SimpleTransitionPanel resizableRoot = new SimpleTransitionPanel();
		OrientationAwareLayoutPanel.get().add(resizableRoot);

		ApplicationVariables.mainPanel.clear();
		resizableRoot.setWidget(ApplicationVariables.mainPanel);

		String authenticationCode = Location.getParameter("code");
		// final String error = Location.getParameter("error_reason");

		LoginVerifyer.authenticate(authenticationCode);
	}
}
