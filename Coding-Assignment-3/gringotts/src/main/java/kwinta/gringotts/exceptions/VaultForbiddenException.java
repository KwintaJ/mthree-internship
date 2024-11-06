package kwinta.gringotts.exceptions;

public class VaultForbiddenException extends GringottsException
{
    private String errMsg;

    public VaultForbiddenException()
    {
        this.errMsg = "vault-forbidden";
    }

    @Override
    public String getMessage()
    {
        return errMsg;
    }
}