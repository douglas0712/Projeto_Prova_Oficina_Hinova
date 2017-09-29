package douglas.listaoficinas;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import douglas.listaoficinas.Entidades.Indicacao;
import douglas.listaoficinas.Entidades.Oficina;
import douglas.listaoficinas.Controles.ControleIndicacao;

public class ActCadIndicacao extends AppCompatActivity {

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

        if (!validaCadastroIndicacao())
            return;

        Indicacao indicacao = criarObjIndicacao();

        try {
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

        return true;

    }












}
