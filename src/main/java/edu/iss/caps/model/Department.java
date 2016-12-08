package edu.iss.caps.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AkhilJayan
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByDepartmentID", query = "SELECT d FROM Department d WHERE d.departmentID = :departmentID")
    , @NamedQuery(name = "Department.findByDepartmentName", query = "SELECT d FROM Department d WHERE d.departmentName = :departmentName")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @Size(max = 60)
    @Column(name = "DepartmentName")
    private String departmentName;
    @OneToMany(mappedBy = "studentDepartmentID")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "courseDepartmentID")
    private Collection<Courseinfo> courseinfoCollection;
    @OneToMany(mappedBy = "lecturerDepartmentID")
    private Collection<Lecturer> lecturerCollection;
    @JoinColumn(name = "FacultyID", referencedColumnName = "FacultyID")
    @ManyToOne
    private Faculty facultyID;

    public Department() {
    }

    public Department(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Courseinfo> getCourseinfoCollection() {
        return courseinfoCollection;
    }

    public void setCourseinfoCollection(Collection<Courseinfo> courseinfoCollection) {
        this.courseinfoCollection = courseinfoCollection;
    }

    @XmlTransient
    public Collection<Lecturer> getLecturerCollection() {
        return lecturerCollection;
    }

    public void setLecturerCollection(Collection<Lecturer> lecturerCollection) {
        this.lecturerCollection = lecturerCollection;
    }

    public Faculty getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Faculty facultyID) {
        this.facultyID = facultyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Department[ departmentID=" + departmentID + " ]";
    }
    
}
