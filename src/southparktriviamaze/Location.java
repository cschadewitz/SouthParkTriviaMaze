package southparktriviamaze;

public class Location {
	private int x;
	private int y;
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public Location convertToCondensed()
	{
		Location temp = new Location(
		this.x/2 + 1, this.y/2 + 1);
		return temp;
	}
	public Location add(Location vectorEndPoint)
	{
		Location temp = new Location(
		this.x + vectorEndPoint.x, 
		this.y + vectorEndPoint.y);
		return temp;
	}
	public Location neighbor(Direction direction)
	{
		return this.add(Location.vector(direction));
	}
	public static Location vector(Direction direction)
	{
		switch(direction)
		{
			case North: return new Location(-2, 0);						
			case East: return new Location(0, 2);
			case South: return new Location(2, 0);
			case West: return new Location(0, -2);
			default: return vectorZero();
			
		}
		
	}
	
	public static Location vectorZero()
	{
		return new Location(0, 0); 
	}
	
}
