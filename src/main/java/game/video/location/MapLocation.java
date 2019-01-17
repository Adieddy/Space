package game.video.location;

import java.io.Serializable;

/**
 * This class would tell us the location in the game map.
 */
public class MapLocation implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The x. */
	private Integer X;
	
	/** The y. */
	private Integer Y;
	
	/**
	 * Instantiates a new map location.
	 *
	 * @param X the x
	 * @param Y the y
	 */
	public MapLocation(Integer X, Integer Y) {
		this.X = X;
		this.Y = Y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public Integer getX() {
		return X;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public Integer getY() {
		return Y;
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(X.toString()+Y.toString());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		MapLocation location = (MapLocation)obj;
		if(this.getX()==null && this.getY()==null) {
			return false;
		}
		else {
			if(X.equals(location.X) && Y.equals(location.Y)) {
				return true;
			}
			return false;
		}
	}
}
