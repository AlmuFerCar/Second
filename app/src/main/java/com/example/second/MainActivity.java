package com.example.second;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //para que se cargue el web view de interent
    //refrescar con swipe
    //poner el zoom
    //menu contextual (carpeta menu xml) on create context menu
    //appbar (carpeta menu xml) on create option menu
    //mensajes con toast y snack bar
    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*TextView mycontext=(TextView) findViewById(R.id.textClick);
        registerForContextMenu(mycontext);*/


        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);


        // DENTRO del Oncreate
        // cast al Layout SwipeRefresh con el que rodeamos la vista
        // en el xml y le colocamos un listener
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe); //refrescar
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //La vista dentro es un webview con permiso para zoom
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        //  miVisorWeb.getSettings().setJavaScriptEnabled(true);
        miVisorWeb.getSettings().setBuiltInZoomControls(true);//hacer zoom
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");//cargar pagina web

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    //para el menu al pinchar la imagen de copiar y descargar
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }
    // DIALOGO MODAL

    //cuando pinchas en el toolbar en el signout aparece un cuadra de diaalogo con los botones y las acciones
    public void showAlertDialogButtonClicked(MainActivity mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Vas a abandorme!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.relojcolor);
        builder.setCancelable(false);

//        // un XML a medida para el diálogo
//        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Signout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Stay Here", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Toast toast0 = Toast.makeText(MainActivity.this, "Hello i do nothing", Toast.LENGTH_LONG);
                toast0.show();
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                System.exit(0);
                dialog.dismiss();

            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
//para refrescar la imagen
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();

            final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "Hi there! I don't exist :)", Snackbar.LENGTH_LONG);


            snackbar.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    //las opciones cuando pinchas sobre la imagen del web view
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                toast.show();

                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "Item copied", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
                return true;

            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
                toast2.show();
                final ConstraintLayout mLayout2 = findViewById(R.id.myMainConstraint);

                Snackbar snackbar1 = Snackbar
                        .make(mLayout2, "Downloading item", Snackbar.LENGTH_SHORT);


                snackbar1.show();
                return true;

            default:
                return super.onContextItemSelected(item);

        }
    }
    //implementing ActionBar/AppBar menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }
    //las opciones del appbar menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item1) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Search", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item3) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        if (id == R.id.item4) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        if (id == R.id.item5) {
            //llama al menu de abandonar, estar aqui, etc
            showAlertDialogButtonClicked(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
