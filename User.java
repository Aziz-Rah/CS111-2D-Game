import java.awt.event.*;
public class User implements KeyListener{
	private Sprite user;
	private boolean up, down, left, right;
	
	public User(Sprite user, Animation movie){

		this.user = user;
		movie.addKeyListener(this);
		up = down = left = right = false;
	}

	public void keyTyped(KeyEvent e){}


	public void keyPressed(KeyEvent e){

		if (e.getKeyCode() == KeyEvent.VK_DOWN){			
			down = true;	
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
			up = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			left = true;
	}

	public void keyReleased(KeyEvent e){ 

		if (e.getKeyCode() == KeyEvent.VK_DOWN){			
			down = false;	
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
			up = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			left = false;
	}

	public void update(){

		if (up)
			user.adjustPosition(0,1);
		if (down)
			user.adjustPosition(0,-1);
		if (right)
			user.adjustPosition(1,0);
		if (left)
			user.adjustPosition(-1,0);
	}
}