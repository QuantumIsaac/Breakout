package steve.breakout.gui;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

import steve.breakout.specs.*;
import steve.breakout.game.*;

public class GameCanvas extends JComponent{
	private static final int HUD_WIDTH = 90;
	private static final int HUD_HEIGHT = 40;
	private Game g;
	public GameCanvas(Game g){
		this.g = g;
	}
	public void setGame( Game gm ){
		g = gm;
	}
	@Override
	public void paintComponent(Graphics grfx){
		grfx.setColor(Color.WHITE);
		Paddle p = g.getPaddle();
		Ball b = g.getBall();
		
		for(Powerup pow : g.getCuedPower()){
			g.getPowers().remove(pow);
		}
		for(Powerup pow : g.getPowers()){
			pow.paint(grfx);
		}
		
		grfx.setColor(Color.GRAY);
		int x = getWidth() - (HUD_WIDTH + 10);
		int y = getHeight() - (HUD_HEIGHT + 10);
		grfx.fillRect(x,y,HUD_WIDTH,HUD_HEIGHT);
		grfx.setColor(Color.WHITE);
		grfx.drawString("Balls: "+String.valueOf(g.getBalls()),x + 10, y + 25);
		
		p.paint(grfx);
		b.paint(grfx);
		
		for( Brick br : g.getCued() ){
			g.getBricks().remove(br);
		}
		for( Brick br : g.getBricks() ){
			br.paint(grfx);
		}
	}
}
