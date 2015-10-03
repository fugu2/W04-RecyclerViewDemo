package ch.hsr.mge.recyclerviewdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hier unser Code

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(R.string.app_name));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("MGE", "Mobile und GUI Engineering", false));
        modules.add(new Module("OO", "Objektorientierte Programmierung", true));
        modules.add(new Module("SE1", "Software Engineering 1", false));
        modules.add(new Module("SA", "Studienarbeit", true));
        modules.add(new Module("BA", "Bachelorarbeit", true));
        modules.add(new Module("AA", "Application Architecture", false));
        modules.add(new Module("CS", "Cloud Solutions", false));
        modules.add(new Module("MGE", "Mobile und GUI Engineering", false));
        modules.add(new Module("OO", "Objektorientierte Programmierung", true));
        modules.add(new Module("SE1", "Software Engineering 1", false));
        modules.add(new Module("SA", "Studienarbeit", true));
        modules.add(new Module("BA", "Bachelorarbeit", true));
        modules.add(new Module("AA", "Application Architecture", false));
        modules.add(new Module("CS", "Cloud Solutions", false));
        modules.add(new Module("MGE", "Mobile und GUI Engineering", false));
        modules.add(new Module("OO", "Objektorientierte Programmierung", true));
        modules.add(new Module("SE1", "Software Engineering 1", false));
        modules.add(new Module("SA", "Studienarbeit", true));
        modules.add(new Module("BA", "Bachelorarbeit", true));
        modules.add(new Module("AA", "Application Architecture", false));
        modules.add(new Module("CS", "Cloud Solutions", false));

        adapter = new MyAdapter(modules);
        recyclerView.setAdapter(adapter);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.plusButton);
    }

    public void onPlusClicked(View button) {

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_new_module, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText moduleNameText = (EditText) promptView.findViewById(R.id.moduleNameText);
        final EditText moduleCodeText = (EditText) promptView.findViewById(R.id.moduleCodeText);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String name = moduleNameText.getText().toString();
                        String code = moduleCodeText.getText().toString();
                        addNewModule(name, code);
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    private void addNewModule(String name, String code) {
        adapter.add(adapter.getItemCount(), new Module(name, code, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
