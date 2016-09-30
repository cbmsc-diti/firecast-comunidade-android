package br.gov.sc.cbm.fccomunidade.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bonet on 9/21/16.
 */

public class Car {


    public final int id;

    @SerializedName("nome")
    public final String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && this.id != ((Car) o).id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
