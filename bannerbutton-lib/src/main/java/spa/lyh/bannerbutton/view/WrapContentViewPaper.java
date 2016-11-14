package spa.lyh.bannerbutton.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/** Created by liyuhao on 2016/11/13.<P>
 * 自定义ViewPaper,使其可以包裹内部内容<P>
 * Custom ViewPaper, so that it can wrap content inside the ViewPaper<P>
 */

public class WrapContentViewPaper extends ViewPager {
    public WrapContentViewPaper(Context context) {
        super(context);
    }

    public WrapContentViewPaper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        //遍历所有child的高度
        //traverse all child height
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            //采用最大的view的高度
            //use highest view
            if (h > height)
                height = h;
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
