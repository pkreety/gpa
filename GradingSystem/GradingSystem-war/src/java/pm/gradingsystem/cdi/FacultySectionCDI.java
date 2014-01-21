package pm.gradingsystem.cdi;

import GPASystem_Services.Evaluation_Service;
import GPASystem_Services.SectionService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.entity.Evaluation;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

@Named
@SessionScoped
public class FacultySectionCDI implements Serializable {

    private List<Section> sections;
    @Inject
    private SessionCDI session;
    @Inject
    SectionStudentCDI ssCDI;
    private List<IUser> students;
    private double gradept;
    private Section section;
    @EJB
    private Evaluation_Service evaluationEJB;
    private List<Evaluation> evaluations=new ArrayList<>();

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public double getGradept() {
        return gradept;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setGradept(double gradept) {
        this.gradept = gradept;
    }

    public List<IUser> getStudents() {
        return students;
    }

    private IUser user = new IUser();
    @EJB
    private SectionService sectionService;

    public List<Section> getSections() {
        user = session.getUser();
        sections = sectionService.findSectionByFaculty(user);
        return sections;
    }

    public String findStdBysection(Section section) {
        this.section = section;
        ssCDI.setSection(section);
        System.out.println("section" + section.getId());
        this.students = section.getStudents();
        return "facultysectionstd";
    }

    public String getFeedback(Section secname) {
        evaluations = evaluationEJB.getFeedbacks(secname);
        return "feedbackDisplay";
    }

    public FacultySectionCDI() {
    }
}
