package com.why.project.shortcutbadgerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.leolin.shortcutbadger.ShortcutBadgeException;
import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;

		//一般设备上的显示角标的代码--可以结合RomUtil进行机型判断
		try {
			ShortcutBadger.applyCountOrThrow(mContext, 9);
		} catch (ShortcutBadgeException e) {
			e.printStackTrace();
			//如果还没有提示过toast，则进行提示
			Toast.makeText(mContext,"本APP暂时无法在该设备上实现应用角标功能",Toast.LENGTH_SHORT).show();
		}

		//下面是小米设备上的显示角标的关键代码--可以结合RomUtil进行机型判断
		/*finish();//在小米设备上APP打开着的情况下，是不显示角标的，只有APP关闭了才会显示角标
		startService(new Intent(MainActivity.this, BadgeIntentService.class).putExtra("badgeCount", 9));*/
	}
}
