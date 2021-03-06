package com.rio.ospf.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TableLayout;
import com.rio.ospf.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class NamaRouterAdapter extends BaseAdapter {

    private List<String> nama = new ArrayList<String>();
    private Context context;
    private LayoutInflater layoutInflater;

    public HashMap<Integer, String> hashMap = new HashMap<Integer, String>();


    public NamaRouterAdapter(List<String> nama, Context mcontext) {
        this.nama = nama;
        this.context = mcontext;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return nama.size();
    }

    @Override
    public Object getItem(int i) {
        return nama.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHold viewHold;

        if (view == null) {
            viewHold = new ViewHold();
            view = layoutInflater.inflate(R.layout.item_input_nama_router, viewGroup, false);

            viewHold.editTextNama = (EditText) (view != null ? view.findViewById(R.id.editTextNamaRouter) : null);

            if (view != null) {
                view.setTag(viewHold);
            }

        } else viewHold = (ViewHold) view.getTag();


        if (hashMap.isEmpty()) {
            viewHold.editTextNama.setText("");
        } viewHold.editTextNama.setText(hashMap.get(position));

        viewHold.editTextNama.setId(position);

        viewHold.editTextNama.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    hashMap.put(position, viewHold.editTextNama.getText().toString());
                }
            }
        });

        return view;
    }

    class ViewHold {
        private EditText editTextNama;
    }
}
