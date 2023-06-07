package br.com.santander.internetbanking.exception;

public class ErrorResponseBalance {
    private String message;

    public ErrorResponseBalance(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
