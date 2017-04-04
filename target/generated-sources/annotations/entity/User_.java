package entity;

import entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-04T11:08:05")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-04T11:29:20")
>>>>>>> 94dddf0bacbe0d9e000cdf2ca8d16169190b473e
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Role> roles;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, String> passwordHash;

}