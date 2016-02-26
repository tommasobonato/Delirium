package model;

import java.util.List;

import model.arena.utility.Actions;
import model.arena.utility.Directions;
import model.exception.IllegalMonsterBoundsException;
import model.exception.NotUniqueCodeException;
import model.transfertentities.EntitiesInfo;
import model.transfertentities.EntitiesInfoToControl;

public interface Model {

    void notifyEvent(final Directions direction);

    void notifyEvent(final Actions action);

    List<EntitiesInfo> updateArena();

    List<EntitiesInfoToControl> getState();

    void createArena(final List<EntitiesInfo> entitiesInfo) throws NotUniqueCodeException, IllegalMonsterBoundsException;

    void putBullet(final List<EntitiesInfo> entitiesInfo) throws NotUniqueCodeException, IllegalMonsterBoundsException;

}
