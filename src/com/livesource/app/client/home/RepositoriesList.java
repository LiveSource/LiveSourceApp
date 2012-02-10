package com.livesource.app.client.home;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RepositoriesList extends VerticalPanel {

	public RepositoriesList(ArrayList<String> repositoriesArray) {

		this.setSpacing(15);

		if (repositoriesArray != null) {

			for (String repositoryName : repositoriesArray) {

				HTML repositoryLabel = new HTML(
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
								+ "<a href=#><font size=3>" + repositoryName
								+ "</font></a>");

				this.add(repositoryLabel);
			}
		}
	}
}
