package br.gov.sc.cbm.fccomunidade.presentation.screens.occurencedetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.gov.sc.cbm.fccomunidade.R;

public class OccurrenceDetailActivity extends AppCompatActivity {

    public static final String OCCURRENCE_ID = "OCCURRENCE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.occurrence__detail);

        int id = getIntent().getExtras().getInt(OCCURRENCE_ID);

        ((TextView) findViewById(R.id.occurrencedetail__textview)).setText(id+"");

        if (this.getActionBar()!=null)
            this.getActionBar().setHomeButtonEnabled(true);
    }

    public static Intent buildIntent(Context from, int occurrenceID) {

        Intent i = new Intent(from, OccurrenceDetailActivity.class);

        i.putExtra(OCCURRENCE_ID, occurrenceID);

        return i;
    }

}
