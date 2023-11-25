package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_subject")
public class TeacherSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherSubjectId;

    @ManyToOne
    @JoinColumn(name = "teacher_user_id")
    private User teacherUserId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @Column(name = "status")
    private boolean status;

    public TeacherSubject() {
    }

    public TeacherSubject(Integer teacherSubjectId, User teacherUserId, Subject subjectId, boolean status) {
        this.teacherSubjectId = teacherSubjectId;
        this.teacherUserId = teacherUserId;
        this.subjectId = subjectId;
        this.status = status;
    }

    public Integer getTeacherSubjectId() {
        return teacherSubjectId;
    }

    public void setTeacherSubjectId(Integer teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    public User getTeacherUserId() {
        return teacherUserId;
    }

    public void setTeacherUserId(User teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeacherSubject{" +
                "teacherSubjectId=" + teacherSubjectId +
                ", teacherUserId=" + teacherUserId +
                ", subjectId=" + subjectId +
                ", status=" + status +
                '}';
    }
}
