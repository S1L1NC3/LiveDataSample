package com.dmd.LiveDataSample.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {
    private MutableLiveData<String> nameData = new MutableLiveData<>();

    public LiveData<String> getName() {
        return nameData;
    }

    public void setName(String name) {
        Log.i("TAGATUGA", "setName: valueChange");
        nameData.setValue(name);
    }
}