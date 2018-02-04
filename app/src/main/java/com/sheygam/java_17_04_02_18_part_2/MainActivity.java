package com.sheygam.java_17_04_02_18_part_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements IMainView, View.OnClickListener {

    @InjectPresenter
    MainPresenter presenter;

    private ProgressBar myProgress;
    private Button startBtn;
    private TextView resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myProgress = findViewById(R.id.myProgress);
        startBtn = findViewById(R.id.startBtn);
        resultTxt = findViewById(R.id.resultTxt);
        startBtn.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        myProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        myProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateResult(String result) {
        resultTxt.setText(result);
    }

    @Override
    public void enableStartBtn(boolean isEnable) {
        startBtn.setEnabled(isEnable);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.startBtn){
            presenter.onStartClicked();
        }
    }
}
