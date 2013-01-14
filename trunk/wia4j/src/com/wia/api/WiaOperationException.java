
package com.wia.api;

import com4j.ComException;

/**
 *
 * @author Naveed Quadri
 */
public class WiaOperationException extends Exception {

    private String comErrorMessage;

    public WiaOperationException(String message) {
        super(message);
    }

    public WiaOperationException(String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof ComException) {
            comErrorMessage = ((ComException) cause).getDetailMessage();
        }
    }

    public String getErrorCode() {
        return comErrorMessage;
    }
}
