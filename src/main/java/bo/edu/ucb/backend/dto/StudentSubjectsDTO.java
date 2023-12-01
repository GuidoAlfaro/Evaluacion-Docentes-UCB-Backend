package bo.edu.ucb.backend.dto;

public class StudentSubjectsDTO {

    private Integer enrollmentId;
    private Integer subjectEvaluationId;
    private String teacherFirstName;
    private String teacherLastName;
    private Integer subjectId;
    private String subjectName;
    private String semester;
    private String year;
    private String parallel;
    private boolean evaluated;

    public StudentSubjectsDTO() {
    }

    public StudentSubjectsDTO(Integer enrollmentId, Integer subjectEvaluationId, String teacherFirstName, String teacherLastName, Integer subjectId, String subjectName, String semester, String year, String parallel, boolean evaluated) {
        this.enrollmentId = enrollmentId;
        this.subjectEvaluationId = subjectEvaluationId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.semester = semester;
        this.year = year;
        this.parallel = parallel;
        this.evaluated = evaluated;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getSubjectEvaluationId() {
        return subjectEvaluationId;
    }

    public void setSubjectEvaluationId(Integer subjectEvaluationId) {
        this.subjectEvaluationId = subjectEvaluationId;
    }
    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    @Override
    public String toString() {
        return "StudentSubjectsDTO{" +
                "enrollmentId=" + enrollmentId + '\'' +
                ", subjectEvaluationId='" + subjectEvaluationId + '\'' +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", semester='" + semester + '\'' +
                ", year='" + year + '\'' +
                ", parallel='" + parallel + '\'' +
                ", evaluated=" + evaluated +
                '}';
    }
}
