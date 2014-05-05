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

import javax.ejb.Remote;

@Remote
public interface FileTransferRemoteBusiness extends FileTransferCommonBusiness {

    /**
     * Ends the current session; will result in a SFSB @Remove call as the bean implementation class
     * will annotate this with {@link javax.ejb.Remove}
     */
    void endSession();

}
