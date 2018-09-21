package com.example.android.floatingactionbuttonbasic.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.android.floatingactionbuttonbasic.ImageFragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Chris Diaz
 */
public class DownloadAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private ImageFragment imageFragment;

    public DownloadAsyncTask(ImageFragment imageFragment) {
        this.imageFragment = imageFragment;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {

        String url = urls[0];
        Bitmap bitmap = null;

        try {
            final InputStream inputStream = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (final MalformedURLException malformedUrlException) {
            // Handle error
        } catch (final IOException ioException) {
            // Handle error
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageFragment.updateImage(bitmap);
    }
}
