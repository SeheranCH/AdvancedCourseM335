package ch.noseryoung.advanceduekm335.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import ch.noseryoung.advanceduekm335.core.BasicScreen;
import ch.noseryoung.advanceduekm335.objects.Explosion;
import ch.noseryoung.advanceduekm335.objects.SpaceShip;


public class GameScreen extends BasicScreen {

    private SpriteBatch batch;
    private final Texture bgTexture;
    private Sprite bgSprite;
    private SpaceShip spaceShip;
    private ArrayList<Explosion> explosions;
    private float x, y;

    public GameScreen(Game parent) {
        batch = new SpriteBatch();
        bgTexture = new Texture("background.png");
        bgSprite = new Sprite(bgTexture);
        spaceShip = new SpaceShip();
        explosions = new ArrayList<>();
        y = 15;
        x = Gdx.graphics.getWidth() / 2 - spaceShip.getWidth() / 2;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Shooting Code
        if (Gdx.input.isTouched()) {
            explosions.add(new Explosion(x + 4));
            explosions.add(new Explosion(x + spaceShip.getWidth() - 4));
        }

        //Update Expplosions
        ArrayList<Explosion> explosionsToRemove = new ArrayList<>();
        for (Explosion explosion : explosions) {
            explosion.update(delta);
            if (explosion.isRemove()) {
                explosionsToRemove.add(explosion);
            }
        }

        explosions.removeAll(explosionsToRemove);

        batch.begin();
        bgSprite.draw(batch);
        batch.end();

        spaceShip.render(batch);

        for(Explosion explosion: explosions){
            explosion.render(batch);
        }

    }

    @Override
    public void dispose() {
        spaceShip.dispose();
        batch.dispose();
    }
}
