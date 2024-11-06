package kwinta.gringotts.exceptions;

public class BadTransferException extends GringottsException
{
    private String errMsg;

    public BadTransferException(String errMsg)
    {
        this.errMsg = errMsg;
    }
}