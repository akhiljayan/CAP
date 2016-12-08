
package edu.iss.caps.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AkhilJayan
 */
@Entity
@Table(name = "loginauthenticate")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Loginauthenticate.findAll", query = "SELECT l FROM Loginauthenticate l")
//    , @NamedQuery(name = "Loginauthenticate.findByUserID", query = "SELECT l FROM Loginauthenticate l WHERE l.userID = :userID")
//    , @NamedQuery(name = "Loginauthenticate.findByUsername", query = "SELECT l FROM Loginauthenticate l WHERE l.username = :username")
//    , @NamedQuery(name = "Loginauthenticate.findByPassword", query = "SELECT l FROM Loginauthenticate l WHERE l.password = :password")
//    , @NamedQuery(name = "Loginauthenticate.findByCreatedDate", query = "SELECT l FROM Loginauthenticate l WHERE l.createdDate = :createdDate")
//    , @NamedQuery(name = "Loginauthenticate.findByIsLogedIn", query = "SELECT l FROM Loginauthenticate l WHERE l.isLogedIn = :isLogedIn")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Username")
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    
    @Column(name = "IsLogedIn")
    private Integer isLogedIn;
    
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private Loginrole roleID;
    
    @OneToMany(mappedBy = "createdBy")
    private Collection<User> loginauthenticateCollection;
    
    @JoinColumn(name = "CreatedBy", referencedColumnName = "UserID")
    @ManyToOne
    private User createdBy;

    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public User(Integer userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getIsLogedIn() {
        return isLogedIn;
    }

    public void setIsLogedIn(Integer isLogedIn) {
        this.isLogedIn = isLogedIn;
    }

    public Loginrole getRoleID() {
        return roleID;
    }

    public void setRoleID(Loginrole roleID) {
        this.roleID = roleID;
    }

    @XmlTransient
    public Collection<User> getLoginauthenticateCollection() {
        return loginauthenticateCollection;
    }

    public void setLoginauthenticateCollection(Collection<User> loginauthenticateCollection) {
        this.loginauthenticateCollection = loginauthenticateCollection;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Loginauthenticate[ userID=" + userID + " ]";
    }
    
}
