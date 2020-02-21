package defaultPackage.gui;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

/**************************************************************************
 *                                                                        *
 *                       GUI component by Tyrael                          *
 *              UploadField, with drag function and animation.            *
 *                                                                        *
 *                       Copyright (c) 2020 LYL                           *
 *                            @author LYL                                 *
 *                            @version 2.0                                *
 **************************************************************************/
public class UploadField extends StackPane {
    private Rectangle hr = new Rectangle();
    private Rectangle vt = new Rectangle();
    private double size = 50;
    private Canvas layer1 = new Canvas();
    private GraphicsContext layer1Context = layer1.getGraphicsContext2D();

    private Circle holo = new Circle();
    private Circle shade = new Circle();

    UploadField(){
        this.hr.setHeight(2);
        this.vt.setHeight(2);
        this.hr.setRotate(90);

        this.getChildren().addAll(hr,vt);
    }

    UploadField(double size){
        this.setAlignment(Pos.CENTER);
        this.size = size;
        setLayersSize(size);
        this.hr.setWidth(size-50);
        this.hr.setHeight(3);
        this.vt.setWidth(3);
        this.vt.setHeight(size-50);
        this.holo.setCenterX(0);
        this.holo.setCenterY(0);
        this.holo.setRadius(size/2);
        this.holo.setStrokeWidth(5);
        this.shade.setCenterX(0);
        this.shade.setCenterY(0);
        this.shade.setRadius(size/2-5);
        //this.holo.set
        setBackColor(1,1,1,1);
        setColor(.32,.75,.89,1);
        //this.layer1Context.strokeArc(5,5,size-5,size-5,10,100,ArcType.OPEN);
        this.getChildren().addAll(holo,shade,hr,vt);
    }

    /**
     * Set the Button location by taken X and Y.
     * The anchor at top left.
     *
     * @param X the point at x-axis
     * @param Y the point at y-axis
     * */
    void setLocation(double X, double Y) {
        this.setLayoutX(X);
        this.setLayoutY(Y);
    }

    void setSize(double size){
        this.size = size;
        //setLayersSize(size);
        this.hr.setWidth(size);
        this.hr.setHeight(2);
        this.vt.setWidth(2);
        this.vt.setHeight(size);
    }

    private void setLayersSize(double size){
        this.layer1.setHeight(size);
        this.layer1.setWidth(size);
    }

    public double getSize(){
        return this.size;
    }

    /**
     * Style setting
     * Set a new display color for button.
     * This method will override the default color which
     * defined in constructors. This method also may called
     * in listener for change color dynamically.
     *
     * The color value rage is 0.0 ~ 1.0
     *
     * @param r the red channel for bar color
     * @param g the green channel for bar color
     * @param b the blue channel for bar color
     * @param a the alpha channel for bar color
     * */
    void setColor(double r, double g, double b, double a){
        setFrontColor(r,g,b,a);
        setHoloColor(r,g,b,a);
    }

    void setFrontColor(double r, double g, double b, double a){
        Color color = new Color(r,g,b,a);
        this.hr.setFill(color);
        this.vt.setFill(color);
    }

    void setBackColor(double r, double g, double b, double a){
        Color color = new Color(r,g,b,a);
        this.shade.setFill(color);
    }

    void setHoloColor(double r, double g, double b, double a){
        Color color = new Color(r,g,b,a);
        this.holo.setFill(color);
    }

    private int angle = 0;
    private boolean exit = true;
    void onDrag(boolean exit){
//        System.out.println(exit+" "+angle);
//        while (!this.exit){
//            RotateTransition rt = new RotateTransition(Duration.millis(10000/360f), layer1);
//            rt.setFromAngle(angle);
//            angle++;
//            setLayersSize(angle);
//            rt.setToAngle(angle);
//            rt.setAutoReverse(false);
//            rt.play();
//        }
//        if(angle>360) angle = 0;
//        rt.setDuration(Duration.millis(10000));
//        rt.setFromAngle(0);
//        rt.setToAngle(360);
//        rt.setAutoReverse(false);
//        rt.setCycleCount(Timeline.INDEFINITE);
//        if(exit)rt.setDuration(Duration.millis(10000));
//        else rt.setDuration(Duration.millis(5000));
//        rt.play();
    }

    /* instruction of active listener.
    * uploadField.setOnDragOver(event -> {
            if (event.getGestureSource() != uploadField) {
                event.acceptTransferModes(TransferMode.ANY);
                ...
                do action here.
            }
        });
        uploadField.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            // essential object.

            address = db.getFiles().get(0).toString();
            // get file/input address

            ...
            do action here.
        });
        * */
    void setExit(boolean exit){
        this.exit = exit;
    }
}
//TODO: animation.