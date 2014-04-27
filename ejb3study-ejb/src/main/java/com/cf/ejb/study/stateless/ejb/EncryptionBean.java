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
package com.cf.ejb.study.stateless.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cf.ejb.study.stateless.api.EncryptionLocalBusiness;
import com.cf.ejb.study.stateless.api.EncryptionRemoteBusiness;

/**
 * Bean implementation class of the EncryptionEJB. Shows how lifecycle callbacks are implemented
 * (@PostConstruct), and two ways of obtaining externalized environment entries.
 * 
 * @author eccnffi
 * 
 */
@Stateless(name = "EncryptionEJB")
public class EncryptionBean implements EncryptionLocalBusiness, EncryptionRemoteBusiness {

    private static final Logger log = LoggerFactory.getLogger(EncryptionBean.class);

    private String beanName;

    @PostConstruct
    public void initialize() {
        log.info("Initializing, part of {} lifecycle", PostConstruct.class.getSimpleName());
        beanName = "EncryptionEJB";
    }

    @Override
    public String encrypt(String clearText) throws IllegalArgumentException {
        return "[" + beanName + "] Encrypted " + clearText;
    }

    @Override
    public String decrypt(String encryptedText) throws IllegalArgumentException {
        return "[" + beanName + "] Decrypted " + encryptedText;
    }

    @Override
    public String hash(String clearText) throws IllegalArgumentException {
        return "[" + beanName + "] Hash " + clearText;
    }

    @Override
    public boolean comapre(String hash, String encryptedText) throws IllegalArgumentException {
        if (hash == null || encryptedText == null) {
            throw new IllegalArgumentException("hash or encryptedText must not be null");
        }
        return hash.equals(encryptedText);
    }

}
