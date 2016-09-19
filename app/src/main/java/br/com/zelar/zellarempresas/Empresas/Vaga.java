package br.com.zelar.zellarempresas.Empresas;


/**
 * Created by enzo on 30/05/2016.
 */
public class Vaga extends Entidade
{
    private String IdUsuario;

    private String IdLocal;
    private String Titulo;
    private String Codigo;
    private String Funcao;
    private String IdFuncao;
    private String DescricaoFuncao;
    private String Genero;
    private String Escala;
    private String Horario;

    private String HorarioEntradaHoras;
    private String HorarioEntradaMinutos;
    private String HorarioSaidaHoras;
    private String HorarioSaidaMinutos;

    private String HorarioEntrada;
    private String HorarioSaida;
    private String TempoExperienciaNaArea;
    private String TempoAberta;
    private String NivelHierarquico;
    private String FaixaEtaria;
    private String FaixaEtariaInicio;
    private String FaixaEtariaFim;

    private String IdEstadoCivil;

    private String DescricaoDoPerfil;
    private String DescricaoDaAtividade;
    private String Mensagem;

    private String Solitante;
    private String MotivoDaAbertura;
    private String Responsavel;
    private String NumeroDaVaga;
    private String FunçãoCTPS;
    private String Sindicato;
    private String OutrasRemuneracoes;
    private String AnexoApresentacao;
    private String TelefoneParaContato;
    private String EmailParaContato;
    private String privateado;
    private String DivulgaEmpresa;
    private String Confidencial;
    private String SalarioVisivel;

    private String Pretensao;
    private double PretensaoInicial;
    private double PretensaoFinal;
    private String Beneficios;
    private String Latitude;
    private String Longitude;
    private String Status;
    private String IdStatusVaga;
    private String IdSegmento;
    private String DescricaoSegmento;
    private String DiasSemana;
    private String Empresa;
    private String Localidade;
    private String DataAbertura;
    private String DataFechamento;
    private String GrupoVaga;
    private String NomeFuncaoCTPS;
    private String MotivoAberturaVaga;
    private String QtdVagasEmAberto;
    private String Escolaridade;
    private String RegimeContratacao;
    private Boolean Todos;
    private Boolean Segunda;
    private Boolean Terca;
    private Boolean Quarta;
    private Boolean Quinta;
    private Boolean Sexta;
    private Boolean Sabado;
    private Boolean Domingo;
    private String Idioma;



    private Boolean ValeTransporte;
    private Boolean ValeRefeicao;
    private Boolean ValeAlimentacao;
    private Boolean ValeAlimentacaoLocal;
    private Boolean AssistenciaMedica;
    private Boolean AssistenciaOdontologia;
    private Boolean CestaBasica;
    private Boolean PLR;
    private Boolean SeguroDeVida;
    private Boolean PrevidenciaPrivada;
    private Boolean VeiculoPelaEmpresa;
    private Boolean Estacionamento;
    private Boolean Combustivel;
    private Boolean AuxiliaCreche;
    private Boolean BolsaEducacaoIdioma;
    private Boolean BolsaEducacaoOutros;
    private Boolean Farmacia;
    private Boolean HorarioFlexivel;
    private String DataCriacao;
    private String UsuarioCriacao;
    private String DataAlteracao;
    private String UsuarioAlteracao;
    private String EtapaAtual;
    private String IdCandidatoContratado;
    private String NomeCandidatoContratado;

    private int QtdeVisualizacoesIndeed;
    private int QtdVisualizacoesVaga;
    private int QtdCandidatura;
    private int QtdSelecoes;
    private String Local;
    private String LocalReduzido;

    private String ClusterLocal;
    private String TituloVagaCampoReduzido;

    private String Origem;

    private Boolean CandidatoNaVaga;

    private Boolean VagaFavorita;

    private int CodigoZellar;
    private int CodigoEmpresa;

    private Boolean privateaIndeed;

    private String Cidade;

    private String Estado;

    private String CEP;
    private Boolean CandidatadoParaVaga;

    private Local localObjeto;

    private String PrecisaCNH;
    private String CategoriaCNH;
    private String VagaParaDeficiente;
    private String Deficiencias;
    private String disponibilidadeViagem;
    private String disponibilidadeMudarCidade;
    private String veiculoProprio;

