package br.com.zelar.zellarempresas.Empresas;

import java.util.List;

/**
 * Created by enzo on 21/09/2016.
 */
public class CandidatoEmpresa extends Entidade
{
    private String Experiencia;

    private String Local;
    private String Nome;
    private String Genero;
    private String CPF;
    private String DataNascimento;
    private String EstadoCivil;
    private String IdEstadoCivil;
    private String Escolaridade;
    private String IdEscolaridade;
    private String CEP;
    private String Rua;
    private String Altura;
    private String Peso;
    private String Raca;
    private String Numero;
    private Boolean SemNumero;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String Pais;
    private String Latitude;
    private String Longitude;
    private String TelefonePrincipal;
    private String idStatusCandidato;
    private String Email;
    private String IdFuncao;
    private String Funcao;
    private String Pretensao;
    private String Fumante;
    private String Naturalidade;
    private String Nacionalidade;
    private String CasaPropria;
    private String TempoMoraNaCasa;
    private String TipoMoradia;
    private String QuantasPessoasMoramNaCasa;
    private String MoraComOsPais;
    private String MoraComFilhos;
    private String Trabalhando;
    private String QtdFilhos;

    private String Habilitacao;
    private Boolean CategoriaA;
    private Boolean CategoriaB;
    private Boolean CategoriaC;
    private Boolean CategoriaD;
    private Boolean CategoriaE;

    private String TemVeiculoProprio;
    private String TipoVeiculoProprio;
    private String PretensaoInicial;

    private Boolean DeficienciaFisica;
    private Boolean DeficienciaMental;
    private Boolean DeficienciaVisual;
    private Boolean DeficienciaAuditiva;
    private Boolean DeficienciaMudez;
    private Boolean DeficienciaOutra;
    private String Facebook;
    private String Linkedin;
    private String Twitter;
    private String Origem;

    private String TipoContrato;
    private String TipoJornada;
    private String EstadoPreferencia;
    private String CidadePreferencia;
    private String NivelHierarquicoMinimo;
    private String NivelHierarquicoMaximo;
    private Boolean DisponibilidadeParaViagens;
    private Boolean DisponibilidadeParaMudarDeCidade;

    private Boolean FuncionarioDaEmpresa;

    private String PaisIP;
    private String CidadeIP;
    private String UserAgent;
    private String ValorRaio;

    private byte[] CV;
    // public HttpPostedFileBase Arquivo;
    private String FileName;
    private String DownloadLink;

    private String Indicacao;
    private Boolean IndicacaoParente;
    private Boolean IndicacaoFuncionarioEmpresa;
    private String LocalTrabalhoIndicacao    ;

    private String ComoSoubeVaga;
    private Boolean Amarelinho;
    private Boolean CAT;
    private Boolean AcaoComunitaria;
    private Boolean IndLinkedin;
    private Boolean SiteEmpresa;
    private Boolean PorLoja;
    private Boolean PorAnuncio;
    private Boolean PorAmigo;
    private Boolean PorMidiaSocial;
    private Boolean Jornal;
    private Boolean Outros;

    private List<String> Telefones;
    //private List<Funcao> Funcoes;

    private String RestricaoViajar; // s
    private Boolean RestricaoMudarCidade; // s
    private String EstadoPreferenciaTrabalho; // s
    private String MunicipioPreferenciaTrabalho; // s
    private String TipoContratoPreferencia;// s clt, pj...
    private Boolean TemFilho;// s
    private int IdadeFilho;// /\
    private String PaisNascimento;// s
    private String EstadoNascimento;// s
    private String MunicipioNascimento;// s
    private String RG;// s
    private String QuemMoraNaCasa; // s
    private double ValorMensal;// s

    private String DataCriacao;
    private String DataAlteracao;

    private Boolean favorito;
    private Boolean candProximaEtapa;
    private Boolean candReprovado;

    private Boolean JaEstaEmProcessoSeletivo;
    private String DetalheProcessoSeletivo;
    private String DataConfirmacao;
    private String IdUsuario;

    private byte[] Foto;

    private int IdadeFilho1;
    private int IdadeFilho2;
    private int IdadeFilho3;
    private int IdadeFilho4;
    private int IdadeFilho5;
    private Boolean InformacoesIncorretas;
    private String DataNotificacaoInfoIncorretas;
    private String idfacebook;
    private String QtdeEmpregosUltimos3Anos;
    private String tempoEmprego1;
    private String tempoEmprego2;
    private String tempoEmprego3;
    private String tempoEmprego4;
    private String tempoEmprego5;
    private String tempoEmprego6;
    private String tempoEmprego7;
    private String tempoEmprego8;
    private String tempoEmprego9;

