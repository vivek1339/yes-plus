package com.club.yes_plus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Member extends AppCompatActivity {
TextView gen_sec;
TextView sec;
TextView vivek;
TextView ihit;
TextView satish;
ImageView image_v;
ImageView sec_1;
ImageView sec_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        gen_sec = (TextView)findViewById(R.id.gen_sec);
        sec = (TextView)findViewById(R.id.sec);
        vivek =(TextView)findViewById(R.id.vivek);
        ihit = (TextView)findViewById(R.id.ihit);
        satish=(TextView)findViewById(R.id.satish);
        image_v = (ImageView)findViewById(R.id.image_v);
        sec_1 =(ImageView)findViewById(R.id.sec_1);
        sec_2=(ImageView)findViewById(R.id.sec_2);

    }
}
