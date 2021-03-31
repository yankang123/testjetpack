package com.example.testjetpack;

import android.util.Log;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MyObserver {
    protected  void acttivityStart(){
        Log.d("dd", "acttivityStart: ");
    };
    protected  void actrivityStop(){
        Log.d("dd", "acttivistoppppp: ");
    }
}
