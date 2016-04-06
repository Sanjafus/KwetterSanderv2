package Model;

import Model.Tweet;
import Model.UserKwetter;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-06T09:35:29")
@StaticMetamodel(UserKwetter.class)
public class UserKwetter_ { 

    public static volatile ListAttribute<UserKwetter, Tweet> Tweets;
    public static volatile SingularAttribute<UserKwetter, String> password;
    public static volatile ListAttribute<UserKwetter, UserKwetter> followers;
    public static volatile ListAttribute<UserKwetter, UserKwetter> following;
    public static volatile SingularAttribute<UserKwetter, String> name;
    public static volatile SingularAttribute<UserKwetter, Long> ID;
    public static volatile SingularAttribute<UserKwetter, String> username;

}