package com.barrault.projet;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetWorldCupServices extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    private static final String ACTION_get_world_cup_info = "com.example.charl.worldcup.action.get_world_cup_info";

    public GetWorldCupServices() {
        super("GetBiersServices");
    }


    // TODO: Customize helper method
    public static void startActionWorldCup(Context context) {
        Intent intent = new Intent(context, GetWorldCupServices.class);
        intent.setAction(ACTION_get_world_cup_info);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_get_world_cup_info.equals(action)) {
                handleActionget_all_biers();
            }
        }
    }

    /**
     * Handle action get_all_biers in the provided background thread with the provided
     * parameters.
     */
    private void handleActionget_all_biers() {
        Log.i("debug","handling action");
        URL url;
        try {
            url=new URL("https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/data.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(),"worldcup.json"));
                Log.d("tag","World Cup's info downloaded");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(Equipes.WORLD_CUP_UPDATE));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyInputStreamToFile(InputStream in, File file){
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
