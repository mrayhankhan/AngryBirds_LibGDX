package com.angrybird1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

//menu screen of the game
public class MainMenuScreen extends ScreenAdapter {
    Stage stage ;
    private Viewport viewport;
    private AssetManager assetManager;
    private Skin skin;
    private Table mainTable;
    private Texture bgImage;
    private Main main;
    //constructor
    public MainMenuScreen(AssetManager assetManager, Main main) {
        this.assetManager = assetManager;
        skin = assetManager.get(Assets.SKIN);
        bgImage = new Texture("home.png");
        this.main = main;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Main.spriteBatch.begin();
        Main.spriteBatch.draw(bgImage,0,0,1920,1080);
        Main.spriteBatch.end();

        stage.act() ;
        stage.draw();
    }

    @Override
    public void show() {


        viewport = new ExtendViewport(1280, 720);
        stage = new Stage(viewport);
        mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);
        //adding button to the main menu play (when clicked level screen appears )
        //settings button
        //option
        //quits (exit the game)

        addButton("play").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                main.setScreen(new levelclass(main, skin));  // Pass 'skin' here
            }
        });
        addButton("setting ");
        addButton("options");
        addButton("Quit").addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("quit");//message is printed quit
                Gdx.app.exit();
            }
        });


        Gdx.input.setInputProcessor(stage);

    }
    private TextButton addButton(String name ){//creates the button
        TextButton button= new TextButton(name,skin);
        mainTable.add(button).width(300).height(80).fillX().padBottom(10);
        mainTable.row();
        return button;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);

    }
}
