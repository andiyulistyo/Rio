package com.rio.ospf;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.*;
import com.rio.ospf.adapter.InputDetailRouterAdapter;

public class InterfaceActivity extends Activity implements View.OnClickListener {

    private Spinner spinner;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_interface);

        Button button = (Button) findViewById(R.id.buttonShowIp);
        spinner = (Spinner) findViewById(R.id.spinnerInterface);
        textView = (TextView) findViewById(R.id.textViewInformasiInterface);

        button.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, InputDetailRouter.namaRouter);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        int selectedItemPosition;
        selectedItemPosition = spinner.getSelectedItemPosition();

        @SuppressWarnings("ConstantConditions") String nameRouter = spinner.getSelectedItem().toString();

        boolean checkBoxFA0, checkBoxFA1, checkBoxSE0, checkBoxSE1;

        checkBoxFA0 = InputDetailRouterAdapter.checboxFA0[selectedItemPosition];
        checkBoxFA1 = InputDetailRouterAdapter.checboxFA1[selectedItemPosition];
        checkBoxSE0 = InputDetailRouterAdapter.checboxSE0[selectedItemPosition];
        checkBoxSE1 = InputDetailRouterAdapter.checboxSE1[selectedItemPosition];

        String routerFA0, routerFA1, routerSE0, routerSE1;

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

        textView.setText(Html.fromHtml("<h1>Configurasi Router <b>"+nameRouter+"</b></h1> " +
                "<br>PORT FA0 <b>"+routerFA0+"</b> <br>" +
                "<br>PORT FA1 <b>"+routerFA1+"</b> <br> " +
                "<br>PORT SEO <b>"+routerSE0+"</b> <br>" +
                "<br>PORT SE1 <b>"+routerSE1+"</b> <br>"));
    }
}
