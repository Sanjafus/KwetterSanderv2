/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Tweet;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Sander
 */
@Singleton
public class SingletonBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<Tweet> tweetList;

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    public void OutputList() {
        for (Tweet t : this.tweetList) {
            System.out.println(t.getTweetText() + " - " + t.getUser() + " - " + "singletonPrint");
        }
    }
}
