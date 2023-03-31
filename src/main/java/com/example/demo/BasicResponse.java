package com.example.demo;

public class BasicResponse {
    private boolean success;
    private Integer errorCode;
    private String explain;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public BasicResponse(boolean success, Integer errorCode) {
        this.success = success;
        this.errorCode = errorCode;
        if(errorCode == 1){
            this.explain = "ERROR_SIGN_UP_ON_USERNAME";
        }
        else if(errorCode ==2){
            this.explain = "ERROR_SIGN_UP_ON_PASSWORD";
        } else if (errorCode ==3) {
            this.explain = "ERROR_SIGN_UP_ON_PASSWORD_DONT_MATCH";
        }else if(errorCode == 4){
            this.explain = "ERROR_SIGN_UP_USERNAME_TAKEN";
        }
        else if(errorCode == 5){
            this.explain = "ERROR_LOGIN";
        }
        else{
            this.explain ="200";
        }

    }
}
