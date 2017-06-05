package com.mygdx.game.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.tetris.IActivityRequestHandler;
import com.mygdx.game.tetris.MyGdxGame;

public class DesktopLauncher implements IActivityRequestHandler {
	public static void main (String[] arg) {
		DesktopLauncher desk = new DesktopLauncher();
	}
	DesktopLauncher()
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 500;
		config.height = 700;
		new LwjglApplication(new MyGdxGame(this), config);
	}


	@Override
	public boolean getSignedInGPGS() {
		return false;
	}

	@Override
	public void loginGPGS() {

	}

	@Override
	public void submitScoreGPGS(int score) {

	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {

	}

	@Override
	public void getLeaderboardGPGS() {

	}

	@Override
	public void getAchievementsGPGS() {

	}
}
