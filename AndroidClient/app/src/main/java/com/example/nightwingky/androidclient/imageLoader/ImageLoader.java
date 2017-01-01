package com.example.nightwingky.androidclient.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by nightwingky on 16-12-30.
 */

public class ImageLoader {

    /**
     * 使用AsyncTask方式实现图片的加载
     */

    public Bitmap getBitmapFromURL(String urlString) {
        Bitmap bitmap;
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            connection.disconnect();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void showImageByAsyncTask(ImageView imageView, String url) {
        new ImageContentAsyncTask(imageView).execute(url);
    }

    private class ImageContentAsyncTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView mImageView;

        public ImageContentAsyncTask(ImageView imageView) {
            mImageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            return getBitmapFromURL(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            mImageView.setImageBitmap(bitmap);
        }
    }

//    多线程方式实现图片加载
//    private ImageView mImageView;
//
//    private android.os.Handler handler = new android.os.Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            mImageView.setImageBitmap((Bitmap) msg.obj);
//        }
//    };
//
//    public void showImageByThread(ImageView imageView, final String URL) {
//
//        mImageView = imageView;
//
//        new Thread() {
//
//            @Override
//            public void run() {
//                super.run();
//                Bitmap bitmap = getBitmapFromURL(URL);
//                Message message = Message.obtain();
//                message.obj = bitmap;
//                handler.sendMessage(message);
//            }
//        }.start();
//    }
}
