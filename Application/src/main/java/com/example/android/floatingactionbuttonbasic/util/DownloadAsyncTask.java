package com.example.android.floatingactionbuttonbasic.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.example.android.floatingactionbuttonbasic.ImageFragment;

/**
 * @author Chris Diaz
 */
public class DownloadAsyncTask extends AsyncTask<String, Void, Bitmap> {

    public DownloadAsyncTask(ImageFragment imageFragment) {
    }

    @Override
    protected Bitmap doInBackground(String... urls) {

        // TODO Download image from given urls

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        // TODO: Update UI
    }
}
