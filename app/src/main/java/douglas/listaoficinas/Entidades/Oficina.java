package douglas.listaoficinas.Entidades;


public class Oficina {


    private int id;
    private String nome;
    private String descricao;
    private String descricaoCurta;
    private String endereco;
    private String Latitude;
    private String Longitude;
    private String Foto;
    private int AvaliacaoUsuario;
    private int codigoAssociacao;
    private String email;
    private String Telefone1;
    private String Telefone2;
    private boolean ativo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public int getAvaliacaoUsuario() {
        return AvaliacaoUsuario;
    }

    public void setAvaliacaoUsuario(int avaliacaoUsuario) {
        AvaliacaoUsuario = avaliacaoUsuario;
    }

    public int getCodigoAssociacao() {
        return codigoAssociacao;
    }

    public void setCodigoAssociacao(int codigoAssociacao) {
        this.codigoAssociacao = codigoAssociacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return Telefone1;
    }

    public void setTelefone1(String telefone1) {
        Telefone1 = telefone1;
    }

    public String getTelefone2() {
        return Telefone2;
    }

    public void setTelefone2(String telefone2) {
        Telefone2 = telefone2;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
