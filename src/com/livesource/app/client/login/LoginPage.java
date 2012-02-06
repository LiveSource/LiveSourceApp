package com.livesource.app.client.login;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.livesource.app.client.home.Blog;
import com.livesource.authentication.client.github.LoginGithubButton;

public class LoginPage extends VerticalPanel {

	public LoginPage() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.add(new Blog());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(new LiveSourceLogoDevelopment());

		this.add(new Label(" "));

		this.add(new LoginGithubButton());
	}
}
