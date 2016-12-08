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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AkhilJayan
 */
@Entity
@Table(name = "lecturer")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l")
//    , @NamedQuery(name = "Lecturer.findByLecturerID", query = "SELECT l FROM Lecturer l WHERE l.lecturerID = :lecturerID")
//    , @NamedQuery(name = "Lecturer.findByLecturerName", query = "SELECT l FROM Lecturer l WHERE l.lecturerName = :lecturerName")
//    , @NamedQuery(name = "Lecturer.findByStatus", query = "SELECT l FROM Lecturer l WHERE l.status = :status")
//    , @NamedQuery(name = "Lecturer.findByGender", query = "SELECT l FROM Lecturer l WHERE l.gender = :gender")
//    , @NamedQuery(name = "Lecturer.findByDob", query = "SELECT l FROM Lecturer l WHERE l.dob = :dob")
//    , @NamedQuery(name = "Lecturer.findByEmail", query = "SELECT l FROM Lecturer l WHERE l.email = :email")
//    , @NamedQuery(name = "Lecturer.findByAddress", query = "SELECT l FROM Lecturer l WHERE l.address = :address")
//    , @NamedQuery(name = "Lecturer.findByEmployedDate", query = "SELECT l FROM Lecturer l WHERE l.employedDate = :employedDate")})
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LecturerID")
    private Integer lecturerID;
    
    @Size(max = 100)
    @Column(name = "LecturerName")
    private String lecturerName;
    
    @Size(max = 45)
    @Column(name = "Status")
    private String status;
    
    @Size(max = 20)
    @Column(name = "Gender")
    private String gender;
    
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 120)
    @Column(name = "Email")
    private String email;
    
    @Size(max = 200)
    @Column(name = "Address")
    private String address;
    
    @Column(name = "EmployedDate")
    @Temporal(TemporalType.DATE)
    private Date employedDate;
    
    @ManyToMany(mappedBy = "lecturerCollection")
    private Collection<Courseinfo> courseinfoCollection;
    
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;
    
    @JoinColumn(name = "LecturerDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne
    private Department lecturerDepartmentID;
    
    @JoinColumn(name = "LecturerFacultyID", referencedColumnName = "FacultyID")
    @ManyToOne
    private Faculty lecturerFacultyID;

    public Lecturer() {
    }

    public Lecturer(Integer lecturerID) {
        this.lecturerID = lecturerID;
    }

    public Integer getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(Integer lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEmployedDate() {
        return employedDate;
    }

    public void setEmployedDate(Date employedDate) {
        this.employedDate = employedDate;
    }

    @XmlTransient
    public Collection<Courseinfo> getCourseinfoCollection() {
        return courseinfoCollection;
    }

    public void setCourseinfoCollection(Collection<Courseinfo> courseinfoCollection) {
        this.courseinfoCollection = courseinfoCollection;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Department getLecturerDepartmentID() {
        return lecturerDepartmentID;
    }

    public void setLecturerDepartmentID(Department lecturerDepartmentID) {
        this.lecturerDepartmentID = lecturerDepartmentID;
    }

    public Faculty getLecturerFacultyID() {
        return lecturerFacultyID;
    }

    public void setLecturerFacultyID(Faculty lecturerFacultyID) {
        this.lecturerFacultyID = lecturerFacultyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecturerID != null ? lecturerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.lecturerID == null && other.lecturerID != null) || (this.lecturerID != null && !this.lecturerID.equals(other.lecturerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Lecturer[ lecturerID=" + lecturerID + " ]";
    }
    
}
