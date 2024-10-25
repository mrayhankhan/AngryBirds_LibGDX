package com.angrybird1;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    private AssetManager assetManager = new AssetManager();
    public Skin buttonSKin;
    public static final AssetDescriptor<TextureAtlas> FILESET01 = new AssetDescriptor<>("skins/freezing/freezingui/freezing-ui.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Skin> SKIN = new AssetDescriptor<Skin>("skins/freezing/freezingui/freezing-ui.json", Skin.class, new SkinLoader.SkinParameter("skins/freezing/freezingui/freezing-ui.atlas"));

    public void loadAll() {
        assetManager.load(FILESET01);
        assetManager.load(FILESET01);
        assetManager.load(SKIN);
        assetManager.load("background.png", Texture.class);
        assetManager.load("bird.png", Texture.class);
        assetManager.load("block.png", Texture.class);
        assetManager.load("pig.png", Texture.class);
        assetManager.finishLoading();
    }

    public AssetManager getAssetManager() {
        return assetManager;

    }

    public boolean update() {
        return assetManager.update();
    }

    public float getProgress() {
        return assetManager.getProgress();
    }

    public void dispose() {
        assetManager.dispose();
    }
}
