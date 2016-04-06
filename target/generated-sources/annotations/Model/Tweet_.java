package Model;

import Model.UserKwetter;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-06T09:35:29")
@StaticMetamodel(Tweet.class)
public class Tweet_ { 

    public static volatile SingularAttribute<Tweet, String> tweetText;
    public static volatile SingularAttribute<Tweet, Long> id;
    public static volatile SingularAttribute<Tweet, String> screenName;
    public static volatile SingularAttribute<Tweet, String> PostedFrom;
    public static volatile SingularAttribute<Tweet, Date> PostDate;
    public static volatile SingularAttribute<Tweet, UserKwetter> user;

}