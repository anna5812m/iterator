package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.ImageCollection;
import model.Iterator;

public class Controller {
    public ImageView imageView;
    public Timeline timeline;
    public ImageCollection imgs;
    public Iterator iter_main;

    public void initialize(){
        imgs = new ImageCollection("");
        iter_main = imgs.getIterator();
        timeline = new Timeline();
    }

    public void onStart(ActionEvent actionEvent) {
        timeline.setCycleCount(Timeline.INDEFINITE);//кол-во повторов
        timeline.getKeyFrames().add(new KeyFrame
                (new Duration(1000),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                if (iter_main.hasNext()) {
                                    Image name = (Image) iter_main.next();
                                    imageView.setImage(name);
                                }
                            }
                        }));
        timeline.play();
    }

    public void onStop(ActionEvent actionEvent) {
        timeline.stop();
    }
}
