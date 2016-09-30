package br.gov.sc.cbm.fccomunidade.presentation.screens.map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.gov.sc.cbm.fccomunidade.R;

public class MapActivity extends AppCompatActivity implements MapContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map__activity);
    }
}
