package com.rio.ospf.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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
    public HashMap<Integer, Integer> spinnerFA0;
    public HashMap<Integer, Integer> spinnerFA1;
    public HashMap<Integer, Integer> spinnerSE0;
    public HashMap<Integer, Integer> spinnerSE1;


    public HashMap<Integer, String> bandwithMap = new HashMap<Integer, String>();
    public HashMap<Integer, String> ipFA0;
    public HashMap<Integer, String> ipFA1 = new HashMap<Integer, String>();
    public HashMap<Integer, String> ipSE0 = new HashMap<Integer, String>();
    public HashMap<Integer, String> ipSE1 = new HashMap<Integer, String>();
    public HashMap<Integer, String> subnetFA0 = new HashMap<Integer, String>();
    public HashMap<Integer, String> subnetFA1 = new HashMap<Integer, String>();
    public HashMap<Integer, String> subnetSE0 = new HashMap<Integer, String>();
    public HashMap<Integer, String> subnetSE1 = new HashMap<Integer, String>();

    public boolean[] checboxFA0, checboxFA1, checboxSE0, checboxSE1;


    public InputDetailRouterAdapter(ArrayList<String> listNama, Context context) {
        this.listNama = listNama;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);

        // definisi panjangnya array
        checboxFA0 = new boolean[listNama.size()];
        checboxFA1 = new boolean[listNama.size()];
        checboxSE0 = new boolean[listNama.size()];
        checboxSE1 = new boolean[listNama.size()];

        spinnerFA0 = new HashMap<Integer, Integer>(listNama.size());
        spinnerFA1 = new HashMap<Integer, Integer>(listNama.size());
        spinnerSE0 = new HashMap<Integer, Integer>(listNama.size());
        spinnerSE1 = new HashMap<Integer, Integer>(listNama.size());

        ipFA0 = new HashMap<Integer, String>(listNama.size());
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

            holder.spinnerFA0 = (Spinner) view.findViewById(R.id.spinnerFA0);
            holder.spinnerFA1 = (Spinner) view.findViewById(R.id.spinnerFA1);
            holder.spinnerSE0 = (Spinner) view.findViewById(R.id.spinnerSE0);
            holder.spinnerSE1 = (Spinner) view.findViewById(R.id.spinnerSE1);

            holder.editTextIpFa0 = (EditText) view.findViewById(R.id.editTextIPFA0);
            holder.editTextIpFa1 = (EditText) view.findViewById(R.id.editTextIPFA1);
            holder.editTextIpSe0 = (EditText) view.findViewById(R.id.editTextIPSE0);
            holder.editTextIpSe1 = (EditText) view.findViewById(R.id.editTextIPSE1);

            holder.editTextSubnetFa0 = (EditText) view.findViewById(R.id.editTextSubnetFA0);
            holder.editTextSubnetFa1 = (EditText) view.findViewById(R.id.editTextSubnetFA1);
            holder.editTextSubnetSE0 = (EditText) view.findViewById(R.id.editTextSubnetSE0);
            holder.editTextSubnetSE1 = (EditText) view.findViewById(R.id.editTextSubnetSE1);

            // check checkbox fa0
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
                        checboxSE0[pos.intValue()] = true;
                    } else  {
                        checboxSE0[pos.intValue()] = false;
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
                        checboxSE1[pos.intValue()] = true;
                    } else  {
                        checboxSE1[pos.intValue()] = false;
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

        // buat array adapter untuk spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, listNama);
        holder.spinnerFA0.setAdapter(adapter);
        holder.spinnerFA1.setAdapter(adapter);
        holder.spinnerSE0.setAdapter(adapter);
        holder.spinnerSE1.setAdapter(adapter);

        // set data to spinner fa0
        if (spinnerFA0.get(position) != null) {
            holder.spinnerFA0.setTag(position);
            holder.spinnerFA0.setSelection(spinnerFA0.get(position));
        } else {
            holder.spinnerFA0.setTag(position);
            holder.spinnerFA0.setSelection(0);
        }

        // set data to spinner fa1
        if (spinnerFA1.get(position) != null) {
            holder.spinnerFA1.setTag(position);
            holder.spinnerFA1.setSelection(spinnerFA1.get(position));
        } else {
            holder.spinnerFA1.setTag(position);
            holder.spinnerFA1.setSelection(0);
        }

        // set data to spinner se0
        if (spinnerSE0.get(position) != null) {
            holder.spinnerSE0.setTag(position);
            holder.spinnerSE0.setSelection(spinnerSE0.get(position));
        } else {
            holder.spinnerSE0.setTag(position);
            holder.spinnerSE0.setSelection(0);
        }

        // set data to spinner se1
        if (spinnerSE1.get(position) != null) {
            holder.spinnerSE1.setTag(position);
            holder.spinnerSE1.setSelection(spinnerSE1.get(position));
        } else {
            holder.spinnerSE1.setTag(position);
            holder.spinnerSE1.setSelection(0);
        }

        // handle spinnerFA0 dari recycle listview
        holder.spinnerFA0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerFA0.put(position, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // handle spinnerFA1 dari recycle listview
        holder.spinnerFA1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerFA1.put(position, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // handle spinnerSE0 dari recycle listview
        holder.spinnerSE0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSE0.put(position, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // handle spinnerSE1 dari recycle listview
        holder.spinnerSE1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSE1.put(position, i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

        // set id bandiwith
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
                    // ambil data dan masukan ke array
                    bandwithMap.put(position, holder.editTextBandwith.getText().toString());
                }
            }
        });

        // set and get value ip fa0
        holder.editTextIpFa0.setTag(position);
        if (ipFA0.isEmpty()){
            holder.editTextIpFa0.setText("");
        } else holder.editTextIpFa0.setText(ipFA0.get(position));
        holder.editTextIpFa0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    ipFA0.put(position, holder.editTextIpFa0.getText().toString());
                }
            }
        });

        // set and get value ip fa1
        holder.editTextIpFa1.setTag(position);
        if (ipFA1.isEmpty()){
            holder.editTextIpFa1.setText("");
        } else holder.editTextIpFa1.setText(ipFA1.get(position));
        holder.editTextIpFa1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    ipFA1.put(position, holder.editTextIpFa1.getText().toString());
                }
            }
        });

        // set and get value ip se0
        holder.editTextIpSe0.setTag(position);
        if (ipSE0.isEmpty()){
            holder.editTextIpSe0.setText("");
        } else holder.editTextIpSe0.setText(ipSE0.get(position));
        holder.editTextIpSe0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    ipSE0.put(position, holder.editTextIpSe0.getText().toString());
                }
            }
        });

        // set and get value ip se1
        holder.editTextIpSe1.setTag(position);
        if (ipSE1.isEmpty()){
            holder.editTextIpSe1.setText("");
        } else holder.editTextIpSe1.setText(ipSE1.get(position));
        holder.editTextIpSe1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    ipSE1.put(position, holder.editTextIpSe1.getText().toString());
                }
            }
        });

        // get and set value from subnet fa0
        holder.editTextSubnetFa0.setTag(position);
        if (subnetFA0.isEmpty()){
            holder.editTextSubnetFa0.setText("");
        } else holder.editTextSubnetFa0.setText(subnetFA0.get(position));
        holder.editTextSubnetFa0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    subnetFA0.put(position, holder.editTextSubnetFa0.getText().toString());
                }
            }
        });

        // get and set value from subnet fa1
        holder.editTextSubnetFa0.setTag(position);
        if (subnetFA1.isEmpty()){
            holder.editTextSubnetFa1.setText("");
        } else holder.editTextSubnetFa1.setText(subnetFA1.get(position));
        holder.editTextSubnetFa1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    subnetFA1.put(position, holder.editTextSubnetFa1.getText().toString());
                }
            }
        });

        // get and set value from subnet se0
        holder.editTextSubnetSE0.setTag(position);
        if (subnetSE0.isEmpty()){
            holder.editTextSubnetSE0.setText("");
        } else holder.editTextSubnetSE0.setText(subnetSE0.get(position));
        holder.editTextSubnetSE0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    subnetSE0.put(position, holder.editTextSubnetSE0.getText().toString());
                }
            }
        });

        // get and set value from subnet se1
        holder.editTextSubnetSE1.setTag(position);
        if (subnetSE1.isEmpty()){
            holder.editTextSubnetSE1.setText("");
        } else holder.editTextSubnetSE1.setText(subnetSE1.get(position));
        holder.editTextSubnetSE1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    subnetSE1.put(position, holder.editTextSubnetSE1.getText().toString());
                }
            }
        });

        return view;
    }

    class ViewHolder {
        private TextView textViewNama;
        private EditText editTextBandwith, editTextIpFa0, editTextIpFa1, editTextIpSe0, editTextIpSe1, editTextSubnetFa0, editTextSubnetFa1, editTextSubnetSE0, editTextSubnetSE1;
        private LinearLayout layoutFA0, layoutFA1, layoutSE0, layoutSE1;
        private CheckBox checkBoxFa0, checkBoxFa1, checkBoxSe0, checkBoxSe1;
        private Spinner spinnerFA0, spinnerFA1, spinnerSE0, spinnerSE1;
    }
}
