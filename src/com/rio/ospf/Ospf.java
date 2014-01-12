package com.rio.ospf;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.*;
import com.rio.ospf.adapter.InputDetailRouterAdapter;

/**
 * Created by souttab on 08/01/14.
 */
public class Ospf extends Activity implements View.OnClickListener {

    private Button button;
    private Spinner spinnerRouter;
    private EditText editTextBandwith;
    private TextView textViewInformasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ospf);

        button = (Button) findViewById(R.id.buttonOSPFInterface);
        editTextBandwith = (EditText) findViewById(R.id.editTextOSPFInterface);
        textViewInformasi = (TextView) findViewById(R.id.textViewInformasiOSPF);
        spinnerRouter = (Spinner) findViewById(R.id.spinnerOSPFInterface);

        button.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, InputDetailRouter.namaRouter);
        spinnerRouter.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        int selectedItemPosition = spinnerRouter.getSelectedItemPosition();

        String bandwidth = InputDetailRouterAdapter.bandwithMap.get(selectedItemPosition);
        String nameRouter = spinnerRouter.getSelectedItem().toString();

        boolean checkBoxFA0, checkBoxFA1, checkBoxSE0, checkBoxSE1;

        checkBoxFA0 = InputDetailRouterAdapter.checboxFA0[selectedItemPosition];
        checkBoxFA1 = InputDetailRouterAdapter.checboxFA1[selectedItemPosition];
        checkBoxSE0 = InputDetailRouterAdapter.checboxSE0[selectedItemPosition];
        checkBoxSE1 = InputDetailRouterAdapter.checboxSE1[selectedItemPosition];

        String routerFA0, routerFA1, routerSE0, routerSE1;

        editTextBandwith.setText(bandwidth);

        if (checkBoxFA0) {
            routerFA0 = "terhubung dengan router "+InputDetailRouterAdapter.spinnerFA0Selected.get(selectedItemPosition);
        } else routerFA0 = "ini tidak digunakan";

        if (checkBoxFA1) {
            routerFA1 = "terhubung dengan router "+InputDetailRouterAdapter.spinnerFA1Selected.get(selectedItemPosition);
        } else routerFA1 = "ini tidak digunakan";

        if (checkBoxSE0) {
            routerSE0 = "terhubung dengan router "+InputDetailRouterAdapter.spinnerSE0Selected.get(selectedItemPosition);
        } else routerSE0 = " ini tidak digunakan";

        if (checkBoxSE1) {
            routerSE1 = "terhubung dengan router "+InputDetailRouterAdapter.spinnerSE1Selected.get(selectedItemPosition);
        } else routerSE1 = " ini tidak digunakan";

        textViewInformasi.setText(Html.fromHtml("<h1>Configurasi Router <b>" + nameRouter + "</b></h1> " +
                "<br>PORT FA0 <b>" + routerFA0 + "</b> <br>" +
                "<br>PORT FA1 <b>" + routerFA1 + "</b> <br> " +
                "<br>PORT SEO <b>" + routerSE0 + "</b> <br>" +
                "<br>PORT SE1 <b>" + routerSE1 + "</b> <br>"));
    }
}
