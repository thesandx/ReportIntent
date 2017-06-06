package com.example.manojkumarjha.ReportIntent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by MANOJ KUMAR JHA on 24-Jan-17.
 */

public class ReportFragment extends Fragment {
    private  static  final String ARG_REPORT_ID="report_id";
    //making object of reoet class
    private Report mReport;
    private EditText mTitleField;
    //below is the way to link the button layout to code
    private Button mDateButton;
    private CheckBox mResolvedCheckBox;

    public  static ReportFragment newInstance(UUID reportId){
        Bundle args =new Bundle();
        args.putSerializable(ARG_REPORT_ID,reportId);

        ReportFragment fragment=new ReportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //below is similar to Report mreport=new Report() i.e making the object of Report class
        UUID reportId=(UUID)getArguments().getSerializable(ARG_REPORT_ID);
        mReport=ReportStore.get(getActivity()).getReport(reportId);
    }
    //pg no. 4 code as usual used for fragment to connect it with layout
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
{
    View v= inflater.inflate(R.layout.fragment_report,container,false);
    mTitleField=(EditText) v.findViewById(R.id.report_title);
    mTitleField.setText(mReport.getTitle());
    mTitleField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        mReport.setTitle(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
//link to layout
    mDateButton=(Button) v.findViewById(R.id.report_date);
    //the text on button will be the date of your phone at that time
    mDateButton.setText(mReport.getDate().toString());
    //it will not clickable ie activated
    mDateButton.setEnabled(false);

    mResolvedCheckBox=(CheckBox) v.findViewById(R.id.report_resolved);
    mResolvedCheckBox.setChecked(mReport.isResolved());

    mResolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mReport.setResolved(isChecked);
        }
    });


    return  v;
}
}
