package br.com.zelar.zellarempresas.Empresas;

/**
 * Created by enzo on 21/09/2016.
 */
public class VagaEtapa extends Entidade
{
    private String NomeEtapa;
    private String IdVaga;
    private String IdAvaliacao;
    private int MaxCandidatos;
    private int MinCandidatos;
    private String Tipo;
    private int Ordem;
    private int QtdeCandidatos;
    private int QtdAprovados;
    private int QtdNaoAvaliados;
    private int QtdReprovados;


    public String getNomeEtapa()
    {
        return NomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa)
    {
        NomeEtapa = nomeEtapa;
    }

    public String getIdVaga()
    {
        return IdVaga;
    }

    public void setIdVaga(String idVaga)
    {
        IdVaga = idVaga;
    }

    public String getIdAvaliacao()
    {
        return IdAvaliacao;
    }

    public void setIdAvaliacao(String idAvaliacao)
    {
        IdAvaliacao = idAvaliacao;
    }

    public int getMaxCandidatos()
    {
        return MaxCandidatos;
    }

    public void setMaxCandidatos(int maxCandidatos)
    {
        MaxCandidatos = maxCandidatos;
    }

    public int getMinCandidatos()
    {
        return MinCandidatos;
    }

    public void setMinCandidatos(int minCandidatos)
    {
        MinCandidatos = minCandidatos;
    }

    public String getTipo()
    {
        return Tipo;
    }

    public void setTipo(String tipo)
    {
        Tipo = tipo;
    }

    public int getOrdem()
    {
        return Ordem;
    }

    public void setOrdem(int ordem)
    {
        Ordem = ordem;
    }

    public int getQtdeCandidatos()
    {
        return QtdeCandidatos;
    }

    public void setQtdeCandidatos(int qtdeCandidatos)
    {
        QtdeCandidatos = qtdeCandidatos;
    }

    public int getQtdAprovados()
    {
        return QtdAprovados;
    }

    public void setQtdAprovados(int qtdAprovados)
    {
        QtdAprovados = qtdAprovados;
    }

    public int getQtdNaoAvaliados()
    {
        return QtdNaoAvaliados;
    }

    public void setQtdNaoAvaliados(int qtdNaoAvaliados)
    {
        QtdNaoAvaliados = qtdNaoAvaliados;
    }

    public int getQtdReprovados()
    {
        return QtdReprovados;
    }

    public void setQtdReprovados(int qtdReprovados)
    {
        QtdReprovados = qtdReprovados;
    }
}
