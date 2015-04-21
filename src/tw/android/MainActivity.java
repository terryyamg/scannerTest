package tw.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//���y�@�����X
	public void scanBar(View v) {
		try {
			Intent intent = new Intent(ACTION_SCAN);
			intent.putExtra("SCAN_MODE", "PRODUCT_MODE"); //�@�����X�Ҧ�
			startActivityForResult(intent, 0);
		} catch (ActivityNotFoundException anfe) {
			
		}
	}
	
	//���yQRcode
	public void scanQR(View v) {
		try {
			Intent intent = new Intent(ACTION_SCAN);
			intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); //QR code�Ҧ�
			startActivityForResult(intent, 0);
		} catch (ActivityNotFoundException anfe) {
		
		}
	}

	//�Ǧ^���G
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				//get the extras that are returned from the intent
				String contents = intent.getStringExtra("SCAN_RESULT"); //���y���G
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");//���y�榡
				Toast toast = Toast.makeText(this, "���e:" + contents + " �榡:" + format, Toast.LENGTH_LONG);
				toast.show();
			}
		}
	}
}