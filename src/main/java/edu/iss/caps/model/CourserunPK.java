package edu.iss.caps.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AkhilJayan
 */
@Embeddable
public class CourserunPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "CourseID")
    private int courseID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CourseStartDate")
    @Temporal(TemporalType.DATE)
    private Date courseStartDate;

    public CourserunPK() {
    }

    public CourserunPK(int courseID, Date courseStartDate) {
        this.courseID = courseID;
        this.courseStartDate = courseStartDate;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) courseID;
        hash += (courseStartDate != null ? courseStartDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourserunPK)) {
            return false;
        }
        CourserunPK other = (CourserunPK) object;
        if (this.courseID != other.courseID) {
            return false;
        }
        if ((this.courseStartDate == null && other.courseStartDate != null) || (this.courseStartDate != null && !this.courseStartDate.equals(other.courseStartDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.CourserunPK[ courseID=" + courseID + ", courseStartDate=" + courseStartDate + " ]";
    }
    
}

