/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sander
 */
@Entity
@Table(name = "UserKwetter")
@NamedQueries({
    @NamedQuery(name = "findAllUsers", query = "SELECT u FROM UserKwetter u"),
    @NamedQuery(name = "findUserByName", query = "SELECT u FROM UserKwetter u WHERE u.username = :username"),
    @NamedQuery(name = "filterUsersBySnippet", query = "SELECT u FROM UserKwetter u WHERE u.username Like '%:snippet%'")
})
public class UserKwetter implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String username;

    
    @OneToMany(mappedBy = "user")
    private List<Tweet> Tweets;

    @ManyToMany
    private List<UserKwetter> followers;
    @ManyToMany(mappedBy = "followers")
    private List<UserKwetter> following;

    public UserKwetter(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public UserKwetter() {

    }

    public String getName() {
        return name;
    }

    public List<UserKwetter> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserKwetter> following) {
        this.following = following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserKwetter> getFollowers() {
        return this.followers;
    }

    public void addFollower(UserKwetter u) {
        this.followers.add(u);
    }

    public List<Tweet> getTweets() {
        return Tweets;
    }

    public void setTweets(List<Tweet> Tweets) {
        this.Tweets = Tweets;
    }
}
