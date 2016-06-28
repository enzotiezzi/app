package br.com.zelar.zellarempresas.Empresas;


/**
 * Created by enzo on 02/06/2016.
 */
public class Local extends Entidade
{
    private String IdEmpresa;

    private String Nome;
    private String CEP;
    private String Rua;
    private String Numero;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String Pais;
    private String Latitude;
    private String Longitude;
    private int QtdeVagasLocal;

    private String Grupo1;
    private String Grupo2;
    private String Grupo3;
    private String Grupo4;
    private String Grupo5;
    private String Grupo6;
    private String URLTrabalheConosco;
    private String TextoTrabalheConosco;
    private byte[] Logo;

    private String LocalCampoReduzido;
    private String Grupo1CampoReduzido;
    private String Grupo2CampoReduzido;
    private String Grupo3CampoReduzido;
    private String Grupo4CampoReduzido;
    private String Grupo5CampoReduzido;
    private String Grupo6CampoReduzido;

    private boolean LatitudeLongitudeManual;

    private String NomeResponsavel;
    private String EmailResponsavel;
    private String IdCliente;
    private String IdGrupo;

    private String Codigo;
    private String CargoContato;
    private String TelefoneContato;
    private String Observacoes;
    private String NomeResponsavelRH;

    @Override
    public String toString()
    {
        return this.getNome();
    }

    public String getNome()
    {
        return this.Nome;
    }

    public String getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public int getQtdeVagasLocal() {
        return QtdeVagasLocal;
    }

    public void setQtdeVagasLocal(int qtdeVagasLocal) {
        QtdeVagasLocal = qtdeVagasLocal;
    }

    public String getGrupo1() {
        return Grupo1;
    }

    public void setGrupo1(String grupo1) {
        Grupo1 = grupo1;
    }

    public String getGrupo2() {
        return Grupo2;
    }

    public void setGrupo2(String grupo2) {
        Grupo2 = grupo2;
    }

    public String getGrupo3() {
        return Grupo3;
    }

    public void setGrupo3(String grupo3) {
        Grupo3 = grupo3;
    }

    public String getGrupo4() {
        return Grupo4;
    }

    public void setGrupo4(String grupo4) {
        Grupo4 = grupo4;
    }

    public String getGrupo5() {
        return Grupo5;
    }

    public void setGrupo5(String grupo5) {
        Grupo5 = grupo5;
    }

    public String getGrupo6() {
        return Grupo6;
    }

    public void setGrupo6(String grupo6) {
        Grupo6 = grupo6;
    }

    public String getURLTrabalheConosco() {
        return URLTrabalheConosco;
    }

    public void setURLTrabalheConosco(String URLTrabalheConosco) {
        this.URLTrabalheConosco = URLTrabalheConosco;
    }

    public String getTextoTrabalheConosco() {
        return TextoTrabalheConosco;
    }

    public void setTextoTrabalheConosco(String textoTrabalheConosco) {
        TextoTrabalheConosco = textoTrabalheConosco;
    }

    public byte[] getLogo() {
        return Logo;
    }

    public void setLogo(byte[] logo) {
        Logo = logo;
    }

    public String getLocalCampoReduzido() {
        return LocalCampoReduzido;
    }

    public void setLocalCampoReduzido(String localCampoReduzido) {
        LocalCampoReduzido = localCampoReduzido;
    }

    public String getGrupo1CampoReduzido() {
        return Grupo1CampoReduzido;
    }

    public void setGrupo1CampoReduzido(String grupo1CampoReduzido) {
        Grupo1CampoReduzido = grupo1CampoReduzido;
    }

    public String getGrupo2CampoReduzido() {
        return Grupo2CampoReduzido;
    }

    public void setGrupo2CampoReduzido(String grupo2CampoReduzido) {
        Grupo2CampoReduzido = grupo2CampoReduzido;
    }

    public String getGrupo3CampoReduzido() {
        return Grupo3CampoReduzido;
    }

    public void setGrupo3CampoReduzido(String grupo3CampoReduzido) {
        Grupo3CampoReduzido = grupo3CampoReduzido;
    }

    public String getGrupo4CampoReduzido() {
        return Grupo4CampoReduzido;
    }

    public void setGrupo4CampoReduzido(String grupo4CampoReduzido) {
        Grupo4CampoReduzido = grupo4CampoReduzido;
    }

    public String getGrupo5CampoReduzido() {
        return Grupo5CampoReduzido;
    }

    public void setGrupo5CampoReduzido(String grupo5CampoReduzido) {
        Grupo5CampoReduzido = grupo5CampoReduzido;
    }

    public String getGrupo6CampoReduzido() {
        return Grupo6CampoReduzido;
    }

    public void setGrupo6CampoReduzido(String grupo6CampoReduzido) {
        Grupo6CampoReduzido = grupo6CampoReduzido;
    }

    public boolean isLatitudeLongitudeManual() {
        return LatitudeLongitudeManual;
    }

    public void setLatitudeLongitudeManual(boolean latitudeLongitudeManual) {
        LatitudeLongitudeManual = latitudeLongitudeManual;
    }

    public String getNomeResponsavel() {
        return NomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        NomeResponsavel = nomeResponsavel;
    }

    public String getEmailResponsavel() {
        return EmailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        EmailResponsavel = emailResponsavel;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    public String getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        IdGrupo = idGrupo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getCargoContato() {
        return CargoContato;
    }

    public void setCargoContato(String cargoContato) {
        CargoContato = cargoContato;
    }

    public String getTelefoneContato() {
        return TelefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        TelefoneContato = telefoneContato;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public String getNomeResponsavelRH() {
        return NomeResponsavelRH;
    }

    public void setNomeResponsavelRH(String nomeResponsavelRH) {
        NomeResponsavelRH = nomeResponsavelRH;
    }
}
