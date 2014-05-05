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

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public interface ClientRestResource {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/request")
    Response sendRequest();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/sessionContext")
    Response getSessionContext();

    // ------ Stateful Session Bean Example START ------
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cd")
    Response cd(@QueryParam("dir") String directory);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/pwd")
    Response pwd();
    // ------ Stateful Session Bean Example END ------

}