    private String IdEmpresa;
    private String IdLocal;
    private String ComoSeCandidatou;
    private String NomeIndicacao;
    private String TelefoneIndicacao;
    private String EmailIndicacao;
    private String TemExperienciaNaFuncao;
    private String TempoExperienciaNaFuncao;
    private String EstaTrabalhando;
    private String QuantosEmpregosNoUltimoAno;
    private String RestricaoDiaTrabalho;
    private Boolean RestricaoDiaSeg;
    private Boolean RestricaoDiaTer;
    private Boolean RestricaoDiaQua;
    private Boolean RestricaoDiaQui;
    private Boolean RestricaoDiaSex;
    private Boolean RestricaoDiaSab;
    private Boolean RestricaoDiaDom;
    private String RestricaoHorarioTrabalho;
    private Boolean RestricaoHorarioManha;
    private Boolean RestricaoHorarioTarde;
    private Boolean RestricaoHorarioNoite;
    private Boolean RestricaoHorarioMadrugada;
    //public List<TagCandidato> Tags;
    private Boolean PreAdmitido;
    private Boolean PagaPelaMoradia;



    private Boolean TemCarro;
    private Boolean TemMoto;
    private Boolean TemVan;
    private Boolean TemCaminho;
    private Boolean TemOnibus;

    private Boolean TemCasa;
    private Boolean TemApartamento;

    private String PossuiDeficiencia;
    private Boolean NaoPossuiEmail;

    private String Calcado;
    private String OutraDeficiencia;

    public String getExperiencia()
    {
        return Experiencia;
    }

    public void setExperiencia(String experiencia)
    {
        Experiencia = experiencia;
    }

    public String getLocal()
    {
        return Local;
    }

    public void setLocal(String local)
    {
        Local = local;
    }

    public String getNome()
    {
        return Nome;
    }

    public void setNome(String nome)
    {
        Nome = nome;
    }

    public String getGenero()
    {
        return Genero;
    }

    public void setGenero(String genero)
    {
        Genero = genero;
    }

    public String getCPF()
    {
        return CPF;
    }

    public void setCPF(String CPF)
    {
        this.CPF = CPF;
    }

    public String getDataNascimento()
    {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        DataNascimento = dataNascimento;
    }

    public String getEstadoCivil()
    {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estadoCivil)
    {
        EstadoCivil = estadoCivil;
    }

    public String getIdEstadoCivil()
    {
        return IdEstadoCivil;
    }

    public void setIdEstadoCivil(String idEstadoCivil)
    {
        IdEstadoCivil = idEstadoCivil;
    }

    public String getEscolaridade()
    {
        return Escolaridade;
    }

    public void setEscolaridade(String escolaridade)
    {
        Escolaridade = escolaridade;
    }

    public String getIdEscolaridade()
    {
        return IdEscolaridade;
    }

    public void setIdEscolaridade(String idEscolaridade)
    {
        IdEscolaridade = idEscolaridade;
    }

    public String getCEP()
    {
        return CEP;
    }

    public void setCEP(String CEP)
    {
        this.CEP = CEP;
    }

    public String getRua()
    {
        return Rua;
    }

    public void setRua(String rua)
    {
        Rua = rua;
    }

    public String getAltura()
    {
        return Altura;
    }

    public void setAltura(String altura)
    {
        Altura = altura;
    }

    public String getPeso()
    {
        return Peso;
    }

    public void setPeso(String peso)
    {
        Peso = peso;
    }

    public String getRaca()
    {
        return Raca;
    }

    public void setRaca(String raca)
    {
        Raca = raca;
    }

    public String getNumero()
    {
        return Numero;
    }

    public void setNumero(String numero)
    {
        Numero = numero;
    }

    public Boolean getSemNumero()
    {
        return SemNumero;
    }

    public void setSemNumero(Boolean semNumero)
    {
        SemNumero = semNumero;
    }

    public String getComplemento()
    {
        return Complemento;
    }

    public void setComplemento(String complemento)
    {
        Complemento = complemento;
    }

    public String getBairro()
    {
        return Bairro;
    }

    public void setBairro(String bairro)
    {
        Bairro = bairro;
    }

    public String getCidade()
    {
        return Cidade;
    }

    public void setCidade(String cidade)
    {
        Cidade = cidade;
    }

    public String getEstado()
    {
        return Estado;
    }

    public void setEstado(String estado)
    {
        Estado = estado;
    }

    public String getPais()
    {
        return Pais;
    }

    public void setPais(String pais)
    {
        Pais = pais;
    }

    public String getLatitude()
    {
        return Latitude;
    }

    public void setLatitude(String latitude)
    {
        Latitude = latitude;
    }

    public String getLongitude()
    {
        return Longitude;
    }

    public void setLongitude(String longitude)
    {
        Longitude = longitude;
    }

    public String getTelefonePrincipal()
    {
        return TelefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal)
    {
        TelefonePrincipal = telefonePrincipal;
    }

    public String getIdStatusCandidato()
    {
        return idStatusCandidato;
    }

