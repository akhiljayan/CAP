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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID")
    , @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName")
    , @NamedQuery(name = "Student.findByStatus", query = "SELECT s FROM Student s WHERE s.status = :status")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob")
    , @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findByMatricDate", query = "SELECT s FROM Student s WHERE s.matricDate = :matricDate")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StudentID")
    private Integer studentID;
    
    @Size(max = 100)
    @Column(name = "StudentName")
    private String studentName;
    
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
    
    @Column(name = "MatricDate")
    @Temporal(TemporalType.DATE)
    private Date matricDate;
    
    @JoinColumn(name = "StudentDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne
    private Department studentDepartmentID;
    
    @JoinColumn(name = "StudentFacultyID", referencedColumnName = "FacultyID")
    @ManyToOne
    private Faculty studentFacultyID;
    
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;
    
    @OneToMany(mappedBy = "studentID")
    private Collection<Studentgrade> studentgradeCollection;

    public Student() {
    }

    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Date getMatricDate() {
        return matricDate;
    }

    public void setMatricDate(Date matricDate) {
        this.matricDate = matricDate;
    }

    public Department getStudentDepartmentID() {
        return studentDepartmentID;
    }

    public void setStudentDepartmentID(Department studentDepartmentID) {
        this.studentDepartmentID = studentDepartmentID;
    }

    public Faculty getStudentFacultyID() {
        return studentFacultyID;
    }

    public void setStudentFacultyID(Faculty studentFacultyID) {
        this.studentFacultyID = studentFacultyID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<Studentgrade> getStudentgradeCollection() {
        return studentgradeCollection;
    }

    public void setStudentgradeCollection(Collection<Studentgrade> studentgradeCollection) {
        this.studentgradeCollection = studentgradeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sss.Student[ studentID=" + studentID + " ]";
    }
    
}
