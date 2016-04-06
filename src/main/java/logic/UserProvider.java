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
public interface UserProvider {
        
    UserKwetter createUser(UserKwetter u);
    
    List<UserKwetter> findAllUsers();
    
    UserKwetter findUserById(long id);

    UserKwetter findUserByName(String username);
    
    List<Tweet> findTweetByUser(String username);
    
    List<UserKwetter> filterUsersBySnippet(String snippet);
    
    boolean followUser(UserKwetter u, UserKwetter following);
    
    int getFollowerAmount(UserKwetter u);

}
