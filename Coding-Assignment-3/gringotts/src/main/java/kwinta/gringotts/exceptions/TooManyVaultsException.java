package kwinta.gringotts.exceptions;

public class TooManyVaultsException extends RuntimeException
{
    private String errMsg;

    public TooManyVaultsException()
    {
    }

    @Override
    public String getMessage()
    {
        return "too-many-vaults";
    }
}