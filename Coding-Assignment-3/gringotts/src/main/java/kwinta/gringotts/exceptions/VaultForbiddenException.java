package kwinta.gringotts.exceptions;

public class VaultForbiddenException extends GringottsException
{
    private String errMsg;

    public VaultForbiddenException()
    {
        this.errMsg = "vault-forbidden";
    }
}