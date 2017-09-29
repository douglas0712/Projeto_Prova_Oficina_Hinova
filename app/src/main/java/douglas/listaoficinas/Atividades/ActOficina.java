package douglas.listaoficinas.Atividades;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import douglas.listaoficinas.R;

public class ActOficina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_oficina);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        exibirOficinaNaTela();
    }


    public void exibirOficinaNaTela() {


        ActOficina.this.setTitle(ActMain.oficinaSelectionada.getNome());

        String encodedImage = ActMain.oficinaSelectionada.getFoto();
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        ImageView img = (ImageView) findViewById(R.id.imgOficina);

        img.setImageBitmap(decodedByte);

        TextView tvNome = (TextView) findViewById(R.id.txtNome);
        TextView tvDescricao = (TextView) findViewById(R.id.txtDescricao);
        TextView tvDescricaoCurta = (TextView) findViewById(R.id.txtDescricaoCurta);
        TextView tvEmail = (TextView) findViewById(R.id.txtEmail);
        TextView tvEndereco = (TextView) findViewById(R.id.txtEndereco);
        TextView tvTelefone = (TextView) findViewById(R.id.txtTelefone);
        CheckBox tvAtivo = (CheckBox) findViewById(R.id.chkAtivo);


         tvNome.setText(ActMain.oficinaSelectionada.getNome());
         tvDescricao.setText(ActMain.oficinaSelectionada.getDescricao());
         tvDescricaoCurta.setText(ActMain.oficinaSelectionada.getDescricaoCurta());
         tvEmail.setText(ActMain.oficinaSelectionada.getEmail());
         tvEndereco.setText(ActMain.oficinaSelectionada.getEndereco());
         tvTelefone.setText(ActMain.oficinaSelectionada.getTelefone1());
         tvAtivo.setChecked(ActMain.oficinaSelectionada.isAtivo());


        Button btnEnviar = (Button) findViewById(R.id.btnIndicacao);
        tvEndereco.setPaintFlags(tvEndereco.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnEndereco();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnIndicacao();
            }
        });;




    }



    public void onClickBtnEndereco() {

        Intent it = new Intent(ActOficina.this, ActMap.class);
        startActivity(it);
    }

    public void onClickBtnIndicacao(){
        Intent it = new Intent(ActOficina.this, ActCadIndicacao.class);
        startActivity(it);

    }





}
