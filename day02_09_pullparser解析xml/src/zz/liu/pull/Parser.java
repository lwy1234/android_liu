package zz.liu.pull;


import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;


import android.content.Context;
import android.util.Xml;

/*
 * 专门用来解析的类
 * 
 */
public class Parser {
	public static ArrayList<Channel> getChannels(Context context){
		//定义一个集合用于存放解析的xml
		ArrayList<Channel> channels = null;
		Channel channel = null;
		try {
			//得到要解析的xml文件，此处存放在本地assets文件中,此处可以得到要解析的流
			InputStream is = context.getAssets().open("weather.xml");
			//得到一个解析器
			XmlPullParser parser = Xml.newPullParser();
			//设置要解析的输入流
			parser.setInput(is, "utf-8");
			//进行解析，首先拿到事件类型
			int type = parser.getEventType();
			while(type != parser.END_DOCUMENT) {
				switch (type) {
				case XmlPullParser.START_TAG:
					if("weather".equals(parser.getName())) {
						//此时new集合队象
						channels = new ArrayList<Channel>();
					} else if("channel".equals(parser.getName())){
						//这里new Channel bean对象
						channel = new Channel();
						//得到id的值，并赋值给channel的id
						String id = parser.getAttributeValue(0);
						channel.id = id;
					} else if("city".equals(parser.getName())){
						channel.city = parser.nextText();
					} else if("temp".equals(parser.getName())){
						channel.temp = parser.nextText();
					} else if("wind".equals(parser.getName())){
						channel.wind = parser.nextText();
					}else if("pm250".equals(parser.getName())){
						channel.pm250 = parser.nextText();
					}
					
					break;
				case XmlPullParser.END_TAG:
					if("channel".equals(parser.getName())) {
						channels.add(channel);
					}
					break;

				default:
					break;
				}
				//一定要有下一个标签获取事件值的步骤
				type = parser.nextTag();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//不要忘记返回集合对象
		return channels;
		
	}
}
