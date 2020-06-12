package ch.noseryoung.advanceduekm335.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

import ch.noseryoung.advanceduekm335.core.BasicScreen;
import ch.noseryoung.advanceduekm335.objects.Asteroid;
import ch.noseryoung.advanceduekm335.objects.Explosion;
import ch.noseryoung.advanceduekm335.objects.SpaceShip;


public class GameScreen extends BasicScreen {
    private SpriteBatch batch;
    private final Texture bgTexture;
    private Sprite bgSprite;
    private SpaceShip spaceShip;
    private Explosion explosion;
    private List<Asteroid> asteroids;


    public GameScreen(Game parent){
        batch = new SpriteBatch();
        bgTexture = new Texture("background.png");
        bgSprite = new Sprite(bgTexture);
        spaceShip = new SpaceShip();
        explosion = new Explosion();
        asteroids = new ArrayList<>();
        asteroids.add(new Asteroid());
        asteroids.add(new Asteroid());
        asteroids.add(new Asteroid());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        bgSprite.draw(batch);
        batch.end();

        spaceShip.render(batch);
        explosion.render(batch, spaceShip);

        for (Asteroid asteroid : asteroids) {
            asteroid.render(batch);
        }
    }

    @Override
    public void dispose() {
        spaceShip.dispose();
        batch.dispose();
    }
}
