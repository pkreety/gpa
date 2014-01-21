/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;

@Named
@SessionScoped
public class AddStudentCDI implements Serializable{
 private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
    private List<IUser> students;
    @EJB
    private UserManagement userManagement;
    
    @Inject
    private SectionCDI sectionCDI;
    private  List<IUser> checkedItems ;

    public List<IUser> getCheckedItems() {
        return checkedItems;
    }
    
//    public List<IUser> getStudents() {
//        //System.out.println(userManagement.findStd().toString());
//        if(checkedItems==null) {
//        students=userManagement.findStd();
//        }
//        return checkedItems;
//    }

    public Map<Long, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Long, Boolean> checked) {
        this.checked = checked;
    }

    public void addSTD() {
        checkedItems  = new ArrayList<>();
        //System.out.println("std: "+students.toString());
        students=userManagement.findStd();
        for (IUser item : students) {
            if (checked.get(item.getId())) {
                checkedItems.add(item);
            }
        }
       // students=checkedItems;
        //students=checkedItems;
       // sectionCDI.setStudents(checkedItems);
       // System.out.println("the checke Item is "+checkedItems.toString());
       checked.clear(); // If necessary.
        // sectionEJB.a
       // this.section.setStudents(checkedItems);
        // Now do your thing with checkedItems.
    }
    public AddStudentCDI() {
    }
    
}
