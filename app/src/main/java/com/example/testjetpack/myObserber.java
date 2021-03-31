package com.example.testjetpack;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class myObserber implements LifecycleObserver {
    private static final String TAG = "myObserber";
    public myObserber(){

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void avtStrart(){
        Log.d(TAG, "avtStrart: ");
    }
@OnLifecycleEvent(Lifecycle.Event.ON_STOP)
   public  void avtStop(){
        Log.d(TAG,"stop");
   }
}
