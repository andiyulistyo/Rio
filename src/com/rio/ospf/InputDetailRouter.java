package com.rio.ospf;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import com.rio.ospf.adapter.InputDetailRouterAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by souttab on 03/01/14.
 */
public class InputDetailRouter extends ListActivity implements View.OnClickListener {

    private InputDetailRouterAdapter routerAdapter;
    private Button buttonNext;
//    private Spinner spinnerFA0, spinnerFA1, spinnerSE0, spinnerSE1;
//    private CheckBox checkBoxFA0, checkBoxFA1, checkBoxSE0, checkBoxSE1;

    private int matrix[][];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_detail_router);

        ArrayList<String> namaRouter = getIntent().getExtras().getStringArrayList("nama");

        buttonNext = (Button) findViewById(R.id.buttonSelanjut);
        buttonNext.setOnClickListener(this);

        // input data ke adapter
        routerAdapter = new InputDetailRouterAdapter(namaRouter, InputDetailRouter.this);
        // set adapter on focus
        getListView().setItemsCanFocus(true);
        // set adapter
        setListAdapter(routerAdapter);
    }

    @Override
    public void onClick(View view) {
        int size = routerAdapter.getCount();

        int wou = getListView().getChildCount();
        Log.i("banyaknya chil ", wou+"");

        

        matrix(size, size);

        for (int i = 1; i < size; i++) {

            boolean checkBoxFA0 = routerAdapter.checboxFA0[i];
            boolean checkBoxFA1 = routerAdapter.checboxFA1[i];
            boolean checkBoxSE0 = routerAdapter.checboxSE0[i];
            boolean checkBoxSE1 = routerAdapter.checboxSE1[i];

            Integer fa0 = routerAdapter.spinnerFA0.get(i);
            Integer fa1 = routerAdapter.spinnerFA1.get(i);
            Integer se0 = routerAdapter.spinnerSE0.get(i);
            Integer se1 = routerAdapter.spinnerSE1.get(i);

            if (checkBoxFA0 && checkBoxFA1 && checkBoxSE0 && checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][fa1] = matrix[fa1][i] = 1;
                matrix[i][se0] = matrix[se0][i] = 64;
                matrix[i][se1] = matrix[se1][i] = 64;

            } else if (checkBoxFA0 && checkBoxFA1 &&checkBoxSE0 && !checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][fa1] = matrix[fa1][i] = 1;
                matrix[i][se0] = matrix[se0][i] = 64;

            } else if (checkBoxFA0 && checkBoxFA1 && !checkBoxSE0 && checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][fa1] = matrix[fa1][i] = 1;
                matrix[i][se1] = matrix[se1][i] = 64;

            } else if (checkBoxFA0 && !checkBoxFA1 && checkBoxSE0 && checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][se0] = matrix[se0][i] = 64;
                matrix[i][se1] = matrix[se1][i] = 64;

            } else if (!checkBoxFA0 && checkBoxFA1 &&checkBoxSE0 && checkBoxSE1) {

                matrix[i][fa1] = matrix[fa1][i] = 1;
                matrix[i][se0] = matrix[se0][i] = 64;
                matrix[i][se1] = matrix[se1][i] = 64;

            } else if (checkBoxFA0 && checkBoxFA1 && !checkBoxSE0 && !checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][fa1] = matrix[fa1][i] = 1;

            } else if (checkBoxFA0 && !checkBoxFA1 &&checkBoxSE0 && !checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][se0] = matrix[se0][i] = 64;

            } else if (checkBoxFA0 && !checkBoxFA1 && !checkBoxSE0 && checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;
                matrix[i][se1] = matrix[se1][i] = 64;

            } else if (!checkBoxFA0 && checkBoxFA1 && !checkBoxSE0 && checkBoxSE1) {

                matrix[i][fa1] = matrix[fa1][i] = 1;
                matrix[i][se1] = matrix[se1][i] = 64;

            } else if (!checkBoxFA0 && checkBoxFA1 &&checkBoxSE0 && !checkBoxSE1) {

                matrix[i][fa1] = matrix[fa1][i] = 1;
                matrix[i][se0] = matrix[se0][i] = 64;

            } else if (!checkBoxFA0 && !checkBoxFA1 &&checkBoxSE0 && checkBoxSE1) {

                matrix[i][se0] = matrix[se0][i] = 64;
                matrix[i][se1] = matrix[se1][i] = 64;
            } else if (checkBoxFA0 && !checkBoxFA1 && !checkBoxSE0 && !checkBoxSE1) {

                matrix[i][fa0] = matrix[fa0][i] = 1;

            } else if (!checkBoxFA0 && checkBoxFA1 && !checkBoxSE0 && !checkBoxSE1) {

                matrix[i][fa1] = matrix[fa1][i] = 1;

            } else if (!checkBoxFA0 && !checkBoxFA1 &&checkBoxSE0 && !checkBoxSE1) {

                matrix[i][se0] = matrix[se0][i] = 64;

            } else if (!checkBoxFA0 && !checkBoxFA1 && !checkBoxSE0 && checkBoxSE1) {

                matrix[i][se1] = matrix[se1][i] = 64;
            }
        }
        for (int i =0 ; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Log.i("Log matrix ["+i+"]["+j+"]", ""+matrix[i][j]);
            }
        }


        Intent intent = new Intent(getApplication(), Menu.class);
        startActivity(intent);
    }

    public void matrix(int panjangMatrix, int panjangMatrix2) {
        matrix = new int[panjangMatrix][panjangMatrix2];
        for (int i = 0; i < panjangMatrix; i++) {
            for (int j = 0; j < panjangMatrix2; j++) {
                matrix[i][j] = 9999;
                Log.i("matrix[" + i + "][" + j + "]", matrix[i][j] + "");
            }
        }
    }
}
