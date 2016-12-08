
package edu.iss.caps.model;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AkhilJayan
 */
@Entity
@Table(name = "loginrole")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Loginrole.findAll", query = "SELECT l FROM Loginrole l")
//    , @NamedQuery(name = "Loginrole.findByRoleID", query = "SELECT l FROM Loginrole l WHERE l.roleID = :roleID")
//    , @NamedQuery(name = "Loginrole.findByRole", query = "SELECT l FROM Loginrole l WHERE l.role = :role")})
public class Loginrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RoleID")
    private Integer roleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<User> loginauthenticateCollection;

    public Loginrole() {
    }

    public Loginrole(Integer roleID) {
        this.roleID = roleID;
    }

    public Loginrole(Integer roleID, String role) {
        this.roleID = roleID;
        this.role = role;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<User> getLoginauthenticateCollection() {
        return loginauthenticateCollection;
    }

    public void setLoginauthenticateCollection(Collection<User> loginauthenticateCollection) {
        this.loginauthenticateCollection = loginauthenticateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loginrole)) {
            return false;
        }
        Loginrole other = (Loginrole) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Loginrole[ roleID=" + roleID + " ]";
    }
    
}
