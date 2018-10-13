package com.example.menga.imagerec;

import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;
import clarifai2.dto.prediction.Prediction;

public class color {
    private String img="https://i.imgflip.com/vh6to.jpg";
    final ClarifaiClient client = new ClarifaiBuilder("b6e11b6479da4bb5b33267988ab7aa4b").buildSync();
    Model<Concept> generalModel = client.getDefaultModels().generalModel();

    PredictRequest<Concept> request = generalModel.predict().withInputs(
            ClarifaiInput.forImage(img)
    );
    private List<ClarifaiOutput<Concept>> result = request.executeSync().get();
    public List getList(){return result;}
    public static void main(String[] args){
        color colour = new color();
        List<ClarifaiOutput<Concept>> colorList = colour.getList();
        ClarifaiOutput temp = colorList.get(0);
        List<Prediction> tempList = temp.data();
        for(int i =0;i<tempList.size();i++){
            System.out.println(tempList.get(i).asConcept().name());
        }
    }
}
