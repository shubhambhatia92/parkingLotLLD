package org.example.dtos;
// this can be extended by response class to add extra info while reponse returning to client
public class responseDto {
    String message;
    String responseCode;// can be enum as well

    public responseDto(String message, String responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
