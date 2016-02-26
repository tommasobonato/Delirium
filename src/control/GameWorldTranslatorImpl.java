package control;

import java.util.LinkedList;
import java.util.List;

import model.arena.entities.Position;
import model.transfertentities.EntitiesInfoToControl;
import view.utilities.ControlComunication;
import view.utilities.ViewPhysicalProperties;

public class GameWorldTranslatorImpl implements GameWorldTranslator {
    private final EntitiesDatabase database;
    private final int screenMoltiplicatorFactor;

    public GameWorldTranslatorImpl(final EntitiesDatabase database, final int screenMoltiplicatorFactor) {
        super();
        this.database = database;
        this.screenMoltiplicatorFactor = screenMoltiplicatorFactor;
    }

    @Override
    public List<ControlComunication> entitiesListFromModelToView(final List<EntitiesInfoToControl> listInfo) {
        final List<ControlComunication> viewList = new LinkedList<>();
        listInfo.stream().forEach(e -> {
            viewList.add(new ControlComunication(e.getCode(), this.database.getViewEntity(e.getCode()), e.getLife(),
                    positionFromModeltoView(e), Translator.getViewActionsForEntities(e)));
        });
        return viewList;
    }

    private ViewPhysicalProperties positionFromModeltoView(final EntitiesInfoToControl info) {
        final Position p = info.getPosition();
        return new ViewPhysicalProperties(p.getPoint().getX() * this.screenMoltiplicatorFactor,
                (this.database.getArenaDimension().getHeight() - p.getPoint().getY() - p.getDimension().getHeight())
                        * this.screenMoltiplicatorFactor,
                p.getDimension().getWidth() * this.screenMoltiplicatorFactor,
                p.getDimension().getHeight() * this.screenMoltiplicatorFactor,
                info.getSpeed().isPresent() ? info.getSpeed().get() * this.screenMoltiplicatorFactor : 0,
                Translator.directionFromModeltoView(p.getDirection()));
    }
}