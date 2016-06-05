package Models.Empresas;


/**
 * Created by enzo on 02/06/2016.
 */
public class Local extends Entidade
{
    public String IdEmpresa;

    public String Nome;
    public String CEP;
    public String Rua;
    public String Numero;
    public String Complemento;
    public String Bairro;
    public String Cidade;
    public String Estado;
    public String Pais;
    public String Latitude;
    public String Longitude;
    public int QtdeVagasLocal;

    public String Grupo1;
    public String Grupo2;
    public String Grupo3;
    public String Grupo4;
    public String Grupo5;
    public String Grupo6;
    public String URLTrabalheConosco;
    public String TextoTrabalheConosco;
    public byte[] Logo;

    public String LocalCampoReduzido;
    public String Grupo1CampoReduzido;
    public String Grupo2CampoReduzido;
    public String Grupo3CampoReduzido;
    public String Grupo4CampoReduzido;
    public String Grupo5CampoReduzido;
    public String Grupo6CampoReduzido;

    public boolean LatitudeLongitudeManual;

    public String NomeResponsavel;
    public String EmailResponsavel;
    public String IdCliente;
    public String IdGrupo;

    public String Codigo;
    public String CargoContato;
    public String TelefoneContato;
    public String Observacoes;
    public String NomeResponsavelRH;

    @Override
    public String toString()
    {
        return this.Nome;
    }
}
