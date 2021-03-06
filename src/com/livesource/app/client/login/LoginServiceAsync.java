package com.livesource.app.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LoginServiceAsync {

	void githubLogin(String authenticationCode, AsyncCallback<String> callback);
}
