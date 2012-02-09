package com.livesource.app.client.github;

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

        String authenticationToken = EncryptText.decrypt(Cookies.getCookie("githubAuthenticationToken"));

        final GithubAPIServiceAsync githubAPIService = GWT.create(GithubAPIService.class);

        if (!(authenticationToken == null || "".equals(authenticationToken))) {

            githubAPIService.listRepositories(authenticationToken, new AsyncCallback<String[]>() {

                public void onFailure(final Throwable caught) {
                    System.out.println(caught);
                }

                public void onSuccess(final String[] result) {

                    Home.vpRepositories.clear();
                    Home.vpRepositories.add(new RepositoriesList(result));

                }
            });
        }
    }
}