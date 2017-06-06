package com.example.manojkumarjha.ReportIntent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by MANOJ KUMAR JHA on 26-Jan-17.
 */

public class ReportStore {
    //below is half of making object and rest half is below
    private static ReportStore sReportStore;
    private List<Report> mReports;

    /**below is a constructor which uses single term pattern concept in which only one value at a
     * time can be given.
     * so by using if we check if value is not assinged already then we will assign it the value
     **/
//below is the single turn pattern and in this at a time only one object can be made
    public static ReportStore get(Context context){
        //it will check a object is already present or not
        if (sReportStore==null){
            //rest half is here
            sReportStore=new ReportStore(context);
        }
        return sReportStore;
    }
    //a set of 100 list in which half is resolved
 private ReportStore(Context context){
     mReports=new ArrayList<>();
    /** for (int i=0;i<100;i++){
         Report report = new Report();
         report.setTitle("Crime #"+i);
         report.setResolved(i%2==0);
         mReports.add(report);
     }**/

 }
    public void addReport(Report r){
        mReports.add(r);
    }

    public List<Report> getReports(){
        return  mReports;
    }
//we are targetting on a specific id at a time
    public Report getReport(UUID id){
        for(Report report : mReports){
            if (report.getId().equals(id)){
                return report;
            }
        }
        return null;
    }

}
