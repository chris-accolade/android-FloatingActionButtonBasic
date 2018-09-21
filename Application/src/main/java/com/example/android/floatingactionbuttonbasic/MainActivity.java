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

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link android.support.v4.app.Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class MainActivity extends FragmentActivity implements ButtonsFragment.FABListener {

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
            case R.id.fab_small:
                handleSmallImage(isChecked);
                break;
            case R.id.fab_large:
                onButtonClicked(fabId, isChecked);
                handleLargeImage(isChecked);
                break;
            default:
                break;
        }
    }

    private void handleSmallImage(boolean isChecked) {

        // TODO - if isChecked != true, hide the image.
        // TODO - if isChecked == true, find the ImageFragment with ID R.id.image_fragment,
        //          and update it with local image drawable resource named "accolade_logo"
    }

    private void handleLargeImage(boolean isChecked) {

        // TODO - if isChecked != true, hide the image.
        // TODO - if isChecked == true, use AsyncTask to download the image with url from R.string.image_url
        //          and update the ImageFragment with ID R.id.image_fragment.
    }

}
