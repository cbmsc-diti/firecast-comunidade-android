package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListContract;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListFragment;

public class DisplayOccurrencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.occurrencelist__activity);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.occurencelist__fragmentholder, new OccurrenceListFragment())
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
