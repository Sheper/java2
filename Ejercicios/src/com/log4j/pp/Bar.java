package com.log4j.pp;

import org.apache.log4j.Logger;

public class Bar {
    static Logger logger = Logger.getLogger(Bar.class);
    public void doIt() {
       logger.debug("Dentro de Bar!");
    }
}