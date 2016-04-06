/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tweet;
import Service.SingletonBean;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Sander
 */
//@Named(value = "tweetRetrieverBean")
@ManagedBean(name="tweets")
@RequestScoped
public class TweetRetrieverBean {

    private List<Tweet> tweetList;
    @EJB
    SingletonBean singleton;

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    private void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
    /**
     * Creates a new instance of TweetRetrieverBean
     */
    public TweetRetrieverBean() {
        this.setTweetList(singleton.getTweetList());
    }
    
    
}
