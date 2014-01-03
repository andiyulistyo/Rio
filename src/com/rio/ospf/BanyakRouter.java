package com.rio.ospf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BanyakRouter extends Activity implements View.OnClickListener {

    private EditText editTextInput;
    private Button buttonNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editTextInput = (EditText) findViewById(R.id.editTextBanyakRouter);
        buttonNext = (Button) findViewById(R.id.buttonSelanjutnya);

        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // ambil nilai dari inputan  user
        int router = Integer.valueOf(editTextInput.getText().toString());

        // pass ke class selanjutnya
        Intent intent = new Intent(getApplication(), NamaRouter.class);
        intent.putExtra("router", router);
        startActivity(intent);
    }
}
