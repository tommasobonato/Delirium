package model;

import control.Position;

public enum Heroes {
    
    JOY(0, Heroe.MAX_LIFE, Heroe.INITIAL_POSITION, Heroe.INITIAL_SPEED);
    
    final private int code;
    final private int life;
    final private Position position;
    final private int speed;
    
    Heroes(final int code, final int life, final Position position, final int speed) {
        this.code = code;
        this.life = life;
        this.position = position;
        this.speed = speed;
    }

    public int getCode() {
        return code;
    }

    public int getLife() {
        return life;
    }

    public Position getPosition() {
        return position;
    }
    
    public int gestSpeed() {
        return speed;
    }

}
