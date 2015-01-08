package com.stuartclaghorn.basicrecipes;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;


public class MainMenu extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        View aboutButton = findViewById(R.id.main_about_button);
        aboutButton.setOnClickListener(this);
        View newButton = findViewById(R.id.main_new_button);
        newButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu, menu);
        // menu.findItem(R.id.main_menu_new).setIntent(
        //                new Intent(this, NewRecipe.class);
        // menu.findItem(R.id.main_menu_search).setIntent(
        //                new Intent(this, SearchRecipe.class);
        menu.findItem(R.id.main_menu_options).setIntent(
                        new Intent(this, Options.class));
        menu.findItem(R.id.main_menu_new).setIntent(
                        new Intent(this, RecipeEntry.class));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem itm) {
        super.onOptionsItemSelected(itm);
        Intent menuIntent = itm.getIntent();
        if (menuIntent != null) {
            startActivity(menuIntent);
        }
        return true;
    }

    @Override
    public void onClick(View thisView) {
        switch (thisView.getId()) {
            case R.id.main_about_button:
                Intent showAbout = new Intent(this, About.class);
                startActivity(showAbout);
                break;
            case R.id.main_new_button:
                Intent doMenuClick = new Intent(this,RecipeNew.class);
                // Intent doNew = new Intent(this, RecipeEntry.class);
                startActivity(doMenuClick);
                break;
        }
    }

}
