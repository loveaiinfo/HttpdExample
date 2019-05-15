package info.loveai.httpdexample;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

public class LocalHttpServer extends NanoHTTPD {

    public static final String TAG = "LocalHttpServer";
    @Override
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        Log.d(TAG,"method:" + method.toString());

        String params = session.getQueryParameterString();

        Log.d(TAG,"params:" + params);

        if (Method.GET.equals(method)){

        }else if (Method.POST.equals(method)){

        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String,String> colors = new HashMap<>();
        colors.put("blue","0x0000FF");
        colors.put("read","0xFF0000");
        colors.put("green","0x00FF00");
        String json = gson.toJson(colors);


        Response response = newFixedLengthResponse(json);
        response.setMimeType("application/json");
        return response;
    }

    public LocalHttpServer(int port){
        super(port);
    }
}
