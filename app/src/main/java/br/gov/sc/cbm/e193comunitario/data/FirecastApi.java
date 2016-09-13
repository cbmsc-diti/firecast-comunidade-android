package br.gov.sc.cbm.e193comunitario.data;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurence;
import br.gov.sc.cbm.e193comunitario.domain.OccurenceRepository;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by bonet on 9/13/16.
 */

public interface FirecastApi {

    @GET("ocorrencias/fpolis")
    Observable<List<Occurence>> getOccurrences();

}
