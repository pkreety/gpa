/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import GPASystem_Services.Evaluation_Service;
import GPASystem_Services.SectionService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.entity.Evaluation;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

@Named
@RequestScoped
public class feedbackCDI {
@EJB
Evaluation_Service evaluationEJB;
@Inject
SessionCDI session;
@EJB
SectionService sectionEJB;
    private String stdMessage;
    
    private Evaluation evaluation=new Evaluation();

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public String getStdMessage() {
        return stdMessage;
    }

    public void setStdMessage(String stdMessage) {
        this.stdMessage = stdMessage;
    }

    public String sendMessage(Section section) {
       // stdMessage = message;
        System.out.println("section"+section);
     
      //  Section section=sectionEJB.getSection(sectionID);
      this.evaluation.setSection(section);
         IUser student=session.getUser();
      this.evaluation.setStud(student);
      
       // evaluation.setDescription(stdMessage);
        
        evaluationEJB.saveMsg(evaluation);
        return "studentdashboard";
    }

    public feedbackCDI() {
    }

}
