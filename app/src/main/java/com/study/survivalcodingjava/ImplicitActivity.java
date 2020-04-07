package com.study.survivalcodingjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPhoneEditText;
    private EditText mUrlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mPhoneEditText = (EditText) findViewById(R.id.edt_phone);
        mUrlEditText = (EditText) findViewById(R.id.edt_url);

        findViewById(R.id.btn_phone).setOnClickListener(this);
        findViewById(R.id.btn_url).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_phone:
                String phoneNumber = mPhoneEditText.getText().toString();
                dialTel(phoneNumber);
                break;
            case R.id.btn_url:
                String url = mUrlEditText.getText().toString();
                showUrl(url);
                break;
        }
    }

    private void showUrl(String url) {
        if (!url.startsWith("http://")) {
            url = "http://" + url;
        }
        Uri webpage = Uri.parse("http://" + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        intent.setData(Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "수행할 앱이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private void dialTel(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "수행할 앱이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
