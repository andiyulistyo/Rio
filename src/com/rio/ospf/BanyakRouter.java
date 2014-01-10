package com.rio.ospf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.haarman.supertooltips.ToolTip;
import com.haarman.supertooltips.ToolTipRelativeLayout;
import com.haarman.supertooltips.ToolTipView;

public class BanyakRouter extends Activity implements View.OnClickListener, ToolTipView.OnToolTipViewClickedListener {

    private EditText editTextInput;
    private Button buttonNext;
    private ToolTipRelativeLayout mToolTipRelativeLayout;
    private ToolTipView toolTips;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mToolTipRelativeLayout = (ToolTipRelativeLayout) findViewById(R.id.layoutFrame);
        editTextInput = (EditText) findViewById(R.id.editTextBanyakRouter);
        buttonNext = (Button) findViewById(R.id.buttonSelanjutnya);
        buttonNext.setEnabled(false);

        editTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().trim().isEmpty())  {
                    buttonNext.setEnabled(true);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            addToolTips();
                        }
                    }, 100);
                } else  {
                    buttonNext.setEnabled(false);
                    toolTips.remove();
                }
            }
        });

        buttonNext.setOnClickListener(this);
    }

    public void addToolTips() {
        toolTips = mToolTipRelativeLayout.showToolTipForView(
                new ToolTip()
                    .withText("Touch untuk Proses Selanjutny")
                    .withColor(getResources().getColor(R.color.holo_green))
                    .withShadow(false),
                findViewById(R.id.buttonSelanjutnya));
        toolTips.setOnToolTipViewClickedListener(this);
    }

    @Override
    public void onClick(View view) {
        // ambil nilai dari inputan  user
        int router = Integer.valueOf(editTextInput.getText().toString());

        if (toolTips == null) {
            addToolTips();
        } else {
            toolTips.remove();
            toolTips = null;
        }
        // pass ke class selanjutnya
        Intent intent = new Intent(getApplication(), NamaRouter.class);
        intent.putExtra("router", router);
        startActivity(intent);
    }

    @Override
    public void onToolTipViewClicked(ToolTipView mtoolTipView) {
        if (toolTips == mtoolTipView) toolTips = null;
    }


}
