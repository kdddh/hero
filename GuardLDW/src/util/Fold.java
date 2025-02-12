package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.hero.app.R;

import activity.LoadGameActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


/*
 * 文件中数据的保存，读取与建立
 */



public class Fold {

	//建立初始记录数据的文件,只需要运行一次
    public static void build(Context context)
    {
   	 File file_gaonai = new File("/data/data/com.hero.app/files/gaonai");//存放高乃线
   	 File file_shixin = new File("/data/data/com.hero.app/files/shixin");//存放诗馨线
   	 File file_newpage = new File("/data/data/com.hero.app/files/newpage");//存放新篇章
   	 
   	 File file_music = new File("/data/data/com.hero.app/files/music");//存放背景音乐
   	 
   	 File file_userInfo = new File("/data/data/com.hero.app/file/userInfo");//存放模拟服务器的用户数据
   	 
   	 File file_save0 = new File("/data/data/com.hero.app/files/save0");//存放存档1
   	 File file_save1 = new File("/data/data/com.hero.app/files/save1");//存放存档2
   	 File file_save2 = new File("/data/data/com.hero.app/files/save2");//存放存档3
   	 File file_save3 = new File("/data/data/com.hero.app/files/save3");//存放存档4
   	 File file_save4 = new File("/data/data/com.hero.app/files/save4");//存放存档5
   	 File file_save5 = new File("/data/data/com.hero.app/files/save5");//存放存档6

   	
   	 File file_savei0 = new File("/data/data/com.hero.app/files/savei0");//存放存档i0的值
   	 File file_savei1 = new File("/data/data/com.hero.app/files/savei1");//存放存档i1的值
   	 File file_savei2 = new File("/data/data/com.hero.app/files/savei2");//存放存档i2的值
   	 File file_savei3 = new File("/data/data/com.hero.app/files/savei3");//存放存档i3的值
   	 File file_savei4 = new File("/data/data/com.hero.app/files/savei4");//存放存档i4的值
   	 File file_savei5 = new File("/data/data/com.hero.app/files/savei5");//存放存档i5的值

   	 
   	 if(!file_gaonai.exists())//运行一次后文件存在则不再运行
   	 {
   		 save("gaonai", "0", context);//建立初始文件，初值为0
   	 }
   	 
   	 if(!file_shixin.exists())
   	 {
   		 save("shixin", "0", context);
   	 }
   	 
   	 if(!file_newpage.exists())
   	 {
   		 save("newpage", "0", context);
   	 }
   	 
   	 if(!file_music.exists())
   	 {
   		 save("music", "0", context);
   	 }
   	 
   	 if(!file_save0.exists())
   	 {
   		 save("save0", "0", context);
   	 }
   	 
   	 if(!file_save1.exists())
   	 {
   		 save("save1", "0", context);
   	 }
   	 
   	 if(!file_save2.exists())
   	 {
   		 save("save2", "0", context);
   	 }
   	 
   	 if(!file_save3.exists())
   	 {
   		 save("save3", "0", context);
   	 }
   	
   	 if(!file_save4.exists())
   	 {
   		 save("save4", "0", context);
   	 }
   	 
   	 if(!file_save5.exists())
   	 {
   		 save("save5", "0", context);
   	 }
   	 

   	 if(!file_savei0.exists())
   	 {
   		 save("savei0", "0", context);
   	 }
   	 
   	 if(!file_savei1.exists())
   	 {
   		 save("savei1", "0", context);
   	 }
   	 
   	 if(!file_savei2.exists())
   	 {
   		 save("savei2", "0", context);
   	 }
   	 
   	 if(!file_savei3.exists())
   	 {
   		 save("savei3", "0", context);
   	 }
   	
   	 if(!file_savei4.exists())
   	 {
   		 save("savei4", "0", context);
   	 }
   	 
   	 if(!file_savei5.exists())
   	 {
   		 save("savei5", "0", context);
   	 }
   	 
   	 if(!file_userInfo.exists())
   	 {
   		 save("userInfo", "", context);
   	 }
   	 

    }
	
	
	
