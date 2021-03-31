package com.example.testjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
myViewModel viewModel;
TextView textView;
MyObserver myObserver;
MutableLiveData<Integer> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myObserver=new MyObserver();
        myObserber myActivityObserver = new myObserber();
        //观察者和被观察者绑定
        getLifecycle().addObserver(myActivityObserver);
        Log.d("main", "onCreate: "+ getLifecycle().getCurrentState());
        SharedPreferences shar=getSharedPreferences("data",MODE_PRIVATE);
        int a=shar.getInt("count",55);
         viewModel= new ViewModelProvider(this,new VmFactory(100)).get(myViewModel.class);
        Button btn=(Button)findViewById(R.id.btn);
        textView=(TextView)findViewById(R.id.text);
        btn.setOnClickListener(MainActivity.this);

        textView.setText(viewModel.a.getValue()+"");

       viewModel.a.observe(this, new Observer<Integer>() {
             @Override
             public void onChanged(Integer integer) {
                 textView.setText(integer+"");
             }
         });


    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn:

              viewModel.a.setValue(viewModel.a.getValue()+1);
                //每次更改数据还要重新set一次
                //而如果用livedata,则不需要每次set,只需要set一次就可。

                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putInt("count",viewModel.a.getValue());
                editor.apply();
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("main", "onCreate: "+ getLifecycle().getCurrentState());
        myObserver.acttivityStart();
    }

    public void onStop(){
        super.onStop();
        myObserver.actrivityStop();
    }

}