import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class signin1 extends AppCompatActivity {

    String name, pass, full_name, full_pass;
    EditText user, passw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin1);
        Button button = findViewById(R.id.sign_in);
        user = findViewById(R.id.user);
        passw = findViewById(R.id.pass);

        Intent is = new Intent(this, home.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(signin1.this, "Signing you in...", Toast.LENGTH_LONG).show();
                DataBase data = new DataBase(signin1.this);
                List<Model> credentials = data.get_cred();
                full_name = user.getText().toString();
                full_pass = passw.getText().toString();
                for(int i=0; i<credentials.size();i++){
                    name = credentials.get(i).username;
                    pass = credentials.get(i).pass;

                    if(Objects.equals(full_name, name) && Objects.equals(full_pass, pass)){
                        startActivity(is);
                        Toast.makeText(signin1.this, "Success", Toast.LENGTH_LONG).show();
                        break;
                    }
                    else{
                        Toast.makeText(signin1.this, "Wrong credentials!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Intent i = new Intent(this, MainActivity.class);
        TextView sign_in_text = findViewById(R.id.sign_inText);
        String in_text = "Not yet registered? SignUp Now";
        SpannableString ss = new SpannableString(in_text);
        ClickableSpan click1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(signin1.this,"Sign-up here", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
            @Override
            public void updateDrawState(TextPaint ns){
                super.updateDrawState(ns);
                ns.setColor(Color.BLUE);
                ns.setUnderlineText(false);
            }
        };
        ss.setSpan(click1, 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sign_in_text.setText(ss);
        sign_in_text.setMovementMethod(LinkMovementMethod.getInstance());


    }
}