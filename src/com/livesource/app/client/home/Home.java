package com.livesource.app.client.home;

import com.google.gwt.user.client.ui.VerticalPanel;

public class Home extends VerticalPanel {

	public static VerticalPanel vpRepositories = new VerticalPanel();

	public Home(String userName) {

		this.add(new TopMenu(userName));
		
		this.add(vpRepositories);
	}
}
