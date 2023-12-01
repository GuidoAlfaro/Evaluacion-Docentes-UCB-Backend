package bo.edu.ucb.backend.dto;

import java.util.Date;

public class TeacherQueryDTO {
    private Integer teacherQueryId;
    private String queryText;
    private String apiResponse;
    private Date date;

    public TeacherQueryDTO() {
    }

    public TeacherQueryDTO(Integer teacherQueryId, String queryText, String apiResponse, Date date) {
        this.teacherQueryId = teacherQueryId;
        this.queryText = queryText;
        this.apiResponse = apiResponse;
        this.date = date;
    }

    public Integer getTeacherQueryId() {
        return teacherQueryId;
    }

    public void setTeacherQueryId(Integer teacherQueryId) {
        this.teacherQueryId = teacherQueryId;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText.toUpperCase();
    }

    public String getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(String apiResponse) {
        this.apiResponse = apiResponse.toUpperCase();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TeacherQueryDTO{" +
                "teacherQueryId=" + teacherQueryId +
                ", queryText='" + queryText + '\'' +
                ", apiResponse='" + apiResponse + '\'' +
                ", date=" + date +
                '}';
    }
}
