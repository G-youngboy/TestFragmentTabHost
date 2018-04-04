package com.gwt.testfragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout flContainer;
    private FragmentTabHost tabHost;
    private FrameLayout flTab;
    private String[] tabNames = {"首页", "题库", "课程", "我的"};
    private int[] imageButton = {R.drawable.tab_home_selector, R.drawable.tab_exercises_selector, R.drawable.tab_course_selector, R.drawable.tab_mine_selector};
    private Class[] fragmentArray = {OneFragment.class, TwoFragment.class, ThreeFragment.class, FourFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        flContainer = findViewById(R.id.fl_container);
        tabHost = findViewById(R.id.fragment_tab);
        flTab = findViewById(R.id.fl_fragment_tab);
    }

    private void initData() {
        tabHost.setup(this, getSupportFragmentManager(), R.id.fl_container);

        for (int i = 0; i < tabNames.length; i++) {
            // 给每一个Tabbutton设置图标、文字和内容
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabNames[i]).setIndicator(getButtonView(i));
            // 将Tabbutton加入进Tab选项卡中
            tabHost.addTab(tabSpec, fragmentArray[i], null);
            //去掉分隔的竖线
            tabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        }
    }

    /**
     * 获取每一个选项
     * @param index
     * @return
     */
    public View getButtonView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
        ImageView imageView = view.findViewById(R.id.image);
        //设置图标
        imageView.setImageResource(imageButton[index]);
        TextView textView = view.findViewById(R.id.text);
        //设置文字
        textView.setText(tabNames[index]);
        return view;
    }
}
