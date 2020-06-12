package ch.noseryoung.advanceduekm335.objects;

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

    private static final int SPEED = 500;
    private static final int DEFAULT_Y = 40;
    private float x, y;
    private boolean remove = false;


    public Explosion(float x) {
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

    public void update (float deltaTime) {
        y += SPEED * deltaTime;
        if(y > Gdx.graphics.getHeight())
            remove = true;
    }

    public void render(SpriteBatch batch){

            batch.begin();
            batch.draw(img, x, y);
            batch.end();

    }

    public void dispose() {
        img.dispose();
        batch.dispose();
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }
}
