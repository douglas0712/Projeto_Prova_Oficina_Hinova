package douglas.listaoficinas.Atividades;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import douglas.listaoficinas.Entidades.Oficina;
import douglas.listaoficinas.Controles.ControleOficina;
import douglas.listaoficinas.EnumMensagemErro;
import douglas.listaoficinas.MensagemErro;
import douglas.listaoficinas.OficinaAdapter;
import douglas.listaoficinas.R;
import douglas.listaoficinas.Util;

public class ActMain extends AppCompatActivity {

    private RecyclerView recicleViewListaDados;
    private ConstraintLayout layoutContent;
    private OficinaAdapter oficinaAdapter;

    public  static Oficina oficinaSelectionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Util.setStrictMode();





        recicleViewListaDados = (RecyclerView) findViewById(R.id.recicleViewListaDados);
        layoutContent = (ConstraintLayout) findViewById(R.id.layoutContent);
        LinearLayoutManager linear = new LinearLayoutManager(this);
        recicleViewListaDados.setLayoutManager(linear);

        ExibirListaOficinaNaTela();

    }


    public void ExibirListaOficinaNaTela() {


        try {

            ActMain.this.setTitle("Lista de Oficinas");

            final List<Oficina> lstOficina = ControleOficina.buscarOficinas();
            oficinaAdapter = new OficinaAdapter(lstOficina);
            recicleViewListaDados.setAdapter(oficinaAdapter);

            oficinaAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    oficinaSelectionada = lstOficina.get(recicleViewListaDados.getChildAdapterPosition(view));

                    Intent it = new Intent(ActMain.this, ActOficina.class);
                    startActivity(it);

                }
            });

        } catch (MensagemErro mensagemErro) {
            Util.ExibirMensagemNaTela(ActMain.this, mensagemErro.getMsg());
        } catch (Exception ex) {
            Util.ExibirMensagemNaTela(ActMain.this, EnumMensagemErro.MENSAGEM_ERRO_GENERICO.getMsg());
        }

    }



    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected())
            return true;
        else
            return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean permissaoDeInternetGarantida() {
        return  (checkSelfPermission(android.Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
