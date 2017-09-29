package douglas.listaoficinas;


public class MensagemErro extends Throwable {
    private int id;
    private String msg;


    public MensagemErro(String msg){
     this.setMsg(msg);
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
