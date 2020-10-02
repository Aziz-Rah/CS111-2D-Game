public class Movie{
	public static void main(String[] args){

		Animation movie = new Animation(500,500);
		movie.setBackgroundImage("background1.jpg");

		Sprite LLama = new Sprite("SLLama.png");
		User user = new User(LLama,movie);

		Sprite weed = new Sprite("weed.png");
		weed.setPosition(100,200);

		Sprite weed2 = new Sprite(weed);
		weed2.setPosition(100,300);

		Sprite weed3 = new Sprite(weed);
		weed3.setPosition(250,250);

		Sprite man = new Sprite("BruH.png");
		man.setPosition(150,250);

		Sprite man1 = new Sprite("BruH.png");
		man1.setPosition(150,350);

		Sprite man2 = new Sprite("BruH.png");
		man2.setPosition(350,350);

		Sprite man3 = new Sprite("BruH.png");
		man3.setPosition(350,150);

		Sprite man4 = new Sprite("BruH.png");
		man4.setPosition(150,150);

		movie.setFrameRate(120);
		movie.addSprite(LLama);
		movie.addSprite(weed);
		movie.addSprite(weed2);
		movie.addSprite(man);

		boolean w1 = false;
		boolean w2 = false;

		for (int t = 0; t <= 600; t++){
			
			if (isSame(LLama,man)){
				movie.removeSprite(LLama);
				movie.removeSprite(man);
				movie.removeSprite(weed);
				movie.removeSprite(weed2);
				movie.removeSprite(weed3);
				movie.setBackgroundImage("tombstone.jpg");
				break;
			}

			if (isSame(LLama,weed)){
				movie.removeSprite(weed);
				w1 = true;
			} 

			if (isSame(LLama,weed2)){
				movie.removeSprite(weed2);
				w2 = true;
			}

			if (w1 == true && w2 == true)
				break;

			if (t > 250 && t < 300)
				man.adjustPosition(-1,0);

			if (t >= 300 && t < 440)
				man.adjustPosition(0,1);

			if (t > 590){
				movie.removeSprite(weed);
				movie.removeSprite(weed2);
				movie.removeSprite(weed3);
				movie.removeSprite(man);
				movie.removeSprite(LLama);
				movie.setBackgroundImage("tombstone.jpg");
				break;
			}

			weed.adjustPosition(randNumber(),randNumber());
			weed2.adjustPosition(randNumber(),randNumber());
			user.update();
			movie.frameFinished();
		}

		boolean w3 = false;
		if (w1 == true && w2 == true && w3 == false){

			movie.removeSprite(man);
			movie.addSprite(man1);
			movie.addSprite(man2);
			movie.addSprite(man3);
			movie.addSprite(man4);
			movie.addSprite(weed3);
			movie.setBackgroundImage("bonus.png");

			for (int t = 0; t < 250; t++){		

				man1.adjustPosition(1,-1);
				man2.adjustPosition(-1,-1);
				man3.adjustPosition(-1,1);
				man4.adjustPosition(1,1);

				if (isSame(LLama,man1) || isSame(LLama,man2) || isSame(LLama,man3) || isSame(LLama,man4)){
					movie.removeSprite(LLama);
					movie.removeSprite(man1);
					movie.removeSprite(man2);
					movie.removeSprite(man3);
					movie.removeSprite(man4);
					movie.removeSprite(weed3);
					movie.setBackgroundImage("tombstone.jpg");
					break;
				}

				if (isSame(LLama,weed3)){
					movie.removeSprite(LLama);
					movie.removeSprite(man1);
					movie.removeSprite(man2);
					movie.removeSprite(man3);
					movie.removeSprite(man4);
					movie.removeSprite(weed3);
					movie.setBackgroundImage("winner.jpg");
					w3 = true;
					break;
				}

				weed3.adjustPosition(randNumber(),randNumber());
				user.update();
				movie.frameFinished();
			}
		}

		if (w1 == true && w2 == true && w3 == false){
			movie.removeSprite(LLama);
			movie.removeSprite(man1);
			movie.removeSprite(man2);
			movie.removeSprite(man3);
			movie.removeSprite(man4);
			movie.removeSprite(weed3);
			movie.setBackgroundImage("tombstone.jpg");
			movie.frameFinished();
		}
		movie.frameFinished();
	}

	public static boolean isSame(Sprite sprite1, Sprite sprite2){

		int x1 = sprite1.getXposition();
		int x2 = sprite2.getXposition();
		int y1 = sprite1.getYposition();
		int y2 = sprite2.getYposition();

		int w1 = sprite1.getXsize();
		int h1 = sprite1.getYsize();
		int w2 = sprite2.getXsize();
		int h2 = sprite2.getYsize();

		Rectangle r1 = new Rectangle(x1,y1,w1,h1);

		return (r1.contains(x2,y2) || r1.contains(x2 + w2,y2) || r1.contains(x2 + w2, y2 - h2) || r1.contains(x2, y2 - h2));			
	}

	public static int randNumber(){

		double r = Math.random();
		r = r - .5;
		if (r > 0)
			return 1;
		if (r < 0)
			return -1;
		if (r == 0)
			return 0;
		return 0;
	}	
}