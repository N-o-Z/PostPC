package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	
	private boolean _round = false;
	private TextView _tip;
	private Button _btn;
	private EditText _billAmount;
	private Editable _billEdit;
	private double _bill;
	private double _tipAmount = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		_tip = (TextView)findViewById(R.id.txtTipResult);
		_btn = (Button)findViewById(R.id.btnCalculate);
		_billAmount = (EditText)findViewById(R.id.edtBillAmount);
		CheckBox chkRound  = (CheckBox)findViewById(R.id.chkRound);
		
		chkRound.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			_round = !_round;
				setTip();
			}		
		});
		
		_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				_billEdit = _billAmount.getEditableText();
				try {
					_bill = Double.valueOf(_billEdit.toString());
					_tipAmount = _bill*0.12;
				}
				catch (Exception e) {
					_tipAmount = 0;
				}
				
				setTip();					
			}
		
		});
	}
	
	private void setTip() {
		if(_round) {
			_tip.setText("Tip: $"+ (Math.round(_tipAmount)));
		}
		else {
			_tip.setText("Tip: $"+String.format("%.2f", _tipAmount));
			
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
