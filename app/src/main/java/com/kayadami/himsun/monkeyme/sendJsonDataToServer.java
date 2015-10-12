package com.kayadami.himsun.monkeyme;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by himsun on 2015. 10. 12..
 */
public class sendJsonDataToServer {

    static public String sendJsonDataToServer(String JsonMsg, String ServerURL)
    {

        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        HttpURLConnection conn = null;

        try
        {
            URL url = new URL(ServerURL);
            conn=(HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(1000*5);
            conn.setReadTimeout(1000*5);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Cache-Control","no-cache");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            os=conn.getOutputStream();
            os.write(JsonMsg.getBytes());

            os.flush();


        }
        catch(MalformedURLException e)
        {
            ;
        }
        catch (IOException e) {
            ;
        }
        catch (Exception e)
        {
            ;
        }

        return null;
    }
}
