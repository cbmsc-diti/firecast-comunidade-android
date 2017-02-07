package br.gov.sc.cbm.e193comunitario.data;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bonet on 9/13/16.
 */

public interface FirecastApi {

    @GET("listar_ocorrencia_aberta_by_servidor_json.php?cidade=FLORIANOPOLIS")
    Call<List<Occurrence>> getOccurrences();

}
