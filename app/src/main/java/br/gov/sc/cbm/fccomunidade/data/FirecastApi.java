package br.gov.sc.cbm.fccomunidade.data;

import java.util.List;

import br.gov.sc.cbm.fccomunidade.domain.Occurrence;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by bonet on 9/13/16.
 */

public interface FirecastApi {

    @GET("listar_ocorrencia_aberta_by_servidor_json.php?cidade=FLORIANOPOLIS")
    Observable<List<Occurrence>> getOccurrences();

}
