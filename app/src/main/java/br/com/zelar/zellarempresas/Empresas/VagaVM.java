package br.com.zelar.zellarempresas.Empresas;

/**
 * Created by Usuário on 30/08/2016.
 */
public class VagaVM
{
    private Vaga vaga;

    public VagaVM(){}

    public Vaga getVaga()
    {
        return vaga;
    }

    public void setVaga(Vaga vaga)
    {
        this.vaga = vaga;
    }

    @Override
    public String toString()
    {
        String formatado = vaga.getEscala() + " - "
                            + vaga.getHorarioEntradaHoras() + ":"
                            + vaga.getHorarioEntradaMinutos() + " às "
                            + vaga.getHorarioSaidaHoras() + ":"
                            + vaga.getHorarioSaidaMinutos() + " - "
                            + vaga.getPretensao();

        return formatado;
    }
}
