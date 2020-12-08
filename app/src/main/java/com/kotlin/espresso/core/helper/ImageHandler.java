package com.kotlin.espresso.core.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageHandler {

    public static Bitmap getImageFromUrl(String url)  {
        Bitmap bitmap = null;
        try {
            URL imageUrl = new URL(url);
            bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;

    }
}
