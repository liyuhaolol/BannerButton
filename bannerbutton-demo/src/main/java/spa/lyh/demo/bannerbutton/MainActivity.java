package spa.lyh.demo.bannerbutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import spa.lyh.bannerbutton.BannerButton;
import spa.lyh.bannerbutton.listener.ViewPagerItemClickListener;
import spa.lyh.bannerbutton.listener.ViewPagerItemLongClickListener;
import spa.lyh.bannerbutton.view.WrapContentViewPaper;
import spa.lyh.demo.bannerbutton.adapter.ItemAdapter;
import spa.lyh.demo.bannerbutton.entity.ItemInfo;



public class MainActivity extends AppCompatActivity {
    private WrapContentViewPaper wrapViewPager;
    private LinearLayout indicator;
    private ItemAdapter iAdapter;
    private List<ItemInfo> mainList,listData;
    Random random = new Random();
    private int[] imgList = new int[]{R.drawable.v3,R.drawable.v4,R.drawable.v5,R.drawable.v6,R.drawable.v7,
            R.drawable.v8,R.drawable.v9,R.drawable.v10,R.drawable.v11,R.drawable.v12,R.drawable.v13,R.drawable.v14,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fakeData(22);
        initView();
        initBannerButton();
    }

    /**
     * 模拟的数据，代替项目实际数据，演示用<p>
     * fake data , instead of the actual project data , just a demo<p>
     * @param no 数据量 size of data
     */
    public void fakeData(int no){
        mainList = new ArrayList<>();
        listData = new ArrayList<>();
        for (int i = 0;i < no;i++){
            ItemInfo ii = new ItemInfo();
            ii.setName(getString(R.string.item_name)+i);
            ii.setImgId(imgList[random.nextInt(12)]);
            listData.add(ii);
        }
    }

    public void initView(){
        wrapViewPager = (WrapContentViewPaper) findViewById(R.id.wrapViewpager);
        indicator = (LinearLayout) findViewById(R.id.indicator);
        iAdapter = new ItemAdapter(getApplicationContext(),mainList);
    }

    public void initBannerButton(){
        BannerButton banBtn = new BannerButton()
                .Builder(getApplicationContext())
                .setViewPager(wrapViewPager)
                .setGridView(R.layout.gridview,R.id.wrapGridview)
                .setWidthHeight(4,2)
                .setData(mainList,listData,iAdapter)
                .setIndicator(indicator,0,0,true,0,0,5,0)
                .init();
        banBtn.setOnItemClickListener(new ViewPagerItemClickListener.onViewPagerItemClickListener() {
            @Override
            public void onPageItemClick(AdapterView<?> parent, View view, int position, long id, int page, int sum) {
                //page*sum+position是计算你点击的item在list中的位数。
                //page*sum+position is the sequence number of item you touched
                Toast.makeText(getApplicationContext(),listData.get(page*sum+position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        banBtn.setOnItemLongClickListener(new ViewPagerItemLongClickListener.onViewPagerItemLongClickListener() {
            @Override
            public boolean onPageItemClick(AdapterView<?> parent, View view, int position, long id, int page, int sum) {
                Intent in = new Intent(MainActivity.this,SuccessActivity.class);
                startActivity(in);
                return true;
            }
        });
    }
}
