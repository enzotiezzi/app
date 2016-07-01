package br.com.zelar.zellarempresas.Empresas;

/**
 * Created by enzo on 01/07/2016.
 */
public class RelatorioVaga
{

    private String Semana ;
    private int QtdeVagasAbertas ;
    private int QtdeVagasFechadas ;
    private double TempoMedio ;
    private int QtdeCadastros ;
    private int VagasEmAberto ;
    private int Ordem ;


    public String getSemana()
    {
        return Semana;
    }

    public void setSemana(String semana)
    {
        Semana = semana;
    }

    public int getQtdeVagasAbertas()
    {
        return QtdeVagasAbertas;
    }

    public void setQtdeVagasAbertas(int qtdeVagasAbertas)
    {
        QtdeVagasAbertas = qtdeVagasAbertas;
    }

    public int getQtdeVagasFechadas()
    {
        return QtdeVagasFechadas;
    }

    public void setQtdeVagasFechadas(int qtdeVagasFechadas)
    {
        QtdeVagasFechadas = qtdeVagasFechadas;
    }

    public double getTempoMedio()
    {
        return TempoMedio;
    }

    public void setTempoMedio(double tempoMedio)
    {
        TempoMedio = tempoMedio;
    }

    public int getQtdeCadastros()
    {
        return QtdeCadastros;
    }

    public void setQtdeCadastros(int qtdeCadastros)
    {
        QtdeCadastros = qtdeCadastros;
    }

    public int getVagasEmAberto()
    {
        return VagasEmAberto;
    }

    public void setVagasEmAberto(int vagasEmAberto)
    {
        VagasEmAberto = vagasEmAberto;
    }

    public int getOrdem()
    {
        return Ordem;
    }

    public void setOrdem(int ordem)
    {
        Ordem = ordem;
    }
}
