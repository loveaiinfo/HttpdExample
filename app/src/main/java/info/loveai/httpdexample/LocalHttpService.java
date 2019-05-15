package info.loveai.httpdexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.IOException;

public class LocalHttpService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LocalHttpServer server = new LocalHttpServer(8080);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
