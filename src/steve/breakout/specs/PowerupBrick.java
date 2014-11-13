package steve.breakout.specs;

import steve.breakout.game.Game;
import java.awt.Color;

public class PowerupBrick extends Brick{
	private Powerup power;
	private Game gm;
	public PowerupBrick(Color c, int x, int y, Powerup p, Game g){
		super(c, x, y);
		power = p;
		power.move(x,y);
		gm = g;
	}
	@Override
	public void loseHealth(){
		super.loseHealth();
		if( getHealth() == 0 ){
			gm.addPowerup(power);
		}
	}
}