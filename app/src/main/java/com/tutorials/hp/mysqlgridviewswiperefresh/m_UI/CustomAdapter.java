package com.tutorials.hp.mysqlgridviewswiperefresh.m_UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.mysqlgridviewswiperefresh.R;
import com.tutorials.hp.mysqlgridviewswiperefresh.m_DataObject.Spacecraft;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.spacecraftImage);

        Spacecraft s= (Spacecraft) this.getItem(position);

        nameTxt.setText(s.getName());
        PicassoClient.downloadImage(c,s.getImageUrl(),img);

        return convertView;
    }
}
