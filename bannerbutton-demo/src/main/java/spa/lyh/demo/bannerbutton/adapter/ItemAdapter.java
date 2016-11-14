package spa.lyh.demo.bannerbutton.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import spa.lyh.demo.bannerbutton.R;
import spa.lyh.demo.bannerbutton.entity.ItemInfo;

/**
 * Created by liyuhao on 2016/11/10.<p>
 * 按钮的适配器<p>
 * button adapter<p>
 */

public class ItemAdapter extends BaseAdapter {
    Context context;
    List<ItemInfo> list;
    public ItemAdapter(Context context, List<ItemInfo> list){
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        ViewHolder mholder;
        ItemInfo itemInfo = list.get(position);
        if (convertView == null){
            v = View.inflate(context, R.layout.item,null);
            mholder = new ViewHolder();
            mholder.item_img = (ImageView) v.findViewById(R.id.item_img);
            mholder.item_name = (TextView) v.findViewById(R.id.item_name);
            v.setTag(mholder);
        }else{
            v=convertView;
            mholder = (ViewHolder) v.getTag();
        }
        mholder.item_img.setImageResource(itemInfo.getImgId());
        mholder.item_name.setText(itemInfo.getName());
        return v;
    }
    class ViewHolder{
        ImageView item_img;
        TextView item_name;
    }
}