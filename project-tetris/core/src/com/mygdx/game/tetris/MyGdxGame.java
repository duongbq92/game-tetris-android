package com.mygdx.game.tetris;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame implements ApplicationListener
{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;

	private GameScreen screen;
	public static IActivityRequestHandler iActivityRequestHandler;
	static boolean restart;
	public MyGdxGame(IActivityRequestHandler iActivityRequestHandler)
	{
		this.iActivityRequestHandler = iActivityRequestHandler;
	}

	public static void Restart()
	{
		restart = true;
	}
	@Override
	public void create()
	{
		//int w = Gdx.graphics.getWidth();
	//	int h = Gdx.graphics.getHeight();
		int w = 480;
		int h = 800;
		screen = new GameScreen(w, h);

		camera = new OrthographicCamera(w, h);
		camera.setToOrtho(true,w, h);
		batch = new SpriteBatch();
		restart = false;
		/*
		 * texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		 * texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		 * 
		 * TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		 * 
		 * sprite = new Sprite(region); sprite.setSize(0.9f, 0.9f *
		 * sprite.getHeight() / sprite.getWidth());
		 * sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		 * sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		 */
	}

	@Override
	public void dispose()
	{
		// batch.dispose();
		// texture.dispose();
		batch.dispose();
		screen.Dispose();
	}

	@Override
	public void render()
	{
		if (!restart) {
			Gdx.gl.glClearColor(156 / 255.0f, 178 / 255.0f, 165 / 255.0f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.setProjectionMatrix(camera.combined);
			screen.Update();
			batch.begin();
			screen.Draw(batch);
			batch.end();
		}

		if (restart)
		{

			create();
		}
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
