package ch.noseryoung.advanceduekm335;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AdvancedCourseM335 extends ApplicationAdapter {
	SpriteBatch batch;
	SpaceShip spaceShip;
	Texture img;
	Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		spaceShip = new SpaceShip();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		spaceShip.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
