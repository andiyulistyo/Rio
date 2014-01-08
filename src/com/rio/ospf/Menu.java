package com.rio.ospf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by souttab on 08/01/14.
 */
public class Menu extends Activity implements View.OnClickListener {

    private Button buttonOSPF, buttonCost, buttonIPShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_menu);

        buttonCost = (Button) findViewById(R.id.buttonCost);
        buttonIPShow = (Button) findViewById(R.id.buttonIPInterface);
        buttonOSPF = (Button) findViewById(R.id.buttonOSPF);

        buttonOSPF.setOnClickListener(this);
        buttonIPShow.setOnClickListener(this);
        buttonCost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonCost :
                intent = new Intent(getApplication(), Cost.class);
                startActivity(intent);
                break;
            case R.id.buttonIPInterface :
                intent = new Intent(getApplication(), InterfaceActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonOSPF :
                intent = new Intent(getApplication(), Ospf.class);
                startActivity(intent);
                break;
        }

    }
}
