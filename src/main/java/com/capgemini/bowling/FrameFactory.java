package com.capgemini.bowling;

public class FrameFactory {
	public static Frame getBowlingGameFrame(Integer numberOfFrame) {
		
		if (numberOfFrame.equals(Integer.valueOf(10))) {
			return new LastFrame();
		}
		return new StandardFrame();
	}
}
