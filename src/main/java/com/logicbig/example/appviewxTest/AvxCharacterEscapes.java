package com.logicbig.example.appviewxTest;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.google.common.html.HtmlEscapers;

public class AvxCharacterEscapes  extends CharacterEscapes {


    private static final long serialVersionUID = 7226095932998153519L;

    private final int[] asciiEscapes;

    public AvxCharacterEscapes() {
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['&'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['"'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        return new SerializedString(HtmlEscapers.htmlEscaper().escape(Character.toString((char) ch)));
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }



}
