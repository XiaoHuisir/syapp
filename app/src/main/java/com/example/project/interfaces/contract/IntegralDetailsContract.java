package com.example.project.interfaces.contract;

import com.example.project.bean.QueryIntegralBean;
import com.example.project.bean.QueryLastWeekStockBean;
import com.example.project.bean.QueryMinuteStockBean;
import com.example.project.bean.QueryStockBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

public interface IntegralDetailsContract {
    interface View extends IBaseView {
        void queryIntegralRrean(QueryIntegralBean queryIntegralBean);

        void queryStockRrean(QueryStockBean queryStockBean);

        void queryMinuteStockRrean(QueryMinuteStockBean queryMinuteStockBean);

        void queryLastWeekStockRrean(QueryLastWeekStockBean queryLastWeekStockBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void queryIntegrals();

        void queryStocks();

        void queryMinuteStocks();

        void queryLastWeekStocks();
    }
}
