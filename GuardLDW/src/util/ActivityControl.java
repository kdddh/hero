package util;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityControl {
	
	//建立链表activities，类型为Activity类
	public static List<Activity>  activities = new ArrayList<Activity>();
	
	//把运行的活动添加到链表中，在每个活动的OnCreate方法中都要调用，或是直接写在BaseActivity中
	public static void addActivity(Activity activity){
		
		activities.add(activity);
	}
	
	
	//把单个活动从链表中移除
	public static void removeActivity(Activity activity){
		
		activities.remove(activity);
	}
	
	//关闭所有活动
	public static void finishAll(){
		
		//遍历activities链表，并把数据记录到activity中
		for(Activity activity : activities){
			
			if(!activity.isFinishing()){
				
				activity.finish();
			}
		}
	}

}
