/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Batch;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Tweet;
import Model.UserKwetter;
import Service.SingletonBean;
import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Sander
 */
@Dependent
@Named
public class TweetWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;
    @EJB 
    SingletonBean singleton;
    UserKwetter u;
   
    @Override
    public void writeItems(List<Object> items) throws Exception {
        @SuppressWarnings("unchecked")
        List<Tweet> tweets = (List<Tweet>) (List<?>) items;
        singleton.setTweetList(tweets);
        singleton.OutputList();
//        for (Tweet tweet : tweets) {
//            try {
//                u = tweet.getUser();
//                Query query = em.createNamedQuery("findUserByName").setParameter("username", u.getUsername());
//                if (query.getSingleResult() == null) { 
//                    //Als er geen user is gevonden, fix het.
//                    em.persist(u);
//                    System.out.println("User persist"); 
//                }
//                
//            } catch (NoResultException ex) {
//                //Als er wel een user is, persist de tweet.
//                em.persist(tweet);
//                System.out.println("tweet persist");            }
//           
//        }
    }
}
