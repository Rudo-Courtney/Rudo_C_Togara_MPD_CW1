package com.example.practice_coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.view.MenuItem;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.practice_coursework.m_RSS.Downloader;
import com.example.practice_coursework.m_UI.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    ViewFlipper viewFlipper;
    EditText startDateValue;
    EditText endDateValue;
    Spinner searchBySpinner;
    int tYear, tMonth, tDay;

    SearchView searchView;
    ListView listViewRss;
    ArrayAdapter<String> arrayAdapter;

    ListView lv;
    final static String urlString ="http://m.highwaysengland.co.uk/feeds/rss/CurrentAndFutureEvents.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button openRoadWorks = (Button) findViewById(R.id.openRoadWorks);

        lv = (ListView) findViewById(R.id.lv);


        Log.e("MyTag", "in onCreate");

        listViewRss = (ListView) findViewById(R.id.listViewRss);

        searchView = findViewById(R.id.search_bar);

        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        //listViewRss.setAdapter(arrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                MainActivity.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                MainActivity.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });


        startDateValue = findViewById(R.id.startDateValue);


        endDateValue = findViewById(R.id.endDateValue);

        searchBySpinner = findViewById(R.id.searchBySpinner);
        ArrayAdapter<CharSequence> filerBySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.filterByOptions, android.R.layout.simple_spinner_item);
        filerBySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchBySpinner.setAdapter(filerBySpinnerAdapter);

        viewFlipper = findViewById(R.id.viewFlipper);

        Log.e("MyTag", "after startButton");
    }


    public void showRoadworks(View view) {
        new Downloader(MainActivity.this,urlString,lv).execute();
        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.roadworksInfo)));
    }

    public void showBack(View view) {
        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.clickBack)));
    }
    public void showPlanner(View view) {
        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.plannerInfo)));
    }
    public void showHome(View view) {
        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.homePage)));
    }
    public void viewByDate(View view) {
        viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.viewRoadwork)));
    }

    public void showStartDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        tYear = calendar.get(Calendar.YEAR);
        tMonth = calendar.get(Calendar.MONTH);
        tDay = calendar.get(Calendar.DAY_OF_MONTH);

        //show dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                startDateValue.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-yyyy");
                String date = "22-03-2022";
                try {
                    sdf.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }, tYear, tMonth, tDay);
        datePickerDialog.show();
    }


    public void showEndDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        tYear = calendar.get(Calendar.YEAR);
        tMonth = calendar.get(Calendar.MONTH);
        tDay = calendar.get(Calendar.DAY_OF_MONTH);

        //show dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endDateValue.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

            }
        }, tYear, tMonth, tDay);
        datePickerDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        MenuItemCompat.OnActionExpandListener onActionExpandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "Search space expanded", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "Search space collapsed", Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        MenuItemCompat.setOnActionExpandListener(menu.findItem(R.id.nav_search), onActionExpandListener);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.nav_search));
        searchView.setQueryHint("Search roadworks here...");

        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.nav_setting:
                Toast.makeText(this, "Open Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}







