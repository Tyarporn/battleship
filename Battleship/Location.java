public class Location
{
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row = row;//initializes row and columns
        this.col = col;
    }

    public int getRow()
    {
        return row;//returns row
    }

    public int getCol()
    {
        return col;//returns col
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Location && ((Location) obj).getCol() == col && ((Location) obj).getRow() == row;//checks if the object is an instance of location
    }
}
