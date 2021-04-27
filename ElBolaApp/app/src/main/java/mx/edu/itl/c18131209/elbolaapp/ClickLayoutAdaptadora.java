package mx.edu.itl.c18131209.elbolaapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ClickLayoutAdaptadora implements View.OnClickListener {

    private Activity activity;

    public ClickLayoutAdaptadora(Activity activity ) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        View view = activity.getCurrentFocus();
        if ( view != null ) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService (
                    Context.INPUT_METHOD_SERVICE );
            imm.hideSoftInputFromWindow ( view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS );
        }
    }
}
