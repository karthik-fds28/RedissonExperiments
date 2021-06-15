package com.logicbig.example.appviewxTest;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;

public abstract class BeanType<T> {


    private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {

        /**
         *
         */
        private static final long serialVersionUID = 5506207882440178804L;
    };

    private final Type type = typeToken.getType(); // or getRawType() to return Class<? super T>

    public Type getType() {
        return type;
    }

    public Class<? super T> getRawType() {
        return typeToken.getRawType();
    }
}
