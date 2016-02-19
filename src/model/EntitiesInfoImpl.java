package model;

import java.util.Optional;

public class EntitiesInfoImpl implements EntitiesInfo {
    
    private int code;
    private final Position position;
    private Optional<MovementInfo> movementInfo; 
    private final int life;
    private final LifePattern lifePattern;
    private final Optional<ShootInfo> shootInfo;
    private final Optional<Integer> contactDamage;
    
    public EntitiesInfoImpl(int code, Position position, Optional<MovementInfo> movementInfo, int life,
            LifePattern lifePattern, Optional<ShootInfo> shootInfo, Optional<Integer> contactDamage) {
        super();
        this.code = code;
        this.position = position;
        this.movementInfo = movementInfo;
        this.life = life;
        this.lifePattern = lifePattern;
        this.shootInfo = shootInfo;
        this.contactDamage = contactDamage;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getCode()
     */
    @Override
    public int getCode() {
        return code;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getMovementInfo()
     */
    @Override
    public Optional<MovementInfo> getMovementInfo() {
        return movementInfo;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#setMovementInfo(java.util.Optional)
     */
    @Override
    public void setMovementInfo(Optional<MovementInfo> movementInfo) {
        this.movementInfo = movementInfo;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getPosition()
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getLife()
     */
    @Override
    public int getLife() {
        return life;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getLifePattern()
     */
    @Override
    public LifePattern getLifePattern() {
        return lifePattern;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getShootInfo()
     */
    @Override
    public Optional<ShootInfo> getShootInfo() {
        return shootInfo;
    }

    /* (non-Javadoc)
     * @see model.EntitiesInfo#getContactDamage()
     */
    @Override
    public Optional<Integer> getContactDamage() {
        return contactDamage;
    }
    
    
    

}
