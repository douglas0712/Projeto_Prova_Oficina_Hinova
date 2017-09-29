package douglas.listaoficinas.Controles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import douglas.listaoficinas.CONSTANTES;
import douglas.listaoficinas.Entidades.Indicacao;
import douglas.listaoficinas.EnumMensagemErro;
import douglas.listaoficinas.MensagemErro;
import douglas.listaoficinas.Util;


public class ControleIndicacao {


    public static void processarEnvioDeIndicacao(Indicacao indicacao) throws MensagemErro {



        try {
            JSONObject jsonObjIndicacao =  converterObjIndicacaoEmJson(indicacao);


            HttpURLConnection conexao = criarObjConexaoApi(jsonObjIndicacao);

            BufferedReader retornoApi = lerRetornoApi(conexao);

            JSONObject objRetornoApi = tranformarRetornoApiEmObj(retornoApi);

            fecharConexaoApiIndicacao(retornoApi);
            
            verificarExistenciaDeErroNoObjRetornoApi(objRetornoApi);


        } catch(MensagemErro e) {
            throw  new MensagemErro(e.getMsg());

        }

    }


    public static void verificarExistenciaDeErroNoObjRetornoApi (JSONObject objRetornoApi) {

        //verificar existencia de erro no retorno da api
        //
        //throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_NO_SERVICO_INDICACAO.getMsg());
        //

    }

    public static JSONObject tranformarRetornoApiEmObj(BufferedReader retornoApi) throws MensagemErro {
        try {
            StringBuilder content = new StringBuilder();
            String line;



            while ((line = retornoApi.readLine()) != null) {
                content.append(line + "\n");

            }

            String jsonString = content.toString();
            return  new JSONObject(jsonString);
        } catch (Exception e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_CONVERTER_RETORNO_API_INDICACAO_EM_OBJ.getMsg());
        }
    }

    public static void fecharConexaoApiIndicacao(BufferedReader retornoApi) throws MensagemErro {
        try {
            retornoApi.close();
        } catch (IOException e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_AO_FECHAR_CONEXAO_API_INDICACAO.getMsg());
        }


    }

    public static BufferedReader lerRetornoApi(HttpURLConnection conexao) throws MensagemErro {

        try {

            BufferedReader retornoApi =
               new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            return retornoApi;

        } catch (Exception e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_LER_RETORNO_API_INDICACAO.getMsg());
        }
    }


    public static HttpURLConnection criarObjConexaoApi(JSONObject jsonObjIndicacao)  throws MensagemErro {
        try {
            URL url = new URL(CONSTANTES.URL_API_INDICACAO);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.getOutputStream().write(jsonObjIndicacao.toString().getBytes("UTF-8"));

            return connection;


        } catch (Exception e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_ENVIAR_INDICACAO_API.getMsg());
        }

    }



    public static JSONObject converterObjIndicacaoEmJson(Indicacao indicacao) throws MensagemErro {

        try {
        JSONObject jResult = new JSONObject();
        JSONArray jArray = new JSONArray();

        JSONObject jGroup = new JSONObject();


            jGroup.put("CodigoAssociacao", indicacao.getCodigoAssociacao());
            jGroup.put("DataCriacao", Util.trataFormatoData(indicacao.getDataCriacao()));
            jGroup.put("CpfAssociado", indicacao.getCpfAssociado());
            jGroup.put("EmailAssociado",indicacao.getEmailAssociado());
            jGroup.put("NomeAssociado", indicacao.getNomeAssociado());
            jGroup.put("TelefoneAssociado", indicacao.getTelefoneAssociado());
            jGroup.put("PlacaVeiculoAssociado", indicacao.getPlacaVeiculoAssociado());
            jGroup.put("NomeAmigo", indicacao.getNomeAmigo());
            jGroup.put("TelefoneAmigo", indicacao.getTelefoneAmigo());
            jGroup.put("EmailAmigo", indicacao.getEmailAmigo());

            jResult.put("Indicacao", jGroup);
            jResult.put("Remetente", "teste.douglas@hinovamobile.com.br");
            jResult.put("Copias", jArray);


            return jResult;
        } catch (JSONException e) {
            throw  new MensagemErro(EnumMensagemErro.MENSAGEM_ERRO_CONVERTER_INDICACAO_EM_JSON.getMsg());

        }

    }



}
