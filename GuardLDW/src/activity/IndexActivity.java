package activity;


import java.util.Timer;
import java.util.TimerTask;

import com.hero.app.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import util.BaseActivity;

public class IndexActivity extends BaseActivity{
	
	private Timer timer;
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			
			//只执行一次
			timer.cancel();
			
			Intent intent = new Intent(IndexActivity.this, MainActivity.class);
			startActivity(intent);
			
			//销毁该活动
			finish();
			super.handleMessage(msg);
		}
	};
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		
		timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				
				handler.sendEmptyMessage(0);
			}
			
			
		}, 1500, 10000);
		
	}

}
