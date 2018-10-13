package com.example.menga.imagerec;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;

public class color {

    private String img="https://i.imgflip.com/vh6to.jpg";
    public static void main(String[] args){
        FirebaseVisionImage image;
        try {
            Drawable stopDrawable = Resources.getSystem().getDrawable(R.drawable.stop);
            Bitmap stopImage = ((BitmapDrawable)stopDrawable).getBitmap();
            image = FirebaseVisionImage.fromBitmap(stopImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();

        textRecognizer.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText result) {
                        // Task completed successfully
                        String resultText = result.getText();
                        System.out.println(resultText);
                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Task failed with an exception
                                System.out.println("why god");
                            }
                        });

    }
}
