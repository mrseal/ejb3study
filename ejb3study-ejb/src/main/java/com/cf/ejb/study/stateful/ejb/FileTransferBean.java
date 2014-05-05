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
package com.cf.ejb.study.stateful.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cf.ejb.study.stateful.api.FileTransferException;
import com.cf.ejb.study.stateful.api.FileTransferRemoteBusiness;

@Stateful(name = FileTransferBean.EJB_NAME)
public class FileTransferBean implements FileTransferRemoteBusiness, Serializable {

    private Logger log = LoggerFactory.getLogger(getClass());

    private static final long serialVersionUID = 2801717093113748495L;

    public static final String EJB_NAME = "FileTransferEJB";

    private static final String CONNECT_HOST = "localhost";
    private static final int CONNECT_PORT = 12345;

    /**
     * The underlying FTP client (delegate for all FTP operations). We don't want its state getting
     * Serialized during passivation. We'll reinitialize this client and its connections upon
     * activation.
     */
    private FTPClient client;

    /**
     * Name of the present working directory. In cases where we're passivated, if this is specified
     * we'll change into this directory upon activation.
     */
    private String presentWorkingDirectory;

    @Override
    public void mkdir(String directory) throws IllegalStateException {

    }

    @Override
    public void cd(String directory) throws IllegalStateException {
        log.info("cd > {}", directory);
        this.setPresentWorkingDirectory(directory);
    }

    @Override
    public String pwd() throws IllegalStateException {
        return this.getPresentWorkingDirectory();
    }

    /**
     * Called by the container when the instance is about to be passivated or brought out of service
     * entirely.
     */
    @PrePassivate
    @PreDestroy
    @Override
    public void disconnect() {

        // Obtain FTP client
        final FTPClient client = this.getClient();

        // If exists
        if (client != null) {
            // If connected
            if (client.isConnected()) {

                // Logout logic here

                // Disconnect Logic here
                log.debug("Disconnected from FTP Server at {}:{}", CONNECT_HOST, CONNECT_PORT);
            }

            // Null out so we don't serialize this field
            this.client = null;
        }

    }

    /**
     * Called by the container when the instance has been created or re-activated (brought out of
     * passivated state). Will construct the underlying FTP client and open all appropriate
     * connections.
     * 
     * @throws IllegalStateException
     */
    @PostConstruct
    @PostActivate
    @Override
    public void connect() throws IllegalStateException, FileTransferException {

        /*
         * Precondition checks
         */
        final FTPClient clientBefore = this.getClient();
        if (clientBefore != null && clientBefore.isConnected()) {
            throw new IllegalStateException("FTP Client is already initialized");
        }

        // Create the client
        final FTPClient client = new FTPClient();
        //        log.debug("Connecting to FTP Server at {}:{}", CONNECT_HOST, CONNECT_PORT);
        //        try {
        //            client.connect(CONNECT_HOST, CONNECT_PORT);
        //        } catch (final IOException ioe) {
        //            throw new FileTransferException("Error in connecting to" + CONNECT_HOST + ":" + CONNECT_PORT, ioe);
        //        }

        // Set
        log.info("Connected to FTP Server at {}:{}", CONNECT_HOST, CONNECT_PORT);
        this.setClient(client);

        // Login logic here

        // If there's a pwd defined, cd into it.
        final String pwd = this.getPresentWorkingDirectory();
        if (pwd != null) {
            this.cd(pwd);
        }
    }

    @Remove
    @Override
    public void endSession() {
        log.info("Session ending...");
    }

    public FTPClient getClient() {
        return client;
    }

    public void setClient(FTPClient client) {
        this.client = client;
    }

    public String getPresentWorkingDirectory() {
        return presentWorkingDirectory;
    }

    public void setPresentWorkingDirectory(String presentWorkingDirectory) {
        this.presentWorkingDirectory = presentWorkingDirectory;
    }

}
