package douglas.listaoficinas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import douglas.listaoficinas.Entidades.Oficina;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class OficinaAdapter extends RecyclerView.Adapter<OficinaAdapter.ViewHolderOficina> implements View.OnClickListener {

    private List<Oficina> dados;
    private View.OnClickListener listener;


    public OficinaAdapter(List<Oficina> dados) {
        this.dados = dados;

    }

    @Override
    public OficinaAdapter.ViewHolderOficina onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);

        ViewHolderOficina holderOficina =new ViewHolderOficina(view);
        view.setOnClickListener(this);

        return holderOficina;
    }

    @Override
    public void onBindViewHolder(OficinaAdapter.ViewHolderOficina holder, int position) {


        if ((dados != null) && (dados.size() > 0)){
            Oficina oficina = dados.get(position);
            holder.txtNome.setText(oficina.getNome());
            holder.txtDescricao.setText(oficina.getDescricaoCurta());

            String encodedImage = oficina.getFoto();
            byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            holder.imgOfinica.setImageBitmap(decodedByte);


        }

    }




    @Override
    public int getItemCount() {
        return dados.size();
    }
    public void setOnClickListener (View.OnClickListener listener) {
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public class ViewHolderOficina extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtDescricao;
        public ImageView imgOfinica;


        public ViewHolderOficina(View intentView) {

            super(intentView);

            txtNome = (TextView)itemView.findViewById(R.id.txtNome);
            txtDescricao = (TextView)itemView.findViewById(R.id.txtDescricao);
            imgOfinica = (ImageView)itemView.findViewById(R.id.imgOficina);


        }

    }

}



