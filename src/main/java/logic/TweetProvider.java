/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Model.UserKwetter;
import java.util.List;
import Model.Tweet;

/**
 *
 * @author Sander
 */
public interface TweetProvider {

    Tweet createTweet(Tweet k);

    List<Tweet> findAllTweets(List<UserKwetter> following, UserKwetter me);

    List<Tweet> findTweetsBySnippet(String snippet);
}
