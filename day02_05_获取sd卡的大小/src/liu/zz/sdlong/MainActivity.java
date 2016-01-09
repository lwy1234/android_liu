package liu.zz.sdlong;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView tv;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_info);
    }

    @SuppressLint("NewApi")
    public void getSd(View view) {
    	//��ȡsd����Ŀ¼
    	File file = Environment.getExternalStorageDirectory();
    	//��ȡsd�����ܴ�С
    	long totalsize =file.getTotalSpace();
    	//��ȡsd���Ŀ��ô�С
    	long usablesize = file.getUsableSpace();
    	
    	//��ȡת���õĴ�С
    	String totalFormatSize = Formatter.formatFileSize(this, totalsize);
    	String usableFormatSize = Formatter.formatFileSize(this, usablesize);
    	
    	//����sd��Ϣ
    	tv.setText("sd���ܴ�С�ǣ�"+totalFormatSize+"\n�������ܴ�СΪ��"+usableFormatSize);
    }
     
}
