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
    	//获取sd卡的目录
    	File file = Environment.getExternalStorageDirectory();
    	//获取sd卡的总大小
    	long totalsize =file.getTotalSpace();
    	//获取sd卡的可用大小
    	long usablesize = file.getUsableSpace();
    	
    	//获取转化好的大小
    	String totalFormatSize = Formatter.formatFileSize(this, totalsize);
    	String usableFormatSize = Formatter.formatFileSize(this, usablesize);
    	
    	//设置sd信息
    	tv.setText("sd的总大小是："+totalFormatSize+"\n，可用总大小为："+usableFormatSize);
    }
     
}
