package com.angrybird1;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
//its more health than the regular pig
public class Helmetpig {
    private Texture texture;
    private float x, y, width, height;
    public Helmetpig(float x, float y, float width, float height) {
        texture = new Texture(Gdx.files.internal("helmetpig.png"));
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



