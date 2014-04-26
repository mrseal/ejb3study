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
package com.cf.ejb.study.client.rest.resources.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.cf.ejb.study.client.rest.resources.ClientRestResourceBean;

@ApplicationPath("/services")
public class ClientRestResourceMapper extends Application {

    private final Set<Object> resourceObjects = new HashSet<Object>();
    private final Set<Class<?>> resourceClasses = new HashSet<Class<?>>();

    public ClientRestResourceMapper() {
        resourceClasses.add(ClientRestResourceBean.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resourceClasses;
    }

    @Override
    public Set<Object> getSingletons() {
        return resourceObjects;
    }

}
