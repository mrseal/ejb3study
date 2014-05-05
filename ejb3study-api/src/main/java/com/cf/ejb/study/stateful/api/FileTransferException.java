/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.cf.ejb.study.stateful.api;

public class FileTransferException extends RuntimeException {

    private static final long serialVersionUID = -415539646506088599L;

    public FileTransferException(String decription) {
        super(decription);
    }

    public FileTransferException(String decription, Throwable throwable) {
        super(decription, throwable);
    }

}
