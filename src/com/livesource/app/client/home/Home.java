package com.livesource.app.client.home;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.livesource.authentication.client.AnchorLogout;
import com.livesource.authentication.client.github.LoginGithubButton;

public class Home extends VerticalPanel {

	public Home() {

		this.setSize("100%", "100%");

		this.add(new AnchorLogout());

		this.add(new LoginGithubButton());

	}
}
