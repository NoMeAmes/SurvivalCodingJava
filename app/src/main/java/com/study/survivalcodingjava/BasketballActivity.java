package com.study.survivalcodingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BasketballActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        if (getIntent() != null) {
            Uri data = this.getIntent().getData();
            Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickButton(View view) {

    }
}
