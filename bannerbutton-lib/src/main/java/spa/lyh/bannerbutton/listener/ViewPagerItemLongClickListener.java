package spa.lyh.bannerbutton.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

/**
 * Created by liyuhao on 2016/11/14.
 */

public class ViewPagerItemLongClickListener implements OnItemLongClickListener{
    private int page,sum;
    private onViewPagerItemLongClickListener listener;

    public interface onViewPagerItemLongClickListener{
        /**
         * 重写的itemClick配合viewpager
         * @param parent 父类view
         * @param view 当前view
         * @param position gridview中的位数
         * @param id id
         * @param page 在viewpager中的页数
         * @param sum 一页viewpaper可以承载的数据总数
         * @return 是否拦截该事件，让其向下传导
         */
        boolean onPageItemClick(AdapterView<?> parent, View view, int position, long id,int page,int sum);
    }

    public ViewPagerItemLongClickListener(int page,int sum, onViewPagerItemLongClickListener listener){
        this.sum = sum;
        this.page = page;
        this.listener = listener;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (this.listener != null){
            return this.listener.onPageItemClick(parent,view,position,id,page,sum);
        }else {
            return true;
        }
    }
}
