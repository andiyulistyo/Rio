package com.rio.ospf;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.rio.ospf.adapter.InputDetailRouterAdapter;

/**
 * Created by souttab on 08/01/14.
 */
public class InterfaceActivity extends Activity implements View.OnClickListener {

    private Spinner spinner;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_interface);

        spinner = (Spinner) findViewById(R.id.spinnerInterface);
        button = (Button) findViewById(R.id.buttonShowIp);
        textView = (TextView) findViewById(R.id.textViewFA0);

        button.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, InputDetailRouter.namaRouter);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        int selectedItemPosition = spinner.getSelectedItemPosition();

        String nameRouter = spinner.getSelectedItem().toString();

        boolean checkBoxFA0, checkBoxFA1, checkBoxSE0, checkBoxSE1;

        checkBoxFA0 = InputDetailRouterAdapter.checboxFA0[selectedItemPosition];
        checkBoxFA1 = InputDetailRouterAdapter.checboxFA1[selectedItemPosition];
        checkBoxSE0 = InputDetailRouterAdapter.checboxSE0[selectedItemPosition];
        checkBoxSE1 = InputDetailRouterAdapter.checboxSE1[selectedItemPosition];


//        String routerFA0 = InputDetailRouterAdapter.spinnerFA0Selected.get(selectedItemPosition);

        String routerFA0, routerFA1, routerSE0, routerSE1;

        if (checkBoxFA0) {
            routerFA0 = InputDetailRouterAdapter.spinnerFA0Selected.get(selectedItemPosition);
        } else routerFA0 = "tidak digunakan";

        if (checkBoxFA1) {
            routerFA1 = InputDetailRouterAdapter.spinnerFA1Selected.get(selectedItemPosition);
        } else routerFA1 = "PORT ini tidak digunakan";

        if (checkBoxSE0) {
            routerSE0 = InputDetailRouterAdapter.spinnerSE0Selected.get(selectedItemPosition);
        } else routerSE0 = "PORT ini tidak digunakan";

        if (checkBoxSE1) {
            routerSE1 = InputDetailRouterAdapter.spinnerSE1Selected.get(selectedItemPosition);
        } else routerSE1 = "PORT ini tidak digunakan";

        textView.setText(Html.fromHtml("<h2>Configurasi  <b>"+nameRouter+"</b></h2> " +
                "<br>PORT FA0 terhubung dengan router <b>"+routerFA0+"</b> " +
                "<br>PORT FA1 terhubung dengan router <b>"+routerFA1+"</b> " +
                "<br>PORT SEO terhubung dengan router <b>"+routerSE0+"</b>" +
                "<br>PORT SE1 terhubung dengan router <b>"+routerSE1+"</b>"));


    }
}
