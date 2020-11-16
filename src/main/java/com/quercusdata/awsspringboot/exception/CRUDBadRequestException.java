package com.quercusdata.awsspringboot.exception;

public class CRUDBadRequestException extends AbstractCRUDException {

    private static final long serialVersionUID = 1492632789660629661L;

    public CRUDBadRequestException(final String errorDescription)
    {
        super(ERROR_BAD_REQUEST, errorDescription, "An error occurred. Please contact Application Support.");
    }

}
