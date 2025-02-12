package util;

import activity.RegisterActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

//子类的super.onCreate(savedInstanceState)可以打印出当前实例的类名

public class BaseActivity extends Activity{
	
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		ActivityControl.addActivity(this);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Log.d("BaseActivity", getClass().getSimpleName());
		
	}
	
	
	protected void onDestroy(){
		
		super.onDestroy();
		ActivityControl.removeActivity(this);
	}
	
	
    //对Back键的监听
    public void onBackPressed(){ 
    	
    	AlertDialog.Builder dialog = new AlertDialog.Builder(BaseActivity.this);
		dialog.setMessage("是否要退出游戏");
		dialog.setCancelable(false);//只能点击对话框
		dialog.setPositiveButton("确认", new DialogInterface.OnClickListener(){
			
			@Override
			public void onClick(DialogInterface dialog, int which){
				
				Music.stopBackgroundMusic();//如果音乐正在播放，停止音乐
				ActivityControl.finishAll();

			}
		});  
		
		
		dialog.setNegativeButton("取消",new DialogInterface.OnClickListener(){
			
			@Override
			public void onClick(DialogInterface dialog, int which){ 
			
			}
		});
		
		dialog.show();
		return;		
		
    }

}
