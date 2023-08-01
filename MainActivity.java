package com.example.new_one;

import static android.view.animation.AnimationUtils.loadAnimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DatabaseReference reference;
    EditText username,password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.sign_up);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        Intent intent = new Intent(this, home.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model;
                try {
                    model = new Model(username.getText().toString(), password.getText().toString(),
                            email.getText().toString());
                    Toast.makeText(MainActivity.this, model.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error Creating DB",Toast.LENGTH_SHORT).show();
                    model = new Model("Error","Error","Error");
                }
                DataBase helper = new DataBase(MainActivity.this);
                boolean success = helper.addOne(model);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Intent i = new Intent(this, signin1.class);
        TextView signup_text = findViewById(R.id.signupText);
        String up_text = "Already a user? Sign in now";
        SpannableString ss = new SpannableString(up_text);
        ClickableSpan click1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(MainActivity.this,"Login here", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
            @Override
            public void updateDrawState(TextPaint ns){
                super.updateDrawState(ns);
                ns.setColor(Color.BLUE);
                ns.setUnderlineText(false);
            }
        };
        ss.setSpan(click1, 16, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signup_text.setText(ss);
        signup_text.setMovementMethod(LinkMovementMethod.getInstance());

        DataBase DataBaseHelper = new DataBase(MainActivity.this);

    }
}
