package pm.gradingsystem.entity;

import GPASystem_misc.SectionPeriod;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pm.gradingsystem.entity.Course;
import pm.gradingsystem.entity.IUser;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-20T18:12:15")
@StaticMetamodel(Section.class)
public class Section_ { 

    public static volatile SingularAttribute<Section, Long> id;
    public static volatile SingularAttribute<Section, Course> course;
    public static volatile ListAttribute<Section, IUser> students;
    public static volatile SingularAttribute<Section, SectionPeriod> sp;
    public static volatile SingularAttribute<Section, Integer> datetime;
    public static volatile SingularAttribute<Section, IUser> faculty;
    public static volatile SingularAttribute<Section, String> section_name;

}