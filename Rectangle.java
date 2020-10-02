public class Rectangle{
	private int x;
	private int y;
	private int h;
	private int w;

	public Rectangle(int x, int y, int w, int h){

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public boolean contains(int x, int y){

		if ((this.x <= x && this.x + w >= x) && (y <= this.y && y >= this.y - h))
			return true;
		else
			return false;
	}
}