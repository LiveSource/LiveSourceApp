package com.livesource.app.client.github;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GithubAPIServiceAsync {

	void listRepositories(String authenticationCode,
			AsyncCallback<ArrayList<String>> callback);
}
