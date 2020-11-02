package com.quercusdata.awsspringboot.exception;

public class AbstractCRUDException extends RuntimeException {

    private static final long serialVersionUID = 5492632789660629660L;

    public static final int OK = 200;
    public static final int ERROR_BAD_REQUEST = 400;
    public static final int ERROR_AUTHENTICATION_FAILED = 401;
    public static final int ERROR_UNAUTHORISED = 403;
    public static final int ERROR_NOT_FOUND = 404;
    public static final int ERROR_INTERNAL_ERROR = 500;

    private int errorCode = 0;
    private String errorDescription;
    private String userMessage;

    public AbstractCRUDException(final int errorCode, final String errorDescription, String userMessage)
    {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.userMessage = userMessage;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(final int errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getUserMessage()
    {
        return userMessage;
    }

    public void setUserMessage(String userMessage)
    {
        this.userMessage = userMessage;
    }

    public String getErrorDescription()
    {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }
}
