package view;

import control.Control;
import control.Pair;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ViewFactory {
    
    public static GenericView createNewScene(final Stage stage, final Control listener, final Pair<SceneType, Dimension2D> settings) {
        
        switch(settings.getX()) {
   
        case DRAWABLE:
            return new DynamicViewImpl(stage, listener,calculateSceneDimension(settings.getY()) , settings.getY());
        case MENU:
            return new StaticView(stage, listener, settings.getY());
        default:
            throw new IllegalArgumentException();
        }   
    }
    
    private static Dimension2D calculateSceneDimension(final Dimension2D worldDimension) {
        //final Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        return new Dimension2D(worldDimension.getWidth()/2, worldDimension.getHeight());
    }
}
