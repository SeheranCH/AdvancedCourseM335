package ch.noseryoung.advanceduekm335;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceShip {

    Texture img;
    Sprite sprite;

    public SpaceShip() {
        img = new Texture("/../");
        sprite = new Sprite();
    }

    public void render(SpriteBatch spriteBatch) {
        if (Gdx.input.isTouched()) {
            sprite.setX(Gdx.input.getX());
            sprite.setY(Gdx.graphics.getHeight() - Gdx.input.getY());
        }
        sprite.setScale(0.5f);
        sprite.draw(spriteBatch);

    }

    public void dispose() {
        img.dispose();

    }
}
