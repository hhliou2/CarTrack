package com.example.menga.imagerec;

import java.util.ArrayList;
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

    public static void main(String[] args){
        color colour = new color();
        ArrayList<com.example.menga.cartrack.entry> list = colour.getData("http://pfguru.com/wp-content/uploads/2015/08/Ex-Showroom-Price-And-On-Road-Price.jpg");
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getColor()+" "+list.get(i).getValue()+" "+list.get(i).getHex());
        }
    }
}
