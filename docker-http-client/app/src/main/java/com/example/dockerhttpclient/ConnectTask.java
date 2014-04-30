package com.example.dockerhttpclient;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectTask extends AsyncTask<Void, Void, String> {
    public static final int CONNECT_TIMEOUT = 3000;

    private static final String TAG = ConnectTask.class.getSimpleName();

    public interface OnCompleteListener {
        void onComplete(String result);
    }

    private OnCompleteListener mListener;

    public void setOnCompleteListener(OnCompleteListener listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(BuildConfig.REMOTE_URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            final int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            while (in.read(buffer, 0, buffer.length) != -1) {
                out.write(buffer);
            }
            out.close();
            in.close();
            return out.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (mListener != null) {
            mListener.onComplete(s);
        }
    }
}
