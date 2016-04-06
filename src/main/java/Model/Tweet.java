/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sander
 */
@Entity
@Table(name = "Tweets")

public class Tweet implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    UserKwetter user;

    public UserKwetter getUser() {
        return user;
    }

    public void setUser(UserKwetter user) {
        this.user = user;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }
    @NotNull
    String tweetText;
    private String screenName;
    private String PostedFrom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date PostDate;

    public Tweet(UserKwetter user, String tweetText) {
        this.user = user;
        this.tweetText = tweetText;
    }

    public Tweet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setTweet(String text) {
        this.tweetText = text;
    }

    public void setPostedFrom(String postFrom) {
        this.PostedFrom = postFrom;
    }

    public void setPostDate(Date postDate) {
        this.PostDate = postDate;
    }
}
