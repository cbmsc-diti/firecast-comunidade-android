package br.gov.sc.cbm.fccomunidade.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.gov.sc.cbm.fccomunidade.domain.Occurrence;
import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;
import rx.Observable;

/**
 * Created by bonet on 9/30/16.
 */

public class FirecastMockClient implements OccurrenceRepository {


    private List<Occurrence> occurences;

    public FirecastMockClient() {

        init();
    }

    private void init() {
        occurences = new Gson().fromJson(occurencesString, new TypeToken<ArrayList<Occurrence>>() {}.getType());

    }



    @Override
    public Observable<List<Occurrence>> getOccurrences() {
        return Observable.just(occurences).delay(2, TimeUnit.SECONDS);
    }


    private String occurencesString = "[{\"id\":\"10058028\",\"ts\":\"2016-09-30 10:23:32.901127\",\"descricao\":\"SIMULADO\",\"logradouro\":\"OSNI\",\"numero\":\"510\",\"complemento\":null,\"bairro\":\"ALTO ARIRI\\u00da\",\"referencia\":null,\"cidade\":{\"id\":\"8233\",\"nome\":\"PALHOCA\"},\"tipoEmergencia\":{\"id\":\"9\",\"nome\":\"A\\u00c7\\u00d5ES PREVENTIVAS\"},\"listViatura\":[{\"id\":0,\"nome\":\"ABTR-028, ABTR-043, AR-76\"}],\"latitude\":\"-27.6600866\",\"longitude\":\"-48.6869806\"},{\"id\":\"10058037\",\"ts\":\"2016-09-30 13:34:51.248741\",\"descricao\":\"AVERIGUA\\u00c7\\u00c3O DE INSETOS.\",\"logradouro\":\"SC 410\",\"numero\":null,\"complemento\":null,\"bairro\":\"AREIAS DE CIMA\",\"referencia\":\"KM 01\",\"cidade\":{\"id\":\"8111\",\"nome\":\"GOVERNADOR CELSO RAMOS\"},\"tipoEmergencia\":{\"id\":\"10\",\"nome\":\"AVERIGUAC\\u00c3O \\/ CORTE DE \\u00c1RVORE\"},\"listViatura\":[{\"id\":0,\"nome\":\"ABS-02\"}],\"latitude\":\"-27.3735518\",\"longitude\":\"-48.6446345\"},{\"id\":\"10058038\",\"ts\":\"2016-09-30 14:03:14.940033\",\"descricao\":\"CORTE ARVORE\",\"logradouro\":\"NICOLAU MOURA CARVALHO\",\"numero\":null,\"complemento\":null,\"bairro\":\"CAEIRA DO NORTE\",\"referencia\":\"PLACA RECANTO DOS GUEDES\",\"cidade\":{\"id\":\"8111\",\"nome\":\"GOVERNADOR CELSO RAMOS\"},\"tipoEmergencia\":{\"id\":\"10\",\"nome\":\"AVERIGUAC\\u00c3O \\/ CORTE DE \\u00c1RVORE\"},\"listViatura\":[{\"id\":0,\"nome\":\"ABS-02\"}],\"latitude\":null,\"longitude\":null},{\"id\":\"10058042\",\"ts\":\"2016-09-30 16:01:16.732129\",\"descricao\":\"QUEDA DE CICLISTA.\",\"logradouro\":\"BAR\\u00c3O DO RIO BRANCO\",\"numero\":null,\"complemento\":null,\"bairro\":\"CENTRO\",\"referencia\":\"EM FRENTE A CLINICA S\\u00c3O LUCAS\",\"cidade\":{\"id\":\"8233\",\"nome\":\"PALHOCA\"},\"tipoEmergencia\":{\"id\":\"8\",\"nome\":\"ACIDENTE DE TR\\u00c2NSITO\"},\"listViatura\":[{\"id\":0,\"nome\":\"ASU-334\"}],\"latitude\":\"-27.6457111\",\"longitude\":\"-48.667803\"}]";
    private String emptyOccurences = "";
}
