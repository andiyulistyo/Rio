package com.rio.ospf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import static com.rio.ospf.InputDetailRouter.*;

public class Cost extends Activity implements View.OnClickListener {

    private Spinner spinnerAwal, spinnerTujuan;
    private EditText editTextHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cost);

        Button buttonCheckHasil = (Button) findViewById(R.id.buttonCheckCost);
        spinnerAwal = (Spinner) findViewById(R.id.spinnerAwal);
        spinnerTujuan = (Spinner) findViewById(R.id.spinnerTujuan);
        editTextHasil = (EditText) findViewById(R.id.editTextCost);

        buttonCheckHasil.setOnClickListener(this);

        Log.i("bandiwidth size", bandwidthList.size()+"");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namaRouter);
        spinnerAwal.setAdapter(adapter);
        spinnerTujuan.setAdapter(adapter);
    }

    private short hitungCost(short awal, short tujuan) {
        short size = (short) matrix.length;
        short jarak[] = new short[100];
        boolean set[] = new boolean[100];
        short bandwidth[] = new short[100];
        short min, minimalIndex = 0;

        for (short i = 0; i < size; i++) {
            jarak[i] = 9999;
            set[i] = false;
            bandwidth[i] = bandwidthList.get(i);
        }

        jarak[awal] = 0;
        bandwidth[tujuan] = 0;

        for (short i = 0; i < size; i++) {
            min = 9999;
            for (short j = 0; j < size; j++) {
                if (!set[j] && jarak[j] <= min) {
                    min = jarak[j];
                    minimalIndex = j;
                }
            }
            set[minimalIndex] = true;

            for (short l = 0; l < size; l++) {
                if (!set[l] && jarak[minimalIndex] != 9999 && (jarak[minimalIndex] + matrix[minimalIndex][l] + bandwidth[l]) < jarak[l]) {
                    jarak[l] = (short) (jarak[minimalIndex] + matrix[minimalIndex][l] + bandwidth[l]);
                    }
                }
            }

        return jarak[tujuan];
    }

    @Override
    public void onClick(View view) {
        short awal = (short) spinnerAwal.getSelectedItemPosition();
        short tujuan = (short) spinnerTujuan.getSelectedItemPosition();
        Log.i("awal", awal+"");
        Log.i("tujuan", tujuan+"");

        short hasil = hitungCost(awal, tujuan);

        editTextHasil.setText(hasil+"");
    }
}
