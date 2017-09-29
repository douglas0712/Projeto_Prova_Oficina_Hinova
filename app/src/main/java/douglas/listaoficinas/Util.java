package douglas.listaoficinas;


import android.app.Activity;
import android.os.StrictMode;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static void ExibirMensagemNaTela(Activity act, String msg) {

        Toast toast = Toast.makeText(act, msg, Toast.LENGTH_LONG);
        toast.show();

    }


    public static boolean isNullOrEmpty(Object obj){

        return (obj == null || obj == "");


    }

    public static void setStrictMode() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public static String trataFormatoData(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }


}
