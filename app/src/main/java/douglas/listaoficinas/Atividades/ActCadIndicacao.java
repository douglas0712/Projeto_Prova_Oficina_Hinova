package douglas.listaoficinas.Atividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import douglas.listaoficinas.Entidades.Indicacao;
import douglas.listaoficinas.Controles.ControleIndicacao;
import douglas.listaoficinas.EnumMensagemErro;
import douglas.listaoficinas.MensagemErro;
import douglas.listaoficinas.R;
import douglas.listaoficinas.Util;

public class ActCadIndicacao extends AppCompatActivity {

    EditText txtCPFAssociado;
    EditText txtEmailAssociado;
    EditText txtNomeAssociado;
    EditText txtTelefoneAssociado;
    EditText txtPlacaVeiculo;
    EditText txtNomeAmigo;
    EditText txtTelefoneAmigo;
    EditText txtEmailAmigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_indicacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = (Button) findViewById(R.id.btnEnviar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnEnviar();
            }
        });



    }


    private Indicacao criarObjIndicacao() {

        Indicacao indicacao = new Indicacao();

        EditText txtCPFAssociado = (EditText)findViewById(R.id.txtCpfAssociado);
        EditText txtEmailAssociado = (EditText)findViewById(R.id.txtEmailAssociado);
        EditText txtNomeAssociado = (EditText)findViewById(R.id.txtNomeAssociado);
        EditText txtTelefoneAssociado = (EditText)findViewById(R.id.txtTelefoneAssociado);
        EditText txtPlacaVeiculo = (EditText)findViewById(R.id.txtPlacaVeiculoAssociado);
        EditText txtNomeAmigo = (EditText)findViewById(R.id.txtNomeAmigo);
        EditText txtTelefoneAmigo = (EditText)findViewById(R.id.txtTelefoneAmigo);
        EditText txtEmailAmigo = (EditText)findViewById(R.id.txtEmailAmigo);

        indicacao.setCodigoAssociacao(601);
        indicacao.setDataCriacao(new Date());
        indicacao.setCpfAssociado(txtCPFAssociado.getText().toString());
        indicacao.setEmailAssociado(txtEmailAssociado.getText().toString());
        indicacao.setNomeAssociado(txtNomeAssociado.getText().toString());
        indicacao.setTelefoneAssociado(txtTelefoneAmigo.getText().toString());
        indicacao.setPlacaVeiculoAssociado(txtPlacaVeiculo.getText().toString());
        indicacao.setNomeAmigo(txtNomeAmigo.getText().toString());
        indicacao.setTelefoneAmigo(txtTelefoneAmigo.getText().toString());
        indicacao.setEmailAmigo(txtEmailAmigo.getText().toString());

        return indicacao;
    }

    public void onClickBtnEnviar() {


        try {

            receberFormularioIndicacao();

            if (!validaCadastroIndicacao())
                throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_PREENCHA_TODOS_OS_CAMPOS.getMsg());


                Indicacao indicacao = criarObjIndicacao();


                ControleIndicacao.processarEnvioDeIndicacao(indicacao);

                Util.ExibirMensagemNaTela(ActCadIndicacao.this, "Sucesso ao Enviar Indicação!");

                abrirTelaPrincipal();

        } catch (MensagemErro mensagemErro) {
            Util.ExibirMensagemNaTela(ActCadIndicacao.this, mensagemErro.getMsg());
        }catch (Exception ex) {
            Util.ExibirMensagemNaTela(ActCadIndicacao.this, EnumMensagemErro.MENSAGEM_ERRO_GENERICO.getMsg());
        }



    }

    public void abrirTelaPrincipal(){
        Intent it =new Intent(ActCadIndicacao.this, ActMain.class);
        startActivity(it);

    }


    public boolean validaCadastroIndicacao () {



        if (txtCPFAssociado.getText().toString().equals(""))
            return false;
        if (txtEmailAssociado.getText().toString().equals(""))
            return false;
        if (txtNomeAssociado.getText().toString().equals(""))
            return false;
        if (txtTelefoneAssociado.getText().toString().equals(""))
            return false;
        if (txtPlacaVeiculo.getText().toString().equals(""))
            return false;
        if (txtNomeAmigo.getText().toString().equals(""))
            return false;
        if (txtTelefoneAmigo.getText().toString().equals(""))
            return false;
        if (txtEmailAmigo.getText().toString().equals(""))
            return false;


        return true;

    }

    public void receberFormularioIndicacao() {
        txtCPFAssociado = (EditText)findViewById(R.id.txtCpfAssociado);
        txtEmailAssociado = (EditText)findViewById(R.id.txtEmailAssociado);
        txtNomeAssociado = (EditText)findViewById(R.id.txtNomeAssociado);
        txtTelefoneAssociado = (EditText)findViewById(R.id.txtTelefoneAssociado);
        txtPlacaVeiculo = (EditText)findViewById(R.id.txtPlacaVeiculoAssociado);
        txtNomeAmigo = (EditText)findViewById(R.id.txtNomeAmigo);
        txtTelefoneAmigo = (EditText)findViewById(R.id.txtTelefoneAmigo);
        txtEmailAmigo = (EditText)findViewById(R.id.txtEmailAmigo);
    }












}
