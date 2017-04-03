/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.utils;

/**
 *
 * @author mridwan
 */
public class Util {
    public static boolean isNotNull(Object o) throws NullPointerException{
        if (o != null) {
            return true;
        }else{
            throw new NullPointerException();
        }        
    }
}
