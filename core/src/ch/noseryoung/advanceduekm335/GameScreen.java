package ch.noseryoung.advanceduekm335;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Sprite sprite;
    private final Texture img;
    private final Texture bgTexture;
    private Sprite bgSprite;
    private SpaceShip spaceShip;

    public boolean touched = false;

    public GameScreen(Game parent){
        batch = new SpriteBatch();
        img = new Texture("spaceshipEdited.png");
        sprite = new Sprite(img);
        bgTexture = new Texture("background.png");
        bgSprite = new Sprite(bgTexture);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isTouched()) {
            float sizeWidth = sprite.getHeight();
            sprite.setY(Gdx.graphics.getHeight() - Gdx.input.getY() - sizeWidth);
        }

        batch.begin();
        bgSprite.draw(batch);
        sprite.draw(batch);
        batch.end();

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
        img.dispose();
        batch.dispose();
    }
}
