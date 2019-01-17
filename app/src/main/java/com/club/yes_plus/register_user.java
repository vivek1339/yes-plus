package com.club.yes_plus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by vivek on 16-01-2019.
 */

public class register_user extends AppCompatActivity{
    Button submit;
    EditText secret_key;
    private DatabaseReference mDatabase,db1;
    FirebaseUser user;
    String s_key,s_map;

    boolean exists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        submit=findViewById(R.id.reg);
        secret_key=findViewById(R.id.secret_key);
        final FirebaseAuth mauth=FirebaseAuth.getInstance();
        user=mauth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        db1 = mDatabase.child("secret_keys");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exists = false;
                s_key=secret_key.getText().toString();
                Log.e("s_key=", s_key);
                db1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot: dataSnapshot.getChildren())
                        {
                               String value=postSnapshot.getValue(String.class);
                               String key=postSnapshot.getKey();
                               if(value.equals(s_key)) {
                                   s_map = key;
                                   exists = true;

                                   Log.e("value=", value);

                                   Log.e("s_map=", s_map);
                                   createuser(s_key, s_map);
                                   return;
                               }
                        }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(register_user.this, "key doesn't exist", Toast.LENGTH_LONG).show();
                }
            });

    }
    void createuser(String secret_key,String s_map)
    {
        Log.e(user.getDisplayName(),s_map);
        DatabaseReference db=mDatabase.child("Users").child(user.getDisplayName());
        String username=user.getDisplayName();
        user_reg u1=new user_reg(username,secret_key);
        db.setValue(u1);
        db1.child(s_map).removeValue();
        Toast.makeText(register_user.this, "Welcome to the YES!+ App", Toast.LENGTH_LONG).show();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
