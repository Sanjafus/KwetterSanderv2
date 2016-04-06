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
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Sander
 */
@Named(value = "tweetManagedBean")
@RequestScoped
public class TweetManagedBean {

    /**
     * Creates a new instance of TweetManagedBean
     */
    @ManagedProperty(value = "#{tweets}")
    private TweetRetrieverBean tweetRetrieverBean;
    private List<Tweet> tweetList;

    public TweetManagedBean() {
    }

    public List<Tweet> getTweetRetrieverBean() {
         if(tweetRetrieverBean != null){
         this.tweetList = tweetRetrieverBean.getTweetList();
      }       
      return this.tweetList;
    }

    public void setTweetRetrieverBean(TweetRetrieverBean tweetRetrieverBean) {
        this.tweetRetrieverBean = tweetRetrieverBean;
    }

  

}
