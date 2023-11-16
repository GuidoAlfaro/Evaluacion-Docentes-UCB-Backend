package bo.edu.ucb.backend.dto;

public class ResponseDTO {
    private String status;
    private Object data;
    private String error;


    //exito
    public ResponseDTO(Object data) {
        this.status = "200";
        this.data = data;
    }

    //error
    public ResponseDTO(String status, String error) {
        this.status = status;
        this.error = error;
    }

    //getters and setters
    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString(){
        return "ResponseDTO{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

}
