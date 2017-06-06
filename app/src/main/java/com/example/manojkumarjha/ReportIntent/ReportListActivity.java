package com.example.manojkumarjha.ReportIntent;

import android.support.v4.app.Fragment;

/**
 * Created by MANOJ KUMAR JHA on 26-Jan-17.
 */

public class ReportListActivity extends  SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new ReportListFragment();

    }
}
