package com.example.menga.imagerec;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;
import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;
import clarifai2.dto.prediction.Prediction;
<<<<<<< HEAD:app/src/main/java/com/example/menga/imagerec/colorSense.java
public class colorSense {
    public ArrayList<com.example.menga.cartrack.entry> getData(String img){
        final ClarifaiClient client = new ClarifaiBuilder("b6e11b6479da4bb5b33267988ab7aa4b").buildSync();
        Model<Color> generalModel = client.getDefaultModels().colorModel();

        PredictRequest<Color> request = generalModel.predict().withInputs(
                ClarifaiInput.forImage(img)
        );
        List<ClarifaiOutput<Color>> result = request.executeSync().get();
        ClarifaiOutput temp = result.get(0);
        List<Prediction> tempList = temp.data();
        ArrayList<com.example.menga.cartrack.entry> resultList = new ArrayList<>();
        for(int i =0;i<tempList.size();i++){
            resultList.add(new com.example.menga.cartrack.entry(tempList.get(i).asColor().webSafeColorName(),
                    tempList.get(i).asColor().value(),tempList.get(i).asColor().webSafeHex()));
        }
        return resultList;
    }
=======

public class color {
>>>>>>> 1363c07681a6c86f3cf7b50a2662929ea7bab1fd:app/src/main/java/com/example/menga/imagerec/color.java

    private String img="https://i.imgflip.com/vh6to.jpg";
    final ClarifaiClient client = new ClarifaiBuilder("b6e11b6479da4bb5b33267988ab7aa4b").buildSync();
    Model<Concept> generalModel = client.getDefaultModels().generalModel();

    PredictRequest<Concept> request = generalModel.predict().withInputs(
            ClarifaiInput.forImage(img)
    );
    private List<ClarifaiOutput<Concept>> result = request.executeSync().get();
    public List getList(){return result;}
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



        color colour = new color();
<<<<<<< HEAD:app/src/main/java/com/example/menga/imagerec/colorSense.java
        ArrayList<com.example.menga.cartrack.entry> list = colour.getData("http://pfguru.com/wp-content/uploads/2015/08/Ex-Showroom-Price-And-On-Road-Price.jpg");
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getColor()+" "+list.get(i).getValue()+" "+list.get(i).getHex());
=======
        List<ClarifaiOutput<Concept>> colorList = colour.getList();
        ClarifaiOutput temp = colorList.get(0);
        List<Prediction> tempList = temp.data();
        for(int i =0;i<tempList.size();i++){
            System.out.println(tempList.get(i).asConcept().name());
>>>>>>> 1363c07681a6c86f3cf7b50a2662929ea7bab1fd:app/src/main/java/com/example/menga/imagerec/color.java
        }
    }
}
