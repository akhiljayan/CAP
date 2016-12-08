package edu.iss.caps.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "courseinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courseinfo.findAll", query = "SELECT c FROM Courseinfo c")
    , @NamedQuery(name = "Courseinfo.findByCourseID", query = "SELECT c FROM Courseinfo c WHERE c.courseID = :courseID")
    , @NamedQuery(name = "Courseinfo.findByCourseName", query = "SELECT c FROM Courseinfo c WHERE c.courseName = :courseName")
    , @NamedQuery(name = "Courseinfo.findByCourseDescription", query = "SELECT c FROM Courseinfo c WHERE c.courseDescription = :courseDescription")
    , @NamedQuery(name = "Courseinfo.findByMaxClassSize", query = "SELECT c FROM Courseinfo c WHERE c.maxClassSize = :maxClassSize")
    , @NamedQuery(name = "Courseinfo.findByCredits", query = "SELECT c FROM Courseinfo c WHERE c.credits = :credits")})
public class Courseinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CourseID")
    private Integer courseID;
    @Size(max = 120)
    @Column(name = "CourseName")
    private String courseName;
    @Size(max = 300)
    @Column(name = "CourseDescription")
    private String courseDescription;
    @Column(name = "MaxClassSize")
    private Integer maxClassSize;
    @Column(name = "Credits")
    private Integer credits;
    @JoinTable(name = "lecturercourse", joinColumns = {
        @JoinColumn(name = "CourseID", referencedColumnName = "CourseID")}, inverseJoinColumns = {
        @JoinColumn(name = "LecturerID", referencedColumnName = "LecturerID")})
    @ManyToMany
    private Collection<Lecturer> lecturerCollection;
    @JoinColumn(name = "CourseDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne
    private Department courseDepartmentID;
    @JoinColumn(name = "CourseFacultyID", referencedColumnName = "FacultyID")
    @ManyToOne
    private Faculty courseFacultyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseinfo")
    private Collection<Courserun> courserunCollection;

    public Courseinfo() {
    }

    public Courseinfo(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Integer getMaxClassSize() {
        return maxClassSize;
    }

    public void setMaxClassSize(Integer maxClassSize) {
        this.maxClassSize = maxClassSize;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @XmlTransient
    public Collection<Lecturer> getLecturerCollection() {
        return lecturerCollection;
    }

    public void setLecturerCollection(Collection<Lecturer> lecturerCollection) {
        this.lecturerCollection = lecturerCollection;
    }

    public Department getCourseDepartmentID() {
        return courseDepartmentID;
    }

    public void setCourseDepartmentID(Department courseDepartmentID) {
        this.courseDepartmentID = courseDepartmentID;
    }

    public Faculty getCourseFacultyID() {
        return courseFacultyID;
    }

    public void setCourseFacultyID(Faculty courseFacultyID) {
        this.courseFacultyID = courseFacultyID;
    }

    @XmlTransient
    public Collection<Courserun> getCourserunCollection() {
        return courserunCollection;
    }

    public void setCourserunCollection(Collection<Courserun> courserunCollection) {
        this.courserunCollection = courserunCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courseinfo)) {
            return false;
        }
        Courseinfo other = (Courseinfo) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Courseinfo[ courseID=" + courseID + " ]";
    }
    
}

