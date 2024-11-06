package kwinta.gringotts.exceptions;

public class GringottsException extends RuntimeException
{
    private String errMsg;

    public GringottsException()
    {
        this.errMsg = "generic";
    }

    public GringottsException(String errMsg)
    {
        this.errMsg = errMsg;
    }

    @Override
    public String getMessage()
    {
        return errMsg;
    }
}