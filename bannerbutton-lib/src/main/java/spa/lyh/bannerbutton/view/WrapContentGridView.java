package spa.lyh.bannerbutton.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/** Created by liyuhao on 2016/11/13.<P>
 * 自定义GridView,使其可以包裹内部内容<P>
 * Custom GridView, so that it can wrap content inside the GridView<P>
 */
public class WrapContentGridView extends GridView{

    public WrapContentGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapContentGridView(Context context) {
        super(context);
    }

    public WrapContentGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
