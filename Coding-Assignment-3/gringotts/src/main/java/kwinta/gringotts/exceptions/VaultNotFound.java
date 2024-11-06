package kwinta.gringotts.exceptions;

public class VaultNotFound extends GringottsException
{
    private String errMsg;

    public VaultNotFound()
    {
        this.errMsg = "vault-not-found";
    }
}