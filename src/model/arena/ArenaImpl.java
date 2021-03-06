package model.arena;

import java.util.LinkedList;
import java.util.List;

import model.arena.entities.Bullet;
import model.arena.entities.Entities;
import model.arena.entities.EntitiesImpl;
import model.arena.entities.EntitiesVisitor;
import model.arena.entities.EntitiesVisitorImpl;
import model.arena.entities.Hero;
import model.arena.entities.HeroImpl;

/**
 * This is the implementation of the interface @Arena and stores any entities.
 * 
 * @author josephgiovanelli
 *
 */
public class ArenaImpl implements Arena {
    private Hero hero;
    private Entities goal;
    private final List<Entities> entities;
    private final List<Bullet> bullets;

    private final EntitiesVisitor addVisitor = new EntitiesVisitorImpl(this);

    /**
     * This constructor initializes the list of the entities and the bullets.
     */
    public ArenaImpl() {
        this.entities = new LinkedList<>();
        this.bullets = new LinkedList<>();
    }

    @Override
    public void add(final Entities entities) {
        entities.accept(addVisitor);
    }

    @Override
    public void add(final EntitiesImpl entitiesImpl) {
        this.entities.add(entitiesImpl);
        if (entitiesImpl.getCode() == -1) {
            this.goal = entitiesImpl;
        }
    }

    @Override
    public void add(final HeroImpl hero) {
        this.hero = hero;
        this.entities.add(hero);
    }

    @Override
    public void add(final Bullet bullet) {
        this.bullets.add(bullet);
    }

    @Override
    public Hero getHero() {
        return this.hero;
    }

    @Override
    public Entities getGoal() {
        return this.goal;
    }

    @Override
    public List<Entities> getEntities() {
        return this.entities;
    }

    @Override
    public List<Bullet> getBullets() {
        return this.bullets;
    }

}
