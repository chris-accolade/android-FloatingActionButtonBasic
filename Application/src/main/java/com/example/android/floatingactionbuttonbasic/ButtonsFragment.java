/*
 * Copyright 2014, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.floatingactionbuttonbasic;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * This fragment inflates a layout with two Floating Action Buttons and acts as a listener to
 * changes on them.
 */
public class ButtonsFragment extends Fragment implements FloatingActionButton.OnCheckedChangeListener{

    public interface FABListener {
        public void onButtonClicked(int fabId, boolean isChecked);
    }

    private FABListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fab_layout, container, false);

        // Make this {@link Fragment} listen for changes in both FABs.
        FloatingActionButton fab1 = rootView.findViewById(R.id.fab_large);
        fab1.setOnCheckedChangeListener(this);
        FloatingActionButton fab2 = rootView.findViewById(R.id.fab_small);
        fab2.setOnCheckedChangeListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof FABListener) {
            listener = (FABListener) context;
        } else {
            throw new RuntimeException("Context must implement FABListener interface.");
        }
    }

    @Override
    public void onCheckedChanged(FloatingActionButton fabView, boolean isChecked) {

        listener.onButtonClicked(fabView.getId(), isChecked);
    }
}
