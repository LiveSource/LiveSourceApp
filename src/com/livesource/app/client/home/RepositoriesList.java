package com.livesource.app.client.home;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RepositoriesList extends VerticalPanel {

	public RepositoriesList(String[] repositoriesArray) {

		if (repositoriesArray != null) {

			for (String repositoryName : repositoriesArray) {

				Label repositoryLabel = new Label(repositoryName);

				this.add(repositoryLabel);
			}
		}
	}
}
