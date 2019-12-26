package com.example.readshare.Model;

import com.orm.SugarRecord;

public class NoteId extends SugarRecord {

    long userId;
    // Default constructor is important!
    public NoteId() {
    }



    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
