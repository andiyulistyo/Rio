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

        String ipFA0 = InputDetailRouterAdapter.ipFA0.get(selectedItemPosition);
        String ipFA1 = InputDetailRouterAdapter.ipFA1.get(selectedItemPosition);
        String ipSE0 = InputDetailRouterAdapter.ipSE0.get(selectedItemPosition);
        String ipSE1 = InputDetailRouterAdapter.ipSE1.get(selectedItemPosition);

        String subnetFA0 = InputDetailRouterAdapter.subnetFA0.get(selectedItemPosition);
        String subnetFA1 = InputDetailRouterAdapter.subnetFA1.get(selectedItemPosition);
        String subnetSE0 = InputDetailRouterAdapter.subnetSE0.get(selectedItemPosition);
        String subnetSE1 = InputDetailRouterAdapter.subnetSE1.get(selectedItemPosition);

        String routerFA0, routerFA1, routerSE0, routerSE1;

        editTextBandwith.setText(bandwidth);

        if (checkBoxFA0) {
            routerFA0 = "terhubung dengan router <b>"
                    +InputDetailRouterAdapter.spinnerFA0Selected.get(selectedItemPosition)+"" +
                    "<br></b> IP     : "+ipFA0+"" +
                    "<br> Subnet : "+subnetFA0;
        } else routerFA0 = "ini tidak digunakan";

        if (checkBoxFA1) {
            routerFA1 = "terhubung dengan router "
                    +InputDetailRouterAdapter.spinnerFA1Selected.get(selectedItemPosition)+"" +
                    "<br> IP     : "+ipFA1+"" +
                    "<br> Subnet : "+subnetFA1;
        } else routerFA1 = "ini tidak digunakan";

        if (checkBoxSE0) {
            routerSE0 = "terhubung dengan router "
                    +InputDetailRouterAdapter.spinnerSE0Selected.get(selectedItemPosition)+"" +
                    "<br> IP     : "+ipSE0+"" +
                    "<br> Subnet : "+subnetSE0;
        } else routerSE0 = " ini tidak digunakan";

        if (checkBoxSE1) {
            routerSE1 = "terhubung dengan router "
                    +InputDetailRouterAdapter.spinnerSE1Selected.get(selectedItemPosition)+"" +
                    "<br> IP     : "+ipSE1+"" +
                    "<br> Subnet : "+subnetSE1;
        } else routerSE1 = " ini tidak digunakan";

        textViewInformasi.setText(Html.fromHtml("<h1>Configurasi Router <b>" + nameRouter + "</b></h1> " +
                "<br>PORT FA0 " + routerFA0 + "<br>" +
                "<br>PORT FA1 " + routerFA1 + "<br> " +
                "<br>PORT SEO " + routerSE0 + "<br>" +
                "<br>PORT SE1 " + routerSE1 + ""));
    }
}
