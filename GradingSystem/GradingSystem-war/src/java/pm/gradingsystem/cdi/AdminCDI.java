/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import GPASystem_Services.AdminService;
//import GPASystem_entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.entity.Role;

/**
 * 
 * @author Prakriti
 */
@Named
@RequestScoped
public class AdminCDI {
List<Role> roles=new ArrayList<>();
Role role=new Role();
 @EJB
    private AdminService adminService;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public List<Role> getRoles() {
        setRoles(adminService.getAllRoles());
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
     public String makeRole(){
        adminService.makeRole(role);
        return "result";
    }

}
