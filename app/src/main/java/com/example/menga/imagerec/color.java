package com.example.menga.imagerec;

<<<<<<< HEAD
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;
=======
import java.util.ArrayList;
>>>>>>> 7c9308ecd6ea586178fd103f1d43d46865bb21eb
import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Color;
import clarifai2.dto.prediction.Concept;
import clarifai2.dto.prediction.Prediction;
public class color {
    public ArrayList<entry> getData(String img){
        final ClarifaiClient client = new ClarifaiBuilder("b6e11b6479da4bb5b33267988ab7aa4b").buildSync();
        Model<Color> generalModel = client.getDefaultModels().colorModel();

<<<<<<< HEAD
    PredictRequest<Concept> request = generalModel.predict().withInputs(
            ClarifaiInput.forImage(img)
    );
    private List<ClarifaiOutput<Concept>> result = request.executeSync().get();
    public List getList(){return result;}
    public static void main(String[] args){
        FirebaseVisionImage image;
        try {
            image = FirebaseVisionImage.fromMediaImage('how do i do this LOL');
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
                                // ...
                            }
                        });



        color colour = new color();
        List<ClarifaiOutput<Concept>> colorList = colour.getList();
        ClarifaiOutput temp = colorList.get(0);
=======
        PredictRequest<Color> request = generalModel.predict().withInputs(
                ClarifaiInput.forImage(img)
        );
        List<ClarifaiOutput<Color>> result = request.executeSync().get();
        ClarifaiOutput temp = result.get(0);
>>>>>>> 7c9308ecd6ea586178fd103f1d43d46865bb21eb
        List<Prediction> tempList = temp.data();
        ArrayList<entry> resultList = new ArrayList<>();
        for(int i =0;i<tempList.size();i++){
            resultList.add(new entry(tempList.get(i).asColor().webSafeColorName(),
                    tempList.get(i).asColor().value(),tempList.get(i).asColor().webSafeHex()));
        }
        return resultList;
    }

    public static void main(String[] args){
        color colour = new color();
        ArrayList<entry> list = colour.getData("http://pfguru.com/wp-content/uploads/2015/08/Ex-Showroom-Price-And-On-Road-Price.jpg");
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getColor()+" "+list.get(i).getValue()+" "+list.get(i).getHex());
        }
    }
}
