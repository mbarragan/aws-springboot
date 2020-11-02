package com.quercusdata.awsspringboot.exception;

public class CRUDNotFoundException extends AbstractCRUDException {

    private static final long serialVersionUID = 5492632789660629661L;

    public CRUDNotFoundException(final String errorDescription)
    {
        super(ERROR_BAD_REQUEST, errorDescription, "An error occurred. Please contact Application Support.");
    }

    public CRUDNotFoundException(final String errorDescription, final String userMessage)
    {
        super(ERROR_NOT_FOUND, errorDescription, userMessage);
    }
}
