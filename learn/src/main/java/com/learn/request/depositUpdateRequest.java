package com.learn.request;

public class depositUpdateRequest {
    private int seq;
    private int type;

    public depositUpdateRequest(int seq, int type) {
        this.seq = seq;
        this.type = type;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
