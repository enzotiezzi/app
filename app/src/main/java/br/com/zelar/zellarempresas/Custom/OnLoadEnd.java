package br.com.zelar.zellarempresas.Custom;

import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;

/**
 * Created by enzo on 21/09/2016.
 */
public interface OnLoadEnd
{
    void carregarListaDescartados(CandidatoEmpresa[] candidatos, String idEtapa);
    void carregarListaNaoDescartados(CandidatoEmpresa[] candidatos, String idEtapa);
}
