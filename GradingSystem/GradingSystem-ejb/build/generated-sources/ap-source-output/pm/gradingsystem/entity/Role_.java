package pm.gradingsystem.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pm.gradingsystem.entity.IUser;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-02T22:30:54")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> id;
    public static volatile ListAttribute<Role, IUser> users;
    public static volatile SingularAttribute<Role, String> name;

}