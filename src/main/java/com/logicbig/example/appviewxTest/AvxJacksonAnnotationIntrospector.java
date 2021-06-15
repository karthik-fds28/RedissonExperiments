package com.logicbig.example.appviewxTest;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class AvxJacksonAnnotationIntrospector extends JacksonAnnotationIntrospector {


    private static final long serialVersionUID = -5417553163353917260L;

    @Override
    public PropertyName findNameForSerialization(Annotated a) {
        AvxProperty pann = _findAnnotation(a, AvxProperty.class);
        if (pann == null || AvxProperty.UseIn.IN_PERSISTENCE.equals(pann.useIn())) {
            return super.findNameForSerialization(a);
        } else {
            return PropertyName.construct(pann.value());
        }
    }

    @Override
    public PropertyName findNameForDeserialization(Annotated a) {
        AvxProperty pann = _findAnnotation(a, AvxProperty.class);
        if (pann == null || AvxProperty.UseIn.IN_PERSISTENCE.equals(pann.useIn())) {
            return super.findNameForDeserialization(a);
        } else {
            return PropertyName.construct(pann.value());
        }
    }

    @Override
    protected boolean _isIgnorable(Annotated a) {
        AvxFieldIgnore ann = _findAnnotation(a, AvxFieldIgnore.class);
        if (ann == null) {
            return super._isIgnorable(a);
        } else {
            return AvxFieldIgnore.Ignore.IN_ALL.equals(ann.ignore()) || AvxFieldIgnore.Ignore.IN_CONVERSION.equals(ann.ignore());
        }
    }

}
