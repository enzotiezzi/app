package br.com.zelar.zellarempresas.Empresas;

/**
 * Created by enzo on 13/07/2016.
 */
public class GestaoEmpresaTreeViewModel
{
    private String Tipo;
    private String Nome;
    private String Id;
    private int Numero;
    private String QtdeLocal;
    private String QtdePessoas;
    private String QtdeVagas;

    public GestaoEmpresaTreeViewModel(){}

    public String getTipo()
    {
        return Tipo;
    }

    public void setTipo(String tipo)
    {
        Tipo = tipo;
    }


    public String getNome()
    {
        return Nome;
    }

    public void setNome(String nome)
    {
        Nome = nome;
    }

    public String getId()
    {
        return Id;
    }

    public void setId(String id)
    {
        Id = id;
    }

    public int getNumero()
    {
        return Numero;
    }

    public void setNumero(int numero)
    {
        Numero = numero;
    }

    public String getQtdeLocal()
    {
        return QtdeLocal;
    }

    public void setQtdeLocal(String qtdeLocal)
    {
        QtdeLocal = qtdeLocal;
    }

    public String getQtdePessoas()
    {
        return QtdePessoas;
    }

    public void setQtdePessoas(String qtdePessoas)
    {
        QtdePessoas = qtdePessoas;
    }

    public String getQtdeVagas()
    {
        return QtdeVagas;
    }

    public void setQtdeVagas(String qtdeVagas)
    {
        QtdeVagas = qtdeVagas;
    }
}
