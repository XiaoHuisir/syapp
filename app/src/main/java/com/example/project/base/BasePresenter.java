package com.example.project.base;




import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BasePresenter<D extends IBaseView> implements IBasePresenter<D> {
    protected D mView;

    protected WeakReference<D> mWeakReference;

    protected CompositeDisposable mCompositeDisposable;
    @Override
    public void attchView(D view) {
        mWeakReference = new WeakReference<D>(view);
        mView = mWeakReference.get();
    }

    @Override
    public void detachView() {
        mView = null;
        unSubscribe();
    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable disposable){
        if(mCompositeDisposable == null) mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(disposable);
    }

}
