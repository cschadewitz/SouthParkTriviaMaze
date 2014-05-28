package southparktriviamaze;

public class Location {
	private int column;
	private int row;
	public Location(int row, int column)
	{
		this.column = column;
		this.row = row;
	}
	public int getColumn()
	{
		return column;
	}
	public int getRow()
	{
		return row;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
	public void setColumn(int column)
	{
		this.column = column;
	}
	public Location convertToCondensed()
	{
		Location temp = new Location(
		this.row/2, this.column/2);
		return temp;
	}
	public Location add(Location vectorEndPoint)
	{
		Location temp = new Location( 
				this.row + vectorEndPoint.row,
				this.column + vectorEndPoint.column
		);
		return temp;
	}
	public Location neighbor(Direction direction)
	{
		return this.add(Location.vector(direction));
	}
	private static Location vector(Direction direction)
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
	
	private static Location vectorZero()
	{
		return new Location(0, 0); 
	}
	
}
