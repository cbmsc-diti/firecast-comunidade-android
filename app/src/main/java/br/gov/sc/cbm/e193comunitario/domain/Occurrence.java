package br.gov.sc.cbm.e193comunitario.domain;

import com.google.gson.annotations.SerializedName;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

import java.util.List;

/**
 * Created by bonet on 9/13/16.
 */

public class Occurrence {

    @SerializedName("id")
    public int id;

    @SerializedName("ts")
    public String date;

    @SerializedName("descricao")
    public String description;

    @SerializedName("logradouro")
    public String adressStreet;
    
    @SerializedName("numero")
    public Float addressNumber;

    @SerializedName("complemento")
    public String addressComplement;

    @SerializedName("bairro")
    public String addressNeighborhood;

    @SerializedName("referencia")
    public String addressReferencePoint;

    @SerializedName("cidade")
    public City city;

    @SerializedName("tipoEmergencia")
    public OccurrenceType type;

    @SerializedName("listViatura")
    public List<Car> dispatchedCars;


    @SerializedName("latitude")
    public float latitude;

    @SerializedName("longitude")
    public float longitude;

}
