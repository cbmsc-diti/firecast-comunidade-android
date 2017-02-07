package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.filter;

import org.greenrobot.eventbus.EventBus;

import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurrenceFilter;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.events.FilterUpdatedEvent;

/**
 * Created by bonet on 9/27/16.
 */
public class FilterPresenter implements FilterView.OnUpdatedFilterListener {

	FilterView view;

	public void attach(FilterView v) {
		view = v;
		v.setUpdateFilterListener(this);
	}

	public void dettach() {
		view.setUpdateFilterListener(NOOP);
		view = null;
	}

	@Override
	public void onUpdateFilter(OccurrenceFilter filter) {
		EventBus.getDefault().post(new FilterUpdatedEvent());
	}
}
