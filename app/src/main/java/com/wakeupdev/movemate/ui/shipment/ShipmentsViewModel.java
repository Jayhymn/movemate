package com.wakeupdev.movemate.ui.shipment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShipmentsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ShipmentsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}