	//保存到文件    
    public static void save(String site, String text, Context context){
   	FileOutputStream out = null;//创建文件输出流对象
   	BufferedWriter writer = null;//创建缓冲写
   	try {
   		out = context.openFileOutput(site, Context.MODE_PRIVATE);//通过openFileOutput方法得到文件输出流对象
	    writer = new BufferedWriter(new OutputStreamWriter(out));
		writer.write(text);//将传入的参数text写入文件
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			}finally{  
           try {  
              if(writer != null){
               	writer.close();
               }
           } catch (Exception e) {  
               e.printStackTrace();  
           }  
       }     	
    }
    
    
    //从文件中读取
    public static String load(String site, Context context)
    {
   	 FileInputStream in = null;//创建文件输入流对象
   	 BufferedReader reader = null;//创建缓存读
   	 StringBuilder content = new StringBuilder();//创建可变字符串对象content
   	 try 
   	 {
			in = context.openFileInput(site);
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while ((line = reader.readLine()) != null){
				content.append(line);
			}			
		 } 
   	 catch (FileNotFoundException e) 
   	 {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{  
			if (reader != null){
           try {  
                	reader.close();
                }catch (Exception e) {  
                e.printStackTrace();  
            }  
			}
		}         
		return content.toString();   	 
    }

    
    public static String loadScript(Context context, String s){
    	SharedPreferences pref = context.getSharedPreferences("script", Context.MODE_PRIVATE); 
		return pref.getString(s, "脚本加载出现错误");
    	
    }
    
    
    //将存档日期显示出来，save0-5文件中保存的是存档1-6的时间，不为0说明有存档记录
    public static void checkSave(Context context)
    {
  	 
      	if(!Fold.load("save0", context).equals("0")){
      		LoadGameActivity.save[0] = Fold.load("save0", context);
      		}
      	if(!Fold.load("save1", context).equals("0"))
   	 {
   		 LoadGameActivity.save[1] = Fold.load("save1", context);
   	 }
      	if(!Fold.load("save2", context).equals("0"))
   	 {
   		 LoadGameActivity.save[2] = Fold.load("save2", context);
   	 }
      	if(!Fold.load("save3", context).equals("0"))
   	 {
   		 LoadGameActivity.save[3] = Fold.load("save3", context);
   	 }
      	if(!Fold.load("save4", context).equals("0"))
   	 {
   		 LoadGameActivity.save[4] = Fold.load("save4", context);
   	 }
      	if(!Fold.load("save5", context).equals("0"))
   	 {
   		 LoadGameActivity.save[5] = Fold.load("save5", context);
   	 }

    
    }
    
    
    

    //存储脚本，只需要运行一次
    public static void saveScript(Context context){
    	File file = new File("/data/data/com.hero.app/shared_prefs/script");
    	//保证只运行一次
    	if (!file.exists()){
    	   	SharedPreferences.Editor editor = context.getSharedPreferences("script", Context.MODE_PRIVATE).edit();
        	editor.putString("0", "柔和的阳光下，男孩在草地上尽情的奔跑着。");
        	editor.putString("1", "爸爸，妈妈，这是什么呀？");
        	editor.putString("2", "等等，这是蜜蜂，不能碰。");
        	editor.putString("3", "然而男孩早已把手伸了过去，紧接着伴随着一句叫喊。");
        	editor.putString("4", "好疼！");
        	editor.putString("5", "刚才是梦吗？");
        	editor.putString("6", "额头上冒着汗珠，身体感觉很沉。");
        	editor.putString("7", "坐在床边，我揉了揉眼睛，可劳累感还是丝毫没有减弱。");
        	editor.putString("8", "虽然记不起睡前发生的事，但心中却有一股莫名的不安。");
        	editor.putString("9", "我究竟睡了多长时间，之前的事情我怎么一点都想不起来？");
        	editor.putString("10", "我勉强站了起来，走向了客厅。");
        	editor.putString("11", "有什么线索呢？");
        	editor.putString("12", "绕着客厅走了一圈，依旧没有回忆起之前的事。");
        	editor.putString("13", "躺在沙发上，我打开了电视。");
        	editor.putString("14", "\"观众朋友们晚上好，今天是2018年11月14日，农历10月初7，欢迎收看《新闻联播》节目，本次节目的主要内容有......\"");
        	editor.putString("15", "新闻联播，有些印象。");
        	editor.putString("16", "现在已经是2018年了吗？");
        	editor.putString("17", "依稀觉得时间有些违和。");
        	editor.putString("18", "回到我的小屋，我寻找着可能记录着时间的东西。");
        	editor.putString("19", "书桌上有一本书，看起来像是日记的样子。");
        	editor.putString("20", "\"2008年8月8日，天气：晴          今天有北京奥运会的开幕式，开幕式上的表演太精彩了。中国队是最后入场的，运动员们都好厉害！我长大也要成为运动员！\"");
        	editor.putString("21", "好幼稚，但我却有种似曾相识的感觉。");
        	editor.putString("22", "我接着翻到了后面的一页。");
        	editor.putString("23", "\"2008年8月9日，天气：晴          今天是奥运会比赛的第一天，中国得了两块金牌，运动运们太棒了。\"");
        	editor.putString("24", "诶？");
        	editor.putString("25", "再往后翻直接到了最后一页，中间的纸不知道被谁撕掉了。");
        	editor.putString("26", "\"2008年11月14日，天气：多云          今天去郊游了，虽然手有点痛，但是好开心，晚上我要睡个好觉。\"");
        	editor.putString("27", "我刚才好像做了差不多的梦？");
        	editor.putString("28", "依旧没有思路，脑袋也变得有些混乱。");
        	editor.putString("29", "空气中弥漫着一丝燥热。");
        	editor.putString("30", "我穿上了大衣，准备去外面走走，说不定能想起些什么。");
        	editor.putString("31", "这是...?");
        	editor.putString("32", "在刚要出门的时候，我发现大门内侧贴着一张纸，纸显得有些残破，上面写满了字。");
        	editor.putString("33", "\"亲爱的高介：看到这段话的时候证明你已经醒了吧！我能够想象你此时的疑惑，但是不要着急。\"");
        	editor.putString("34", "\"不知道你对之前的记忆还留存多少。一年前，也就是2008年11月14日的晚上。\"");
        	editor.putString("35", "这不是我日记上记录的那天吗？");
        	editor.putString("36", "我接着看了下去。");
        	editor.putString("37", "\"那天我们郊游回来后，我问你想不想成为英雄。你还记得你当时的回答是什么吗？\"");
        	editor.putString("38", "\"你当时非常兴奋地答应了，还问我怎么能成为英雄。我兴奋的同时又伴有一丝悲伤，但对于你来说，这是不必可少的一段经历。\"");
        	editor.putString("39", "\"所谓英雄，是要拯救世界的。当我告诉你只要睡一觉醒后就能成为英雄时，你毫不犹豫的就上床准备去睡觉了。\"");
        	editor.putString("40", "\"我正在写些文字时，你还在床上躺着。这一觉，也不知你会睡几年。\"");
        	editor.putString("41", "妈妈在说些什么？我怎么有些听不懂呢。");
        	editor.putString("42", "\"长时间的沉睡是成为英雄的必备条件，可能你还没有发现自己有什么本质的改变，但你会慢慢察觉到发生在你身上的变化。\"");
        	editor.putString("43", "\"我和你爸爸马上就要去外国办些事情了，等我们事情办完就回来。这段时间你要好好生活，一定要等到我们回来的那天。\"");
        	editor.putString("44", "\"更多的真相就由你自己去探索吧。时刻要记住，不要放弃希望，要坚强的活下去。\"");
        	editor.putString("45", "\"爱你的妈妈，2009年11月14日。\"");
        	editor.putString("46", "纸上的字到这里就结束了，但我心中的疑惑却没有消除");
        	editor.putString("47", "这种小说一样的情节是怎么回事？(官方吐槽哈哈)");
        	editor.putString("48", "估计是恶作剧吧，即使这样，我还是有些在意。");
        	editor.putString("49", "我又回到了自己的房间。");
        	editor.putString("50", "再次看着我日记本记载着郊游那天的记录。");
        	editor.putString("51", "是有人看了我的日记后写的恶作剧吧，真是过分。");
        	editor.putString("52", "刚要合上日记本的时候，我注意到这页底下似乎写着字。");
        	editor.putString("53", "\"晚安\"");
        	editor.putString("54", "这不是刚才门上贴着的纸的字迹吗？");
        	editor.putString("55", "恶作剧会做的这么细心？");
        	editor.putString("56", "我有些迷茫。");
        	editor.putString("57", "难道说，这张纸真的是妈妈留给我的？");
        	editor.putString("58", "不愿意相信是真的，不愿去思考如果是真的自己该怎么办。");
        	editor.putString("59", "但我迟迟记不起的之前的事让我感觉这像是真的。这一觉，我睡了10年吗?");
        	editor.putString("60", "先去外面看看吧，呆在这里也没有用。");
        	editor.putString("61", "这么想着，我再次穿好外衣，准备走出家门。 ");
        	editor.putString("62", "开门的一刹那，外边一片明亮，仿佛打开了一扇通往新世界的大门。");
        	editor.putString("63", "阳光好刺眼。");
        	editor.putString("64", "我静静地观察着周围的一切，有些陌生又有些熟悉。");
        	editor.putString("65", "我能够感觉到我小时候来过这些地方。");
        	editor.putString("66", "\"车怎么还没来，这也太慢了。\"");
        	editor.putString("67", "一位等车的人不停地跺着地，面目狰狞的好像要吃人一般。");
        	editor.putString("68", "好可怕。");
        	editor.putString("69", "我往远离他的方向移了几步。");
        	editor.putString("70", "就在我快要经过他的时候，他突然朝我这边看了过来。");
        	editor.putString("71", "我回头看了看，什么都没有。");
        	editor.putString("72", "难道他是在看我？");
        	editor.putString("73", "我哪些地方很奇怪吗？");
        	editor.putString("74", "我有些疑惑，停下了脚步，想确认发生了什么。");
        	editor.putString("75", "突然！");
        	editor.putString("76", "他把喝完的饮料罐扔掉了地上，向我这边踢了过来。");
        	editor.putString("77", "什么！？");
        	editor.putString("78", "饮料罐直接砸到了我的腿上。");
        	editor.putString("79", "好疼。");
        	editor.putString("80", "这也太欺负人了，我非常生气。");
        	editor.putString("81", "不知为何，他竟然露出了吃惊的表情。");
        	editor.putString("82", "这难道是新的问候方式？");
        	editor.putString("83", "太荒唐了，我直接否定了这个可能性。");
        	editor.putString("84", "我走到他身边，竭力不将愤怒体现在表情上。");
        	editor.putString("85", "\"您刚才为什么用饮料罐踢我呢？\"");
        	editor.putString("86", "没有回答，似乎没有听见我说话一样。");
        	editor.putString("87", "我无法再控制我的情绪。");
        	editor.putString("88", "我挥出了拳头。");
        	editor.putString("89", "然而，我的手仿佛透明一般，直接穿过了他的身体。");
        	editor.putString("90", "失去平衡的我重重摔在了地上。");
        	editor.putString("91", "他竟然还在戏弄我？");
        	editor.putString("92", "我站了起来，准备用脚踹他。");
        	editor.putString("93", "但相似的一幕又发生了，我的脚直接穿过了他的身体。");
        	editor.putString("94", "他好像什么感觉都没有，依旧抱怨着车来的太慢。");
        	editor.putString("95", "这是怎么了？");
        	editor.putString("96", "我试图触碰身旁的任何人，但都失败了。");
        	editor.putString("97", "为什么我碰触不到别人？为什么奇怪的事接连发生在我身上？");
        	editor.putString("98", "莫非是我真的睡了10年，身体发生了变化？");
        	editor.putString("99", "完全不知道如何处理现在的情况。");
        	editor.putString("100", "先离开这个地方吧，感觉继续呆在这里会有不好的事发生。");
        	editor.putString("101", "我向着回家的方向走去。");
        	editor.putString("102", "\"喂，等会再走。\"");
        	editor.putString("103", "耳边传来了少女的声音。");
        	editor.putString("104", "估计是在叫一起玩的同伴吧，反正也没人能看见我。");
        	editor.putString("105", "我没有回头，继续走着。");
        	editor.putString("106", "\"说你呢！怎么听不懂人话啊！\"");
        	editor.putString("107", "是不是她们吵起来了，我回头看了看。");
        	editor.putString("108", "啊！眼前的画面吓了我一跳。");
        	editor.putString("109", "少女红着脸，两只大眼睛瞪着这边。");
        	editor.putString("110", "生气的少女好可怕。还好不是对我生气，要不然……");
        	editor.putString("111", "好疼！");
        	editor.putString("112", "......");
        	editor.putString("113", "恢复意识的时候，我已经趴在了地上。");
        	editor.putString("114", "好像被谁踹了一脚。");
        	editor.putString("115", "\"草莓的……\"");
        	editor.putString("116", "\"啊！！！变态，快去死！\"");
        	editor.putString("117", "紧接着又是一脚。");
        	editor.putString("118", "等等，她能听见我说话？");
        	editor.putString("119", "我突然燃起了希望。");
        	editor.putString("120", "\"别色咪咪地看着我。\"");
        	editor.putString("121", "少女的脸更红了。");
        	editor.putString("122", "\"你能看见我？\"");
        	editor.putString("123", "\"不光能看见，还能听见你刚才变态的发言呢。\"");
        	editor.putString("124", "终于能跟人说话了，终于有人能发觉我的存在了。");
        	editor.putString("125", "\"太好了，我还以为我被世界完全抛弃了。\"");
        	editor.putString("126", "\"喂，你在那里嘟囔什么？\"");
        	editor.putString("127", "\"没事，只是有些激动。\"");
        	editor.putString("128", "眼前的少女跟看起来就是一个普通的高中生。");
        	editor.putString("129", "\"为什么，只有你能看见我？\"");
        	editor.putString("130", "\"我们是一族的啊，交流对话什么的完全没问题。\"");
        	editor.putString("131", "\"原来是这样,看来那封信有很大可能真的是妈妈留给我的。\"");
        	editor.putString("132", "我是英雄？不会吧？");
        	editor.putString("133", "少女盯着我，像是在看着奇怪的东西。");
        	editor.putString("134", "\"你不会什么都不知道吧？\"");
        	editor.putString("135", "\"我才刚刚醒过来，对这个世界，甚至是我自己，都一无所知。\"");
        	editor.putString("136", "\"你也发觉你身体的异样了吧，我们一族身体变成这样是有原因的。\"");
        	editor.putString("137", "\"这与咱们被称为英雄有关系吗？\"");
        	editor.putString("138", "\"算是吧，咱们有的能力是吸收人们的负面情绪。\"");
        	editor.putString("139", "这是真的？我真的有能力？");
        	editor.putString("140", "\"我们可以把人的负面情绪吸收到自己身上。\"");
        	editor.putString("141", "好像很厉害的样子，等等……");
        	editor.putString("142", "\"这样的话我们不会崩溃吗？\"");
        	editor.putString("143", "少女的表情突然变得有些忧伤。");
        	editor.putString("144", "\"其实，咱们已经没有肉体了。\"");
        	editor.putString("145", "骗人的吧。");
        	editor.putString("146", "\"不对啊，我刚刚还被你踢了呢？\"");
        	editor.putString("147", "\"因为咱们都是特殊一族的。\"");
        	editor.putString("148", "我还是不相信，竭力找着反例。");
        	editor.putString("149", "\"我刚才被饮料罐了击中了...\"");
        	editor.putString("150", "没等我说完，少女就打断了我。");
        	editor.putString("151", "\"你所能碰触到的，只有没有生命的物体罢了。\"");
        	editor.putString("152", "\"不是吧？\"");
        	editor.putString("153", "\"这就是事实。\"");
        	editor.putString("154", "\"没有生命的物体，没有独立的思想，它们遵循的是世界普遍的真理，它会'认为'你跟普通人一样。\"");
        	editor.putString("155", "\"但像人这样有思想的生物就不行了，它们或多或少都有着思想，它们能够察觉到我们身体的异样。\"");
        	editor.putString("156", "\"所以，我们能碰触到的，只有像石头这样没有生命的物体。\"");
        	editor.putString("157", "少女已经解释的很清楚了，但我却还是不愿相信。");
        	editor.putString("158", "为什么，她能这么平静地说出这些话？");
        	editor.putString("159", "难道她经历的太多，已经适应了吗？");
        	editor.putString("160", "或许是害怕知道更多的真相，我没有继续问下去。");
        	editor.putString("161", "\"我叫高乃，一直在这片区域活动，以后咱们应该会经常见到。\"");
        	editor.putString("162", "高乃吗？没想到名字还挺正常的。");
        	editor.putString("163", "\"我叫高介，请多指教了。\"");
        	editor.putString("164", "和高乃的初遇，给了我继续生活的希望。");
        	editor.putString("165", "孤独感，不再那么强烈了。");
        	editor.putString("166", "\"起床了！\"");
        	editor.putString("167", "好吵……");
        	editor.putString("168", "朦胧地看到了有个人站在我面前，张着嘴说着什么的样子。");
        	editor.putString("169", "\"啊！\"");
        	editor.putString("170", "头被某个东西击中了，我也渐渐地变得清醒。");
        	editor.putString("171", "原来是高乃。");
        	editor.putString("172", "等等，这穿的难道是……");
        	editor.putString("173", "\"你为什么穿着围裙啊？\"");
        	editor.putString("174", "\"因为，要吃早饭。\"");
        	editor.putString("175", "\"我们没有肉体，应该不需要营养跟能量了吧，吃饭什么的没必要了吧？\"");
        	editor.putString("176", "\"确实是这样，但你刚才不是还在睡觉，明明不睡也可以的。\"");
        	editor.putString("177", "\"可能是因为习惯了吧。\"");
        	editor.putString("178", "昨天晚上回到家我就自觉地去睡觉了，虽然身体不累，也没有困意，我还是下意识地去睡觉了。");
        	editor.putString("179", "人，真是奇怪的生物呢。");
        	editor.putString("180", "\"咱们要尽量过普通人的生活，像是吃饭睡觉什么的，这样我们才有活着的感觉。\"");
        	editor.putString("181", "高乃看着我，认真的说。");
        	editor.putString("182", "\"嗯，知道了。\"");
        	editor.putString("183", "\"早饭做好了，快来吃吧！\"");
        	editor.putString("184", "虽然没有饿意，我还是把早饭好好的吃完了。");
        	editor.putString("185", "\"高乃。\"");
        	editor.putString("186", "\"嗯？\"");
        	editor.putString("187", "\"你之前也经历过长时间的沉睡吗？\"");
        	editor.putString("188", "既然我们是一族的，应该有很多相似的地方。");
        	editor.putString("189", "\"据说我睡了三年。\"");
        	editor.putString("190", "\"这么短啊，我睡了整整十年呢。\"");
        	editor.putString("191", "\"哈哈，怪不得这么笨呢！\"");
        	editor.putString("192", "高乃大笑着，然而我一头雾水。");
        	editor.putString("193", "\"笑什么呀？\"");
        	editor.putString("194", "\"沉睡的时间越短，能力就越强。像我这样的在整个族中都属于时间短的了，被称为天才也毫不为过。\"");
        	editor.putString("195", "\"你这样睡了十年的我还是第一次见，一定属于吊车尾的。\"");
        	editor.putString("196", "\"是吗？还真是抱歉呢！\"");
        	editor.putString("197", "\"生气啦？对不起，我没有嘲笑你的意思。\"");
        	editor.putString("198", "嘴上说着，高乃还是忍不住在笑……");
        	editor.putString("199", "\"为什么我们睡了那么长时间？\"");
        	editor.putString("200", "昨天晚上才躺下的我，今天早上就起来了，跟正常人的睡眠时间一样。");
        	editor.putString("201", "对于之前长时间的睡眠，我有些在意。");
        	editor.putString("202", "\"我们一族有着极其特殊的体质，不得不通过长时间的睡眠使我们的肉体变得虚无，要不然我们就无法活下去。\"");
        	editor.putString("203", "\"特殊的体质？\"");
        	editor.putString("204", "\"负面情绪在人与人之间是不停流动的，从不易吸收负面情绪体质的人身上到容易吸收负面情绪的体质的人身上。\"");
        	editor.putString("205", "\"有的人生气的时候，会遇到怒气突然消失的情况。这就是因为他们身上的怒气被身旁的人吸收了。\"");
        	editor.putString("206", "\"而我们，就是属于最容易吸收负面情绪的体质。负面情绪又是依附于肉体存在的，所以……\"");
        	editor.putString("207", "\"只能舍弃肉体了吗？\"");
        	editor.putString("208", "\"是的，小孩时期这种体质还不是很明显。但随着年龄增长，体质带来的影响会越来越突出。\"");
        	editor.putString("209", "\"如果现在我们的肉体还在，会不停地吸收周围人的负面情绪，最后会崩溃的。\"");
        	editor.putString("210", "现在的安然无恙原来得益于那次睡眠。");
        	editor.putString("211", "\"当我们失去肉体后，吸收的负面情绪就会飘散到天空之中了。因此，我们可以不停地吸收负面情绪并且不会崩溃。\"");
        	editor.putString("212", "这样看来，我真的能够成为英雄。");
        	editor.putString("213", "不过，是建立在失去肉体的巨大牺牲下，不为人知的英雄。");
        	editor.putString("214", "\"谢谢你，耐心的讲给我听。\"");
        	editor.putString("215", "\"突，突然说什么啊，变态……\"");
        	editor.putString("216", "高乃红着脸，但没一会就恢复了正常。");
        	editor.putString("217", "\"公园那边散发出了很多负面情绪，我待会要去看看。你先自己试试你的能力吧。\"");
        	editor.putString("218", "说完后，高乃就离开了，并没有告诉我使用能力的方法。");
        	editor.putString("219", "现在该怎么办啊...我纠结着。");
        	editor.putString("220", "总之，先出去看看吧，英雄，首先就要能担负起肩上的责任。");
        	editor.putString("221", "我做好了准备，再一次走出了家门。");        	
        	editor.putString("222", "\"怎么车还没来啊，真慢。\"");
        	editor.putString("223", "\"途经车站时，我听到了似乎有些熟悉的声音。\"");
        	editor.putString("224", "这不是……上次用饮料罐踢我的大叔吗！");
        	editor.putString("225", "听了之前高乃讲述的真相，见到大叔后我也没有很生气。说不定这个人是易于吸收负面情绪的体质。");
        	editor.putString("226", "正好拿他来练练手吧。");
        	editor.putString("227", "我集中注意力，感受着聚集在他身上的负面情绪，然后想象着它们向我身体周围移动的情景。");
        	editor.putString("228", "这样持续了一段时间后，我感觉有些累了。");
        	editor.putString("229", "也不知道成没成功。");
        	editor.putString("230", "我能稍微感觉到一点点负面情绪的踪迹，但对于它们具体量的多少，我还感觉不出来。");
        	editor.putString("231", "此时，公交车进站了。");
        	editor.putString("232", "怎么偏偏挑这个时间来，这样我怎么知道能力生没生效。");
        	editor.putString("233", "看来还要找另一个人实验了。");
        	editor.putString("234", "\"您先上车吧。\"");
        	editor.putString("235", "什么！？");
        	editor.putString("236", "刚才急着等车的大叔没有着急上车，反而在礼让周围的人。");
        	editor.putString("237", "成功了！");
        	editor.putString("238", "第一次尝试还挺顺利的，就是感觉有些累。");
        	editor.putString("239", "我现在了解到了我的能力，我真的能够去拯救一个人。");
        	editor.putString("240", "如果我能够及时恰当地使用能力，就不会有人因为压力过大而自杀了。");
        	editor.putString("241", "战争，犯罪，这些也都不会再发生了。");
        	editor.putString("242", "我感受到了身上的责任，即使没人有知道我，我也要不停的努力着。");
        	editor.putString("243", "现在先回家休息会吧。也不知道高乃那边的事情办的怎么样了。");
        	editor.putString("244", "过马路时，我格外小心，因为人们看不到我。");
        	editor.putString("245", "如果车撞到我的话，对车上的人会造成伤害。");
        	editor.putString("246", "这红灯时间好长啊，我发着呆，看着时间一秒秒的减少。");
        	editor.putString("247", "身前突然晃过一个人影。");
        	editor.putString("248", "好漂亮，披在肩上的散发，迷人的眼睛，身上散发着文雅的气息。");
        	editor.putString("249", "我想向她打招呼，但没有开口。");
        	editor.putString("250", "她是普通人，是听不见我的声音的。");
        	editor.putString("251", "少女从我身边经过，逐渐向远方走去。而我呆呆地站在原地。");
        	editor.putString("252", "我是英雄，我有更重要的事情去做。我对自己说。");
        	editor.putString("253", "以后估计也见不到了吧，这么想着，我继续踏上了回家的旅途。");
        	editor.putString("254", "\"我回来了。\"");
        	editor.putString("255", "\"哎呀，你好慢啊。我都在家呆了好长时间了。\"");
        	editor.putString("256", "\"别看我慢，我第一次尝试就成功了。\"");
        	editor.putString("257", "\"是嘛？没想到还挺厉害的。\"");
        	editor.putString("258", "\"你那边什么状况？\"");
        	editor.putString("259", "\"公园里行人多，负面情绪的积累快，有些敏感体质的人很快就承受不住了。\"");
        	editor.putString("260", "\"不过我分分钟就解决了。\"");
        	editor.putString("261", "高乃一副自豪的样子。");
        	editor.putString("262", "回到房间，脑中依稀还有那位少女的身影。");
        	editor.putString("263", "我躺在床上，很快就睡着了。");
        	editor.putString("264", "第二天早上，熟悉的声音。");
        	editor.putString("265", "\"起床了！笨蛋，快起来。\"");
        	editor.putString("266", "\"知道了，别拿枕头砸我了。\"");
        	editor.putString("267", "早上刚起来就这么有能量，高乃还真是厉害。");
        	editor.putString("268", "坐在饭桌旁，高乃又端上了看起来很美味的早餐。");
        	editor.putString("269", "我依旧没有食欲。");
        	editor.putString("270", "你还真是不怕麻烦呢。");
        	editor.putString("271", "\"当然了，我已经习惯每天早起吃早餐了，这样我才有执行任务的动力。\"");
        	editor.putString("272", "\"执行任务吗……\"");
        	editor.putString("273", "\"这是我们必须要做的，就算是任务吧。你待会也要出发，继续磨练你的能力。\"");
        	editor.putString("274", "虽然觉得身体很累，但行动起来丝毫没有影响。");
        	editor.putString("275", "每当我想偷懒时，我都会提醒自己是英雄，是荣耀的一族。这次也不例外。");
        	editor.putString("276", "\"我出门了。\"");
        	editor.putString("277", "\"嗯，加油！\"");
        	editor.putString("278", "高乃冲我摆出了加油的手势。");
        	editor.putString("279", "刚顺着路走了一会，我就发现了一个消极的年轻人。");
        	editor.putString("280", "他坐在路边的椅子上，不停地抱怨着。");
        	editor.putString("281", "\"为什么我做什么事情都不顺利，每个人都在针对我，这个社会已经容不下我了。\"");
        	editor.putString("282", "看来问题好像很严重。");
        	editor.putString("283", "不过有了上次的经验，我也没有不知所措。");
        	editor.putString("284", "跟上次一样，静静地感受他身上聚集的负面情绪，然后把它们移到自己周围。");
        	editor.putString("285", "\"我现在应该努力提升自己，主动去适应这个社会，总会有适合我的路可走。\"");
        	editor.putString("286", "还是挺顺利的。");
        	editor.putString("287", "虽然还是不能直接感觉出负面情绪具体量的多少，但这次用的时间少了很多。");
        	editor.putString("288", "现在还挺早的，接着去寻找需要帮助的人吧。");
        	editor.putString("289", "\"诗馨，快点走啊，吃不吃饭了？\"");
        	editor.putString("290", "一位少女在我前面不远处，冲着同伴喊着。");
        	editor.putString("291", "已经快中午了，我却一点都不饿，好羡慕有食欲的普通人的生活。");
        	editor.putString("292", "少女的同伴转过身来...");
        	editor.putString("293", "这不是上次过红绿灯时遇见的那个美少女吗？");
        	editor.putString("294", "穿着校服，应该是高中生吧。");
        	editor.putString("295", "当她从我身边经过时，我觉得有些奇怪。");
        	editor.putString("296", "回去问问高乃吧。 ");
        	editor.putString("297", "不出所料，当我回家的时候，高乃已经在沙发上悠闲地休息了。");
        	editor.putString("298", "\"今天怎么样？\"");
        	editor.putString("299", "\"还可以，比昨天更熟练了。\"");
        	editor.putString("300", "\"你要加油练到我这个样子，这样才能变得更轻松。\"");
        	editor.putString("301", "真是的……");
        	editor.putString("302", "\"今天中午，我遇到了一个人，我觉得她身上负面情绪的存在跟其他人不太一样。\"");
        	editor.putString("303", "\"你竟然能察觉到这个。\"");
        	editor.putString("304", "原本趴着的高乃坐了起来，显得很吃惊。");
        	editor.putString("305", "\"每个人身上的负面情绪基本上有两种来源，一种是自己产生的，另一种是从别人身上吸收的。\"");
        	editor.putString("306", "\"两种量不同的配比会造成不一样的结果，如果从别人身上吸收的多，我们就更好处理。如果自己产生的多，处理起来就要费些力气。\"");
        	editor.putString("307", "高乃在说什么，好深奥的样子。");
        	editor.putString("308", "\"等等……\"");
        	editor.putString("309", "\"你遇见的是不是一个长发的少女，高中左右的年纪？\"");
        	editor.putString("310", "\"你怎么知道，莫非这是心灵感应？\"");
        	editor.putString("311", "\"感应个头啊，她可是我们这个地区重点监视对象。\"");
        	editor.putString("312", "\"啊？为什么要重点监视她？\"");
        	editor.putString("313", "\"她自身产生的负面情绪可以达到非常巨大的量，我们要尽力避免她情绪的波动。\"");
        	editor.putString("314", "高乃挠了挠头，从旁边的档案袋里掏出了几页纸，递给了我。");
        	editor.putString("315", "\"她这种情况处理起来很麻烦呢，你先看看这些资料。\"");
        	editor.putString("316", "\"姓名：诗馨，年龄：16，级别：危险\"");
        	editor.putString("317", "真的是她……看起来明明很普通的样子。");
        	editor.putString("318", "\"她之前还是挺稳定的，近些天我也没太关注她。\"");
        	editor.putString("319", "\"要不你每天都去看看她的状况吧？\"");
        	editor.putString("320", "高乃坏笑着。");
        	editor.putString("321", "\"我该怎么找到她？\"");
        	editor.putString("322", "\"她不是学生吗？你去学校就行了。\"");
        	editor.putString("323", "\"哪个学校的？\"");
        	editor.putString("324", "\"看校服你都不知道啊，真笨。\"");
        	editor.putString("325", "熟悉的高乃式嘲笑。");
        	editor.putString("326", "这个丫头，真是……");
        	editor.putString("327", "真的是她……看起来明明很普通的样子。");
        	editor.putString("328", "\"三叶中学的，顺着门外边那条街一直向北走就能看见了。\"");
        	editor.putString("329", "\"谢谢了。\"");
        	editor.putString("330", "我尽量保持着微笑，心中却已是万匹神兽奔腾。");
        	editor.putString("331", "隔天早晨，为了能在校门口见到诗馨，我起的很早。");
        	editor.putString("332", "\"尽量别让人注意到你。\"");
        	editor.putString("333", "想起了临走前高乃对我说的话。");
        	editor.putString("334", "本来就没人能看见我，为什么还要注意呢？高乃是不是老起太早变傻了。");
        	editor.putString("335", "校门口，正好是学生入校的时间，显得很拥挤。");
        	editor.putString("336", "我集中注意力，在无数穿着校服的学生中寻找着诗馨的身影。");
        	editor.putString("337", "诗馨刚踏入校门，我就发现了，真是个完完全全的美少女，非常显眼。");
        	editor.putString("338", "现在可不是想这个的时候，我赶紧追上诗馨，一起到了教室。");
        	editor.putString("339", "要是我跟正常人一样的话，应该也是在上高中的吧。");
        	editor.putString("340", "铃声响起，开始上课了。");
        	editor.putString("341", "\"上课的开始，先来回顾上次课的内容。\"");
        	editor.putString("342", "老师走了进来，一边说着一边在黑板上写着题。");
        	editor.putString("343", "\"诗馨，你上来做做这道题，用上节课学的知识点。\"");
        	editor.putString("344", "\"老师，我不会做了。\"");
        	editor.putString("345", "\"那个同学，你上来接着做。\"");
        	editor.putString("346", "诗馨红着脸，回到了自己的座位。");
        	editor.putString("347", "几个同学在底下悄悄议论着什么。");
        	editor.putString("348", "我走了过去。");
        	editor.putString("349", "\"诗馨又没做出来，这都几次了。\"");
        	editor.putString("350", "紧接着传来了声音很小的笑声。");
        	editor.putString("351", "下课了，诗馨回到了座位上，默默的看着刚才上课记的笔记。");
        	editor.putString("352", "\"这么笨干脆别学习了。\"");
        	editor.putString("353", "\"次次考试都倒数第一，太差劲了。\"");
        	editor.putString("354", "又是那几个同学在悄悄的议论。");
        	editor.putString("355", "笨难道有错吗？这个时候不是应该去帮助诗馨吗？");
        	editor.putString("356", "越想越生气，这样对诗馨太不公平了。");
        	editor.putString("357", "要给他们点惩罚。");
        	editor.putString("358", "\"别让人注意到你。\"");
        	editor.putString("359", "原来高乃是不让我做一些超乎普通人常理的事情。");
        	editor.putString("360", "再呆在这里不知道会做出什么事来，总之现在先回家冷静冷静。");
        	editor.putString("361", "回到家中，我终于冷静下来了。");
        	editor.putString("362", "诗馨能产生巨大的负面情绪的原因我总算知道了，可她表现得一直很平静，没有不满跟抱怨。");
        	editor.putString("363", "为什么那些同学跟诗馨过不去呢，难道是因为她们都吸收了其他人的负面情绪？");
        	editor.putString("364", "不会这么凑巧的，怎么想都是她们主动去讨厌诗馨的。");
        	editor.putString("365", "诗馨明明努力过了，即使最后比不过别人，也不应该被指责。");
        	editor.putString("366", "人们总是喜欢看一件事的结果，只要最后的结果好了，就不去管过程了。结果不好，甚至会将任何过程都否定掉。");
        	editor.putString("367", "\"你之前监视她时，她也经常被同学说笨吗？\"");
        	editor.putString("368", "\"是啊，那时候她还经常当时就哭出来呢。\"");
        	editor.putString("369", "\"对了，忘记告诉你。她的感应比平常人要灵敏的多。所以不到万不得已，不要去做多余的事情。\"");
        	editor.putString("370", "\"什么是多余的事情？\"");
        	editor.putString("371", "\"比如说，惩罚嘲笑诗馨的人？\"");
        	editor.putString("372", "高乃一边说一边看着我。");
        	editor.putString("373", "\"你怎么会知道？\"");
        	editor.putString("374", "\"果然，我就觉得你这么笨做出不聪明的事。你要是被诗馨注意到了无论是对他还是对我们都没有好处。\"");
        	editor.putString("375", "\"她的感觉那么厉害？\"	");
        	editor.putString("376", "\"我觉得她在这方面很厉害，之前我甚至觉得她察觉到我了，你还是多注意点吧。\"");
        	editor.putString("377", "隔天早上，我直接去了诗馨的教室。");
        	editor.putString("378", "班级里很热闹，正在收作业。");
        	editor.putString("379", "过了一会，老师走了进来。");
        	editor.putString("380", "讲台上已经收了很多的作业本，老师一本接一本的翻着，翻到一本的时候突然停住了。");
        	editor.putString("381", "\"诗馨，你这个作业没写完吧?\"");
        	editor.putString("382", "\"老师，她没认真写。\"");
        	editor.putString("383", "又是那个讨厌的声音。");
        	editor.putString("384", "我作业是认真写的，昨天回家之后我就开始写了。");
        	editor.putString("385", "诗馨尽力为自己辩解。");
        	editor.putString("386", "行了，先这样吧。");
        	editor.putString("387", "老师看起来没有相信诗馨的样子，随后离开了教室。");
        	editor.putString("388", "我无法忍受了,我完全无视了高乃的建议。");
        	editor.putString("389", "在她写东西的时候，我碰了她拿笔的胳膊，紧接着在纸上出现了长长的一道。");
        	editor.putString("390", "我知道做这种事情是不好的，但是我还是没有控制住自己。");
        	editor.putString("391", "诗馨一早就受到打击，没问题吧？");
        	editor.putString("392", "我向诗馨那边的座位看了过去。");
        	editor.putString("393", "诗馨依旧很平静，默默地低着头，写着什么的样子。");
        	editor.putString("394", "应该在记笔记吧。");
        	editor.putString("395", "突然，诗馨把写着字的本竖着举了起来，像是在让什么人看的样子。");
        	editor.putString("396", "我非常好奇，靠了过去。");
        	editor.putString("397", "\"我知道你在周围。\"");
        	editor.putString("398", "什么？凑巧了吧。");
        	editor.putString("399", "紧接着，诗馨又写了几行字。");
        	editor.putString("400", "\"前段时间我也觉得有个人，不过似乎不是你。\"	");
        	editor.putString("401", "\"我也不知道我是怎么感觉到这些的，但我对你们的了解远比你认为的多的多。\"");
        	editor.putString("402", "\"高乃竟然也被发现了，一个普通人怎么会有这种能力？\"");
        	editor.putString("403", "\"你们是来监视我的吧，因为我非常危险。\"");
        	editor.putString("404", "\"我还知道，当一个人负面情绪积攒到一定地步的时候，就会崩溃，甚至消失。\"");
        	editor.putString("405", "诗馨难道也是我们一族的？");
        	editor.putString("406", "不对，其他同学明明能看见她。那是为什么？");
        	editor.putString("407", "\"我消失的话你们也会很开心的吧。\"");
        	editor.putString("408", "写完这句话后，诗馨傻傻的笑了笑。");
        	editor.putString("409", "可恶，事情怎么会变成这样。");
            editor.putString("410", "我该怎么办？");
            
            //点击了stayButton，高乃线
        	editor.putString("510", "不行，让她知道我对我们都没有好处，要忍住。");
        	editor.putString("511", "长时间的沉默，我和诗馨似乎都静止了一般。");
        	editor.putString("512", "我渐渐的觉得有些不对劲，诗馨身上的负面情绪似乎正在快速的增长。");
        	editor.putString("513", "这是怎么回事？我有些不知所措。");
        	editor.putString("514", "先把诗馨身上的负面情绪吸收过来吧，跟以前一样，先集中注意力……");
        	editor.putString("515", "但突然，诗馨从座位上跃起，顺着窗户跳了下去。");
        	editor.putString("516", "在跳下前的一瞬间，诗馨流着泪，看着我所在的方向。");
        	editor.putString("517", "我赶紧跑到窗户边，可一切都太迟了。");
        	editor.putString("518", "诗馨的本上，写着最后一行字。");
            editor.putString("519", "\"谢谢你们这段时间对我的照顾，我走了，你们不用再费心了。\"");
        	editor.putString("520", "都是我的错，如果我刚才及时劝阻她，就不会……");
        	editor.putString("521", "我离开了教室，行尸走肉般，一步步的向家中走去。");
        	editor.putString("522", "忘不了诗馨的脸。");
        	editor.putString("523", "学校中传来的喧哗，救护车的警报声，都被我抛在了身后。");
        	editor.putString("524", "记不清是怎么走回来的，我无力地打开了屋门。");
        	editor.putString("525", "高乃好像早已发现了什么异常，看到我回来后，急忙跑了过来。");
        	editor.putString("526", "\"我刚才感觉到这片区域有一个巨大量的负面情绪产生又突然消失了，是诗馨出什么事了吗？\"");
        	editor.putString("527", "\"她，她不在了。都是我害的。\"");
        	editor.putString("528", "高乃扑了过来，抱住了我。");
            editor.putString("529", "\"没事的。\"");
        	editor.putString("530", "\"可是，我害死了她，我明明有机会救她的。\"");
        	editor.putString("531", "\"这些都过去了，待会在想吧。\"");
        	editor.putString("532", "……");
        	editor.putString("533", "风和日丽的早上，我拿着一束花，与高乃一起往墓地走去。");
        	editor.putString("534", "\"一年了呢。\"");
        	editor.putString("535", "\"是啊。\"");
        	editor.putString("536", "距离诗馨去世，已经过了整整一年的时间。");
        	editor.putString("537", "这一年，很平静，人们都安逸地生活着。这算是我们给诗馨最大的礼物了吧。");
        	editor.putString("538", "诗馨去世以后，我曾消极了一段时间。");
            editor.putString("539", "但后来，我想明白了，诗馨既然这样选择了，不是为了自己，而是为了整个社会。");
        	editor.putString("540", "我所能为诗馨做的只有持续不断地使用我的能力，去吸收世间的负面情绪，完成诗馨的愿望。");
        	editor.putString("541", "在我消极的那段时间，高乃每天都陪着我，安慰我。");
        	editor.putString("542", "当然，还有不可缺少的早饭……");
        	editor.putString("543", "我轻轻的抱住了身边的高乃。");
        	editor.putString("544", "\"啊？你这是干嘛，快松开。\"");
        	editor.putString("545", "\"谢谢你了。\"");
        	editor.putString("546", "笨蛋，我是强者，你是弱者，帮助你是应该做的。");
        	editor.putString("547", "高乃的脸变得通红。");
        	editor.putString("548", "回家的路上，阳光明媚，我们手挽着手，漫步在街道。");
            editor.putString("549", "不管未来等待我的是什么困难，我都不会再迷茫。");
            editor.putString("550", "因为，高乃会在我身边一直陪伴着我，帮助着我。");
            editor.putString("551", "高乃线已通关");
            
            //点击了doButton，诗馨线
            editor.putString("1510", "我抢过了她手中的笔，划掉了诗馨刚写的那句话。");
        	editor.putString("1511", "同时我在底下又添上了一句话。");
        	editor.putString("1512", "\"我是正义的英雄，是来帮助你的。你由我来拯救。\"");
        	editor.putString("1513", "诗馨看了我写的话后，低下了头，久久没有动作。");
        	editor.putString("1514", "难道我写了什么不合适的话吗？");
        	editor.putString("1515", "过了一会儿，诗馨慢慢抬起了头，脸上有些许泪痕。");
        	editor.putString("1516", "\"谢谢你了，你一定要好好拯救我。\"");
        	editor.putString("1517", "\"放心吧。\"");
        	editor.putString("1518", "这种用笔在纸上写字的交流方式，更像是上课怕老师发现时的动作，但此时却成为了我们唯一的交流方式。");
            editor.putString("1519", "\"今天过的怎么样?\"");
        	editor.putString("1520", "\"挺好的，今天我做出来老师在黑板上出的题了！\"");
        	editor.putString("1521", "这样日常的对话已经持续了好多天，每天课间或是放学，我都会站在她身边。");
        	editor.putString("1522", "笔和纸成为了我现在每天携带的必需品，虽然诗馨能稍微感觉到我的存在，但是还不足以看见我，更别提听见我说话了。");
        	editor.putString("1523", "即使不能被看见，这样默默的在周围守护诗馨就够了，不仅保护了诗馨的安全，也维护了整个区域的稳定。");
        	editor.putString("1524", "周末，久违的短暂休息时间，高乃躺在沙发上悠闲的看着电视。");
        	editor.putString("1525", "而我嘛……");
        	editor.putString("1526", "\"又去见诗馨啊？\"");
        	editor.putString("1527", "\"没错！\"");
        	editor.putString("1528", "我一边回答着一边跑出了家门。");
            editor.putString("1529", "夕阳下，樱花盛开着，一位少女站在樱花树下，静静地赏着花。");
        	editor.putString("1530", "一阵微风佛过，吹散了少女的长发，也吹动了枝条，几朵樱花从枝条上掉落。");
        	editor.putString("1531", "与此同时，一位少年正从道路的远端走来。随着眼中画面不断地清晰，少年渐渐露出了微笑。");
        	editor.putString("1532", "诗馨线已通关");

            
            
        	editor.commit();
    	}
 
    	
    	
    	
    }

    


}
