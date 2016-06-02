package DataType;

/**
 * Created by enzo on 02/06/2016.
 */
public class Guid
{
    private String guid;

    public Guid(String guid)
    {
        this.guid = guid;
    }

    @Override
    public String toString()
    {
        return this.guid;
    }
}
