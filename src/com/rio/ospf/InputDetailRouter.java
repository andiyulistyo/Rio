package com.rio.ospf;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.rio.ospf.adapter.InputDetailRouterAdapter;

import java.util.ArrayList;

/**
 * Created by souttab on 03/01/14.
 */
public class InputDetailRouter extends ListActivity {

    private InputDetailRouterAdapter routerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_detail_router);

        ArrayList<String> namaRouter = getIntent().getExtras().getStringArrayList("nama");

        // input data ke adapter
        routerAdapter = new InputDetailRouterAdapter(namaRouter, InputDetailRouter.this);
        // set adapter on focus
        getListView().setItemsCanFocus(true);
        // set adapter
        setListAdapter(routerAdapter);
    }
}
