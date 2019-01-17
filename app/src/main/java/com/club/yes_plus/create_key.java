package com.club.yes_plus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vivek on 17-01-2019.
 */

public class create_key extends AppCompatActivity {
    private Button generate;
    private EditText usn;
    private TextView key;
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_key);
        generate=findViewById(R.id.generate);
        usn=findViewById(R.id.usn);
        key=findViewById(R.id.key);

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S_usn=usn.getText().toString();
                String S_key=md5(S_usn);
                DatabaseReference db= FirebaseDatabase.getInstance().getReference().child("secret_keys");
                db.push().setValue(S_key);
                key.setText(S_key);
            }
        });
    }
    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
