package com.livesource.app.client.github;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GithubAPIServiceAsync {

	void listRepositories(String authenticationCode,
			AsyncCallback<String[]> callback);
}
