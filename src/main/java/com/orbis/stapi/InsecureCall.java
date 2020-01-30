package com.orbis.stapi;

import java.lang.annotation.*;

/**
 * User: Daniil Sosonkin
 * Date: 9/5/2018 10:57 AM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InsecureCall
    {
    }
