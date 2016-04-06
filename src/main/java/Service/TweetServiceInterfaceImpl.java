/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Tweet;
import Model.UserKwetter;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import logic.TweetProvider;
import logic.TweetProviderImpl;
import logic.UserProvider;
import logic.UserProviderImpl;

@Stateless
public class TweetServiceInterfaceImpl implements TweetServiceInterface {

    @Inject
    UserProvider userProvider;

    @Inject
    TweetProvider tweetProvider;

    @Override
    public void setUserProvider(UserProviderImpl userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public void setTweetProvider(TweetProviderImpl tweetProvider) {
        this.tweetProvider = tweetProvider;
    }

    @Override
    public UserKwetter createUser(UserKwetter u) {
        return userProvider.createUser(u);
    }

    @Override
    public List<UserKwetter> findAllUsers() {
        return userProvider.findAllUsers();
    }

    @Override
    public UserKwetter findUserById(long id) {
        return userProvider.findUserById(id);
    }

    @Override
    public UserKwetter findUserByName(String username) {
        return userProvider.findUserByName(username);
    }

    @Override
    public List<Tweet> findTweetByUser(String username) {
        return userProvider.findTweetByUser(username);
    }

    @Override
    public List<UserKwetter> filterUsersBySnippet(String snippet) {
        return userProvider.filterUsersBySnippet(snippet);
    }

    @Override
    public Tweet createTweet(Tweet t) {
        return tweetProvider.createTweet(t);
    }

    @Override
    public List<Tweet> findAllTweets(List<UserKwetter> following, UserKwetter yourself) {
        return tweetProvider.findAllTweets(following, yourself);
    }

    @Override
    public List<Tweet> findTweetsBySnippet(String snippet) {
        return tweetProvider.findTweetsBySnippet(snippet);
    }

}
