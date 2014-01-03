package com.rio.ospf;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.rio.ospf.adapter.NamaRouterAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souttab on 03/01/14.
 */
public class NamaRouter extends ListActivity {

    private NamaRouterAdapter routerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_nama_router);

        // ambil nilai dari intent
        int router = getIntent().getExtras().getInt("router");

        List<String> nama = new ArrayList<String>();

        for (int i = 0; i < router; i++) {
            nama.add("Nama Router ke : "+i);
        }

        routerAdapter = new NamaRouterAdapter(nama, getApplicationContext());
        getListView().setItemsCanFocus(true);
        setListAdapter(routerAdapter);
    }
}
