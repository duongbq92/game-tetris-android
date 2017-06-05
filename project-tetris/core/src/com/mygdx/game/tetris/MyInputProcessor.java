package com.mygdx.game.tetris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor
{
	IKeyDownOneTime KeyDownOneTime;

	public boolean IsKeyDown = false;
	public int CurrentKeyDownCode;
	int lastTouchScreenX;
	int lastTouchScreenY;
	boolean isDragging = false;
	@Override
	public boolean keyDown(int keycode)
	{
		IsKeyDown = true;
		CurrentKeyDownCode = keycode;
		if (KeyDownOneTime != null)
		{
			KeyDownOneTime.KeyDownOneTimeHandler();
		}

		System.out.println("keycode = " + keycode);
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		if (keycode == this.CurrentKeyDownCode)
		{
			// mean up the same key
			IsKeyDown = false;
		}

		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		if (!isDragging) {
			CurrentKeyDownCode = Input.Keys.UP;
			if (KeyDownOneTime != null) {
				KeyDownOneTime.KeyDownOneTimeHandler();
			}
		}
		isDragging = false;
		IsKeyDown = false;
		return false;
	}

	//int count =0;
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		//count++;
		//if (count%2==0) {


			Gdx.app.log("DEBUG - mouseMoved: ", "screenX " + screenX + ", screenY " + screenY);
			// TODO Auto-generated method stub
			if (screenY - lastTouchScreenY > 5) {
				IsKeyDown = true;
				CurrentKeyDownCode = Input.Keys.DOWN;
				isDragging = true;
			} else if (screenX - lastTouchScreenX > 2) {
				IsKeyDown = true;
				CurrentKeyDownCode = Input.Keys.RIGHT;
				isDragging = true;
			} else if (screenX - lastTouchScreenX < -2) {
				IsKeyDown = true;
				CurrentKeyDownCode = Input.Keys.LEFT;
				isDragging = true;
			}else
			{
				isDragging = false;
				IsKeyDown = false;
			}

			lastTouchScreenX = screenX;
			lastTouchScreenY = screenY;
		//}else
		//{
			//IsKeyDown = false;
		//}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub

		return false;
	}

}

interface IKeyDownOneTime
{
	public void KeyDownOneTimeHandler();
}
