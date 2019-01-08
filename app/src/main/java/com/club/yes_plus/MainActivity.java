package com.club.yes_plus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Events;
    Button Members;
    Button About_Us;
    Button Kriya;
    Button News_Feed;
    Button project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        About_Us=(Button)findViewById(R.id.About_Us);
        Kriya= (Button)findViewById(R.id.Kriya);
        News_Feed=(Button)findViewById(R.id.News_Feed);
        project=(Button)findViewById(R.id.project) ;
        Members=(Button)findViewById(R.id.Members);
        Members.setOnClickListener(new View.OnClickListener() {
@Override
            public void onClick(View v) {
                Intent memb = new Intent(MainActivity.this,Member.class);
                startActivity(memb);

            }



        });
About_Us.setOnClickListener(    new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent about = new Intent(MainActivity.this,about_us.class);
        startActivity(about);
    }
});
    }
}
