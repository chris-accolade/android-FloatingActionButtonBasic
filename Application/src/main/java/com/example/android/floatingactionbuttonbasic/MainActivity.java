/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.android.floatingactionbuttonbasic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.android.floatingactionbuttonbasic.util.DatabaseHelper;
import com.example.android.floatingactionbuttonbasic.util.DownloadAsyncTask;

/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link android.support.v4.app.Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class MainActivity extends FragmentActivity implements ButtonsFragment.FABListener, ImageFragment.OnImageClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            ButtonsFragment fragment = new ButtonsFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    @Override
    public void onButtonClicked(int fabId, boolean isChecked) {

        switch (fabId) {
            case R.id.fab_large:
                handleLargeImage(isChecked);
                break;
            case R.id.fab_small:
                handleSmallImage(isChecked);
                break;
            default:
                break;
        }
    }

    private void handleSmallImage(boolean isChecked) {

        // TODO - load ImageFragment with local image drawable resource "accolade_logo"
        ImageFragment imageFragment = (ImageFragment) getFragmentManager().findFragmentById(R.id.image_fragment);
        if (!isChecked) {
            imageFragment.updateImage(null);
        } else {
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.accolade_logo);
            imageFragment.updateImage(image);
        }
    }

    private void handleLargeImage(boolean isChecked) {

        // TODO - use AsyncTask to download image with url: R.string.image_url and update the ImageFragment
        ImageFragment imageFragment = (ImageFragment) getFragmentManager().findFragmentById(R.id.image_fragment);
        if(!isChecked) {
             imageFragment.updateImage(null);;
        } else {

            DownloadAsyncTask downloadTask = new DownloadAsyncTask(imageFragment);
            downloadTask.execute(getResources().getString(R.string.image_url));
        }

    }

    @Override
    public void onImageClicked(Bitmap image) {

        // TODO - when image is clicked, launch FullScreenImageActivity to show the Bitmap image
        String filename = DatabaseHelper.saveImage(this, image);

        Intent intent = new Intent(this, FullScreenImageActivity.class);
        intent.putExtra("FILENAME", filename);
        startActivity(intent);
    }
}
