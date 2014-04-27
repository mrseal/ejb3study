package com.cf.ejb.study.ejb;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import com.cf.ejb.study.api.CalculatorLocalBusiness;
import com.cf.ejb.study.api.CalculatorRemoteBusiness;

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

@Stateless
public class CalculatorEJB implements CalculatorRemoteBusiness, CalculatorLocalBusiness {

    @Resource
    private SessionContext sessionCtxt;

    @Override
    public int add(int... arguments) {
        int result = 0;
        for (int arg : arguments) {
            result += arg;
        }
        return result;
    }

    @Override
    public String obtainSessionContext() {
        StringBuffer result = new StringBuffer();
        result.append("SessionContext: " + sessionCtxt);
        result.append("\ngetBusinessObject(CalculatorLocalBusiness): " + sessionCtxt.getBusinessObject(CalculatorLocalBusiness.class));
        result.append("\ngetBusinessObject(CalculatorRemoteBusiness): " + sessionCtxt.getBusinessObject(CalculatorRemoteBusiness.class));
        result.append("\ngetInvokedBusinessInterface" + sessionCtxt.getInvokedBusinessInterface());
        return result.toString();
    }
}
