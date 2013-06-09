package com.jt.getdunked2;
 
import java.util.List;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
 
public class LazyAdapter extends ArrayAdapter {
 
    int resource;
    String response;
    Context context;
    private LayoutInflater mInflater;
 
    public LazyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.resource = resource;
        mInflater = LayoutInflater.from(context);
    }
 
    static class ViewHolder {
        TextView title;
        TextView description;
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        //Get the current location object
        Response pcs = (Response) getItem(position);
 
        //Inflate the view
        if(convertView==null)
        {
            convertView = mInflater.inflate(R.layout.custom_list_view, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView
                    .findViewById(R.id.gameType);
            holder.description = (TextView) convertView
                    .findViewById(R.id.tvResult);
 
            convertView.setTag(holder);
 
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
        //holder.title.setText();
        //holder.description.setText(pcs.getChampionId().toString());
 
        return convertView;
    }
 
}