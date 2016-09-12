package br.gov.sc.cbm.e193comunitario.presentation.screens.map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.gov.sc.cbm.e193comunitario.R;

public class MapActivity extends AppCompatActivity implements MapContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map__activity);
    }
}
