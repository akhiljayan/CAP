package edu.iss.caps.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AkhilJayan
 */
@Embeddable
public class StudentgradePK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "StudentID")
    private int studentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CourseID")
    private int courseID;

    public StudentgradePK() {
    }

    public StudentgradePK(int studentID, int courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentID;
        hash += (int) courseID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentgradePK)) {
            return false;
        }
        StudentgradePK other = (StudentgradePK) object;
        if (this.studentID != other.studentID) {
            return false;
        }
        if (this.courseID != other.courseID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.StudentgradePK[ studentID=" + studentID + ", courseID=" + courseID + " ]";
    }
    
}

