package com.example.padtm3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.padtm3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab2 = findViewById(R.id.fab2);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja, REQUEST_IMAGE_CAPTURE);
            }
        });

    }

    public void kliknij(View view) {
        Toast.makeText(getApplicationContext(), "Kliknięto przycisk Button", Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    public void kliknij2(View view) {
        Random randomobj = new Random();
        ImageView myImageView = (ImageView) findViewById(R.id.fab2);
        int randy = randomobj.nextInt(5);

        switch (randy) {
            case 0: {
                myImageView.setImageResource(android.R.drawable.ic_menu_call);
                break;
            }
            case 1: {
                myImageView.setImageResource(R.drawable.ic_launcher_background);
                break;
            }
            case 2: {
                myImageView.setImageResource(android.R.drawable.ic_menu_help);
                break;
            }
            case 3: {
                myImageView.setImageResource(R.drawable.ic_launcher_foreground);
                break;
            }
            case 4: {
                myImageView.setImageResource(android.R.drawable.ic_menu_delete);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.action_settings: {
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_preferences: {
                Toast.makeText(getApplicationContext(), "Preferences", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_statistics: {
                Toast.makeText(getApplicationContext(), "Statistics", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_logout: {
                Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_exit: {
                Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

}