package ch.noseryoung.advanceduekm335.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ch.noseryoung.advanceduekm335.objects.Asteroid;
import ch.noseryoung.advanceduekm335.objects.Explosion;
import ch.noseryoung.advanceduekm335.objects.SpaceShip;


public class GameScreen implements Screen {
    private SpriteBatch batch;
    private final Texture bgTexture;
    private Sprite bgSprite;
    private ch.noseryoung.advanceduekm335.objects.SpaceShip spaceShip;
    private ch.noseryoung.advanceduekm335.objects.Asteroid aestorid;
    private ch.noseryoung.advanceduekm335.objects.Explosion explosion;

    private ch.noseryoung.advanceduekm335.objects.Asteroid aestorid1;
    private ch.noseryoung.advanceduekm335.objects.Asteroid aestorid2;
    private ch.noseryoung.advanceduekm335.objects.Asteroid aestorid3;

    public GameScreen(Game parent){
        batch = new SpriteBatch();
        bgTexture = new Texture("background.png");
        bgSprite = new Sprite(bgTexture);
        spaceShip = new SpaceShip();
        aestorid = new ch.noseryoung.advanceduekm335.objects.Asteroid();
        explosion = new Explosion();

        aestorid1 = new ch.noseryoung.advanceduekm335.objects.Asteroid();
        aestorid2 = new ch.noseryoung.advanceduekm335.objects.Asteroid();
        aestorid3 = new Asteroid();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        bgSprite.draw(batch);
        batch.end();

        spaceShip.render(batch);
        aestorid.render(batch);
        explosion.render(batch, spaceShip);

        aestorid1.render(batch);
        aestorid2.render(batch);
        aestorid3.render(batch);

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        spaceShip.dispose();
        batch.dispose();
    }
}
