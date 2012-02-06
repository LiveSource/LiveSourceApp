package com.livesource.app.client.home;

import com.google.gwt.user.client.ui.VerticalPanel;

public class Home extends VerticalPanel {

	public Home(String userName) {

		this.add(new TopMenu(userName));
	}
}
