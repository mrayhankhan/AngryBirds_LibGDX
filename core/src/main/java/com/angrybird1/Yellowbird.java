package com.angrybird1;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
//it incerases speed when clicked
public class Yellowbird {
    private Texture texture;
    private float x, y, width, height;
    public Yellowbird(float x, float y, float width, float height) {
        texture = new Texture(Gdx.files.internal("yellow.png"));
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
