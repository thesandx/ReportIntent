package com.example.manojkumarjha.ReportIntent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by MANOJ KUMAR JHA on 24-Jan-17.
 */

public class Report {
    //in this class we have 2 variable,1 constructor,2 get method and a set method
    //uuid is used to assign unique id to different reports.
    private UUID mId;
    private String mTitle;
    public Date mDate;
    private boolean mResolved;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }



    public boolean isResolved() {
        return mResolved;
    }

    public void setResolved(boolean mResolved) {
        this.mResolved = mResolved;
    }


//this is a constructer which is used to assign value to the variable declared above
    public Report(){
        mId=UUID.randomUUID();
        mDate=new Date();
    }
//here get method return you the value of variable
    public  UUID getId(){
        return mId;
    }
    public  String getTitle(){
        return  mTitle;
    }
    //by setter it is similar
    public void setTitle(String title){
        mTitle=title;
    }
}
