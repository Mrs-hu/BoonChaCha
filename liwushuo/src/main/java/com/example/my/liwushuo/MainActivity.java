package com.example.my.liwushuo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.my.liwushuo.app.BaseActivity;
import com.example.my.liwushuo.frg.FenLeiFragment;
import com.example.my.liwushuo.frg.MeFragment;
import com.example.my.liwushuo.frg.ReMenFragment;
import com.example.my.liwushuo.frg.ZhiNanFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.rb_zhinan)
    RadioButton rbZhiNan;
    @BindView(R.id.rb_remen)
    RadioButton rbReMen;
    @BindView(R.id.rb_fenlei)
    RadioButton rbFenLei;
    @BindView(R.id.rb_wode)
    RadioButton rbMe;

    private FragmentManager manager;
    private ZhiNanFragment zhiNanFragment;
    private ReMenFragment reMenFragment;
    private FenLeiFragment fenLeiFragment;
    private MeFragment meFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        manager = getSupportFragmentManager();
        rgMain.setOnCheckedChangeListener(this);
        rbZhiNan.setChecked(true);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        hideAll(transaction);
        switch (checkedId){
            case R.id.rb_zhinan:
                if (zhiNanFragment==null){
                    zhiNanFragment = ZhiNanFragment.newInstance();
                    transaction.add(R.id.fl_main,zhiNanFragment,"zhiNanFragment");
                    transaction.addToBackStack("zhiNanFragment");
                }else {
                    transaction.show(zhiNanFragment);
                }
                break;
            case R.id.rb_remen:
                if (reMenFragment==null){
                    reMenFragment = ReMenFragment.newInstance();
                    transaction.add(R.id.fl_main,reMenFragment,"reMenFragment");
                    transaction.addToBackStack("reMenFragment");
                }else {
                    transaction.show(reMenFragment);
                }
                break;
            case R.id.rb_fenlei:
                if (fenLeiFragment==null){
                    fenLeiFragment = FenLeiFragment.newInstance();
                    transaction.add(R.id.fl_main,fenLeiFragment,"fenLeiFragment");
                    transaction.addToBackStack("fenLeiFragment");
                }else {
                    transaction.show(fenLeiFragment);
                }
                break;
            case R.id.rb_wode:
                if (meFragment==null){
                    meFragment = MeFragment.newInstance();
                    transaction.add(R.id.fl_main,meFragment,"meFragment");
                    transaction.addToBackStack("meFragment");
                }else {
                    transaction.show(meFragment);
                }
                break;
        }
        transaction.commit();
    }



    private void hideAll(FragmentTransaction transaction) {
        if (zhiNanFragment!=null){
            transaction.hide(zhiNanFragment);
        }
        if (reMenFragment!=null){
            transaction.hide(reMenFragment);
        }
        if (fenLeiFragment!=null){
            transaction.hide(fenLeiFragment);
        }
        if (meFragment!=null){
            transaction.hide(meFragment);
        }
    }
}
