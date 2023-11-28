package bo.edu.ucb.backend.dto;

public class TeacherSubjectsDTO {
    private Integer teacherSubjectId;
    private Integer subjectId;
    private String subjectName;
    private String parallel;
    private String evaluationPercent;

    public TeacherSubjectsDTO() {
    }

    public TeacherSubjectsDTO(Integer teacherSubjectId, Integer subjectId, String subjectName, String parallel, String evaluationPercent) {
        this.teacherSubjectId = teacherSubjectId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.parallel = parallel;
        this.evaluationPercent = evaluationPercent;
    }

    public Integer getTeacherSubjectId() {
        return teacherSubjectId;
    }

    public void setTeacherSubjectId(Integer teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    public String getEvaluationPercent() {
        return evaluationPercent;
    }

    public void setEvaluationPercent(String evaluationPercent) {
        this.evaluationPercent = evaluationPercent;
    }

    @Override
    public String toString() {
        return "TeacherSubjectsDTO{" + "teacherSubjectId=" + teacherSubjectId + ", subjectId=" + subjectId + ", subjectName=" + subjectName + ", parallel=" + parallel + ", evaluationPercent=" + evaluationPercent + '}';
    }
}
