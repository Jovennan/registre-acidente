package br.edu.unipe.pos.mobile.registreacidente.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.unipe.pos.mobile.registreacidente.MainActivity;
import br.edu.unipe.pos.mobile.registreacidente.R;

public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, 1000);
    }

    @Override
    public void run() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
