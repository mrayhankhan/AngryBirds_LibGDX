package com.angrybird1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
//main gamescree , when level 1 is clicked this screen appears
public class gameScreenlevel implements Screen {
    private Main main;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture background;
    private Blackbird blackbird;
    private Bluebird bluebird;
    private Bird bird;
    private Pig pig;
    private Kingpig kingpig;
    private Block[] blocks;
    private Mustachepig mustachepig;
    private Helmetpig helmetpig;
    private Yellowbird yellowbird;
    private Whitebird whitebird;
    private Steelblock[] steelblock;
    private Woodenblock[] woodenblock;
    private Iceblock[] iceblock;
    private Eagle eagle;
    private Orangebird orangebird;
    private Pigengineer pigengineer;
    private Decoypig decoypig;
    private Stage stage;
    private Skin skin;

    public gameScreenlevel(Main main) {
        this.main = main;
        ScreenViewport viewport = new ScreenViewport();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 3080, 2000);
        viewport.setCamera(camera);
        batch = new SpriteBatch();
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skins/freezing/freezingui/freezing-ui.json"));
        //buttons are  created ,
        Table table = new Table();
        table.setFillParent(true);
        table.bottom().right();
        stage.addActor(table);
        //win button created , when clicked win screen appeared with next level button .
        TextButton winButton = new TextButton("win", skin);
        winButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new WinningScreen(main, skin));
            }
        });
        //lose button created ,when clicked lose screen appear with retry button
        TextButton loseButton = new TextButton("lose", skin);
        loseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new Losescreen(main, skin));
            }
        });
        table.add(loseButton).width(80).height(80).padRight(10);
        table.add(winButton).width(80).height(80);
        //all the components are define that are in uml

        background = new Texture(Gdx.files.internal("background.png"));
        //bird component=
        bird = new Bird(75, 100, 300, 300);
        blackbird =new Blackbird(450,100,100,100);
        bluebird =new Bluebird(550,100,100,100);
        whitebird=new Whitebird(350,100,100,100);
        yellowbird=new Yellowbird(650,100,100,100);
        eagle=new Eagle(750,100,100,100);
        orangebird=new Orangebird(850 ,100,100,100);

        //pig component=


        pig = new Pig(1400, 250, 100, 100);
        pigengineer=new Pigengineer(1800,150,100,100);
        kingpig = new Kingpig(1500, 350, 100, 100);
        mustachepig = new Mustachepig(1700, 150, 100, 100);
        helmetpig = new Helmetpig(1600, 450, 100, 100);
        decoypig = new Decoypig(1400, 450, 100, 100);

        //block components,
        blocks = new Block[] {
            new Block(1400, 150, 100, 100),
            new Block(1500, 150, 100, 100),
            new Block(1500, 250, 100, 100),

            new Block(1300, 250, 100, 100),
            new Block(1400, 350, 100, 100)

        };
        steelblock = new Steelblock[] {
            new Steelblock(1600, 150, 100, 100),
            new Steelblock(1700, 250, 100, 100),

        };
        woodenblock = new Woodenblock[] {
            new Woodenblock(1600, 250, 100, 100),
            new Woodenblock(1300, 150, 100, 100)
        };
        iceblock = new Iceblock[] {
            new Iceblock(1600, 350, 100, 100),
            new Iceblock(1500, 450, 100, 100)
        };

    }

    @Override//render the screen
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, 1920,1080);
        bird.render(batch);
        blackbird.render(batch);
        bluebird.render(batch);
        kingpig.render(batch);
        pigengineer.render(batch);
        decoypig.render(batch);
        mustachepig.render(batch);
        helmetpig.render(batch);
        whitebird.render(batch);
        yellowbird.render(batch);
        for (Steelblock steelblock : steelblock) {
            steelblock.render(batch);
        }
        for (Iceblock iceblock : iceblock) {
            iceblock.render(batch);
        }
        for (Woodenblock woodenblock : woodenblock) {
            woodenblock.render(batch);
        }
        eagle.render(batch);
        orangebird.render(batch);

        pig.render(batch);
        for (Block block : blocks) {
            block.render(batch);
        }
        batch.end();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
        stage.getViewport().update(width, height, true);
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void dispose() {
        background.dispose();
        bird.dispose();
        pig.dispose();
        blackbird.dispose();
        yellowbird.dispose();
        whitebird.dispose();
        bluebird.dispose();
        kingpig.dispose();
        decoypig.dispose();
        mustachepig.dispose();
        helmetpig.dispose();
        pigengineer.dispose();
        for (Steelblock steelblock : steelblock) steelblock.dispose();
        for (Iceblock iceblock : iceblock) iceblock.dispose();
        for (Woodenblock woodenblock : woodenblock)
            woodenblock.dispose();
        eagle.dispose();
        orangebird.dispose();
        for (Block block : blocks) block.dispose();
        batch.dispose();
    }

    @Override
    public void show() {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
}
