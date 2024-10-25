package com.angrybird1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
//its the home screen with loading bar
public class gamescreen implements Screen {
    //screen
    private Camera camera;
    private Viewport viewport;
    // graphics
    private SpriteBatch batch;
    private Texture background;
    private ShapeRenderer shapeRenderer;
    //timing
    private int backgroundOffset;
    //bar
    private float loadingProgress;
    //world parameters
    private final int WORLD_WIDTH=1200;
    private final int WORLD_HEIGHT=1000;
    //constructor o game screen class
    gamescreen(){
        camera= new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera);
        camera.position.set(WORLD_WIDTH / 2f, WORLD_HEIGHT / 2f, 0);
        camera.update();

        background = new Texture(Gdx.files.internal("ang1.png"));

        backgroundOffset = 0;
        batch = new SpriteBatch() ;
        shapeRenderer = new ShapeRenderer();

    }


    @Override
    public void show() {


    }

    @Override
    public void render(float deltaTime) {
        //render background
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        batch.end();
        //loading bar
        loadingProgress += deltaTime * 0.1f;
        if (loadingProgress > 1.0f) {
            loadingProgress = 1.0f;
        }
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //background of loading bar color white
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect((WORLD_WIDTH - 400) / 2, 50, 400, 20);
        //gold color shows how much loading is done
        shapeRenderer.setColor(Color.GOLD);

        shapeRenderer.rect((WORLD_WIDTH - 400) / 2, 50, 400 * loadingProgress, 20);

        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        batch.setProjectionMatrix(camera.combined);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {

    }
}
