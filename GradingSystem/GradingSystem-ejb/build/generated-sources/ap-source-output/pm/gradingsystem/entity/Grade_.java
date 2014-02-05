package pm.gradingsystem.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-02T22:30:54")
@StaticMetamodel(Grade.class)
public class Grade_ { 

    public static volatile SingularAttribute<Grade, Integer> id;
    public static volatile SingularAttribute<Grade, IUser> student_id;
    public static volatile SingularAttribute<Grade, Float> gpa;
    public static volatile SingularAttribute<Grade, Section> section;

}