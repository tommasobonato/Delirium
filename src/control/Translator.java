package control;

import java.util.HashMap;
import java.util.Map;

import model.Actions;
import model.Position;
import view.Entities;
import view.ViewPhysicalProperties;

class Translator {
	
	//eventualmente da sostare dentro controller impl
	public static Actions tranViewEvents(ViewEvents event) {
		switch(event) {
		case MLEFT: return Actions.LEFT;
		case MRIGHT: return Actions.RIGHT;
		case JUMP: return Actions.UP;
		case STOPMOVEMENT : return Actions.STOP;
		default:
			//TODO cambia exception in IllegalEventException
			throw(new IllegalArgumentException());
		}
	}
	
	public static ViewPhysicalProperties positionFromModeltoView (Position position, Dimension arenaDimension) {
		return new ViewPhysicalProperties(positionNormalizator(position.getPrimitivePosition(), arenaDimension), directionFromModeltoView(position.getDirection()));
	}
	
	private static PhisicalProprieties positionNormalizator(PhisicalProprieties position, Dimension arenaDimension) {
		position.setPoint(new Point(position.getPoint().getX(), arenaDimension.getHeight() - position.getPoint().getY() - position.getDimension().getHeight()));
		return position;
	}
	
	private static ViewPhysicalProperties.Directions directionFromModeltoView (Actions direction) {
		switch(direction) {
		case LEFT: return ViewPhysicalProperties.Directions.LEFT;
		case RIGHT: return ViewPhysicalProperties.Directions.RIGHT;
		case UP: return ViewPhysicalProperties.Directions.UP;
		case DOWN: return ViewPhysicalProperties.Directions.DOWN;
		case STOP: return ViewPhysicalProperties.Directions.NONE;
		default:
			//TODO cambia exception in IllegalEventException
			throw(new IllegalArgumentException());
		}
	}
	
	//eventualmente da sostare dentro controller impl
	public static Map<Integer, Pair<Entities, Pair<Integer, ViewPhysicalProperties>>> mapFromModelToView(Map<Integer, Pair<Integer, Position>> modelMap, EntitiesDatabase database) {
		Map<Integer, Pair<Entities, Pair<Integer, ViewPhysicalProperties>>> viewMap = new HashMap<>();
		modelMap.entrySet().forEach(e -> {
			viewMap.put(e.getKey(), new Pair<Entities, Pair<Integer, ViewPhysicalProperties>>(database.getViewEntity(e.getKey()), new Pair<Integer, ViewPhysicalProperties>(e.getValue().getX(), positionFromModeltoView(e.getValue().getY(), database.getArenaDimension()))));
		});
		return viewMap;
	}

}
