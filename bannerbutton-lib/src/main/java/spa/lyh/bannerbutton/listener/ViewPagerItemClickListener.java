package spa.lyh.bannerbutton.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Created by liyuhao on 2016/11/14.
 */

public class ViewPagerItemClickListener implements OnItemClickListener{
    private int page,sum;
    private onViewPagerItemClickListener listener;

    public interface onViewPagerItemClickListener{
        /**
         * 重写的itemClick配合viewpager
         * @param parent 父类view
         * @param view 当前view
         * @param position gridview中的位数
         * @param id id
         * @param page 在viewpager中的页数
         * @param sum 一页viewpaper可以承载的数据总数
         */
        void onPageItemClick(AdapterView<?> parent, View view, int position, long id,int page,int sum);
    }


    public ViewPagerItemClickListener(int page,int sum, onViewPagerItemClickListener listener){
        this.sum = sum;
        this.page = page;
        this.listener = listener;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (this.listener != null){
            this.listener.onPageItemClick(parent,view,position,id,page,sum);
        }
    }
}
