package com.example.menga.imagerec;

import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.request.model.PredictRequest;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.Model;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;

public class color {
    final ClarifaiClient client = new ClarifaiBuilder("b6e11b6479da4bb5b33267988ab7aa4b").buildSync();
    Model<Concept> generalModel = client.getDefaultModels().generalModel();

    PredictRequest<Concept> request = generalModel.predict().withInputs(
            ClarifaiInput.forImage("https://www.cambridgema.gov/~/media/Images/sharedphotos/Residential-Street-Permits.jpg?mw=1920")
    );
<<<<<<< HEAD
    private List<ClarifaiOutput<Concept>> result = request.executeSync().get();
    public color(String images){
        image = images;
    }
    public int getSize(){return result.size();}

    public static void main(String[] args){
        color test = new color("https://www.cambridgema.gov/~/media/Images/sharedphotos/Residential-Street-Permits.jpg?mw=1920");

    }
}
=======
    List<ClarifaiOutput<Concept>> result = request.executeSync().get();
}
>>>>>>> parent of e979af3... Added Anthony's changes to color
