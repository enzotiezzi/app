package Models.Empresas;

import DataType.Guid;

/**
 * Created by enzo on 02/06/2016.
 */
public class Entidade
{
    private Guid UniqueId;
    private boolean Ativo;

    public Entidade()
    {

    }

    public Guid getUniqueId()
    {
        return UniqueId;
    }

    public void setUniqueId(Guid uniqueId)
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
