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
package com.cf.ejb.study.stateless.api;

public interface EncryptionCommonBusiness {

    /**
     * Symmetrical encryption. Encrypts the specified clear text.
     * 
     * @param clearText
     * @return
     * @throws IllegalArgumentException
     */
    String encrypt(String clearText) throws IllegalArgumentException;

    /**
     * Symmetrical encryption. Decrypts the specified encrypted text. The general contract is that
     * the result of decrypting a String encrypted with {@link #encrypt(String)} will be equal by
     * value to the original clear text.
     * 
     * @param encryptedText
     * @return
     * @throws IllegalArgumentException
     */
    String decrypt(String encryptedText) throws IllegalArgumentException;

    /**
     * Returns a one-way hash of the specified clear text. Useful for safely storing passwords.
     * 
     * @param clearText
     * @return
     * @throws IllegalArgumentException
     */
    String hash(String clearText) throws IllegalArgumentException;

    /**
     * Return whether or not the specified encrypted text using cryptographic hashing matches the
     * specified hash. Useful for validating passwords against a securely stored hash.
     * 
     * @param hash
     * @param encryptedText
     * @return
     * @throws IllegalArgumentException
     */
    boolean comapre(String hash, String encryptedText) throws IllegalArgumentException;

}
