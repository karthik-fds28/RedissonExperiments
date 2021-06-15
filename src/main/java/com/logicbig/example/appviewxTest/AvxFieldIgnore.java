package com.logicbig.example.appviewxTest;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AvxFieldIgnore {


    /**
     * Optional property that allows flexibility to ignore a field only during
     * persistence.
     *
     */

    Ignore ignore() default Ignore.IN_ALL;

    public enum Ignore {

        /**
         * Field will be ignored by both Mongo and Jackson
         */
        IN_ALL,

        /**
         * Field will be ignored by Mongo
         */
        IN_PERSISTENCE,

        /**
         * Field will be ignored by Jackson
         */
        IN_CONVERSION
    }


}
