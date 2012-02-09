package com.livesource.app.server.github;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.livesource.app.server.URLUtilities;


public class GithubUserRepos {

    private static final String githubAPI_URL = "https://api.github.com/";

    public static String[] listRepositories(final String authenticationToken) {

        // [{"clone_url":"https://github.com/LiveSource/LiveSourceApp.git",
        // "watchers":2,"forks":1,"pushed_at":"2012-02-06T04:38:39Z",
        // "url":"https://api.github.com/repos/LiveSource/LiveSourceApp",
        // "ssh_url":"git@github.com:LiveSource/LiveSourceApp.git","description":"",
        // "has_downloads":true,"mirror_url":null,
        // "homepage":"","fork":false,"has_wiki":true,"updated_at":"2012-02-06T04:38:39Z",
        // "private":false,"git_url":"git://github.com/LiveSource/LiveSourceApp.git","size":22952,
        // "master_branch":null,"language":"Java",
        // "owner":{"url":"https://api.github.com/users/LiveSource","gravatar_id":"23f10e6b7af0bac91fe8b46540c206b9",
        // "login":"LiveSource",
        // "avatar_url":"https://secure.gravatar.com/avatar/23f10e6b7af0bac91fe8b46540c206b9?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png",
        // "id":1316812},"name":"LiveSourceApp","html_url":"https://github.com/LiveSource/LiveSourceApp","open_issues":0,
        // "id":3350192,"svn_url":"https://github.com/LiveSource/LiveSourceApp",
        // "has_issues":true,"created_at":"2012-02-04T02:18:37Z"},

        // {"clone_url":"https://github.com/CustDevDay/CustDevDayDocumentation.git",
        // "watchers":2,"forks":1,"pushed_at":"2012-01-31T18:04:45Z",
        // "url":"https://api.github.com/repos/CustDevDay/CustDevDayDocumentation",
        // "ssh_url":"git@github.com:CustDevDay/CustDevDayDocumentation.git","description":"",
        // "has_downloads":true,"mirror_url":null,"homepage":"","fork":false,"has_wiki":true,
        // "updated_at":"2012-01-31T18:04:45Z","private":false,"git_url":
        // "git://github.com/CustDevDay/CustDevDayDocumentation.git","size":84,
        // "master_branch":null,"language":null,
        // "owner":{"url":"https://api.github.com/users/CustDevDay",
        // "gravatar_id":"4536d74bcaab8beb6e5e24d223eb9138","login":"CustDevDay",
        // "avatar_url":"https://secure.gravatar.com/avatar/4536d74bcaab8beb6e5e24d223eb9138?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png",
        // "id":1395034},"name":"CustDevDayDocumentation",
        // "html_url":"https://github.com/CustDevDay/CustDevDayDocumentation",
        // "open_issues":0,"id":3316307,"svn_url":"https://github.com/CustDevDay/CustDevDayDocumentation",
        // "has_issues":true,"created_at":"2012-01-31T16:24:03Z"}]

        String parameters = authenticationToken;

        final String jsonString = URLUtilities.fetchURLGet(githubAPI_URL + "user/repos", parameters);

        String[] repositories = null; 

        try {
            JSONArray jsonArrayRepositories = new JSONArray(jsonString);

            repositories = new String[jsonArrayRepositories.length()];

            for (int i = 0; i < jsonArrayRepositories.length(); i++) {

                JSONObject jsonRepository = jsonArrayRepositories.getJSONObject(i);

                String repositoryName = jsonRepository.getString("name");

                repositories[i] = repositoryName;
            }
        }
        catch (JSONException e) {

            e.printStackTrace();
        }

        return repositories;
    }

}