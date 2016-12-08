package edu.iss.caps.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AkhilJayan
 */
@Entity
@Table(name = "courserun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courserun.findAll", query = "SELECT c FROM Courserun c")
    , @NamedQuery(name = "Courserun.findByCourseID", query = "SELECT c FROM Courserun c WHERE c.courserunPK.courseID = :courseID")
    , @NamedQuery(name = "Courserun.findByCourseStartDate", query = "SELECT c FROM Courserun c WHERE c.courserunPK.courseStartDate = :courseStartDate")
    , @NamedQuery(name = "Courserun.findByCourseEndDate", query = "SELECT c FROM Courserun c WHERE c.courseEndDate = :courseEndDate")
    , @NamedQuery(name = "Courserun.findByClassSize", query = "SELECT c FROM Courserun c WHERE c.classSize = :classSize")
    , @NamedQuery(name = "Courserun.findByCourseStatus", query = "SELECT c FROM Courserun c WHERE c.courseStatus = :courseStatus")
    , @NamedQuery(name = "Courserun.findByCourseVenue", query = "SELECT c FROM Courserun c WHERE c.courseVenue = :courseVenue")
    , @NamedQuery(name = "Courserun.findByCourseGrading", query = "SELECT c FROM Courserun c WHERE c.courseGrading = :courseGrading")})
public class Courserun implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourserunPK courserunPK;
    @Column(name = "CourseEndDate")
    @Temporal(TemporalType.DATE)
    private Date courseEndDate;
    @Column(name = "ClassSize")
    private Integer classSize;
    @Size(max = 20)
    @Column(name = "CourseStatus")
    private String courseStatus;
    @Size(max = 60)
    @Column(name = "CourseVenue")
    private String courseVenue;
    @Size(max = 20)
    @Column(name = "CourseGrading")
    private String courseGrading;
    @JoinColumn(name = "CourseID", referencedColumnName = "CourseID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Courseinfo courseinfo;

    public Courserun() {
    }

    public Courserun(CourserunPK courserunPK) {
        this.courserunPK = courserunPK;
    }

    public Courserun(int courseID, Date courseStartDate) {
        this.courserunPK = new CourserunPK(courseID, courseStartDate);
    }

    public CourserunPK getCourserunPK() {
        return courserunPK;
    }

    public void setCourserunPK(CourserunPK courserunPK) {
        this.courserunPK = courserunPK;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public Integer getClassSize() {
        return classSize;
    }

    public void setClassSize(Integer classSize) {
        this.classSize = classSize;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseVenue() {
        return courseVenue;
    }

    public void setCourseVenue(String courseVenue) {
        this.courseVenue = courseVenue;
    }

    public String getCourseGrading() {
        return courseGrading;
    }

    public void setCourseGrading(String courseGrading) {
        this.courseGrading = courseGrading;
    }

    public Courseinfo getCourseinfo() {
        return courseinfo;
    }

    public void setCourseinfo(Courseinfo courseinfo) {
        this.courseinfo = courseinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courserunPK != null ? courserunPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courserun)) {
            return false;
        }
        Courserun other = (Courserun) object;
        if ((this.courserunPK == null && other.courserunPK != null) || (this.courserunPK != null && !this.courserunPK.equals(other.courserunPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Courserun[ courserunPK=" + courserunPK + " ]";
    }
    
}

