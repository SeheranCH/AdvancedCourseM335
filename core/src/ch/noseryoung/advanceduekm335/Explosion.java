package ch.noseryoung.advanceduekm335;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;

public class Explosion extends Rectangle {

    private SpriteBatch batch;
    private Sprite sprite;
    private final Texture img;
    private TextureRegion[][] regions;
    private int frame = 0;
    private int line = 0;
    //private Texture spaceship = new Texture("spaceshipEdited.png");

    public Explosion() {
        batch = new SpriteBatch();
        img = new Texture("explosion.png");
        regions = TextureRegion.split(img, 128, 128);
        sprite = new Sprite(regions[0][0]);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                frame++;
                if(frame > 16){
                    frame = 0;
                }
                sprite.setRegion(regions[line][frame]);
            }
        }, 0, 1/20f);
    }

    public void render(SpriteBatch batch, SpaceShip spaceship){

        if (Gdx.input.isTouched()) {
            //float sizeWidth = sprite.getHeight();
            Sprite spriteSpaceship = spaceship.getSprite();
            sprite.setX(spaceship.getWidth() + 200);
            sprite.setY(spaceship.getHeight()/2);

            batch.begin();
            sprite.draw(batch);
            batch.end();
        }
    }

    public void dispose() {
        img.dispose();
        batch.dispose();
    }
}
