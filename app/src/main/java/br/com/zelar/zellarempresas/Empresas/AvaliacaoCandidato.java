package br.com.zelar.zellarempresas.Empresas;

import java.util.List;

/**
 * Created by enzo on 07/10/2016.
 */
public class AvaliacaoCandidato
{
    private String idVaga;
    private String idEtapa;
    private List<String> Candidatos;
    private String loginUsuario;

    public void setLoginUsuario(String loginUsuario)
    {
        this.loginUsuario = loginUsuario;
    }

    public String getLoginUsuario()
    {
        return loginUsuario;
    }

    public String getIdVaga()
    {
        return idVaga;
    }

    public void setIdVaga(String idVaga)
    {
        this.idVaga = idVaga;
    }

    public String getIdEtapa()
    {
        return idEtapa;
    }

    public void setIdEtapa(String idEtapa)
    {
        this.idEtapa = idEtapa;
    }

    public List<String> getCandidatos()
    {
        return Candidatos;
    }

    public void setCandidatos(List<String> candidatos)
    {
        Candidatos = candidatos;
    }
}
