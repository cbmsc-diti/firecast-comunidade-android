package br.gov.sc.cbm.e193comunitario.data.events;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

public class OcurrencesFinishedLoading {
	public final List<Occurrence> occurrences;

	public OcurrencesFinishedLoading(List<Occurrence> occurrences) {
		this.occurrences = occurrences;
	}
}
