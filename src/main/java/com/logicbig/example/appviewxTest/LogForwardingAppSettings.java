package com.logicbig.example.appviewxTest;

public class LogForwardingAppSettings extends AppSettings {

    private long lastModifiedTime;

    private long retryIntervalTime;

    private boolean retryEnabled;

    private String logFormat;

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public long getRetryIntervalTime() {
        return retryIntervalTime;
    }

    public void setRetryIntervalTime(long retryIntervalTime) {
        this.retryIntervalTime = retryIntervalTime;
    }

    public boolean isRetryEnabled() {
        return retryEnabled;
    }

    public void setRetryEnabled(boolean retryEnabled) {
        this.retryEnabled = retryEnabled;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }


}
