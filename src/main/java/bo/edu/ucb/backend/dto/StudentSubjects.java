package bo.edu.ucb.backend.dto;

public class StudentSubjects {
    private Integer userSubjectId;
    private Integer teacherUserId;
    private String teacherFirstName;
    private String teacherLastName;
    private Integer subjectId;
    private String subjectName;
    private String semester;
    private Integer year;
    private Integer parallel;
    private boolean evaluated;

    public StudentSubjects() {
    }

    public StudentSubjects(Integer userSubjectId, Integer teacherUserId, String teacherFirstName, String teacherLastName, Integer subjectId, String subjectName, String semester, Integer year, Integer parallel, boolean evaluated) {
        this.userSubjectId = userSubjectId;
        this.teacherUserId = teacherUserId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.semester = semester;
        this.year = year;
        this.parallel = parallel;
        this.evaluated = evaluated;
    }

    // Getters and setters
    public Integer getUserSubjectId() {
        return this.userSubjectId;
    }

    public void setUserSubjectId(Integer userSubjectId) {
        this.userSubjectId = userSubjectId;
    }

    public Integer getTeacherUserId() {
        return this.teacherUserId;
    }

    public void setTeacherUserId(Integer teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public String getTeacherFirstName() {
        return this.teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return this.teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public Integer getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String name) {
        this.subjectName = name;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setParallel(Integer parallel) {
        this.parallel = parallel;
    }

    public Integer getParallel(){
        return this.parallel;
    }

    public boolean isEvaluated() {
        return evaluated;
    }    

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    @Override
    public String toString() {
        return "{" +
            " userSubjectId='" + getUserSubjectId() + "'" +
            ", teacherUserId='" + getTeacherUserId() + "'" +
            ", teacherFirstName='" + getTeacherFirstName() + "'" +
            ", teacherLastName='" + getTeacherLastName() + "'" +
            ", subjectId='" + getSubjectId() + "'" +
            ", subjectName='" + getSubjectName() + "'" +
            ", semester='" + getSemester() + "'" +
            ", year='" + getYear() + "'" +
            ", evaluated='" + isEvaluated() + "'" +
            "}";
    }
}
