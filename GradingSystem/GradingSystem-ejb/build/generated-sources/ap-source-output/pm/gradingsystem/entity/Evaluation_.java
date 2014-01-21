package pm.gradingsystem.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-20T18:12:15")
@StaticMetamodel(Evaluation.class)
public class Evaluation_ { 

    public static volatile SingularAttribute<Evaluation, Integer> id;
    public static volatile SingularAttribute<Evaluation, IUser> student;
    public static volatile SingularAttribute<Evaluation, String> description;
    public static volatile SingularAttribute<Evaluation, Section> section;

}