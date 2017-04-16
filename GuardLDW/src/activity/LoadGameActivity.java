package activity;


import com.hero.app.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import util.BaseActivity;
import util.Fold;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class LoadGameActivity extends BaseActivity{
	
	//打开一次应用只运行一次
    public static String[] save = {"存档1          XXXX.XX.XX.XX.XX.XX","存档2          XXXX.XX.XX.XX.XX.XX","存档3          XXXX.XX.XX.XX.XX.XX",
                                   "存档4          XXXX.XX.XX.XX.XX.XX","存档5          XXXX.XX.XX.XX.XX.XX","存档6          XXXX.XX.XX.XX.XX.XX",
                                  };
    
    
	private ListView loadList;
	private Button backButton;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		

		super.onCreate(savedInstanceState);
        setContentView(R.layout.loadgame);
   	
       
        backButton = (Button)findViewById(R.id.button_loadgameback);
        backButton.setOnClickListener(new Listener());
 
        //在loadList设置适配器前更改save数组的值
        Fold.checkSave(LoadGameActivity.this);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LoadGameActivity.this, android.R.layout.simple_list_item_1, save);
        loadList = (ListView)findViewById(R.id.listview_loadgame);
        loadList.setAdapter(adapter);
        
        //长按listviewset的监听
        loadList.setOnItemLongClickListener(new LongListener());

        //ListView的点击子项响应方法（点击）
        loadList.setOnItemClickListener(new ItemListener());
        
	}

	
	
	
	private class Listener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(LoadGameActivity.this, MainActivity.class);
			startActivity(intent);
			
		}

	}
	
	
	private class LongListener implements OnItemLongClickListener{

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
			
			MainActivity.i = Integer.parseInt(Fold.load("savei" + position, LoadGameActivity.this));
			if(MainActivity.i >= 0 && MainActivity.i <= 410){
				Toast.makeText(LoadGameActivity.this, "当前存档位于共通线", Toast.LENGTH_SHORT).show();
			}else if(MainActivity.i >= 510 && MainActivity.i <= 551){
				Toast.makeText(LoadGameActivity.this, "当前存档位于高乃线",Toast.LENGTH_SHORT).show();
			}else if(MainActivity.i >= 1510 && MainActivity.i <= 1532){
				Toast.makeText(LoadGameActivity.this, "当前存档位于诗馨线",Toast.LENGTH_SHORT).show();
			}else if(MainActivity.i == 411){
				Toast.makeText(LoadGameActivity.this, "当前存档位于第一个选项处",Toast.LENGTH_SHORT).show();
			}
			
	        //如果返回false那么click仍然会被调用。而且是先调用Long click，然后调用click。 
	        //如果返回true那么click就会被吃掉，click就不会再被调用了
			return true;
		}
		
		
	}
	
	
	private class ItemListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
				MainActivity.i = Integer.parseInt(Fold.load("savei" + position, LoadGameActivity.this));//将字符形式的MainActivity.i转化为整形并读取
				Intent intent = new Intent(LoadGameActivity.this, StartGameActivity.class);
				startActivity(intent);//开始加载游戏（通过进入游戏的布局）

		}
		
		
	}
	

	
 
}
