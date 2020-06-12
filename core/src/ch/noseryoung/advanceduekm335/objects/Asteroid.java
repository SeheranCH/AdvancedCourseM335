package ch.noseryoung.advanceduekm335.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Asteroid extends Rectangle {

    private SpriteBatch batch;
    private Sprite sprite;
    private final Texture img;
    Random r = new Random();
    int min = 0;
    int max = Gdx.graphics.getHeight();
    int resultX;
    int resultY;

    public Asteroid(){
        batch = new SpriteBatch();
        img = new Texture("asteroid.png");
        sprite = new Sprite(img);
        resultY = r.nextInt(max-min) + min;
    }

    public void render(SpriteBatch batch){
        resultX = (int) (Gdx.graphics.getWidth() - sprite.getWidth());

        sprite.setPosition(resultX, resultY);

        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public void dispose() {
        img.dispose();
        batch.dispose();
    }
}
