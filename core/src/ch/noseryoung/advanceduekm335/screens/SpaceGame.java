package ch.noseryoung.advanceduekm335.screens;

import com.badlogic.gdx.Game;


public class SpaceGame extends Game {

    @Override
    public void create() {
        setScreen(new MainMenuScreen(this));
    }
}
