package io.github.dkbai.tinydroidhttpd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.dkbai.tinyhttpd.nanohttpd.webserver.SimpleWebServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGO(View view) {
        SimpleWebServer.init(getApplicationContext(), true);
    }
}
