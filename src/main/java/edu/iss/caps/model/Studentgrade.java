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
@Table(name = "studentgrade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentgrade.findAll", query = "SELECT s FROM Studentgrade s")
    , @NamedQuery(name = "Studentgrade.findByStudentID", query = "SELECT s FROM Studentgrade s WHERE s.studentgradePK.studentID = :studentID")
    , @NamedQuery(name = "Studentgrade.findByCourseID", query = "SELECT s FROM Studentgrade s WHERE s.studentgradePK.courseID = :courseID")
    , @NamedQuery(name = "Studentgrade.findByGrade", query = "SELECT s FROM Studentgrade s WHERE s.grade = :grade")
    , @NamedQuery(name = "Studentgrade.findByEnrolledDate", query = "SELECT s FROM Studentgrade s WHERE s.enrolledDate = :enrolledDate")
    , @NamedQuery(name = "Studentgrade.findByCompletionStatus", query = "SELECT s FROM Studentgrade s WHERE s.completionStatus = :completionStatus")})
public class Studentgrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentgradePK studentgradePK;
    @Size(max = 10)
    @Column(name = "Grade")
    private String grade;
    @Column(name = "EnrolledDate")
    @Temporal(TemporalType.DATE)
    private Date enrolledDate;
    @Size(max = 45)
    @Column(name = "CompletionStatus")
    private String completionStatus;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Studentgrade() {
    }

    public Studentgrade(StudentgradePK studentgradePK) {
        this.studentgradePK = studentgradePK;
    }

    public Studentgrade(int studentID, int courseID) {
        this.studentgradePK = new StudentgradePK(studentID, courseID);
    }

    public StudentgradePK getStudentgradePK() {
        return studentgradePK;
    }

    public void setStudentgradePK(StudentgradePK studentgradePK) {
        this.studentgradePK = studentgradePK;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentgradePK != null ? studentgradePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentgrade)) {
            return false;
        }
        Studentgrade other = (Studentgrade) object;
        if ((this.studentgradePK == null && other.studentgradePK != null) || (this.studentgradePK != null && !this.studentgradePK.equals(other.studentgradePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iss.caps.Studentgrade[ studentgradePK=" + studentgradePK + " ]";
    }
    
}
