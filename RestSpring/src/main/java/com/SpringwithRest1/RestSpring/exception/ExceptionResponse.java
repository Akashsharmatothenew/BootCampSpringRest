package com.SpringwithRest1.RestSpring.exception;

import java.util.Date;

/**
 * Created by ttn on 9/3/21.
 */
public class ExceptionResponse {
    Date timestamp;
    String message;
    String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
