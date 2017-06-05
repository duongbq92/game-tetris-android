package com.mygdx.game.tetris;

public class BrickType1 extends Brick
{
	private static int[][] a = { { 0, 1, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { 0, 1, 0, 0 } };

	private static int[][] b = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 1, 1, 1, 1 }, { 0, 0, 0, 0 } };

	public BrickType1()
	{
		super(2);
		this.array[0] = a;
		this.array[1] = b;

	}

	@Override
	public Brick Clone()
	{
		return new BrickType1();
	}

}
