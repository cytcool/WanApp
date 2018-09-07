package com.example.cyt.wanapp.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cyt.wanapp.R;
import com.example.cyt.wanapp.activity.base.BaseActivity;
import com.example.cyt.wanapp.view.fragment.home.HomeFragment;
import com.example.cyt.wanapp.view.fragment.home.MessageFragment;
import com.example.cyt.wanapp.view.fragment.home.MineFragment;


public class HomeActivity extends BaseActivity implements OnClickListener {

    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private Fragment mCommonFragmentOne;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        //初始化页面中所有的控件
        initView();

        mHomeFragment = new HomeFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();
    }



    private void initView() {
        mHomeLayout = findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView =  findViewById(R.id.home_image_view);
        mPondView = findViewById(R.id.fish_image_view);
        mMessageView = findViewById(R.id.message_image_view);
        mMineView = findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void hideFragment(Fragment fragment,FragmentTransaction ft){
        if (fragment!=null){
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                //隐藏其他两个fragment
                hideFragment(mMessageFragment,fragmentTransaction);
                hideFragment(mMineFragment,fragmentTransaction);
                //将我们的HomeFragment显示出来
                if (mHomeFragment == null){
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout,mHomeFragment);
                }else {
                    //已经创建过了
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);

                //隐藏其他两个fragment
                hideFragment(mHomeFragment,fragmentTransaction);
                hideFragment(mMineFragment,fragmentTransaction);
                //将我们的HomeFragment显示出来
                if (mMessageFragment == null){
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout,mMessageFragment);
                }else {
                    //已经创建过了
                    fragmentTransaction.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);

                //隐藏其他两个fragment
                hideFragment(mHomeFragment,fragmentTransaction);
                hideFragment(mMessageFragment,fragmentTransaction);
                //将我们的HomeFragment显示出来
                if (mMineFragment == null){
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout,mMineFragment);
                }else {
                    //已经创建过了
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }

        fragmentTransaction.commit();
    }
}
