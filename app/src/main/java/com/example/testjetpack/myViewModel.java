package com.example.testjetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class myViewModel extends ViewModel {
    MutableLiveData<Integer> a=new MutableLiveData<>();

    int b;
MutableLiveData<Integer> getA(){
    if (a==null) {
        a = new MutableLiveData<>();
    a.setValue(b);
    }
        return a;
}



    public myViewModel(int b){
a.setValue(0);
this.b=b;
    }

}
