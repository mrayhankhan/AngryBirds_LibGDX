package com.angrybird1;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
//decoy pig
public class Decoypig {
    private Texture texture;
    private float x, y, width, height;


    public Decoypig(float x, float y, float width, float height) {
        texture = new Texture(Gdx.files.internal("decoy.png"));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }


    public void dispose() {
        texture.dispose();
    }
}


