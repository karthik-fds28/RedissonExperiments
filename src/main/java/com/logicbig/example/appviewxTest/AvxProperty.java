package com.logicbig.example.appviewxTest;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface AvxProperty {


    public static final String USE_DEFAULT_NAME = "";

    /**
     * Defines name of the logical property, i.e. JSON/DB object field name to
     * use for the property.
     */
    String value() default AvxProperty.USE_DEFAULT_NAME;

    /**
     * Optional property that allows flexibility to ignore a field only during
     * persistence.
     */

    UseIn useIn() default UseIn.IN_ALL;

    public enum UseIn {

        /**
         * Name will be used by both Mongo and Jackson
         */
        IN_ALL,

        /**
         * Name will be used by Mongo
         */
        IN_PERSISTENCE,

        /**
         * Name will be used by Jackson
         */
        IN_CONVERSION
    }


}
