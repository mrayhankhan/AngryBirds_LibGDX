package com.angrybird1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import java.time.Duration;
import java.time.LocalTime;
//angry bird game entry point
public class Main extends Game {
    private final static Assets assets = new Assets();
    MainMenuScreen mainMenuScreen;//main menu screen
    gamescreen gameScreen;//gamescreen
    public static SpriteBatch spriteBatch;
    private LocalTime startTime;
    private boolean isGameScreenActive;



    @Override
    public void create() {
        Assets assets = new Assets();
        assets.loadAll();
        assets.getAssetManager().finishLoading();

        Skin skin = assets.getAssetManager().get(Assets.SKIN);  // Get skin

        levelclass levelScreen = new levelclass(this, skin);  // Pass skin to levelclass
        setScreen(levelScreen);
        spriteBatch = new SpriteBatch();
        assets.loadAll();
        assets.getAssetManager().finishLoading();
        gameScreen = new gamescreen();  // Pass assets to game screen
        mainMenuScreen = new MainMenuScreen(assets.getAssetManager(), this);  // Pass AssetManager to MainMenuScreen
        setScreen(gameScreen);
        startTime = LocalTime.now();
        isGameScreenActive = true;

    }

    @Override
    public void render() {
        Duration timeElapsed = Duration.between(startTime, LocalTime.now());

        if (timeElapsed.getSeconds() > 5 && isGameScreenActive) {
            setScreen(mainMenuScreen);
            isGameScreenActive = false;
        }
        super.render();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        gameScreen.dispose();
        mainMenuScreen.dispose();
    }

    public Assets getAssets(){
        return assets;
    }
}
