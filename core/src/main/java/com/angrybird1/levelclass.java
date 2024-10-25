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
//multiple level is shown after the menu screen play button is clicked,three level of difficulty is define easy medium hard
//all three difficulty has three level
public class levelclass implements Screen {
    private Texture backgroundImage;
    private Main main;
    private Stage stage;
    private Skin skin;
//difficulty levels are define
    private static final String[] DIFFICULTY_LEVELS = {"Easy", "Medium", "Hard"};

    public levelclass(Main main, Skin skin) {
        this.main = main;
        this.skin = skin;
        this.backgroundImage = new Texture(Gdx.files.internal("levelbackground.png"));
        this.setupStage();
        this.setupDifficultyButtons();
    }

    private void setupStage() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);
    }

    private void setupDifficultyButtons() {
        this.createBackButton(skin);
        this.createDifficultyButtons(skin);
    }//now difficulty is created
    private void createDifficultyButtons(Skin skin) {
        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

        for (String difficulty : DIFFICULTY_LEVELS) {
            final String selectedDifficulty = difficulty;
            TextButton lvlButton = new TextButton(difficulty, skin);
            lvlButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    showLevelsForDifficulty(selectedDifficulty);
                }
            });
            table.defaults().width(300.0F).height(100.0F).pad(50.0F);
            table.add(lvlButton);
            table.row();  // Move to next row after each button
        }
    }
//back button is creayted to move from level screen to main menu screen
    private void createBackButton(Skin skin) {
        TextButton backButton = new TextButton("<", skin);
        this.stage.addActor(backButton);
        backButton.setHeight(70.0F);
        backButton.setWidth(70.0F);
        backButton.setPosition(50.0F, 950.0F);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(main.mainMenuScreen);
            }
        });
    }
//each difficulty level has three level 123

    private void showLevelsForDifficulty(String difficulty) {
        stage.clear();

        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

//each levl level2 level 3 is created ,
        for (int i = 1; i <= 3; i++) {
            final int lvlNum = i;
            TextButton lvlButton = new TextButton("Level " + i, skin);
            lvlButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    startLevel(difficulty, lvlNum);
                }
            });
            table.defaults().width(150.0F).height(100.0F).pad(50.0F);
            table.add(lvlButton);
            table.row();
        }

//back is created to ge from level screen to difficukty level screen
        TextButton backButton = new TextButton("<", skin);
        backButton.setHeight(70.0F);
        backButton.setWidth(70.0F);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.clear();
                setupDifficultyButtons();
            }
        });
        stage.addActor(backButton);
    }

    public void startLevel(String difficulty, int lvlNum) {
        if (difficulty.equals("Easy") && lvlNum == 1) {
            main.setScreen(new gameScreenlevel(main));
        }
    }

    @Override
    public void show() {}
    @Override
    public void render(float v) {
        Gdx.gl.glClear(16384);
        this.main.spriteBatch.begin();
        this.main.spriteBatch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.main.spriteBatch.end();
        this.stage.act();
        this.stage.draw();
    }

    @Override
    public void resize(int i, int i1) {}

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
