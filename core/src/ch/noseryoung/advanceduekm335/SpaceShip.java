package ch.noseryoung.advanceduekm335;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class SpaceShip extends Rectangle {

    private SpriteBatch batch;
    private Sprite sprite;
    private final Texture img;

    public SpaceShip(Game parent){
        batch = new SpriteBatch();
        img = new Texture("spaceshipEdited.png");
        sprite = new Sprite(img);
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Sprite getSprite() {
        return sprite;
    }


    public Texture getImg() {
        return img;
    }
}
