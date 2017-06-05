package com.mygdx.game.tetris;

/**
 * Created by INNOVATION on 5/9/2015.
 */
public interface IActivityRequestHandler
{
	public boolean getSignedInGPGS();
	public void loginGPGS();
	public void submitScoreGPGS(int score);
	public void unlockAchievementGPGS(String achievementId);
	public void getLeaderboardGPGS();
	public void getAchievementsGPGS();
}
