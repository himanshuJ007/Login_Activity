package com.technicalrj.task;

/**
 * Created by hamuj on 4/8/2018.
 */

class UserFeedback {

    public String userFeedback;
    public String userEmail;
    public String userName;

    public UserFeedback() {
    }

    public UserFeedback( String userEmail, String userName,String userfeedback) {
        this.userFeedback = userfeedback;
        this.userEmail = userEmail;
        this.userName = userName;

    }

    public String getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(String userAge) {
        this.userFeedback = userFeedback;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}