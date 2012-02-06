package com.livesource.app.client.home;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.livesource.authentication.client.AnchorLogout;

public class TopMenu extends HorizontalPanel {

	public TopMenu(String userName) {

		this.setSpacing(15);

		this.add(new LiveSourceLogo());

		Label space = new Label(" ");
		space.setWidth("300px");
		this.add(space);

		this.add(new Label(userName));

		this.add(new Label("|"));

		Blog blog = new Blog();
		this.add(blog);

		this.add(new Label("|"));

		this.add(new AnchorLogout());
	}
}
