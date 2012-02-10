package com.livesource.app.client.github;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.livesource.app.client.home.Home;
import com.livesource.app.client.home.RepositoriesList;
import com.livesource.app.client.utilities.LoadingPanel;
import com.livesource.authentication.client.Utilities.EncryptText;

public class RequestGithubListRepositories {

	public static void getJsonpRequest() {

		Home.vpRepositories.clear();
		Home.vpRepositories.add(new LoadingPanel());

		String authenticationToken = EncryptText.decrypt(Cookies
				.getCookie("githubAuthenticationToken"));
		
		String liveSourceUserID = EncryptText.decrypt(Cookies
				.getCookie("livesourceUser"));

		final GithubAPIServiceAsync githubAPIService = GWT
				.create(GithubAPIService.class);

		if (!(authenticationToken == null || "".equals(authenticationToken))) {

			githubAPIService.listRepositories(liveSourceUserID,
					new AsyncCallback<ArrayList<String>>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final ArrayList<String> result) {

							Home.vpRepositories.clear();
							Home.vpRepositories
									.add(new RepositoriesList(result));

						}
					});
		}
	}
}