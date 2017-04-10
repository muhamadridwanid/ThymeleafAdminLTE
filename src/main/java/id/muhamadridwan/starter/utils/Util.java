/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.utils;

import id.muhamadridwan.starter.exceptions.IllegalInputException;

/**
 *
 * @author mridwan
 */
public class Util {
    public static boolean isNotNull(Object o) throws IllegalInputException{
        if (o != null) {
            return true;
        }else{
            throw new IllegalInputException("Invalid input");
        }        
    }
}
