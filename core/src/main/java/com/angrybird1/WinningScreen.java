package com.angrybird1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
//when win button is clicked in the gamescreen this screen appear
//next level button
public class WinningScreen implements Screen {
    private Main main;
    private Stage stage;
    private Skin skin;
    private Texture winBackground;

    public WinningScreen(Main main, Skin skin) {
        this.main = main;
        this.skin = skin;

        winBackground = new Texture(Gdx.files.internal("winningscreen.png"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
//next levl button is created
        TextButton nextLevelButton = new TextButton("Next Level", skin);
        nextLevelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                main.setScreen(new gameScreenlevel(main));
            }
        });
        table.add(nextLevelButton).width(200).height(50).pad(10);
    }

    @Override
    public void show() {}
    @Override
    public void render(float delta) {
        // Render the winning background
        main.spriteBatch.begin();
        main.spriteBatch.draw(winBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.spriteBatch.end();

        stage.act(delta);
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}


    @Override
    public void hide() {}

    @Override
    public void dispose() {

        }
    }

