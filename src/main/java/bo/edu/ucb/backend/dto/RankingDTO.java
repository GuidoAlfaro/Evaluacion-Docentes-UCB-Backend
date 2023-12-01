package bo.edu.ucb.backend.dto;

public class RankingDTO {
    private String name;
    private String lastName;
    private String subjectName;
    private String parallel;
    private Double result;

    public RankingDTO() {
    }

    public RankingDTO(String name, String lastName, String subjectName, String parallel, Double result) {
        this.name = name;
        this.lastName = lastName;
        this.subjectName = subjectName;
        this.parallel = parallel;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RankingDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", parallel='" + parallel + '\'' +
                ", result=" + result +
                '}';
    }
}