package Models.Empresas;

/**
 * Created by Usuário on 24/06/2016.
 */
public class AprovacaoComVaga
{
    private Vaga Vaga;
    private AprovacaoVaga Aprovacao;

    public AprovacaoComVaga()
    {}

    public Models.Empresas.Vaga getVaga()
    {
        return Vaga;
    }

    public void setVaga(Models.Empresas.Vaga vaga)
    {
        Vaga = vaga;
    }

    public AprovacaoVaga getAprovacao()
    {
        return Aprovacao;
    }

    public void setAprovacao(AprovacaoVaga aprovacao)
    {
        Aprovacao = aprovacao;
    }
}
