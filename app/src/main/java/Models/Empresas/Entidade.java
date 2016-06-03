package Models.Empresas;

/**
 * Created by enzo on 02/06/2016.
 */
public class Entidade
{
    private String UniqueId;
    private boolean Ativo;

    public Entidade()
    {

    }

    public String getUniqueId()
    {
        return UniqueId;
    }

    public void setUniqueId(String uniqueId)
    {
        UniqueId = uniqueId;
    }

    public boolean isAtivo()
    {
        return Ativo;
    }

    public void setAtivo(boolean ativo)
    {
        Ativo = ativo;
    }
}
