package douglas.listaoficinas;

public enum EnumMensagemErro {

    MENSAGEM_ERRO_GENERICO(1, "Ocorreu algum erro inesperado!"),
    MENSAGEM_ERRO_ACESSO_INTERNET(2, "Não existe conexão com a internet!"),
    MENSAGEM_ERRO_PERMISSAO_INTERNET(3, "Permissão de acesso a internet não concedida"),
    MENSAGEM_ERRO_API_INDICACAO(4, "Erro ao acessar o serviço de Indicação"),
    MENSAGEM_ERRO_API_GET_OFICINAS(5, "Erro ao acessar o serviço de Oficinas"),
    MENSAGEM_ERRO_CRIAR_LISTA_OFICINAS(6, "Erro criar a lista de Oficinas"),
    MENSAGEM_ERRO_LER_DADOS_API(7, "Erro ao ler dados da API"),
    MENSAGEM_ERRO_CONVERTER_API_EM_OBJ(8, "Erro ao converter os dados da API!"),
    MENSAGEM_ERRO_FECHAR_CONEXAO(8, "Erro ao fechar conexão com API!"),
    MENSAGEM_ERRO_PEGAR_DADOS_DO_JSON(8, "Erro ao pegar dados do json"),
    MENSAGEM_ERRO_CONVERTER_INDICACAO_EM_JSON(8, "Erro ao converter indicacao em JSON"),
    MENSAGEM_ERRO_ENVIAR_INDICACAO_API(8, "Erro ao enviar a indicacao para a API"),
    MENSAGEM_ERRO_VERIFICAR_EXISTENCIA_ERROS_INDICACAO(8, "Erro ao verificar a existencia de erros no retorno da api Indicacao"),
    MENSAGEM_ERRO_CONVERTER_RETORNO_API_INDICACAO_EM_OBJ(8, "Erro ao converter retorno da api indicacao em obj!"),
    MENSAGEM_ERRO_LER_RETORNO_API_INDICACAO(8, "Ler retorno API indicacao!"),
    MENSAGEM_ERRO_NO_SERVICO_INDICACAO(8, "Erro NO serviço de indicação!"),
    MENSAGEM_ERRO_AO_FECHr_CONEXAO_API_INDICACAO(8, "Erro NO serviço de indicação!");



    private int id;
    private String msg;

    private EnumMensagemErro(int id, String msg) {
        this.setId(id);
        this.setMsg(msg);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}