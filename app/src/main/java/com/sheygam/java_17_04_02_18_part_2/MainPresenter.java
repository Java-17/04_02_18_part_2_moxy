package com.sheygam.java_17_04_02_18_part_2;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


/**
 * Created by gregorysheygam on 04/02/2018.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<IMainView> implements IMainPresenter{
    @SuppressLint("StaticFieldLeak")
    @Override
    public void onStartClicked() {
        new AsyncTask<Void,String,Void>(){

            @Override
            protected void onPreExecute() {
                getViewState().showProgress();
                getViewState().enableStartBtn(false);
            }

            @Override
            protected void onProgressUpdate(String... values) {
                getViewState().updateResult(values[0]);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                for (int i = 0; i < 10; i++) {
                    publishProgress(String.valueOf(i));
                    Log.d("My_TAG", "doInBackground: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().hideProgress();
                getViewState().enableStartBtn(true);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
