package com.example.shiyuankeji.interfaces.contract;

import com.example.shiyuankeji.bean.CashBean;
import com.example.shiyuankeji.bean.CostBean;
import com.example.shiyuankeji.bean.QueryIntegralBean;
import com.example.shiyuankeji.bean.QueryLastWeekStockBean;
import com.example.shiyuankeji.bean.QueryMinuteStockBean;
import com.example.shiyuankeji.bean.QueryStockBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.IBaseView;

public interface IntegralDetailsContract {
    interface View extends IBaseView {
        void queryIntegralRrean(QueryIntegralBean queryIntegralBean);

        void queryStockRrean(QueryStockBean queryStockBean);

        void queryMinuteStockRrean(QueryMinuteStockBean queryMinuteStockBean);

        void queryLastWeekStockRrean(QueryLastWeekStockBean queryLastWeekStockBean);
        void  cashRean(CashBean cashBean);
//        提现说明
        void  costRean(CostBean costBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void queryIntegrals();

        void queryStocks();

        void queryMinuteStocks();

        void queryLastWeekStocks();
        void   cashs(int score);
        //        提现说明
        void  costs();
    }
}
