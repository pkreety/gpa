package pm.gradingsystem.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pm.gradingsystem.entity.Section;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-02T22:30:54")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile ListAttribute<Course, Section> sections;
    public static volatile SingularAttribute<Course, String> course_code;
    public static volatile SingularAttribute<Course, Integer> credit;
    public static volatile SingularAttribute<Course, String> coursename;

}