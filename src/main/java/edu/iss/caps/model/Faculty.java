package edu.iss.caps.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f")
    , @NamedQuery(name = "Faculty.findByFacultyID", query = "SELECT f FROM Faculty f WHERE f.facultyID = :facultyID")
    , @NamedQuery(name = "Faculty.findByFacultyName", query = "SELECT f FROM Faculty f WHERE f.facultyName = :facultyName")})
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FacultyID")
    private Integer facultyID;
    @Size(max = 60)
    @Column(name = "FacultyName")
    private String facultyName;
    @OneToMany(mappedBy = "studentFacultyID")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "courseFacultyID")
    private Collection<Courseinfo> courseinfoCollection;
    @OneToMany(mappedBy = "lecturerFacultyID")
    private Collection<Lecturer> lecturerCollection;
    @OneToMany(mappedBy = "facultyID")
    private Collection<Department> departmentCollection;

    public Faculty() {
    }

    public Faculty(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public Integer getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
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

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyID != null ? facultyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultyID == null && other.facultyID != null) || (this.facultyID != null && !this.facultyID.equals(other.facultyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Faculty[ facultyID=" + facultyID + " ]";
    }
    
}

