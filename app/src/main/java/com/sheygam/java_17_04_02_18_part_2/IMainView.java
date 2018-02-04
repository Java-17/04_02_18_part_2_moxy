package com.sheygam.java_17_04_02_18_part_2;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by gregorysheygam on 04/02/2018.
 */
@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface IMainView extends MvpView{
    void showProgress();
    void hideProgress();
    void updateResult(String result);
    void enableStartBtn(boolean isEnable);
}
