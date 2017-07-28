## TinyDroidHttpd

*TinyDroidHttpd* is a very light-weight server based [NanoHttpd](https://github.com/NanoHttpd/nanohttpd) and used for Android. More about NanoHttpd to see [THIS](ABOUT.md) and [THIS](https://github.com/NanoHttpd/nanohttpd).

## HOW to use it on Android Studio

### 1. Add a new module or just create a individual package for the *TinyDroidHttpd*, and then copy all codes there. According to  your need, you can add more MIME types in *mimetypes.properties* file under the *tynyhttpd/assets* folder.

### 2. *TinyDroidHttpd* needs to be initialized. You should only do this ONE time, so placing the initialization in your Application is a good idea. An example for this would be:

```java
[MyApplication.java]
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SimpleWebServer.init(this, BuildConfig.DEBUG);
    }
}
```

*NOTE:* Remember to also declare you Application class in the ```AndroidManifest.xml``` as well as add the required permissions. In most cases you will need the INTERNET permission.

```xml
  <manifest
    ...
    >
    <uses-permission android:name="android.permission.INTERNET" />
    <application
      ...
      android:label="@string/app_name"
      android:name=".MyApplication"
      >
      ...
    </application>
    ...
  </manifest>
```

### 3. You can invoke `SimpleWebServer.runServer(String[])` method to start the server. It need a string array as parameter. By the parameter, you can set hostname, port and web workspace directory for the server as normal. It likes as following:

```
-h|--hostname NAME -p|--port PORT -d|--dir DIRECTORY
```
*NOTE:* Server works on the same thread as started it, so you must not start it on your UI thread.
