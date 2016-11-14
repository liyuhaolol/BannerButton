package spa.lyh.bannerbutton;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import spa.lyh.bannerbutton.listener.ViewPagerItemClickListener;
import spa.lyh.bannerbutton.listener.ViewPagerItemClickListener.onViewPagerItemClickListener;
import spa.lyh.bannerbutton.listener.ViewPagerItemLongClickListener;
import spa.lyh.bannerbutton.listener.ViewPagerItemLongClickListener.onViewPagerItemLongClickListener;
import spa.lyh.bannerbutton.utils.DensityUtil;
import spa.lyh.bannerbutton.view.WrapContentGridView;
import spa.lyh.bannerbutton.view.WrapContentViewPaper;

/**
 * Created by liyuhao on 2016/11/13.
 */

public class BannerButton {
    private Context context;
    private WrapContentViewPaper wrapViewPager;
    private WrapContentGridView wrapGridView;
    private int layoutID,resID,width,sum,img,img_pressed;
    private List mainLst,listData;
    private List<List> listLst;
    private List<ImageView> imgList;
    private BaseAdapter adapter;
    private LinearLayout indicator;
    private onViewPagerItemClickListener shortClick;
    private onViewPagerItemLongClickListener longClick;

    public BannerButton(){
        indicator = null;
    }

    /**
     * Builder必须第一个设置，否则后面的设置可能会调用不到context<p>
     * Builder must be set frist,or other config may can't get context<p>
     * @param context 上下文
     * @return
     */
    public BannerButton Builder(Context context){
        this.context = context;
        return this;
    }

    /**
     * 设置viewpager<p>
     * set viewpager<p>
     * @param wrapViewPager WrapContentViewPaper对象
     * @return
     */
    public BannerButton setViewPager(WrapContentViewPaper wrapViewPager){
        this.wrapViewPager = wrapViewPager;
        return this;
    }

    /**
     * 设置GridView<p>
     * set viewpager<p>
     * @param layoutID 使用gridview的那个layout的xml的id。id of layout which include gridview
     * @param resID gridview的id。gridview id
     * @return
     */
    public BannerButton setGridView(int layoutID,int resID){
        this.layoutID = layoutID;
        this.resID = resID;
        return this;
    }

    /**
     * 设置一页最多有几行几列数据(4x2=8)<p>
     * set one page have how many columns and lines
     * @param width 列数 columns
     * @param height 行数 lines
     * @return
     */
    public BannerButton setWidthHeight(int width,int height){
        this.width = width;
        this.sum = width*height;
        return this;
    }

    /**
     * 设置列表数据
     * set list data
     * @param mainLst adapter绑定的list，进行翻页数据刷新用. list bound by adapter,when page change,refresh this list
     * @param listData 实际的原始数据. real data
     * @param adapter gridview的adapter gridview's adapter
     * @return
     */
    public BannerButton setData(List mainLst,List listData, BaseAdapter adapter){
        this.mainLst = mainLst;
        this.listData = listData;
        this.adapter = adapter;
        initListData();
        return this;
    }

    /**
     * 设置页签指示器
     * @param indicator 加载指示器的LinearLayout，设置null将不生成页签，后面的属性将没有意义.
     *                  LinearLayout to mount the indicator,if set null,it will not to mount the indicator,the rest of config will be useless
     * @param img_id 未被选中的页签图片id，设置0，调用lib默认的图片id
     *               img id which not be selected, set 0 ,will use lib default img id
     * @param img_pressed_id 选中的页签图片id，设置0，调用lib默认的图片id
     *                       img id which be selected, set 0 ,will use lib default img id
     * @param isDPvalus 是否使用DP设置Margin，否，使用PX
     *                  whether to use DP values to set margin.if false,use PX values
     * @param left Margin left
     * @param top Margin top
     * @param right Margin right
     * @param bottom Margin bottom
     * @return
     */
    public BannerButton setIndicator(LinearLayout indicator,int img_id,int img_pressed_id,boolean isDPvalus,int left,int top,int right,int bottom){
        if (indicator == null){
            return this;
        }
        this.indicator = indicator;
        if (img_id == 0){
            this.img = R.drawable.banner_dot;
        }else {
            this.img = img_id;
        }
        if (img_pressed_id == 0){
            this.img_pressed = R.drawable.banner_dot_pressed;
        }else {
            this.img_pressed = img_pressed_id;
        }
        if (listLst.size() > 1){
            imgList = new ArrayList<>();
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (isDPvalus){
                lp.setMargins(DensityUtil.dip2px(context,left),DensityUtil.dip2px(context,top), DensityUtil.dip2px(context,right),DensityUtil.dip2px(context,bottom));
            }else {
                lp.setMargins(left,top,right,bottom);
            }
            for (int i=0;i<listLst.size();i++){
                ImageView iv = new ImageView(context);
                if (i==0){
                    iv.setImageResource(img_pressed);
                }else {
                    iv.setImageResource(img);
                }
                indicator.addView(iv,lp);
                imgList.add(iv);
            }
        }
        return this;
    }

    /**
     * 最后调用这个属性，初始化并运行bannerbutton
     * use init() at last,to init and run the bannerbutton
     * @return
     */
    public BannerButton init(){
        PagerAdapter pAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return listLst.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = LayoutInflater.from(context).inflate(layoutID,wrapViewPager,false);
                wrapGridView = (WrapContentGridView) view.findViewById(resID);
                wrapGridView.setNumColumns(width);
                wrapGridView.setAdapter(adapter);
                wrapGridView.setOnItemClickListener(new ViewPagerItemClickListener(position,sum,shortClick));
                wrapGridView.setOnItemLongClickListener(new ViewPagerItemLongClickListener(position,sum,longClick));
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        };

        wrapViewPager.setAdapter(pAdapter);
        wrapViewPager.setCurrentItem(0);
        wrapViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mainLst.clear();
                mainLst.addAll(listLst.get(position));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageSelected(int position) {
                if (indicator != null){
                    for (int i = 0;i < imgList.size();i++){
                        imgList.get(i).setImageResource(img);
                    }
                    imgList.get(position).setImageResource(img_pressed);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return this;
    }

    /**
     * 将原始数据listData按照页数打散成对应的多个list
     * divide real data in to pieces by pages
     */
    public void initListData(){
        int page;
        switch (listData.size()/sum){
            case 0:
                page = 1;
                break;
            default:
                page = listData.size()/sum;
                switch (listData.size()%sum){
                    case 0:
                        break;
                    default:
                        page = page+1;
                        break;
                }
                break;
        }
        listLst = new ArrayList<>();
        List li;
        for (int i = 0;i < page;i++){
            li = new ArrayList<>();
            for (int j = i*sum;j<i*sum+sum;j++){
                if (j < listData.size()){
                    li.add(listData.get(j));
                }else {
                    break;
                }
            }
            listLst.add(li);
        }
    }

    public void setOnItemClickListener(onViewPagerItemClickListener shortClick){
        this.shortClick = shortClick;
    }

    public void setOnItemLongClickListener(onViewPagerItemLongClickListener longClick){
     this.longClick = longClick;
    }
}
