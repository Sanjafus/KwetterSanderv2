/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Model.Tweet;
import Model.UserKwetter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sander
 */
@Stateless
public class UserProviderImpl implements UserProvider {

    @PersistenceContext
    EntityManager em;

    public UserProviderImpl() {
    }

    @Override
    public UserKwetter createUser(UserKwetter u) {
        try {
            Query query = em.createNamedQuery("findUserByName").setParameter("username", u.getUsername());
            Object retrieve =  query.getSingleResult();
            if (query.getSingleResult() == null) {
                System.out.println("User bestaat al gevonden");
            }
        } catch (NoResultException ex) {
            System.out.println("Bart is een hoertje");
            em.persist(u);
            return u;
        }
        em.merge(u);
        return u;
    }

    @Override
    public List<UserKwetter> findAllUsers() {
        Query query = em.createNamedQuery("findAllUsers");
        return (List<UserKwetter>) query.getResultList();

    }

    @Override
    public UserKwetter findUserById(long id) {
        return em.find(UserKwetter.class, id);
    }

    @Override
    public UserKwetter findUserByName(String username) {
        Query query = em.createNamedQuery("findUserByName").setParameter("username", username);
        return (UserKwetter) query.getSingleResult();
    }

    @Override
    public List<Tweet> findTweetByUser(String username) {
        Query query = em.createNamedQuery("findTweetByUser").setParameter("username", username);
        return (List<Tweet>) query.getResultList();
    }

    @Override
    public List<UserKwetter> filterUsersBySnippet(String snippet) {
        Query query = em.createNamedQuery("filterUsersBySnippet").setParameter("snippet", snippet);
        return (List<UserKwetter>) query.getResultList();
    }

    @Override
    public boolean followUser(UserKwetter u, UserKwetter follower) {
        for (UserKwetter follow : u.getFollowers()) {
            if (follow.getUsername().equals(follower.getUsername())) {
                return false;
            }
        }
        u.addFollower(follower);
        return true;
    }

    @Override
    public int getFollowerAmount(UserKwetter u) {
        return u.getFollowers().size();
    }
}
