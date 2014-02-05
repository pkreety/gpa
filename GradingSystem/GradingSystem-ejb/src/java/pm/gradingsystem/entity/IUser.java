/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Tahmasebi
 */
@Entity
public class IUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
//    private String address;
    private int securityCode;
    private String securitAnswer;

    @Transient
    private String rolesStr;
    @Transient
    private int[] num = new int[0];

    public void setNum(int[] num) {
        this.num = num;
    }

//    @OneToOne(cascade = CascadeType.ALL)
//    private Address address=new Address();
//    @OneToMany
//    private List<Role> roles;
//    @OneToOne
//    private Address address=new Address();
//    @OneToOne
//    private List<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address = new Address();
    @ManyToMany
    private List<Role> roles;

    public int[] getNum() {
        if(roles==null) return num;
        num = new int[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            num[i] = roles.get(i).getId();
            System.out.println(num[i]);

        }
        return num;
        //  return num;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public IUser(String firstname, String lastname, String email, String password, Address address, int securityCode, String securitAnswer) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = email;
        this.password = password;
        this.address = address;
        this.securityCode = securityCode;
        this.securitAnswer = securitAnswer;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
    public String getSecuritAnswer() {
        return securitAnswer;
    }

    public void setSecuritAnswer(String securitAnswer) {
        this.securitAnswer = securitAnswer;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    private enum ROLE {

        STAFF, FACULTY, STUDENT, ADMIN
    };

//    public IUser(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public IUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IUser)) {
            return false;
        }
        IUser other = (IUser) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IUser{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", address=" + address + ", securityCode=" + securityCode + ", securitAnswer=" + securitAnswer + ", roles=" + roles + '}';
    }

    public String getRolesStr() {
        return rolesStr;
    }

    public void setRolesStr(String rolesStr) {
        this.rolesStr = rolesStr;
    }

}
