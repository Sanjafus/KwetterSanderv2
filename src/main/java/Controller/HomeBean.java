/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tweet;
import Model.UserKwetter;
import Service.SingletonBean;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Sander
 */
@ManagedBean(name="homeBean")
@SessionScoped
public class HomeBean implements Serializable {

    /**
     * Creates a new instance of HomeBean
     */
    private final SingletonBean singleton = this.FixSingleton();
    
    public String geringeDingen;
    /**
     *
     * @return
     */
    public List<Tweet> getAllTweets() {
        return singleton.getTweetList();
    }
    
    public UserKwetter mockUser()
    {
        return new UserKwetter("Sander" , "pw" , "UserSander");
    }
    private SingletonBean FixSingleton(){
        //Get je JO
             JobOperator jo = BatchRuntime.getJobOperator();

            //Set de json in de properties zodat de tweetjob de processor/reader/writer aan kan roepen.
            Properties props = new Properties();
            String url = "C:\\Users\\Sander\\Documents\\NetBeansProjects\\KwetterSander\\src\\main\\resources\\kwetterinput.json";
            props.setProperty("jsonUrl", url);
            //Start de job en print de output
            long jid = jo.start("TweetJob", props);
        return singleton;
    }

    public SingletonBean getSingleton() {
        return singleton;
    }

    public String getGeringeDingen() {
        geringeDingen = "Test";
        return geringeDingen;
    }

}
