package no.dremar17.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Controller {
    @FXML
    private TextField answer;
    @FXML
    private ImageView imageView;
    @FXML
    private Text country, congratulation;
    @FXML
    private Button submitButton;
    @FXML
    private Circle circle1, circle2, circle3, circle4, circle5;
    @FXML
    private Rectangle bg;
  
    private int stage;
    private int points;



    @FXML
    private void submitAction(ActionEvent event) {
        country.setText(countryCheck());
        Image image = new Image(imageCheck());
        if(answer.getText().toLowerCase().equals(capitalCheck())) {
            imageView.setImage(image);
            System.out.println("Correct answer!");

            switch (stage) {
                case 0:
                    circle1.setFill(Color.GREEN);
                    break;
                case 1:
                    circle2.setFill(Color.GREEN);
                    break;
                case 2:
                    circle3.setFill(Color.GREEN);
                    break;
                case 3:
                    circle4.setFill(Color.GREEN);
                    break;
                case 4:
                    circle5.setFill(Color.GREEN);
                    break;
                case 5:
                    circle2.setFill(Color.GREEN);
                    break;
            }
            points++;
        }
      
        else {
            imageView.setImage(image);
            System.out.println("Wrong Answer, correct answer is " + capitalCheck());
            switch (stage) {
                case 0:
                    circle1.setFill(Color.RED);
                    break;
                case 1:
                    circle2.setFill(Color.RED);
                    break;
                case 2:
                    circle3.setFill(Color.RED);
                    break;
                case 3:
                    circle4.setFill(Color.RED);
                    break;
                case 4:
                    circle5.setFill(Color.RED);
                    break;
                case 5:
                    circle5.setFill(Color.RED);
                    break;
            }
        }
              stage++;
        if(stage > 4) {
            congratulation.setText("Congratulations, you got " + points + "/" + stage + " right!");
            submitButton.setDisable(true);
        }
        answer.setText("");
    }

    public String imageCheck() {
        String imageURL;
        Stop[] belgium = new Stop[] { new Stop(0, Color.rgb(248, 69, 69)), new Stop(1, Color.rgb(247, 197, 67))};
        Stop[] canada = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.rgb(248, 69, 69))};
        Stop[] china = new Stop[] { new Stop(0, Color.rgb(248, 69, 69)), new Stop(1, Color.rgb(247, 197, 67))};
        Stop[] uk = new Stop[] { new Stop(0, Color.rgb(25,34,123)), new Stop(1, Color.rgb(248, 69, 69))};

        switch (stage) {
            case 0:
                imageURL = "no/dremar17/assignment2/images/belgium.png";
                LinearGradient lg1 = new LinearGradient(390, 180, 225, 0, false, CycleMethod.NO_CYCLE, belgium);
                bg.setFill(lg1);
                break;
            case 1:
                imageURL = "no/dremar17/assignment2/images/canada.png";
                LinearGradient lg2 = new LinearGradient(390, 180, 225, 0, false, CycleMethod.NO_CYCLE, canada);
                bg.setFill(lg2);
                break;
            case 2:
                imageURL = "no/dremar17/assignment2/images/china.png";
                LinearGradient lg3 = new LinearGradient(390, 180, 225, 0, false, CycleMethod.NO_CYCLE, china);
                bg.setFill(lg3);
                break;
                       case 3:
                imageURL = "no/dremar17/assignment2/images/uk.png";
                LinearGradient lg4 = new LinearGradient(390, 180, 225, 0, false, CycleMethod.NO_CYCLE, uk);
                bg.setFill(lg4);
                break;
            case 4:
                imageURL = "no/dremar17/assignment2/images/uk.png";
                break;
            default:
                imageURL = "error";
                break;
        }
        return imageURL;
    }

    public String capitalCheck() {
        String capital;

        switch (stage) {
            case 0:
                capital = "canberra";
                break;
            case 1:
                capital = "brussels";
                break;
            case 2:
                capital = "ottawa";
                break;
            case 3:
                capital = "beijing";
                break;
            case 4:
                capital = "london";
                break;
            default:
                capital = "error";
                break;
        }
        return capital;
    }
  
    public String countryCheck() {
        String country;

        switch (stage) {
            case 0:
                country = "Belgium?";
                break;
            case 1:
                country = "Canada?";
                break;
            case 2:
                country = "China?";
                break;
            case 3:
                country = "United Kingdom?";
                break;
            case 4:
                country = "United Kingdom?";
                break;
            default:
                country = "error";
                break;
        }
        return country;
    }

}
