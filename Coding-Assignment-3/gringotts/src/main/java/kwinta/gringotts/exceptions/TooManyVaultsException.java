package kwinta.gringotts.exceptions;

public class TooManyVaultsException extends GringottsException
{
    private String errMsg;

    public TooManyVaultsException()
    {
        this.errMsg = "too-many-vaults";
    }
}