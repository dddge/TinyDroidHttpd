package io.github.dkbai.tinydroidhttpd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.github.dkbai.tinydroidhttpd.server.RunningServer;
import io.github.dkbai.tinyhttpd.nanohttpd.webserver.SimpleWebServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleWebServer.init(this, BuildConfig.DEBUG);
    }

    public void startGO(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                startService(new Intent(this, RunningServer.class));
                break;
            case R.id.tv_stop:
                SimpleWebServer.stopServer();
                break;
        }


    }
}
