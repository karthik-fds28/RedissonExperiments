package com.logicbig.example.dto;

public class FormatCheck {

    private long GLOBAL_SESSION_TIMEOUT;
    private String NAME;

    public long getGLOBAL_SESSION_TIMEOUT() {
        return GLOBAL_SESSION_TIMEOUT;
    }

    public void setGLOBAL_SESSION_TIMEOUT(long GLOBAL_SESSION_TIMEOUT) {
        this.GLOBAL_SESSION_TIMEOUT = GLOBAL_SESSION_TIMEOUT;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "FormatCheck{" +
                "GLOBAL_SESSION_TIMEOUT=" + GLOBAL_SESSION_TIMEOUT +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
