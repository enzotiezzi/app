package Models.Empresas;


/**
 * Created by enzo on 03/06/2016.
 */
public class Authentication
{
    private String Login;
    private String Senha;

    private boolean Response;
    private String IdEmpresa;
    private String NomeEmpresa;

    public Authentication()
    {

    }

    public String getLogin()
    {
        return Login;
    }

    public void setLogin(String login)
    {
        Login = login;
    }

    public String getSenha()
    {
        return Senha;
    }

    public void setSenha(String senha)
    {
        Senha = senha;
    }

    public boolean isResponse()
    {
        return Response;
    }

    public void setResponse(boolean response)
    {
        Response = response;
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
}
