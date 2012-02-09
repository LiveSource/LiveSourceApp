package com.livesource.app.client.github;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("githubAPI")
public interface GithubAPIService extends RemoteService {

	public String[] listRepositories(String authenticationCode);
}
