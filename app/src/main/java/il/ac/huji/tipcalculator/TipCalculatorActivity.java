package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class TipCalculatorActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnCalculate);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        EditText editText = (EditText)findViewById(R.id.edtBillAmount);
        String text = editText.getText().toString();
        double val = Double.parseDouble(text);
        val = val*0.12;

        CheckBox chk = (CheckBox)findViewById(R.id.chkRound);
        DecimalFormat formatter = new DecimalFormat("#.##");
        if (chk.isChecked()){
            int rnded = (int) Math.round(val);
            TextView res= (TextView)findViewById(R.id.txtTipResult);
            res.setText("Tip:" + String.valueOf(rnded));
        }
        else{
            TextView res= (TextView)findViewById(R.id.txtTipResult);
            res.setText("Tip:" + formatter.format(val));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
