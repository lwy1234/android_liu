package zz.liu.pull;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView) findViewById(R.id.tv);
    }


    public void pull(View view){
    	//拿到解析封装的对象
    	ArrayList<Channel> channels = Parser.getChannels(this);
    	//遍历显示在tv中，把集合对象添加到StringBuilder中，然后在显示tv中
    	StringBuilder builder = new StringBuilder();
    	for (Channel channel : channels) {
			builder.append("城市是：" + channel.city);
			builder.append("，温度为：" + channel.temp);
			builder.append("，风力为：" + channel.wind);
			builder.append("，PM250为：" + channel.pm250);
			builder.append("\n");
		}
    	tv.setText(builder);
    }
    
}
