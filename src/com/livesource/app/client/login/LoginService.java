package com.livesource.app.client.login;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("livesourceAuthentication")
public interface LoginService extends RemoteService {
	public String githubLogin(String authenticationCode);
}
