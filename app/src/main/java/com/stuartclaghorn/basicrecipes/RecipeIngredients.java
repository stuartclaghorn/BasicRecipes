package com.stuartclaghorn.basicrecipes;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by stuart on 1/3/15.
 */
public class RecipeIngredients extends ListActivity implements OnClickListener {
    private static EditText _ingredientText = null;
    private static Button _ingredientAdd = null;
    private static final ArrayList<String> _ingredientListContents = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_tab_ingredients);
        _ingredientListContents.add("Salt");
        _ingredientListContents.add("Pepper");

        _ingredientText = (EditText) findViewById(R.id.ingredient_text);
        _ingredientAdd = (Button)findViewById(R.id.ingredient_button);
        _ingredientAdd.setOnClickListener(this);
        setListAdapter(new ListViewAdapter(this));
    }

    private static class ListViewAdapter extends BaseAdapter {
        private LayoutInflater ingredientInflater;

        public ListViewAdapter(Context context) {
            ingredientInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return _ingredientListContents.size();
        }

        public Object getItem(int position) {
            return _ingredientListContents.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View view, ViewGroup group) {
            ListContent contents;

            if (view == null) {
                view = ingredientInflater.inflate(R.layout.recipe_tab_ingredients_inflate, null);
                contents = new ListContent();
                contents.text = (EditText) view.findViewById(R.id.ingredient_first);
                contents.text.setCompoundDrawables(view.getResources().getDrawable(R.drawable.arrow),null,null,null);
                view.setTag(contents);
            } else {
                contents = (ListContent) view.getTag();
            }
            contents.text.setText(_ingredientListContents.get(position));
            return view;
        }

        static class ListContent {
            TextView text;
        }
    }

    public void onClick(View v) {
        if (v == _ingredientAdd) {
            _ingredientListContents.add( _ingredientText.getText().toString());
            setListAdapter(new ListViewAdapter(this));
        }
    }
}
