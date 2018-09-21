package com.example.android.floatingactionbuttonbasic;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment {

    public interface OnImageClickedListener {
        // TODO: Update argument type and name
        void onImageClicked(Bitmap image);
    }

    private OnImageClickedListener mListener;
    private ImageView imageView;

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_image, container, false);
        imageView = root.findViewById(R.id.image_preview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                if(bitmapDrawable != null) {
                    mListener.onImageClicked(bitmapDrawable.getBitmap());
                }
            }
        });

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnImageClickedListener) {
            mListener = (OnImageClickedListener) context;
        } else {
            throw new RuntimeException("Context must implement OnImageClickedListener.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void updateImage(Bitmap image) {
        imageView.setImageBitmap(image);
    }

}
