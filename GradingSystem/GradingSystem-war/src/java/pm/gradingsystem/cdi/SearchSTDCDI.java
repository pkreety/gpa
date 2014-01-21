/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.Course;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

/**
 *
 * @author Tahmasebi
 */
@Named
@RequestScoped
public class SearchSTDCDI {

    private IUser user = new IUser();
    @EJB
    private UserManagement userService;
    private List<Section> sections = new ArrayList<>();

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    public IUser getUser() {
        return user;
    }

    public void searchSTDById(int id) {
        user = userService.getUser(id);
        sections = userService.findUserInfoById(user);
    }
}
