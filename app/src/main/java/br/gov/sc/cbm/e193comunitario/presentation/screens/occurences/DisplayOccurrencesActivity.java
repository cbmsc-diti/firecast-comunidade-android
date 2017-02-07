package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurencesmap.OccurenceMapFragment;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurrencelist.OccurrenceListFragment;

public class DisplayOccurrencesActivity extends AppCompatActivity {

    private static final String TAG = "DisplayOccurrencesActiv";
    Fragment mapView, listView;
    boolean isMap;
    MenuItem switcherItem;

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayoccurences__activity);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mapView = new OccurenceMapFragment();
        listView = new OccurrenceListFragment();

        showList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.displayoccurences__menu, menu);

        switcherItem = menu.findItem(R.id.displayocurrences__action__switchviewmode);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.displayocurrences__action__switchviewmode) {
            if (isMap) showList();
            else showMap();
        } else if (item.getItemId() == R.id.displayocurrences__action__showfilter) {
            showFilter();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void showFilter() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
            if(switcherItem!= null) {
                switcherItem.setEnabled(true);
                switcherItem.setVisible(true);
            }
        } else {
            drawer.openDrawer(Gravity.RIGHT);
            if(switcherItem!= null) {
                switcherItem.setEnabled(false);
                switcherItem.setVisible(false);
            }

        }
    }

    // TODO this should the fragments responsibility
    private void showMap() {
        Log.d(TAG, "showMap: ");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.displayoccurrences__fragmentholder, mapView)
                .commit();

        isMap = true;

        if(switcherItem!= null)
            switcherItem.setIcon(R.drawable.ic_view_list_white_36dp);
    }

    // TODO this should the fragments responsibility
    private void showList() {
        Log.d(TAG, "showList: ");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.displayoccurrences__fragmentholder, listView)
                .commit();

        isMap = false;

        if (switcherItem != null) {
            switcherItem.setIcon(R.drawable.ic_map_white_36dp);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
