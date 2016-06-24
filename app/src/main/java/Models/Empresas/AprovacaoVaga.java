package Models.Empresas;

/**
 * Created by Usuário on 24/06/2016.
 */
public class AprovacaoVaga extends Entidade
{
    private String IdVaga;
    private String IdResponsavel;
    private String EmailResposavel;
    private String IdPosterior;
    private String EmailPosterior;
    private int Indice;
    private boolean Aprovado;
    private String DataAprovacao;
    private String IdEmpresa;

    public AprovacaoVaga()
    {}


    public String getIdVaga()
    {
        return IdVaga;
    }

    public void setIdVaga(String idVaga)
    {
        IdVaga = idVaga;
    }

    public String getIdResponsavel()
    {
        return IdResponsavel;
    }

    public void setIdResponsavel(String idResponsavel)
    {
        IdResponsavel = idResponsavel;
    }

    public String getEmailResposavel()
    {
        return EmailResposavel;
    }

    public void setEmailResposavel(String emailResposavel)
    {
        EmailResposavel = emailResposavel;
    }

    public String getIdPosterior()
    {
        return IdPosterior;
    }

    public void setIdPosterior(String idPosterior)
    {
        IdPosterior = idPosterior;
    }

    public String getEmailPosterior()
    {
        return EmailPosterior;
    }

    public void setEmailPosterior(String emailPosterior)
    {
        EmailPosterior = emailPosterior;
    }

    public int getIndice()
    {
        return Indice;
    }

    public void setIndice(int indice)
    {
        Indice = indice;
    }

    public boolean isAprovado()
    {
        return Aprovado;
    }

    public void setAprovado(boolean aprovado)
    {
        Aprovado = aprovado;
    }

    public String getDataAprovacao()
    {
        return DataAprovacao;
    }

    public void setDataAprovacao(String dataAprovacao)
    {
        DataAprovacao = dataAprovacao;
    }

    public String getIdEmpresa()
    {
        return IdEmpresa;
    }

    public void setIdEmpresa(String idEmpresa)
    {
        IdEmpresa = idEmpresa;
    }
}
