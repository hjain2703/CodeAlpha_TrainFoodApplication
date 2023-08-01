package com.example.new_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class home extends AppCompatActivity {
    public static final String idly_s = "method_id";
    public static int idly = 1,dosa = 2,poori = 3,paratha = 4,chick = 5,mutt = 6,
            smeals = 7,nmeals = 8,pulav = 9,mlassi = 10,lime = 11,orange = 12,choco = 13;
    ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cart = findViewById(R.id.carticon);
    }
    public void cartpage(View view){
        Intent i = new Intent(this, Cart.class);
        startActivity(i);
    }
    public void idly(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,idly);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("idly","50.0").apply();
        startActivity(i);
    }
    public void d_add(View view){

        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,dosa);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("dosa","70.0").apply();
        startActivity(i);


    }
    public void poori(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,poori);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("poori","50.0").apply();
        startActivity(i);
    }
    public void paratha(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,paratha);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("paratha","60.0").apply();
        startActivity(i);
    }
    public void chick(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,chick);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("chick","150.0").apply();
        startActivity(i);
    }
    public void mutt(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,mutt);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("mutt","180.0").apply();
        startActivity(i);
    }
    public void smeals(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,smeals);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("smeals","80.0").apply();
        startActivity(i);
    }
    public void nmeals(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,nmeals);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("nmeals","90.0").apply();
        startActivity(i);
    }
    public void pulav(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,pulav);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("pulav","80.0").apply();
        startActivity(i);
    }
    public void mlassi(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,mlassi);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("mlassi","50.0").apply();
        startActivity(i);
    }
    public void lime(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,lime);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("lime","30.0").apply();
        startActivity(i);
    }
    public void orange(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,orange);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("orange","40.0").apply();
        startActivity(i);
    }
    public void choco(View view){
        Intent i = new Intent(this, Cart.class);
        i.putExtra(idly_s,choco);
        getSharedPreferences("cart", Context.MODE_PRIVATE).edit().putString("choco","50.0").apply();
        startActivity(i);
    }
}
