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
package com.cf.ejb.study.client.rest.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import com.cf.ejb.study.api.CalculatorRemoteBusiness;
import com.cf.ejb.study.stateful.api.FileTransferRemoteBusiness;

@Stateless
public class ClientRestResourceBean implements ClientRestResource {

    @EJB
    CalculatorRemoteBusiness calculator;

    @Override
    public Response sendRequest() {
        String result = "EJB not working!";
        if (calculator != null) {
            result = "1 + 1 = " + calculator.add(1, 1);
        }
        return Response.ok(result).build();
    }

    @Override
    public Response getSessionContext() {
        return Response.ok(calculator.obtainSessionContext()).build();
    }

    // ------ Stateful Session Bean Example START ------
    @EJB
    FileTransferRemoteBusiness ftpBean;

    @Override
    public Response cd(String directory) {
        ftpBean.cd(directory);
        return Response.ok("cd successful, use pwd to check the current location").build();
    }

    @Override
    public Response pwd() {
        return Response.ok(ftpBean.pwd()).build();
    }
    // ------ Stateful Session Bean Example END ------

}