package douglas.listaoficinas.Controles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import douglas.listaoficinas.CONSTANTES;
import douglas.listaoficinas.Entidades.Oficina;
import douglas.listaoficinas.MensagemErro;
import douglas.listaoficinas.EnumMensagemErro;
public class ControleOficina {


    public static List<Oficina> buscarOficinas() throws MensagemErro{

        try {


            BufferedReader reader = lerDadosApi();
            JSONArray jsonArrayOficinas =  pegarOficinasDoObjJSON(reader);
            List<Oficina> listaOficinas =  criarListaOficina(jsonArrayOficinas);
            fecharConexao(reader);

            return listaOficinas;

        } catch(MensagemErro e) {
            throw  new MensagemErro(e.getMsg());

        }


    }

    public static JSONArray pegarOficinasDoObjJSON (BufferedReader reader) throws MensagemErro {



        try {
            String jsonString = criarStrJsonFromObj(reader);
            JSONObject obj =   new JSONObject(jsonString);
            JSONArray array= obj.getJSONArray("ListaOficinas");

            jsonString = criarStrJsonFromObj(reader);
            return array;
        }  catch (JSONException e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_PEGAR_DADOS_DO_JSON.getMsg());
        }


    }


    public static void fecharConexao(BufferedReader reader) throws MensagemErro {

        try {
            reader.close();
        } catch (IOException e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_FECHAR_CONEXAO.getMsg());
        }
    }


    public static String criarStrJsonFromObj (BufferedReader reader) throws MensagemErro {

        try {


            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line + "\n");
            }
            return content.toString();



        } catch (IOException e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_CONVERTER_API_EM_OBJ.getMsg());
        }
    }

    public static BufferedReader lerDadosApi() throws MensagemErro {


       try {
           String theUrl = CONSTANTES.URL_API_OFICINAS;

           URL url = new URL(theUrl);

           URLConnection urlConnection = url.openConnection();

           BufferedReader bufferedReader =
                   new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

           return  bufferedReader;

       } catch (IOException ex){
           throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_LER_DADOS_API.getMsg());

       }

    }



    public static List<Oficina> criarListaOficina(JSONArray array) throws MensagemErro {
        try{
            List<Oficina> lstOficina = new ArrayList<>();

            Oficina c;

            for (int i=0;i < array.length(); i++) {
                c = new Oficina();

                c.setId((Integer)array.getJSONObject(i).get("Id"));
                c.setNome((String)array.getJSONObject(i).get("Nome"));
                c.setDescricao((String)array.getJSONObject(i).get("Descricao"));
                c.setDescricaoCurta((String)array.getJSONObject(i).get("DescricaoCurta"));
                c.setEndereco((String)array.getJSONObject(i).get("Endereco"));
                c.setLatitude((String)array.getJSONObject(i).get("Latitude"));
                c.setLongitude((String)array.getJSONObject(i).get("Longitude"));
                c.setFoto((String)array.getJSONObject(i).get("Foto"));
                c.setAvaliacaoUsuario((Integer)array.getJSONObject(i).get("AvaliacaoUsuario"));
                c.setCodigoAssociacao((Integer)array.getJSONObject(i).get("CodigoAssociacao"));
                c.setEmail((String)array.getJSONObject(i).get("Email"));
                // c.setTelefone1((String)array.getJSONObject(i).get("Telefone1"));
                //c.setTelefone2((String)array.getJSONObject(i).get("Telefone2"));
                 c.setAtivo((Boolean) array.getJSONObject(i).get("Ativo"));

                lstOficina.add(c);
            }

            return lstOficina;



        }catch (JSONException ex){

            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_CRIAR_LISTA_OFICINAS.getMsg());

        }
    }

}
