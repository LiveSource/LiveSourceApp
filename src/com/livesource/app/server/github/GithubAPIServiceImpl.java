package com.livesource.app.server.github;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.livesource.app.client.github.GithubAPIService;

public class GithubAPIServiceImpl extends RemoteServiceServlet implements
		GithubAPIService {

	private static final long serialVersionUID = -8355612980477933670L;

	public ArrayList<String> listRepositories(final String authenticationCode) {

		//return GithubUserRepos.listRepositories(authenticationCode);
		
		return LiveSourceUserProjects.list(authenticationCode);
	}

}
