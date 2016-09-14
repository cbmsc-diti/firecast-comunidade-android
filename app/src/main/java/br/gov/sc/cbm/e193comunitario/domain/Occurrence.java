package br.gov.sc.cbm.e193comunitario.domain;

import com.google.gson.annotations.SerializedName;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

/**
 * Created by bonet on 9/13/16.
 */

public class Occurrence {

    @SerializedName("id_ocorrencia")
    public int id;

    @SerializedName("dt_ocorrencia")
    public String date;

    @SerializedName("hora")
    public String time;

    @SerializedName("emergencia")
    public String type;

    @SerializedName("logradouro")
    public String adressStreet;

    @SerializedName("numero")
    public int addressNumber;

    @SerializedName("bairro")
    public String neighborhood;

    @SerializedName("cidade")
    public String city;

    @SerializedName("referencia")
    public String referencePoint;

    @SerializedName("chegada_ocorrencia")
    public String arrivalTime;

    @SerializedName("saida_ocorrencia")
    public String exitTime;
    
    @SerializedName("solicitante")
    public String solicitantName;

    @SerializedName("telefone_solicitante")
    public long solicitantNumber;

    @SerializedName("historico")
    public String history;
    
    @SerializedName("orgao_apoio")
    public String support;

    @SerializedName("recursos_materiais")
    public String materialResources;

}
