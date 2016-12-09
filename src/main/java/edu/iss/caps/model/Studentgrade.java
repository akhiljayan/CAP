package edu.iss.caps.model;


import java.io.Serializable;
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
@Table(name = "studentgrade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentgrade.findAll", query = "SELECT s FROM Studentgrade s")
    , @NamedQuery(name = "Studentgrade.findByGrade", query = "SELECT s FROM Studentgrade s WHERE s.grade = :grade")
    , @NamedQuery(name = "Studentgrade.findByEnrolledDate", query = "SELECT s FROM Studentgrade s WHERE s.enrolledDate = :enrolledDate")
    , @NamedQuery(name = "Studentgrade.findByCompletionStatus", query = "SELECT s FROM Studentgrade s WHERE s.completionStatus = :completionStatus")
    , @NamedQuery(name = "Studentgrade.findByEnrolmentID", query = "SELECT s FROM Studentgrade s WHERE s.enrolmentID = :enrolmentID")})
public class Studentgrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "Grade")
    private String grade;
    
    @Column(name = "EnrolledDate")
    @Temporal(TemporalType.DATE)
    private Date enrolledDate;
    
    @Size(max = 45)
    @Column(name = "CompletionStatus")
    private String completionStatus;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EnrolmentID")
    private Integer enrolmentID;
    
    @JoinColumn(name = "CourseID", referencedColumnName = "CourseID")
    @ManyToOne
    private Courseinfo courseID;
    
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID")
    @ManyToOne
    private Student studentID;

    public Studentgrade() {
    }

    public Studentgrade(Integer enrolmentID) {
        this.enrolmentID = enrolmentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }

    public Integer getEnrolmentID() {
        return enrolmentID;
    }

    public void setEnrolmentID(Integer enrolmentID) {
        this.enrolmentID = enrolmentID;
    }

    public Courseinfo getCourseID() {
        return courseID;
    }

    public void setCourseID(Courseinfo courseID) {
        this.courseID = courseID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrolmentID != null ? enrolmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentgrade)) {
            return false;
        }
        Studentgrade other = (Studentgrade) object;
        if ((this.enrolmentID == null && other.enrolmentID != null) || (this.enrolmentID != null && !this.enrolmentID.equals(other.enrolmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sss.Studentgrade[ enrolmentID=" + enrolmentID + " ]";
    }
    
}
