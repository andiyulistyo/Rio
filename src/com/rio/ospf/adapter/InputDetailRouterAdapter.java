package com.rio.ospf.adapter;

import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.rio.ospf.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by souttab on 04/01/14.
 */
public class InputDetailRouterAdapter extends BaseAdapter {

    private ArrayList<String> listNama = new ArrayList<String>();
    private Context mContext;
    private LayoutInflater layoutInflater;
    private HashMap<Integer, Boolean> checkBoxMap = new HashMap<Integer, Boolean>();

    public HashMap<Integer, String> bandwithMap = new HashMap<Integer, String>();
    public HashMap<Integer, String> ipMap = new HashMap<Integer, String>();
    public HashMap<Integer, String> subnetMap = new HashMap<Integer, String>();

    private boolean[] checboxFA0, checboxFA1, checboxSE0, checboxSE1;


    public InputDetailRouterAdapter(ArrayList<String> listNama, Context context) {
        this.listNama = listNama;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);

        // definisi panjangnya array
        checboxFA0 = new boolean[listNama.size()];
        checboxFA1 = new boolean[listNama.size()];
        checboxSE0 = new boolean[listNama.size()];
        checboxSE1 = new boolean[listNama.size()];
    }

    @Override
    public int getCount() {
        return listNama.size();
    }

    @Override
    public Object getItem(int i) {
        return listNama.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item_input_detail_router, viewGroup, false);

            holder.textViewNama = (TextView) view.findViewById(R.id.textViewNama);
            holder.editTextBandwith = (EditText) view.findViewById(R.id.editTextBandwith);

            holder.layoutFA0 = (LinearLayout) view.findViewById(R.id.layoutFA0);
            holder.layoutFA1 = (LinearLayout) view.findViewById(R.id.layoutFA1);
            holder.layoutSE0 = (LinearLayout) view.findViewById(R.id.layoutSE0);
            holder.layoutSE1 = (LinearLayout) view.findViewById(R.id.layoutSE1);

            holder.checkBoxFa0 = (CheckBox) view.findViewById(R.id.checkBoxFA0);
            holder.checkBoxFa1 = (CheckBox) view.findViewById(R.id.checkBoxFA1);
            holder.checkBoxSe0 = (CheckBox) view.findViewById(R.id.checkBoxSE0);
            holder.checkBoxSe1 = (CheckBox) view.findViewById(R.id.checkBoxSE1);

//            // check checkbox fa0
            holder.checkBoxFa0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    Integer pos = (Integer) compoundButton.getTag();
                    if (isChecked){
                        checboxFA0[pos.intValue()] = true;
                    } else  {
                        checboxFA0[pos.intValue()] = false;
                        Log.e("checked", "unchecked");
                    }

                    // check layout hide atau gak
                    if (holder.layoutFA0.getVisibility() == View.GONE) {
                        holder.layoutFA0.setVisibility(View.VISIBLE);
                    } else holder.layoutFA0.setVisibility(View.GONE);
                }
            });

            // check checox fa1
            holder.checkBoxFa1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Integer pos = (Integer) compoundButton.getTag();
                    if (b){
                        checboxFA1[pos.intValue()] = true;
                    } else  {
                        checboxFA1[pos.intValue()] = false;
                        Log.e("checked", "unchecked");
                    }

                    // check layout hide atau gak
                    if (holder.layoutFA1.getVisibility() == View.GONE) {
                        holder.layoutFA1.setVisibility(View.VISIBLE);
                    } else holder.layoutFA1.setVisibility(View.GONE);
                }
            });

            // check checkbox se03
            holder.checkBoxSe0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Integer pos = (Integer) compoundButton.getTag();
                    if (b){
                        checboxFA1[pos.intValue()] = true;
                    } else  {
                        checboxFA1[pos.intValue()] = false;
                        Log.e("checked", "unchecked");
                    }

                    // check layout hide atau gak
                    if (holder.layoutSE0.getVisibility() == View.GONE) {
                        holder.layoutSE0.setVisibility(View.VISIBLE);
                    } else holder.layoutSE0.setVisibility(View.GONE);
                }
            });

            // check checkbox se1
            holder.checkBoxSe1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Integer pos = (Integer) compoundButton.getTag();
                    if (b){
                        checboxFA1[pos.intValue()] = true;
                    } else  {
                        checboxFA1[pos.intValue()] = false;
                        Log.e("checked", "unchecked");
                    }

                    // check layout hide atau gak
                    if (holder.layoutSE1.getVisibility() == View.GONE) {
                        holder.layoutSE1.setVisibility(View.VISIBLE);
                    } else holder.layoutSE1.setVisibility(View.GONE);
                }
            });

            view.setTag(holder);

        } else holder = (ViewHolder) view.getTag();

        // set checkbox fa0
        holder.checkBoxFa0.setTag(position);
        if (checboxFA0.length > 0) {
            holder.checkBoxFa0.setChecked(checboxFA0[position]);
        } else holder.checkBoxFa0.setChecked(false);

        // set checkbox fa1
        holder.checkBoxFa1.setTag(position);
        if (checboxFA1.length > 0) {
            holder.checkBoxFa1.setChecked(checboxFA1[position]);
        } else holder.checkBoxFa1.setChecked(false);

        // set checkbox se0
        holder.checkBoxSe0.setTag(position);
        if (checboxSE0.length > 0) {
            holder.checkBoxSe0.setChecked(checboxSE0[position]);
        } else holder.checkBoxSe0.setChecked(false);

        // set checkbox se1
        holder.checkBoxSe1.setTag(position);
        if (checboxSE1.length > 0) {
            holder.checkBoxSe1.setChecked(checboxSE1[position]);
        } else holder.checkBoxSe1.setChecked(false);

        // set data nama router
        holder.textViewNama.setText(listNama.get(position));

        // set id
        holder.editTextBandwith.setId(position);
        // set value if exist data
        if (bandwithMap.isEmpty()) {
            holder.editTextBandwith.setText("");
        } holder.editTextBandwith.setText(bandwithMap.get(position));

        // set on focus
        holder.editTextBandwith.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    bandwithMap.put(position, holder.editTextBandwith.getText().toString());
                }
            }
        });

        return view;
    }


    class ViewHolder {
        private TextView textViewNama;
        private EditText editTextBandwith, editTextIpFa0, editTextIpFa1, editTextIpSe0, editTextIpSe1, editTextSubnetFa0, editTextSubnetFa1;
        private LinearLayout layoutFA0, layoutFA1, layoutSE0, layoutSE1;
        private CheckBox checkBoxFa0, checkBoxFa1, checkBoxSe0, checkBoxSe1;
    }
}
