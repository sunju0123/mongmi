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

    DownThread(String addr)
    {
        mAddr = addr;
        mResult="";
    }

    public void run()
    {
        StringBuilder html = new StringBuilder();
        try
        {
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
            // 문자열을 json객체로 변환
            JSONObject obj = new JSONObject(mResult);

            // 위의 객체에서 channel 키의 값을 객체로 가져와
            JSONObject channel = obj.getJSONObject("channel");

            // 위 객체에서 item 키의 값을 배열로 가져오기
            JSONArray items = channel.getJSONArray("item");

            // 배열을 순회하면서 객체를 가져와서 author
            // 키의 값을 data에 추가하기
            for (int i = 0; i < items.length(); i++) {
                JSONObject imsi = items.getJSONObject(i);
                data.add(imsi.getString("author"));

                Log.d("data",imsi.getString("author"));
            }

            handler.sendEmptyMessage(0);

        } catch (Exception e) {
        }
    }


    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
        //    (MainActivity.this).setProgressBarIndeterminateVisibility(false);
            // 데이터가 갱신되었으니 리스트뷰를 다시 출력하도록 통보
         //   adapter.notifyDataSetChanged();
        }
    };

}
