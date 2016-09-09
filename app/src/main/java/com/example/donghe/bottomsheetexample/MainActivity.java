package com.example.donghe.bottomsheetexample;

import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn)
    Button btnOnclick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                initView();
                sheetDialog();
            }
        });


    }

    private void initView() {
        BottomSheetBehavior behavior = BottomSheetBehavior.from(findViewById(R.id.scoll));
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    private void sheetDialog() {
        BottomSheetAdapter adapter = new BottomSheetAdapter(this);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.recycler, null);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
        recyclerView.setLayoutParams(params);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        final MyBottomSheetDialog dialog = new MyBottomSheetDialog(this, this);
        dialog.setContentView(recyclerView);
        dialog.show();
    }
}
