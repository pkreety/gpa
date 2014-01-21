/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import GPASystem_Services.SectionService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.entity.Grade;

@Named
@RequestScoped
public class TransactionCDI {
private List<Grade> grades;
@EJB
private SectionService sectionService;
    public List<Grade> getGrades() {
        return sectionService.findTransactions();
    }

    public TransactionCDI() {
    }
    
}
