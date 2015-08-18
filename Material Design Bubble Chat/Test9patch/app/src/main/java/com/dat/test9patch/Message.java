package com.dat.test9patch;

/**
 * Created by DAT on 8/12/2015.
 */
public class Message {
    public static final boolean isFromMe = true;
    private boolean isFrom;
    private String content;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFrom() {
        return isFrom;
    }

    public void setFrom(boolean isFrom) {
        this.isFrom = isFrom;
    }
}