    private String SalarioDiferenciado;
    private String DescricaoDoPerfilCandidato;
    private String NivelHabilidadeIdioma;
    private String IdiomaObrigatorio;
    private String DescricaoMotivoAberturaVaga;
    private String PerfilNaoVisivelCandidato;
    private String DataPrevAdmissao;

    public String getIdLocal()
    {
        return IdLocal;
    }

    public void setIdLocal(String idLocal)
    {
        IdLocal = idLocal;
    }

    public String getTitulo()
    {
        return Titulo;
    }

    public void setTitulo(String titulo)
    {
        Titulo = titulo;
    }

    public String getCodigo()
    {
        return Codigo;
    }

    public void setCodigo(String codigo)
    {
        Codigo = codigo;
    }

    public String getFuncao()
    {
        return Funcao;
    }

    public void setFuncao(String funcao)
    {
        Funcao = funcao;
    }

    public String getIdFuncao()
    {
        return IdFuncao;
    }

    public void setIdFuncao(String idFuncao)
    {
        IdFuncao = idFuncao;
    }

    public String getDescricaoFuncao()
    {
        return DescricaoFuncao;
    }

    public void setDescricaoFuncao(String descricaoFuncao)
    {
        DescricaoFuncao = descricaoFuncao;
    }

    public String getGenero()
    {
        return Genero;
    }

    public void setGenero(String genero)
    {
        Genero = genero;
    }

    public String getEscala()
    {
        return Escala;
    }

    public void setEscala(String escala)
    {
        Escala = escala;
    }

    public String getHorario()
    {
        return Horario;
    }

    public void setHorario(String horario)
    {
        Horario = horario;
    }

    public String getHorarioEntradaHoras()
    {
        return HorarioEntradaHoras;
    }

    public void setHorarioEntradaHoras(String horarioEntradaHoras)
    {
        HorarioEntradaHoras = horarioEntradaHoras;
    }

    public String getHorarioEntradaMinutos()
    {
        return HorarioEntradaMinutos;
    }

    public void setHorarioEntradaMinutos(String horarioEntradaMinutos)
    {
        HorarioEntradaMinutos = horarioEntradaMinutos;
    }

    public String getHorarioSaidaHoras()
    {
        return HorarioSaidaHoras;
    }

    public void setHorarioSaidaHoras(String horarioSaidaHoras)
    {
        HorarioSaidaHoras = horarioSaidaHoras;
    }

    public String getHorarioSaidaMinutos()
    {
        return HorarioSaidaMinutos;
    }

    public void setHorarioSaidaMinutos(String horarioSaidaMinutos)
    {
        HorarioSaidaMinutos = horarioSaidaMinutos;
    }

