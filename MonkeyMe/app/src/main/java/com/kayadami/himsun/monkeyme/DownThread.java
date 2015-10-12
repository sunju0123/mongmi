package com.kayadami.himsun.monkeyme;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by himsun on 2015. 10. 9..
 */
public class DownThread extends Thread{
    String mAddr;
    String mResult;

    List<String> data;// 모델

    public DownThread(String addr)
    {
        mAddr = addr;
        mResult="";
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            //(MainActivity.this).setProgressBarIndeterminateVisibility(false);
            // 데이터가 갱신되었으니 리스트뷰를 다시 출력하도록 통보
            //adapter.notifyDataSetChanged();
        }
    };

    public void run()
    {
        StringBuilder html = new StringBuilder();
        try
        {
            mAddr="http://52.68.63.215/mongmi_serverside";



            URL url = new URL(mAddr);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();

            if(conn!=null)
            {
                conn.setConnectTimeout(10000);
                conn.setUseCaches(false);
                Log.d("connect", "true");

                if(conn.getResponseCode()== HttpURLConnection.HTTP_OK) {

                    Log.d("HTTP_OK","TRUE");

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));

                    for (; ; )
                    {
                        String line = br.readLine();
                       Log.d("line",line);

                        if(line==null) break;
                        html.append(line+"\n");
                    }
                    br.close();
                    mResult=html.toString();
                }
                conn.disconnect();
            }
        }
        catch (Exception e) {
            ;
        }

        try
        {

            mResult = "{\n" +
                    "    \"apiVersion\": \"2.1\",\n" +
                    "    \"data\": {\n" +
                    "        \"id\": \"AAbokV76tkU\",\n" +
                    "        \"uploaded\": \"2012-03-06T13:52:43.000Z\",\n" +
                    "        \"updated\": \"2012-03-15T01:34:53.000Z\",\n" +
                    "        \"content\": {\n" +
                    "            \"5\": \"http://www.youtube.com/v/AAbokV76tkU?version=3&f=videos&app=youtube_gdata\",\n" +
                    "            \"1\": \"rtsp://v6.cache4.c.youtube.com/CiILENy73wIaGQlFtvpekegGABMYDSANFEgGUgZ2aWRlb3MM/0/0/0/video.3gp\",\n" +
                    "            \"6\": \"rtsp://v8.cache3.c.youtube.com/CiILENy73wIaGQlFtvpekegGABMYESARFEgGUgZ2aWRlb3MM/0/0/0/video.3gp\"\n" +
                    "        }\n" +
                    "   }\n" +
                    "}";


   //        Log.d("result",mResult);
            // 문자열을 json객체로 변환
            JSONObject obj = new JSONObject(mResult);

            Log.d("obj","new obj");

            // 위의 객체에서 channel 키의 값을 객체로 가져와
            JSONObject channel = obj.getJSONObject("data");

            Log.d("data",obj.getString("data"));

            // 위 객체에서 item 키의 값을 배열로 가져오기
            JSONArray items = obj.getJSONArray("data");

            // 배열을 순회하면서 객체를 가져와서 author
            // 키의 값을 data에 추가하기
            for (int i = 0; i < items.length(); i++) {
                JSONObject imsi = items.getJSONObject(i);
                data.add(imsi.getString("name"));

                Log.d("data",imsi.getString("name"));
            }


            handler.sendEmptyMessage(0);

        } catch (Exception e) {
            Log.d("data","cant make Json Obj");
        }
    }
}
