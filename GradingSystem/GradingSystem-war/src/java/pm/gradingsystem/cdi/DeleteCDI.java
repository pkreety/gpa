/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;

@Named
@RequestScoped
public class DeleteCDI {

    @EJB
    private UserManagement ejb;

    private List<IUser> cars;
    private IUser car;

    public IUser getIUser() {
        if (car == null) {
            car = new IUser();
        }
        return car;
    }

    public void setIUser(IUser car) {
        this.car = car;
    }

    public List<IUser> getUsers() {
        return ejb.getUsers();
    }

    public void setIUsers(List<IUser> cars) {
        this.cars = cars;
    }

    public String delete() {
        String page = "";
        ejb.delete(car.getId());
        page = "deletepage";
        return page;
    }

    public DeleteCDI() {
    }

}
