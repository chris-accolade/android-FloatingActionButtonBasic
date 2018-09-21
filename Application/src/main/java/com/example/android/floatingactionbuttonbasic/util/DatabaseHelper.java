package com.example.android.floatingactionbuttonbasic.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatabaseHelper {

    private DatabaseHelper() {

    }

    public static String saveImage(Context context, Bitmap image) {

        String filename = "temp_image.jpg";
        FileOutputStream outputStream = null;

        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(bitmapToBytes(image));

            return filename;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static Bitmap getImage(Context context, String filename) {

        FileInputStream fis = null;
        try {

            fis = context.openFileInput(filename);
            return BitmapFactory.decodeFileDescriptor(fis.getFD());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


    private static byte[] bitmapToBytes(Bitmap bitmap) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;
    }
}