    public void setIdStatusCandidato(String idStatusCandidato)
    {
        this.idStatusCandidato = idStatusCandidato;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public String getIdFuncao()
    {
        return IdFuncao;
    }

    public void setIdFuncao(String idFuncao)
    {
        IdFuncao = idFuncao;
    }

    public String getFuncao()
    {
        return Funcao;
    }

    public void setFuncao(String funcao)
    {
        Funcao = funcao;
    }

    public String getPretensao()
    {
        return Pretensao;
    }

    public void setPretensao(String pretensao)
    {
        Pretensao = pretensao;
    }

    public String getFumante()
    {
        return Fumante;
    }

    public void setFumante(String fumante)
    {
        Fumante = fumante;
    }

    public String getNaturalidade()
    {
        return Naturalidade;
    }

    public void setNaturalidade(String naturalidade)
    {
        Naturalidade = naturalidade;
    }

    public String getNacionalidade()
    {
        return Nacionalidade;
    }

    public void setNacionalidade(String nacionalidade)
    {
        Nacionalidade = nacionalidade;
    }

    public String getCasaPropria()
    {
        return CasaPropria;
    }

    public void setCasaPropria(String casaPropria)
    {
        CasaPropria = casaPropria;
    }

    public String getTempoMoraNaCasa()
    {
        return TempoMoraNaCasa;
    }

    public void setTempoMoraNaCasa(String tempoMoraNaCasa)
    {
        TempoMoraNaCasa = tempoMoraNaCasa;
    }

    public String getTipoMoradia()
    {
        return TipoMoradia;
    }

    public void setTipoMoradia(String tipoMoradia)
    {
        TipoMoradia = tipoMoradia;
    }

    public String getQuantasPessoasMoramNaCasa()
    {
        return QuantasPessoasMoramNaCasa;
    }

    public void setQuantasPessoasMoramNaCasa(String quantasPessoasMoramNaCasa)
    {
        QuantasPessoasMoramNaCasa = quantasPessoasMoramNaCasa;
    }

    public String getMoraComOsPais()
    {
        return MoraComOsPais;
    }

    public void setMoraComOsPais(String moraComOsPais)
    {
        MoraComOsPais = moraComOsPais;
    }

    public String getMoraComFilhos()
    {
        return MoraComFilhos;
    }

    public void setMoraComFilhos(String moraComFilhos)
    {
        MoraComFilhos = moraComFilhos;
    }

    public String getTrabalhando()
    {
        return Trabalhando;
    }

    public void setTrabalhando(String trabalhando)
    {
        Trabalhando = trabalhando;
    }

    public String getQtdFilhos()
    {
        return QtdFilhos;
    }

    public void setQtdFilhos(String qtdFilhos)
    {
        QtdFilhos = qtdFilhos;
    }

    public String getHabilitacao()
    {
        return Habilitacao;
    }

    public void setHabilitacao(String habilitacao)
    {
        Habilitacao = habilitacao;
    }

    public Boolean getCategoriaA()
    {
        return CategoriaA;
    }

    public void setCategoriaA(Boolean categoriaA)
    {
        CategoriaA = categoriaA;
    }

    public Boolean getCategoriaB()
    {
        return CategoriaB;
    }

    public void setCategoriaB(Boolean categoriaB)
    {
        CategoriaB = categoriaB;
    }

    public Boolean getCategoriaC()
    {
        return CategoriaC;
    }

    public void setCategoriaC(Boolean categoriaC)
    {
        CategoriaC = categoriaC;
    }

    public Boolean getCategoriaD()
    {
        return CategoriaD;
    }

    public void setCategoriaD(Boolean categoriaD)
    {
        CategoriaD = categoriaD;
    }

    public Boolean getCategoriaE()
    {
        return CategoriaE;
    }

    public void setCategoriaE(Boolean categoriaE)
    {
        CategoriaE = categoriaE;
    }

    public String getTemVeiculoProprio()
    {
        return TemVeiculoProprio;
    }

    public void setTemVeiculoProprio(String temVeiculoProprio)
    {
        TemVeiculoProprio = temVeiculoProprio;
    }

    public String getTipoVeiculoProprio()
    {
        return TipoVeiculoProprio;
    }

    public void setTipoVeiculoProprio(String tipoVeiculoProprio)
    {
        TipoVeiculoProprio = tipoVeiculoProprio;
    }

    public String getPretensaoInicial()
    {
        return PretensaoInicial;
    }

    public void setPretensaoInicial(String pretensaoInicial)
    {
        PretensaoInicial = pretensaoInicial;
    }

    public Boolean getDeficienciaFisica()
    {
        return DeficienciaFisica;
    }

    public void setDeficienciaFisica(Boolean deficienciaFisica)
    {
        DeficienciaFisica = deficienciaFisica;
    }

    public Boolean getDeficienciaMental()
    {
        return DeficienciaMental;
    }

    public void setDeficienciaMental(Boolean deficienciaMental)
    {
        DeficienciaMental = deficienciaMental;
    }

    public Boolean getDeficienciaVisual()
    {
        return DeficienciaVisual;
    }

    public void setDeficienciaVisual(Boolean deficienciaVisual)
    {
        DeficienciaVisual = deficienciaVisual;
    }

    public Boolean getDeficienciaAuditiva()
    {
        return DeficienciaAuditiva;
    }

    public void setDeficienciaAuditiva(Boolean deficienciaAuditiva)
    {
        DeficienciaAuditiva = deficienciaAuditiva;
    }

    public Boolean getDeficienciaMudez()
    {
        return DeficienciaMudez;
    }

    public void setDeficienciaMudez(Boolean deficienciaMudez)
    {
        DeficienciaMudez = deficienciaMudez;
    }

    public Boolean getDeficienciaOutra()
    {
        return DeficienciaOutra;
    }

    public void setDeficienciaOutra(Boolean deficienciaOutra)
    {
        DeficienciaOutra = deficienciaOutra;
    }

    public String getFacebook()
    {
        return Facebook;
    }

    public void setFacebook(String facebook)
    {
        Facebook = facebook;
    }

    public String getLinkedin()
    {
        return Linkedin;
    }

    public void setLinkedin(String linkedin)
    {
        Linkedin = linkedin;
    }

    public String getTwitter()
    {
        return Twitter;
    }

    public void setTwitter(String twitter)
    {
        Twitter = twitter;
    }

    public String getOrigem()
    {
        return Origem;
    }

    public void setOrigem(String origem)
    {
        Origem = origem;
    }

    public String getTipoContrato()
    {
        return TipoContrato;
    }

    public void setTipoContrato(String tipoContrato)
    {
        TipoContrato = tipoContrato;
    }

    public String getTipoJornada()
    {
        return TipoJornada;
    }

    public void setTipoJornada(String tipoJornada)
    {
        TipoJornada = tipoJornada;
    }

    public String getEstadoPreferencia()
    {
        return EstadoPreferencia;
    }

    public void setEstadoPreferencia(String estadoPreferencia)
    {
        EstadoPreferencia = estadoPreferencia;
    }

    public String getCidadePreferencia()
    {
        return CidadePreferencia;
    }

    public void setCidadePreferencia(String cidadePreferencia)
    {
        CidadePreferencia = cidadePreferencia;
    }

    public String getNivelHierarquicoMinimo()
    {
        return NivelHierarquicoMinimo;
    }

    public void setNivelHierarquicoMinimo(String nivelHierarquicoMinimo)
    {
        NivelHierarquicoMinimo = nivelHierarquicoMinimo;
    }

    public String getNivelHierarquicoMaximo()
    {
        return NivelHierarquicoMaximo;
    }

    public void setNivelHierarquicoMaximo(String nivelHierarquicoMaximo)
    {
        NivelHierarquicoMaximo = nivelHierarquicoMaximo;
    }

    public Boolean getDisponibilidadeParaViagens()
    {
        return DisponibilidadeParaViagens;
    }

    public void setDisponibilidadeParaViagens(Boolean disponibilidadeParaViagens)
    {
        DisponibilidadeParaViagens = disponibilidadeParaViagens;
    }

    public Boolean getDisponibilidadeParaMudarDeCidade()
    {
        return DisponibilidadeParaMudarDeCidade;
    }

    public void setDisponibilidadeParaMudarDeCidade(Boolean disponibilidadeParaMudarDeCidade)
    {
        DisponibilidadeParaMudarDeCidade = disponibilidadeParaMudarDeCidade;
    }

    public Boolean getFuncionarioDaEmpresa()
    {
        return FuncionarioDaEmpresa;
    }

    public void setFuncionarioDaEmpresa(Boolean funcionarioDaEmpresa)
    {
        FuncionarioDaEmpresa = funcionarioDaEmpresa;
    }

    public String getPaisIP()
    {
        return PaisIP;
    }

    public void setPaisIP(String paisIP)
    {
        PaisIP = paisIP;
    }

    public String getCidadeIP()
    {
        return CidadeIP;
    }

    public void setCidadeIP(String cidadeIP)
    {
        CidadeIP = cidadeIP;
    }

    public String getUserAgent()
    {
        return UserAgent;
    }

    public void setUserAgent(String userAgent)
    {
        UserAgent = userAgent;
    }

    public String getValorRaio()
    {
        return ValorRaio;
    }

    public void setValorRaio(String valorRaio)
    {
        ValorRaio = valorRaio;
    }

    public byte[] getCV()
    {
        return CV;
    }

    public void setCV(byte[] CV)
    {
        this.CV = CV;
    }

    public String getFileName()
    {
        return FileName;
    }

    public void setFileName(String fileName)
    {
        FileName = fileName;
    }

    public String getDownloadLink()
    {
        return DownloadLink;
    }

    public void setDownloadLink(String downloadLink)
    {
        DownloadLink = downloadLink;
    }

    public String getIndicacao()
    {
        return Indicacao;
    }

    public void setIndicacao(String indicacao)
    {
        Indicacao = indicacao;
    }

    public Boolean getIndicacaoParente()
    {
        return IndicacaoParente;
    }

    public void setIndicacaoParente(Boolean indicacaoParente)
    {
        IndicacaoParente = indicacaoParente;
    }

    public Boolean getIndicacaoFuncionarioEmpresa()
    {
        return IndicacaoFuncionarioEmpresa;
    }

    public void setIndicacaoFuncionarioEmpresa(Boolean indicacaoFuncionarioEmpresa)
    {
        IndicacaoFuncionarioEmpresa = indicacaoFuncionarioEmpresa;
    }

    public String getLocalTrabalhoIndicacao()
    {
        return LocalTrabalhoIndicacao;
    }

    public void setLocalTrabalhoIndicacao(String localTrabalhoIndicacao)
    {
        LocalTrabalhoIndicacao = localTrabalhoIndicacao;
    }

    public String getComoSoubeVaga()
    {
        return ComoSoubeVaga;
    }

    public void setComoSoubeVaga(String comoSoubeVaga)
    {
        ComoSoubeVaga = comoSoubeVaga;
    }

    public Boolean getAmarelinho()
    {
        return Amarelinho;
    }

    public void setAmarelinho(Boolean amarelinho)
    {
        Amarelinho = amarelinho;
    }

    public Boolean getCAT()
    {
        return CAT;
    }

    public void setCAT(Boolean CAT)
    {
        this.CAT = CAT;
    }

    public Boolean getAcaoComunitaria()
    {
        return AcaoComunitaria;
    }

    public void setAcaoComunitaria(Boolean acaoComunitaria)
    {
        AcaoComunitaria = acaoComunitaria;
    }

    public Boolean getIndLinkedin()
    {
        return IndLinkedin;
    }

    public void setIndLinkedin(Boolean indLinkedin)
    {
        IndLinkedin = indLinkedin;
    }

    public Boolean getSiteEmpresa()
    {
        return SiteEmpresa;
    }

    public void setSiteEmpresa(Boolean siteEmpresa)
    {
        SiteEmpresa = siteEmpresa;
    }

    public Boolean getPorLoja()
    {
        return PorLoja;
    }

    public void setPorLoja(Boolean porLoja)
    {
        PorLoja = porLoja;
    }

    public Boolean getPorAnuncio()
    {
        return PorAnuncio;
    }

    public void setPorAnuncio(Boolean porAnuncio)
    {
        PorAnuncio = porAnuncio;
    }

    public Boolean getPorAmigo()
    {
        return PorAmigo;
    }

    public void setPorAmigo(Boolean porAmigo)
    {
        PorAmigo = porAmigo;
    }

    public Boolean getPorMidiaSocial()
    {
        return PorMidiaSocial;
    }

    public void setPorMidiaSocial(Boolean porMidiaSocial)
    {
        PorMidiaSocial = porMidiaSocial;
    }

    public Boolean getJornal()
    {
        return Jornal;
    }

    public void setJornal(Boolean jornal)
    {
        Jornal = jornal;
    }

    public Boolean getOutros()
    {
        return Outros;
    }

    public void setOutros(Boolean outros)
    {
        Outros = outros;
    }

    public List<String> getTelefones()
    {
        return Telefones;
    }

    public void setTelefones(List<String> telefones)
    {
        Telefones = telefones;
    }

    public String getRestricaoViajar()
    {
        return RestricaoViajar;
    }

    public void setRestricaoViajar(String restricaoViajar)
    {
        RestricaoViajar = restricaoViajar;
    }

    public Boolean getRestricaoMudarCidade()
    {
        return RestricaoMudarCidade;
    }

    public void setRestricaoMudarCidade(Boolean restricaoMudarCidade)
    {
        RestricaoMudarCidade = restricaoMudarCidade;
    }

    public String getEstadoPreferenciaTrabalho()
    {
        return EstadoPreferenciaTrabalho;
    }

    public void setEstadoPreferenciaTrabalho(String estadoPreferenciaTrabalho)
    {
        EstadoPreferenciaTrabalho = estadoPreferenciaTrabalho;
    }

    public String getMunicipioPreferenciaTrabalho()
    {
        return MunicipioPreferenciaTrabalho;
    }

    public void setMunicipioPreferenciaTrabalho(String municipioPreferenciaTrabalho)
    {
        MunicipioPreferenciaTrabalho = municipioPreferenciaTrabalho;
    }

    public String getTipoContratoPreferencia()
    {
        return TipoContratoPreferencia;
    }

    public void setTipoContratoPreferencia(String tipoContratoPreferencia)
    {
        TipoContratoPreferencia = tipoContratoPreferencia;
    }

    public Boolean getTemFilho()
    {
        return TemFilho;
    }

    public void setTemFilho(Boolean temFilho)
    {
        TemFilho = temFilho;
    }

    public int getIdadeFilho()
    {
        return IdadeFilho;
    }

    public void setIdadeFilho(int idadeFilho)
    {
        IdadeFilho = idadeFilho;
    }

    public String getPaisNascimento()
    {
        return PaisNascimento;
    }

    public void setPaisNascimento(String paisNascimento)
    {
        PaisNascimento = paisNascimento;
    }

    public String getEstadoNascimento()
    {
        return EstadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento)
    {
        EstadoNascimento = estadoNascimento;
    }

    public String getMunicipioNascimento()
    {
        return MunicipioNascimento;
    }

    public void setMunicipioNascimento(String municipioNascimento)
    {
        MunicipioNascimento = municipioNascimento;
    }

    public String getRG()
    {
        return RG;
    }

    public void setRG(String RG)
    {
        this.RG = RG;
    }

    public String getQuemMoraNaCasa()
    {
        return QuemMoraNaCasa;
    }

    public void setQuemMoraNaCasa(String quemMoraNaCasa)
    {
        QuemMoraNaCasa = quemMoraNaCasa;
    }

    public double getValorMensal()
    {
        return ValorMensal;
    }

    public void setValorMensal(double valorMensal)
    {
        ValorMensal = valorMensal;
    }

    public String getDataCriacao()
    {
        return DataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
    {
        DataCriacao = dataCriacao;
    }

    public String getDataAlteracao()
    {
        return DataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao)
    {
        DataAlteracao = dataAlteracao;
    }

    public Boolean getFavorito()
    {
        return favorito;
    }

    public void setFavorito(Boolean favorito)
    {
        this.favorito = favorito;
    }

    public Boolean getCandProximaEtapa()
    {
        return candProximaEtapa;
    }

    public void setCandProximaEtapa(Boolean candProximaEtapa)
    {
        this.candProximaEtapa = candProximaEtapa;
    }

    public Boolean getCandReprovado()
    {
        return candReprovado;
    }

    public void setCandReprovado(Boolean candReprovado)
    {
        this.candReprovado = candReprovado;
    }

    public Boolean getJaEstaEmProcessoSeletivo()
    {
        return JaEstaEmProcessoSeletivo;
    }

    public void setJaEstaEmProcessoSeletivo(Boolean jaEstaEmProcessoSeletivo)
    {
        JaEstaEmProcessoSeletivo = jaEstaEmProcessoSeletivo;
    }

    public String getDetalheProcessoSeletivo()
    {
        return DetalheProcessoSeletivo;
    }

    public void setDetalheProcessoSeletivo(String detalheProcessoSeletivo)
    {
        DetalheProcessoSeletivo = detalheProcessoSeletivo;
    }

    public String getDataConfirmacao()
    {
        return DataConfirmacao;
    }

    public void setDataConfirmacao(String dataConfirmacao)
    {
        DataConfirmacao = dataConfirmacao;
    }

    public String getIdUsuario()
    {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        IdUsuario = idUsuario;
    }

    public byte[] getFoto()
    {
        return Foto;
    }

    public void setFoto(byte[] foto)
    {
        Foto = foto;
    }

    public int getIdadeFilho1()
    {
        return IdadeFilho1;
    }

    public void setIdadeFilho1(int idadeFilho1)
    {
        IdadeFilho1 = idadeFilho1;
    }

    public int getIdadeFilho2()
    {
        return IdadeFilho2;
    }

    public void setIdadeFilho2(int idadeFilho2)
    {
        IdadeFilho2 = idadeFilho2;
    }

    public int getIdadeFilho3()
    {
        return IdadeFilho3;
    }

    public void setIdadeFilho3(int idadeFilho3)
    {
        IdadeFilho3 = idadeFilho3;
    }

    public int getIdadeFilho4()
    {
        return IdadeFilho4;
    }

    public void setIdadeFilho4(int idadeFilho4)
    {
        IdadeFilho4 = idadeFilho4;
    }

    public int getIdadeFilho5()
    {
        return IdadeFilho5;
    }

    public void setIdadeFilho5(int idadeFilho5)
    {
        IdadeFilho5 = idadeFilho5;
    }

    public Boolean getInformacoesIncorretas()
    {
        return InformacoesIncorretas;
    }

    public void setInformacoesIncorretas(Boolean informacoesIncorretas)
    {
        InformacoesIncorretas = informacoesIncorretas;
    }

    public String getDataNotificacaoInfoIncorretas()
    {
        return DataNotificacaoInfoIncorretas;
    }

    public void setDataNotificacaoInfoIncorretas(String dataNotificacaoInfoIncorretas)
    {
        DataNotificacaoInfoIncorretas = dataNotificacaoInfoIncorretas;
    }

    public String getIdfacebook()
    {
        return idfacebook;
    }

    public void setIdfacebook(String idfacebook)
    {
        this.idfacebook = idfacebook;
    }

    public String getQtdeEmpregosUltimos3Anos()
    {
        return QtdeEmpregosUltimos3Anos;
    }

    public void setQtdeEmpregosUltimos3Anos(String qtdeEmpregosUltimos3Anos)
    {
        QtdeEmpregosUltimos3Anos = qtdeEmpregosUltimos3Anos;
    }

    public String getTempoEmprego1()
    {
        return tempoEmprego1;
    }

    public void setTempoEmprego1(String tempoEmprego1)
    {
        this.tempoEmprego1 = tempoEmprego1;
    }

    public String getTempoEmprego2()
    {
        return tempoEmprego2;
    }

    public void setTempoEmprego2(String tempoEmprego2)
    {
        this.tempoEmprego2 = tempoEmprego2;
    }

    public String getTempoEmprego3()
    {
        return tempoEmprego3;
    }

    public void setTempoEmprego3(String tempoEmprego3)
    {
        this.tempoEmprego3 = tempoEmprego3;
    }

    public String getTempoEmprego4()
    {
        return tempoEmprego4;
    }

    public void setTempoEmprego4(String tempoEmprego4)
    {
        this.tempoEmprego4 = tempoEmprego4;
    }

    public String getTempoEmprego5()
    {
        return tempoEmprego5;
    }

    public void setTempoEmprego5(String tempoEmprego5)
    {
        this.tempoEmprego5 = tempoEmprego5;
    }

    public String getTempoEmprego6()
    {
        return tempoEmprego6;
    }

    public void setTempoEmprego6(String tempoEmprego6)
    {
        this.tempoEmprego6 = tempoEmprego6;
    }

    public String getTempoEmprego7()
    {
        return tempoEmprego7;
    }

    public void setTempoEmprego7(String tempoEmprego7)
    {
        this.tempoEmprego7 = tempoEmprego7;
    }

    public String getTempoEmprego8()
    {
        return tempoEmprego8;
    }

    public void setTempoEmprego8(String tempoEmprego8)
    {
        this.tempoEmprego8 = tempoEmprego8;
    }

    public String getTempoEmprego9()
    {
        return tempoEmprego9;
    }

    public void setTempoEmprego9(String tempoEmprego9)
    {
        this.tempoEmprego9 = tempoEmprego9;
    }

    public String getIdEmpresa()
    {
        return IdEmpresa;
    }

    public void setIdEmpresa(String idEmpresa)
    {
        IdEmpresa = idEmpresa;
    }

    public String getIdLocal()
    {
        return IdLocal;
    }

    public void setIdLocal(String idLocal)
    {
        IdLocal = idLocal;
    }

    public String getComoSeCandidatou()
    {
        return ComoSeCandidatou;
    }

    public void setComoSeCandidatou(String comoSeCandidatou)
    {
        ComoSeCandidatou = comoSeCandidatou;
    }

    public String getNomeIndicacao()
    {
        return NomeIndicacao;
    }

    public void setNomeIndicacao(String nomeIndicacao)
    {
        NomeIndicacao = nomeIndicacao;
    }

    public String getTelefoneIndicacao()
    {
        return TelefoneIndicacao;
    }

    public void setTelefoneIndicacao(String telefoneIndicacao)
    {
        TelefoneIndicacao = telefoneIndicacao;
    }

    public String getEmailIndicacao()
    {
        return EmailIndicacao;
    }

    public void setEmailIndicacao(String emailIndicacao)
    {
        EmailIndicacao = emailIndicacao;
    }

    public String getTemExperienciaNaFuncao()
    {
        return TemExperienciaNaFuncao;
    }

    public void setTemExperienciaNaFuncao(String temExperienciaNaFuncao)
    {
        TemExperienciaNaFuncao = temExperienciaNaFuncao;
    }

    public String getTempoExperienciaNaFuncao()
    {
        return TempoExperienciaNaFuncao;
    }

    public void setTempoExperienciaNaFuncao(String tempoExperienciaNaFuncao)
    {
        TempoExperienciaNaFuncao = tempoExperienciaNaFuncao;
    }

    public String getEstaTrabalhando()
    {
        return EstaTrabalhando;
    }

    public void setEstaTrabalhando(String estaTrabalhando)
    {
        EstaTrabalhando = estaTrabalhando;
    }

    public String getQuantosEmpregosNoUltimoAno()
    {
        return QuantosEmpregosNoUltimoAno;
    }

    public void setQuantosEmpregosNoUltimoAno(String quantosEmpregosNoUltimoAno)
    {
        QuantosEmpregosNoUltimoAno = quantosEmpregosNoUltimoAno;
    }

    public String getRestricaoDiaTrabalho()
    {
        return RestricaoDiaTrabalho;
    }

    public void setRestricaoDiaTrabalho(String restricaoDiaTrabalho)
    {
        RestricaoDiaTrabalho = restricaoDiaTrabalho;
    }

    public Boolean getRestricaoDiaSeg()
    {
        return RestricaoDiaSeg;
    }

    public void setRestricaoDiaSeg(Boolean restricaoDiaSeg)
    {
        RestricaoDiaSeg = restricaoDiaSeg;
    }

    public Boolean getRestricaoDiaTer()
    {
        return RestricaoDiaTer;
    }

    public void setRestricaoDiaTer(Boolean restricaoDiaTer)
    {
        RestricaoDiaTer = restricaoDiaTer;
    }

    public Boolean getRestricaoDiaQua()
    {
        return RestricaoDiaQua;
    }

    public void setRestricaoDiaQua(Boolean restricaoDiaQua)
    {
        RestricaoDiaQua = restricaoDiaQua;
    }

    public Boolean getRestricaoDiaQui()
    {
        return RestricaoDiaQui;
    }

    public void setRestricaoDiaQui(Boolean restricaoDiaQui)
    {
        RestricaoDiaQui = restricaoDiaQui;
    }

    public Boolean getRestricaoDiaSex()
    {
        return RestricaoDiaSex;
    }

    public void setRestricaoDiaSex(Boolean restricaoDiaSex)
    {
        RestricaoDiaSex = restricaoDiaSex;
    }

    public Boolean getRestricaoDiaSab()
    {
        return RestricaoDiaSab;
    }

    public void setRestricaoDiaSab(Boolean restricaoDiaSab)
    {
        RestricaoDiaSab = restricaoDiaSab;
    }

    public Boolean getRestricaoDiaDom()
    {
        return RestricaoDiaDom;
    }

    public void setRestricaoDiaDom(Boolean restricaoDiaDom)
    {
        RestricaoDiaDom = restricaoDiaDom;
    }

    public String getRestricaoHorarioTrabalho()
    {
        return RestricaoHorarioTrabalho;
    }

    public void setRestricaoHorarioTrabalho(String restricaoHorarioTrabalho)
    {
        RestricaoHorarioTrabalho = restricaoHorarioTrabalho;
    }

    public Boolean getRestricaoHorarioManha()
    {
        return RestricaoHorarioManha;
    }

    public void setRestricaoHorarioManha(Boolean restricaoHorarioManha)
    {
        RestricaoHorarioManha = restricaoHorarioManha;
    }

    public Boolean getRestricaoHorarioTarde()
    {
        return RestricaoHorarioTarde;
    }

    public void setRestricaoHorarioTarde(Boolean restricaoHorarioTarde)
    {
        RestricaoHorarioTarde = restricaoHorarioTarde;
    }

    public Boolean getRestricaoHorarioNoite()
    {
        return RestricaoHorarioNoite;
    }

    public void setRestricaoHorarioNoite(Boolean restricaoHorarioNoite)
    {
        RestricaoHorarioNoite = restricaoHorarioNoite;
    }

    public Boolean getRestricaoHorarioMadrugada()
    {
        return RestricaoHorarioMadrugada;
    }

    public void setRestricaoHorarioMadrugada(Boolean restricaoHorarioMadrugada)
    {
        RestricaoHorarioMadrugada = restricaoHorarioMadrugada;
    }

    public Boolean getPreAdmitido()
    {
        return PreAdmitido;
    }

    public void setPreAdmitido(Boolean preAdmitido)
    {
        PreAdmitido = preAdmitido;
    }

    public Boolean getPagaPelaMoradia()
    {
        return PagaPelaMoradia;
    }

    public void setPagaPelaMoradia(Boolean pagaPelaMoradia)
    {
        PagaPelaMoradia = pagaPelaMoradia;
    }

    public Boolean getTemCarro()
    {
        return TemCarro;
    }

    public void setTemCarro(Boolean temCarro)
    {
        TemCarro = temCarro;
    }

    public Boolean getTemMoto()
    {
        return TemMoto;
    }

    public void setTemMoto(Boolean temMoto)
    {
        TemMoto = temMoto;
    }

    public Boolean getTemVan()
    {
        return TemVan;
    }

    public void setTemVan(Boolean temVan)
    {
        TemVan = temVan;
    }

    public Boolean getTemCaminho()
    {
        return TemCaminho;
    }

    public void setTemCaminho(Boolean temCaminho)
    {
        TemCaminho = temCaminho;
    }

    public Boolean getTemOnibus()
    {
        return TemOnibus;
    }

    public void setTemOnibus(Boolean temOnibus)
    {
        TemOnibus = temOnibus;
    }

    public Boolean getTemCasa()
    {
        return TemCasa;
    }

    public void setTemCasa(Boolean temCasa)
    {
        TemCasa = temCasa;
    }

    public Boolean getTemApartamento()
    {
        return TemApartamento;
    }

    public void setTemApartamento(Boolean temApartamento)
    {
        TemApartamento = temApartamento;
    }

    public String getPossuiDeficiencia()
    {
        return PossuiDeficiencia;
    }

    public void setPossuiDeficiencia(String possuiDeficiencia)
    {
        PossuiDeficiencia = possuiDeficiencia;
    }

    public Boolean getNaoPossuiEmail()
    {
        return NaoPossuiEmail;
    }

    public void setNaoPossuiEmail(Boolean naoPossuiEmail)
    {
        NaoPossuiEmail = naoPossuiEmail;
    }

    public String getCalcado()
    {
        return Calcado;
    }

    public void setCalcado(String calcado)
    {
        Calcado = calcado;
    }

    public String getOutraDeficiencia()
    {
        return OutraDeficiencia;
    }

    public void setOutraDeficiencia(String outraDeficiencia)
    {
        OutraDeficiencia = outraDeficiencia;
    }
}
