package pm.gradingsystem.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pm.gradingsystem.entity.Address;
import pm.gradingsystem.entity.Role;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-20T18:12:15")
@StaticMetamodel(IUser.class)
public class IUser_ { 

    public static volatile SingularAttribute<IUser, Integer> id;
    public static volatile SingularAttribute<IUser, Integer> securityCode;
    public static volatile SingularAttribute<IUser, String> securitAnswer;
    public static volatile SingularAttribute<IUser, String> username;
    public static volatile SingularAttribute<IUser, Address> address;
    public static volatile ListAttribute<IUser, Role> roles;
    public static volatile SingularAttribute<IUser, String> lastname;
    public static volatile SingularAttribute<IUser, String> firstname;
    public static volatile SingularAttribute<IUser, String> password;

}