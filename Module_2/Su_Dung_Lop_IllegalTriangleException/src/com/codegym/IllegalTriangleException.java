package com.codegym;

import java.util.logging.*;
import java.io.*;

class IllegalTriangleException extends Exception{
    private static Logger logger = Logger.getLogger("IllegalTriangleException");


    public IllegalTriangleException(){}
    public IllegalTriangleException(String msg) {
        super(msg);
        StringWriter trace = new StringWriter();
        this.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}