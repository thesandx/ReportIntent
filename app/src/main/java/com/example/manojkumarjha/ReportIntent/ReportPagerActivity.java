package com.example.manojkumarjha.ReportIntent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
//the diff b/w the up and down is described in the last of the lecture of viewpager
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by MANOJ KUMAR JHA on 19-Mar-17.
 */

public class ReportPagerActivity extends AppCompatActivity {

    private static final String EXTRA_REPORT_ID="com.example.manojkumarjha.ReportIntent.report_id";

    private ViewPager mViewPager;
    private List<Report> mReports;

    public static Intent newIntent(Context packageContext, UUID reportId){
        Intent intent =new Intent(packageContext,ReportPagerActivity.class);
        intent.putExtra(EXTRA_REPORT_ID,reportId);
        return intent;
    }


    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_pager);

        UUID reportId=(UUID) getIntent()
                .getSerializableExtra(EXTRA_REPORT_ID);

        mViewPager=(ViewPager) findViewById(R.id.activity_report_pager_view_pager);
        mReports=ReportStore.get(this).getReports();

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Report report = mReports.get(position);
                 /** below return statement connect this viewpageractivity to host ReportFragment*/
                return ReportFragment.newInstance(report.getId());
            }

            @Override
            public int getCount() {
                return mReports.size();
            }
        });

        for(int i=0;i<mReports.size();i++){
            if (mReports.get(i).getId().equals(reportId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
