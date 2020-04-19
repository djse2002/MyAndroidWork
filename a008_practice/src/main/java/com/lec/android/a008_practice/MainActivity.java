package com.lec.android.a008_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    Useradapter adapter;
    RecyclerView rv;
    EditText etName, etAge, etAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAdd = findViewById(R.id.etAddr);
        rv = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);

        adapter = new Useradapter();

        rv.setAdapter(adapter);

        Button btnadd = findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              adapter.addItem(new User(etName.getText().toString(),etAge.getText().toString(), etAdd.getText().toString()));
              adapter.notifyDataSetChanged();

            }
        });

     }//end onCreate()

    // 액티비티가 사용자게엑 보여지기 시작할때 (바로직전)에 호출
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myapp", "onStart");
    }

    // 액티비티가 동작, 즉 사용자와의 상호작용 (포커스를 갖기 시작) 할때 호출
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myapp", "onResume");
    }

    // 다른 액티비티가 보여질때 (혹은 다른 액티비티에 의해 가려지기 시작할때) 호출
    // 액티비티를 통해 다루고 있던 데이터 저장, 쓰레드 중지.. 등의 처리를 해야 함.
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myapp", "onPause");
    }

    // 액티비티가 더이상 안보여질때 호출되는 메소드
    // 메모리 상황에 따라 호출안될수도 있슴.
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myapp", "onStop");
    }

    // 액티비티 소멸될때 호출
    // 액티비티 소멸은
    //   시스템에 의해서 소멸되기도 하고
    //   코드를 통해 제거되기도 함 : ex: finish()
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myapp", "onDestroy");
    }

    // onStop -> onStart 전환될때 호출
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myapp", "onRestart");
    }

    // 직전에 저장되어 있던 액티비티의 상태정보가 있다면,
    // onRestoreInstanceState() 는 onStart 직후에 호출됨.
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("myapp", "onRestoreInstanceState");

        if(savedInstanceState != null) rv = savedInstanceState.getParcelable("value");
    }

    // 액티비티 소멸 전에 호출된다. (주의! onPause 뒤에 호출된다고 간주하지 말것!)
    // outState :<-- 액티비티 정보 저장(백업)하여 나중에 onCreate 에서 사용 가능.
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
       outState.putString("value", rv.getLayoutManager().toString());

    }



}// end Activity