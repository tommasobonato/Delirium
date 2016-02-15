package model;

public class HeroMovementManager extends DinamicMovementManager{
    
    private boolean onJump = false;
    private int time = 0;

    public HeroMovementManager(Position position, Bounds bounds, Actions action, int speed, boolean canFly) {
        super(position, bounds, action, speed, canFly);
    }

    /**
     * 	@author Matteo Magnani
     */
    @Override
    public Position getNextMove() {
    	Position newPosition = this.getPosition();
    	
    	//applico le funzioni dopo il calcolo dell'eventuale salto o caduta in modo da poter settare la reale direzione del personaggio 
        if (this.getAction() == Actions.MOVE) {
        	newPosition.setPoint(this.getAction().getFunction().deterimnateNewPoint(newPosition.getPoint(), this.getSpeed(), newPosition.getDirection()));
        	if(!checkBounds(newPosition, getBounds(), this.getAction())) {
        		fixPositionBounds(newPosition, getBounds(), this.getAction());
        	}
        }
    	
        //TODO eventualmente aumetare il salto ed applicare comunque la gravità, a livello astratto è forse più logico
        if(!onJump) {
            newPosition = applyGravity(newPosition);
        }
        
        if(this.getAction() != Actions.FALL && this.getAction() == Actions.JUMP && !onJump) {
        	time = 0;
            this.onJump = true;
        }
        
        if (onJump) {
            if(time < 200) {
                newPosition.setPoint(Actions.JUMP.getFunction().deterimnateNewPoint(newPosition.getPoint(), this.getSpeed(), newPosition.getDirection()));
                //TODO metti controllo bounds salto
                if (!checkBounds(newPosition, this.getBounds(), Actions.JUMP)) {
                    fixPositionBounds(newPosition, getBounds(), Actions.JUMP);
                    time = 200;
                }
                time++;
            } else {
                onJump = false;
            }
        }
        
        return newPosition;
    }

    

}
