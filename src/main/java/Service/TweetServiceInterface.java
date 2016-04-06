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

/**
 *
 * @author Sander
 */
public interface TweetServiceInterface {

    /**
     * Set userrovider as variabel in TweetService
     *
     * @param userProvider
     */
    public void setUserProvider(UserProviderImpl userProvider);

    /**
     * Set tweetprovider as variabel in TweetService
     *
     * @param tweetProvider
     */
    public void setTweetProvider(TweetProviderImpl tweetProvider);

    /**
     * Create UserKwetter and put in database
     *
     * @param u
     * @return USerer class object
     */
    public UserKwetter createUser(UserKwetter u);

    /**
     * Return all UserKwetter of database
     *
     * @return List<User>
     */
    public List<UserKwetter> findAllUsers();

    /**
     * Return UserKwetter associated by id
     *
     * @param id
     * @return UserKwetter class object
     */
    public UserKwetter findUserById(long id);

    /**
     * Return UserKwetter associated by username
     *
     * @param username
     * @return UserKwetter class object
     */
    public UserKwetter findUserByName(String username);

    /**
     * Return list of Tweet associated by username
     *
     * @param username
     * @return List tweet
     */
    public List<Tweet> findTweetByUser(String username);

    /**
     * Return list of UserKwetter associated by partial string
     *
     * @param snippet
     * @return List UserKwetter
     */
    public List<UserKwetter> filterUsersBySnippet(String snippet);

    /**
     * Create Tweet and put in database
     *
     * @param t
     * @return Tweet class object
     */
    public Tweet createTweet(Tweet t);

    /**
     * Return list of Tweet associated by followed users
     *
     * @param following
     * @param yourself
     * @return List Tweet
     */
    public List<Tweet> findAllTweets(List<UserKwetter> following, UserKwetter yourself);

    /**
     * Return list of Tweet associated by partial string (called snippet)
     *
     * @param snippet
     * @return List Tweet
     */
    public List<Tweet> findTweetsBySnippet(String snippet);
}
