package com.rio.ospf;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.rio.ospf.adapter.NamaRouterAdapter;

import java.util.ArrayList;
import java.util.List;


public class NamaRouter extends ListActivity implements View.OnClickListener {

    private NamaRouterAdapter routerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_nama_router);

        Button buttonNext = (Button) findViewById(R.id.buttonNamaRouter);
        buttonNext.setOnClickListener(this);

        // ambil nilai dari intent
        @SuppressWarnings("ConstantConditions") int router = getIntent().getExtras().getInt("router");

        // buat hint
        List<String> nama = new ArrayList<String>();

        for (int i = 0; i < router; i++) {
            nama.add("Nama Router ke : "+i);
        }

        // set data ke adapter
        routerAdapter = new NamaRouterAdapter(nama, getApplicationContext());
        // set item focus true
        getListView().setItemsCanFocus(true);
        // set adapter ke listview
        setListAdapter(routerAdapter);
    }

    @Override
    public void onClick(View view) {
        ArrayList<String> arrayList = new ArrayList<String>();

        // get value dari inputan di listview
        for (int i = 0; i < routerAdapter.getCount(); i++) {
            // ambil data dari adapter
            arrayList.add(routerAdapter.hashMap.get(i));
        }

        // panggil class selanjutnya dan kirim value nama yang telah
        // diinputkan
        Intent intent = new Intent(NamaRouter.this, InputDetailRouter.class);
        intent.putStringArrayListExtra("nama", arrayList);
        startActivity(intent);
    }
}
