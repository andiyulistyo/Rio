package com.rio.ospf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.rio.ospf.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by souttab on 04/01/14.
 */
public class InputDetailRouterAdapter extends BaseAdapter {

    private ArrayList<String> listNama = new ArrayList<String>();
    private Context mContext;
    private LayoutInflater layoutInflater;

    public HashMap<Integer, String> bandwithMap = new HashMap<Integer, String>();
    public HashMap<Integer, String> ipMap = new HashMap<Integer, String>();
    public HashMap<Integer, String> subnetMap = new HashMap<Integer, String>();

    public InputDetailRouterAdapter(ArrayList<String> listNama, Context context) {
        this.listNama = listNama;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
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

            // check checkbox fa0
            holder.checkBoxFa0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (holder.layoutFA0.getVisibility() == View.GONE) {
                        holder.layoutFA0.setVisibility(View.VISIBLE);
                    } else holder.layoutFA0.setVisibility(View.GONE);
                }
            });

            // check checox fa1
            holder.checkBoxFa1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (holder.layoutFA1.getVisibility() == View.GONE) {
                        holder.layoutFA1.setVisibility(View.VISIBLE);
                    } else holder.layoutFA1.setVisibility(View.GONE);
                }
            });

            // check checkbox se0
            holder.checkBoxSe0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (holder.layoutSE0.getVisibility() == View.GONE) {
                        holder.layoutSE0.setVisibility(View.VISIBLE);
                    } else holder.layoutSE0.setVisibility(View.GONE);
                }
            });

            // check checkbox se1
            holder.checkBoxSe1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if (holder.layoutSE1.getVisibility() == View.GONE) {
                        holder.layoutSE1.setVisibility(View.VISIBLE);
                    } else holder.layoutSE1.setVisibility(View.GONE);
                }
            });

            view.setTag(holder);
        } else holder = (ViewHolder) view.getTag();

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