    public String getHorarioEntrada()
    {
        return HorarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada)
    {
        HorarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida()
    {
        return HorarioSaida;
    }

    public void setHorarioSaida(String horarioSaida)
    {
        HorarioSaida = horarioSaida;
    }

    public String getTempoExperienciaNaArea()
    {
        return TempoExperienciaNaArea;
    }

    public void setTempoExperienciaNaArea(String tempoExperienciaNaArea)
    {
        TempoExperienciaNaArea = tempoExperienciaNaArea;
    }

    public String getTempoAberta()
    {
        return TempoAberta;
    }

    public void setTempoAberta(String tempoAberta)
    {
        TempoAberta = tempoAberta;
    }

    public String getNivelHierarquico()
    {
        return NivelHierarquico;
    }

    public void setNivelHierarquico(String nivelHierarquico)
    {
        NivelHierarquico = nivelHierarquico;
    }

    public String getFaixaEtaria()
    {
        return FaixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria)
    {
        FaixaEtaria = faixaEtaria;
    }

    public String getFaixaEtariaInicio()
    {
        return FaixaEtariaInicio;
    }

    public void setFaixaEtariaInicio(String faixaEtariaInicio)
    {
        FaixaEtariaInicio = faixaEtariaInicio;
    }

    public String getFaixaEtariaFim()
    {
        return FaixaEtariaFim;
    }

    public void setFaixaEtariaFim(String faixaEtariaFim)
    {
        FaixaEtariaFim = faixaEtariaFim;
    }

    public String getIdEstadoCivil()
    {
        return IdEstadoCivil;
    }

    public void setIdEstadoCivil(String idEstadoCivil)
    {
        IdEstadoCivil = idEstadoCivil;
    }

    public String getDescricaoDoPerfil()
    {
        return DescricaoDoPerfil;
    }

    public void setDescricaoDoPerfil(String descricaoDoPerfil)
    {
        DescricaoDoPerfil = descricaoDoPerfil;
    }

    public String getDescricaoDaAtividade()
    {
        return DescricaoDaAtividade;
    }

    public void setDescricaoDaAtividade(String descricaoDaAtividade)
    {
        DescricaoDaAtividade = descricaoDaAtividade;
    }

    public String getMensagem()
    {
        return Mensagem;
    }

    public void setMensagem(String mensagem)
    {
        Mensagem = mensagem;
    }

    public String getSolitante()
    {
        return Solitante;
    }

    public void setSolitante(String solitante)
    {
        Solitante = solitante;
    }

    public String getMotivoDaAbertura()
    {
        return MotivoDaAbertura;
    }

    public void setMotivoDaAbertura(String motivoDaAbertura)
    {
        MotivoDaAbertura = motivoDaAbertura;
    }

    public String getResponsavel()
    {
        return Responsavel;
    }

    public void setResponsavel(String responsavel)
    {
        Responsavel = responsavel;
    }

    public String getNumeroDaVaga()
    {
        return NumeroDaVaga;
    }

    public void setNumeroDaVaga(String numeroDaVaga)
    {
        NumeroDaVaga = numeroDaVaga;
    }

    public String getFunçãoCTPS()
    {
        return FunçãoCTPS;
    }

    public void setFunçãoCTPS(String funçãoCTPS)
    {
        FunçãoCTPS = funçãoCTPS;
    }

    public String getSindicato()
    {
        return Sindicato;
    }

    public void setSindicato(String sindicato)
    {
        Sindicato = sindicato;
    }

    public String getOutrasRemuneracoes()
    {
        return OutrasRemuneracoes;
    }

    public void setOutrasRemuneracoes(String outrasRemuneracoes)
    {
        OutrasRemuneracoes = outrasRemuneracoes;
    }

    public String getAnexoApresentacao()
    {
        return AnexoApresentacao;
    }

    public void setAnexoApresentacao(String anexoApresentacao)
    {
        AnexoApresentacao = anexoApresentacao;
    }

    public String getTelefoneParaContato()
    {
        return TelefoneParaContato;
    }

    public void setTelefoneParaContato(String telefoneParaContato)
    {
        TelefoneParaContato = telefoneParaContato;
    }

    public String getEmailParaContato()
    {
        return EmailParaContato;
    }

    public void setEmailParaContato(String emailParaContato)
    {
        EmailParaContato = emailParaContato;
    }

    public String getPrivateado()
    {
        return privateado;
    }

    public void setPrivateado(String privateado)
    {
        this.privateado = privateado;
    }

    public String getDivulgaEmpresa()
    {
        return DivulgaEmpresa;
    }

    public void setDivulgaEmpresa(String divulgaEmpresa)
    {
        DivulgaEmpresa = divulgaEmpresa;
    }

    public String getConfidencial()
    {
        return Confidencial;
    }

    public void setConfidencial(String confidencial)
    {
        Confidencial = confidencial;
    }

    public String getSalarioVisivel()
    {
        return SalarioVisivel;
    }

    public void setSalarioVisivel(String salarioVisivel)
    {
        SalarioVisivel = salarioVisivel;
    }

    public String getPretensao()
    {
        return Pretensao;
    }

    public void setPretensao(String pretensao)
    {
        Pretensao = pretensao;
    }

    public double getPretensaoInicial()
    {
        return PretensaoInicial;
    }

    public void setPretensaoInicial(double pretensaoInicial)
    {
        PretensaoInicial = pretensaoInicial;
    }

    public double getPretensaoFinal()
    {
        return PretensaoFinal;
    }

    public void setPretensaoFinal(double pretensaoFinal)
    {
        PretensaoFinal = pretensaoFinal;
    }

    public String getBeneficios()
    {
        return Beneficios;
    }

    public void setBeneficios(String beneficios)
    {
        Beneficios = beneficios;
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

    public String getStatus()
    {
        return Status;
    }

    public void setStatus(String status)
    {
        Status = status;
    }

    public String getIdStatusVaga()
    {
        return IdStatusVaga;
    }

    public void setIdStatusVaga(String idStatusVaga)
    {
        IdStatusVaga = idStatusVaga;
    }

    public String getIdSegmento()
    {
        return IdSegmento;
    }

    public void setIdSegmento(String idSegmento)
    {
        IdSegmento = idSegmento;
    }

    public String getDescricaoSegmento()
    {
        return DescricaoSegmento;
    }

    public void setDescricaoSegmento(String descricaoSegmento)
    {
        DescricaoSegmento = descricaoSegmento;
    }

    public String getDiasSemana()
    {
        return DiasSemana;
    }

    public void setDiasSemana(String diasSemana)
    {
        DiasSemana = diasSemana;
    }

    public String getEmpresa()
    {
        return Empresa;
    }

    public void setEmpresa(String empresa)
    {
        Empresa = empresa;
    }

    public String getLocalidade()
    {
        return Localidade;
    }

    public void setLocalidade(String localidade)
    {
        Localidade = localidade;
    }

    public String getDataAbertura()
    {
        return DataAbertura;
    }

    public void setDataAbertura(String dataAbertura)
    {
        DataAbertura = dataAbertura;
    }

    public String getDataFechamento()
    {
        return DataFechamento;
    }

    public void setDataFechamento(String dataFechamento)
    {
        DataFechamento = dataFechamento;
    }

    public String getGrupoVaga()
    {
        return GrupoVaga;
    }

    public void setGrupoVaga(String grupoVaga)
    {
        GrupoVaga = grupoVaga;
    }

    public String getNomeFuncaoCTPS()
    {
        return NomeFuncaoCTPS;
    }

    public void setNomeFuncaoCTPS(String nomeFuncaoCTPS)
    {
        NomeFuncaoCTPS = nomeFuncaoCTPS;
    }

    public String getMotivoAberturaVaga()
    {
        return MotivoAberturaVaga;
    }

    public void setMotivoAberturaVaga(String motivoAberturaVaga)
    {
        MotivoAberturaVaga = motivoAberturaVaga;
    }

    public String getQtdVagasEmAberto()
    {
        return QtdVagasEmAberto;
    }

    public void setQtdVagasEmAberto(String qtdVagasEmAberto)
    {
        QtdVagasEmAberto = qtdVagasEmAberto;
    }

    public String getEscolaridade()
    {
        return Escolaridade;
    }

    public void setEscolaridade(String escolaridade)
    {
        Escolaridade = escolaridade;
    }

    public String getRegimeContratacao()
    {
        return RegimeContratacao;
    }

    public void setRegimeContratacao(String regimeContratacao)
    {
        RegimeContratacao = regimeContratacao;
    }

    public Boolean getTodos()
    {
        return Todos;
    }

    public void setTodos(Boolean todos)
    {
        Todos = todos;
    }

    public Boolean getSegunda()
    {
        return Segunda;
    }

    public void setSegunda(Boolean segunda)
    {
        Segunda = segunda;
    }

    public Boolean getTerca()
    {
        return Terca;
    }

    public void setTerca(Boolean terca)
    {
        Terca = terca;
    }

    public Boolean getQuarta()
    {
        return Quarta;
    }

    public void setQuarta(Boolean quarta)
    {
        Quarta = quarta;
    }

    public Boolean getQuinta()
    {
        return Quinta;
    }

    public void setQuinta(Boolean quinta)
    {
        Quinta = quinta;
    }

    public Boolean getSexta()
    {
        return Sexta;
    }

    public void setSexta(Boolean sexta)
    {
        Sexta = sexta;
    }

    public Boolean getSabado()
    {
        return Sabado;
    }

    public void setSabado(Boolean sabado)
    {
        Sabado = sabado;
    }

    public Boolean getDomingo()
    {
        return Domingo;
    }

    public void setDomingo(Boolean domingo)
    {
        Domingo = domingo;
    }

    public String getIdioma()
    {
        return Idioma;
    }

    public void setIdioma(String idioma)
    {
        Idioma = idioma;
    }

    public Boolean getValeTransporte()
    {
        return ValeTransporte;
    }

    public void setValeTransporte(Boolean valeTransporte)
    {
        ValeTransporte = valeTransporte;
    }

    public Boolean getValeRefeicao()
    {
        return ValeRefeicao;
    }

    public void setValeRefeicao(Boolean valeRefeicao)
    {
        ValeRefeicao = valeRefeicao;
    }

    public Boolean getValeAlimentacao()
    {
        return ValeAlimentacao;
    }

    public void setValeAlimentacao(Boolean valeAlimentacao)
    {
        ValeAlimentacao = valeAlimentacao;
    }

    public Boolean getValeAlimentacaoLocal()
    {
        return ValeAlimentacaoLocal;
    }

    public void setValeAlimentacaoLocal(Boolean valeAlimentacaoLocal)
    {
        ValeAlimentacaoLocal = valeAlimentacaoLocal;
    }

    public Boolean getAssistenciaMedica()
    {
        return AssistenciaMedica;
    }

    public void setAssistenciaMedica(Boolean assistenciaMedica)
    {
        AssistenciaMedica = assistenciaMedica;
    }

    public Boolean getAssistenciaOdontologia()
    {
        return AssistenciaOdontologia;
    }

    public void setAssistenciaOdontologia(Boolean assistenciaOdontologia)
    {
        AssistenciaOdontologia = assistenciaOdontologia;
    }

    public Boolean getCestaBasica()
    {
        return CestaBasica;
    }

    public void setCestaBasica(Boolean cestaBasica)
    {
        CestaBasica = cestaBasica;
    }

    public Boolean getPLR()
    {
        return PLR;
    }

    public void setPLR(Boolean PLR)
    {
        this.PLR = PLR;
    }

    public Boolean getSeguroDeVida()
    {
        return SeguroDeVida;
    }

    public void setSeguroDeVida(Boolean seguroDeVida)
    {
        SeguroDeVida = seguroDeVida;
    }

    public Boolean getPrevidenciaPrivada()
    {
        return PrevidenciaPrivada;
    }

    public void setPrevidenciaPrivada(Boolean previdenciaPrivada)
    {
        PrevidenciaPrivada = previdenciaPrivada;
    }

    public Boolean getVeiculoPelaEmpresa()
    {
        return VeiculoPelaEmpresa;
    }

    public void setVeiculoPelaEmpresa(Boolean veiculoPelaEmpresa)
    {
        VeiculoPelaEmpresa = veiculoPelaEmpresa;
    }

    public Boolean getEstacionamento()
    {
        return Estacionamento;
    }

    public void setEstacionamento(Boolean estacionamento)
    {
        Estacionamento = estacionamento;
    }

    public Boolean getCombustivel()
    {
        return Combustivel;
    }

    public void setCombustivel(Boolean combustivel)
    {
        Combustivel = combustivel;
    }

    public Boolean getAuxiliaCreche()
    {
        return AuxiliaCreche;
    }

    public void setAuxiliaCreche(Boolean auxiliaCreche)
    {
        AuxiliaCreche = auxiliaCreche;
    }

    public Boolean getBolsaEducacaoIdioma()
    {
        return BolsaEducacaoIdioma;
    }

    public void setBolsaEducacaoIdioma(Boolean bolsaEducacaoIdioma)
    {
        BolsaEducacaoIdioma = bolsaEducacaoIdioma;
    }

    public Boolean getBolsaEducacaoOutros()
    {
        return BolsaEducacaoOutros;
    }

    public void setBolsaEducacaoOutros(Boolean bolsaEducacaoOutros)
    {
        BolsaEducacaoOutros = bolsaEducacaoOutros;
    }

    public Boolean getFarmacia()
    {
        return Farmacia;
    }

    public void setFarmacia(Boolean farmacia)
    {
        Farmacia = farmacia;
    }

    public Boolean getHorarioFlexivel()
    {
        return HorarioFlexivel;
    }

    public void setHorarioFlexivel(Boolean horarioFlexivel)
    {
        HorarioFlexivel = horarioFlexivel;
    }

    public String getDataCriacao()
    {
        return DataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
    {
        DataCriacao = dataCriacao;
    }

    public String getUsuarioCriacao()
    {
        return UsuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao)
    {
        UsuarioCriacao = usuarioCriacao;
    }

    public String getDataAlteracao()
    {
        return DataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao)
    {
        DataAlteracao = dataAlteracao;
    }

    public String getUsuarioAlteracao()
    {
        return UsuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao)
    {
        UsuarioAlteracao = usuarioAlteracao;
    }

    public String getEtapaAtual()
    {
        return EtapaAtual;
    }

    public void setEtapaAtual(String etapaAtual)
    {
        EtapaAtual = etapaAtual;
    }

    public String getIdCandidatoContratado()
    {
        return IdCandidatoContratado;
    }

    public void setIdCandidatoContratado(String idCandidatoContratado)
    {
        IdCandidatoContratado = idCandidatoContratado;
    }

    public String getNomeCandidatoContratado()
    {
        return NomeCandidatoContratado;
    }

    public void setNomeCandidatoContratado(String nomeCandidatoContratado)
    {
        NomeCandidatoContratado = nomeCandidatoContratado;
    }

    public int getQtdeVisualizacoesIndeed()
    {
        return QtdeVisualizacoesIndeed;
    }

    public void setQtdeVisualizacoesIndeed(int qtdeVisualizacoesIndeed)
    {
        QtdeVisualizacoesIndeed = qtdeVisualizacoesIndeed;
    }

    public int getQtdVisualizacoesVaga()
    {
        return QtdVisualizacoesVaga;
    }

    public void setQtdVisualizacoesVaga(int qtdVisualizacoesVaga)
    {
        QtdVisualizacoesVaga = qtdVisualizacoesVaga;
    }

    public int getQtdCandidatura()
    {
        return QtdCandidatura;
    }

    public void setQtdCandidatura(int qtdCandidatura)
    {
        QtdCandidatura = qtdCandidatura;
    }

    public int getQtdSelecoes()
    {
        return QtdSelecoes;
    }

    public void setQtdSelecoes(int qtdSelecoes)
    {
        QtdSelecoes = qtdSelecoes;
    }

    public String getLocal()
    {
        return Local;
    }

    public void setLocal(String local)
    {
        Local = local;
    }

    public String getLocalReduzido()
    {
        return LocalReduzido;
    }

    public void setLocalReduzido(String localReduzido)
    {
        LocalReduzido = localReduzido;
    }

    public String getClusterLocal()
    {
        return ClusterLocal;
    }

    public void setClusterLocal(String clusterLocal)
    {
        ClusterLocal = clusterLocal;
    }

    public String getTituloVagaCampoReduzido()
    {
        return TituloVagaCampoReduzido;
    }

    public void setTituloVagaCampoReduzido(String tituloVagaCampoReduzido)
    {
        TituloVagaCampoReduzido = tituloVagaCampoReduzido;
    }

    public String getOrigem()
    {
        return Origem;
    }

    public void setOrigem(String origem)
    {
        Origem = origem;
    }

    public Boolean getCandidatoNaVaga()
    {
        return CandidatoNaVaga;
    }

    public void setCandidatoNaVaga(Boolean candidatoNaVaga)
    {
        CandidatoNaVaga = candidatoNaVaga;
    }

    public Boolean getVagaFavorita()
    {
        return VagaFavorita;
    }

    public void setVagaFavorita(Boolean vagaFavorita)
    {
        VagaFavorita = vagaFavorita;
    }

    public int getCodigoZellar()
    {
        return CodigoZellar;
    }

    public void setCodigoZellar(int codigoZellar)
    {
        CodigoZellar = codigoZellar;
    }

    public int getCodigoEmpresa()
    {
        return CodigoEmpresa;
    }

    public void setCodigoEmpresa(int codigoEmpresa)
    {
        CodigoEmpresa = codigoEmpresa;
    }

    public Boolean getPrivateaIndeed()
    {
        return privateaIndeed;
    }

    public void setPrivateaIndeed(Boolean privateaIndeed)
    {
        this.privateaIndeed = privateaIndeed;
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

    public String getCEP()
    {
        return CEP;
    }

    public void setCEP(String CEP)
    {
        this.CEP = CEP;
    }

    public Boolean getCandidatadoParaVaga()
    {
        return CandidatadoParaVaga;
    }

    public void setCandidatadoParaVaga(Boolean candidatadoParaVaga)
    {
        CandidatadoParaVaga = candidatadoParaVaga;
    }

    public String getIdUsuario()
    {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        IdUsuario = idUsuario;
    }

    public br.com.zelar.zellarempresas.Empresas.Local getLocalObjeto() {
        return localObjeto;
    }

    public void setLocalObjeto(br.com.zelar.zellarempresas.Empresas.Local localObjeto) {
        this.localObjeto = localObjeto;
    }

    @Override
    public String toString()
    {
        return this.Titulo;
    }


    public String getPrecisaCNH() {
        return PrecisaCNH;
    }

    public void setPrecisaCNH(String precisaCNH) {
        PrecisaCNH = precisaCNH;
    }

    public String getCategoriaCNH() {
        return CategoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        CategoriaCNH = categoriaCNH;
    }

    public String getVagaParaDeficiente() {
        return VagaParaDeficiente;
    }

    public void setVagaParaDeficiente(String vagaParaDeficiente) {
        VagaParaDeficiente = vagaParaDeficiente;
    }

    public String getDeficiencias() {
        return Deficiencias;
    }

    public void setDeficiencias(String deficiencias) {
        Deficiencias = deficiencias;
    }

    public String getDisponibilidadeViagem() {
        return disponibilidadeViagem;
    }

    public void setDisponibilidadeViagem(String disponibilidadeViagem) {
        this.disponibilidadeViagem = disponibilidadeViagem;
    }

    public String getDisponibilidadeMudarCidade() {
        return disponibilidadeMudarCidade;
    }

    public void setDisponibilidadeMudarCidade(String disponibilidadeMudarCidade) {
        this.disponibilidadeMudarCidade = disponibilidadeMudarCidade;
    }

    public String getVeiculoProprio() {
        return veiculoProprio;
    }

    public void setVeiculoProprio(String veiculoProprio) {
        this.veiculoProprio = veiculoProprio;
    }

    public String getSalarioDiferenciado() {
        return SalarioDiferenciado;
    }

    public void setSalarioDiferenciado(String salarioDiferenciado) {
        SalarioDiferenciado = salarioDiferenciado;
    }

    public String getDescricaoDoPerfilCandidato() {
        return DescricaoDoPerfilCandidato;
    }

    public void setDescricaoDoPerfilCandidato(String descricaoDoPerfilCandidato) {
        DescricaoDoPerfilCandidato = descricaoDoPerfilCandidato;
    }

    public String getNivelHabilidadeIdioma() {
        return NivelHabilidadeIdioma;
    }

    public void setNivelHabilidadeIdioma(String nivelHabilidadeIdioma) {
        NivelHabilidadeIdioma = nivelHabilidadeIdioma;
    }

    public String getIdiomaObrigatorio() {
        return IdiomaObrigatorio;
    }

    public void setIdiomaObrigatorio(String idiomaObrigatorio) {
        IdiomaObrigatorio = idiomaObrigatorio;
    }

    public String getDescricaoMotivoAberturaVaga() {
        return DescricaoMotivoAberturaVaga;
    }

    public void setDescricaoMotivoAberturaVaga(String descricaoMotivoAberturaVaga) {
        DescricaoMotivoAberturaVaga = descricaoMotivoAberturaVaga;
    }

    public String getPerfilNaoVisivelCandidato() {
        return PerfilNaoVisivelCandidato;
    }

    public void setPerfilNaoVisivelCandidato(String perfilNaoVisivelCandidato) {
        PerfilNaoVisivelCandidato = perfilNaoVisivelCandidato;
    }

    public String getDataPrevAdmissao() {
        return DataPrevAdmissao;
    }

    public void setDataPrevAdmissao(String dataPrevAdmissao) {
        DataPrevAdmissao = dataPrevAdmissao;
    }
}
