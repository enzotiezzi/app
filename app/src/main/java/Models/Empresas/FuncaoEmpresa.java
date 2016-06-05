package Models.Empresas;

/**
 * Created by enzo on 02/06/2016.
 */
public class FuncaoEmpresa extends Entidade
{
    private String IdUsuario;
    private String IdEmpresa;
    private String NomeEmpresa;
    private String IdFuncao;
    private String NomeFuncao;
    private boolean AcaoDropdown;
    private boolean AcaoOutros;
    private int AcaoOrdem;

    public String getIdUsuario()
    {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        IdUsuario = idUsuario;
    }

    public String getIdEmpresa()
    {
        return IdEmpresa;
    }

    public void setIdEmpresa(String idEmpresa)
    {
        IdEmpresa = idEmpresa;
    }

    public String getNomeEmpresa()
    {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa)
    {
        NomeEmpresa = nomeEmpresa;
    }

    public String getIdFuncao()
    {
        return IdFuncao;
    }

    public void setIdFuncao(String idFuncao)
    {
        IdFuncao = idFuncao;
    }

    public String getNomeFuncao()
    {
        return NomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao)
    {
        NomeFuncao = nomeFuncao;
    }

    public boolean isAcaoDropdown()
    {
        return AcaoDropdown;
    }

    public void setAcaoDropdown(boolean acaoDropdown)
    {
        AcaoDropdown = acaoDropdown;
    }

    public boolean isAcaoOutros()
    {
        return AcaoOutros;
    }

    public void setAcaoOutros(boolean acaoOutros)
    {
        AcaoOutros = acaoOutros;
    }

    public int getAcaoOrdem()
    {
        return AcaoOrdem;
    }

    public void setAcaoOrdem(int acaoOrdem)
    {
        AcaoOrdem = acaoOrdem;
    }

    @Override
    public String toString()
    {
        return NomeFuncao;
    }
}