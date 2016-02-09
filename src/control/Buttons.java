package control;

public enum Buttons {
	NEWGAME(ViewEvents.LEVEL1), EXIT(ViewEvents.EXIT);
	private final ViewEvents event;
	private Buttons(ViewEvents event) {
		this.event = event;
	}
	public ViewEvents getEvent() {
		return event;
	}
	
}
