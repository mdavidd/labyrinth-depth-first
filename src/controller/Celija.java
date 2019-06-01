/*
 * //
 */
package controller;

/**
 *
 * @author david
 */
public class Celija {
	/*
	 * Klasa Celija sadrzi informacije o celijama labirinta
	 * Svaka celija se sastoji od 4 zida, i obiljezava se dali je posjecena i dali je igrac trenutno na toj celiji
	 */
	// enum za obiljezavanje zidova
	public enum Walls {
		LEFT, RIGHT, TOP, BOTTOM
	};

        // boolean koji obiljezava dali je celija podsjecena
	private boolean visited;
        public boolean player = false;
	// boolean za crtanja zidova, obiljezava dali i koji zidovi postoje na celiji (za crtanje)
	public boolean left, right, top, bottom;
	private int x, y;

	public Celija(int x, int y) {
		this.visited = false;
		this.left = true;
		this.right = true;
		this.top = true;
		this.bottom = true;
		this.x = x;
		this.y = y;
	}

	// mice zid sa celije
	public void removeWall(Walls w) {
		switch (w) {
		case LEFT:
			this.left = false;
			break;
		case RIGHT:
			this.right = false;
			break;
		case TOP:
			this.top = false;
			break;
		case BOTTOM:
			this.bottom = false;
			break;
		}
		visited = true;
	}

	// za obiljeziti celiju kao podsjecenu
	public void mark() {
		this.visited = true;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isVisited() {
		return visited;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isBottom() {
		return bottom;
	}

	public boolean isTop() {
		return top;
	}
        
        //postavlja i mice player-a sa celije
        public void setPlayer(){
            player = true;
        }
        public boolean isPlayer(){
            return player;
        }
        public void removePlayer(){
            player = false;
        }
}
