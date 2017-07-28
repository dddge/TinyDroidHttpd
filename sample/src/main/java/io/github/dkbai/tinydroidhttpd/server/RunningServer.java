package io.github.dkbai.tinydroidhttpd.server;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import io.github.dkbai.tinyhttpd.nanohttpd.webserver.SimpleWebServer;

/**
 * @author X
 * @version 0.1
 */

public class RunningServer extends IntentService {

    public RunningServer() {
        this("Running Server");
    }

    public RunningServer(String name) {
        super(name);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        SimpleWebServer.stopServer();
        super.onStart(intent, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        ArrayList<String> options = new ArrayList<>();
        options.add("-h");
        options.add("127.0.0.1");
        options.add("-d");
        options.add(getCacheDir().getAbsolutePath());

        SimpleWebServer.runServer(options.toArray(new String[options.size()]));
    }
    
}
