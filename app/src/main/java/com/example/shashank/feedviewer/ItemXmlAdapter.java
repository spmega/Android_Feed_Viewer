package com.example.shashank.feedviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * Created by shashank on 4/6/16.
 */
public class ItemXmlAdapter extends BaseAdapter {
    private ArrayList<ItemXml> itemXmls = new ArrayList<ItemXml>();

    public ItemXmlAdapter(){
        itemXmls.add(new ItemXml("bhadu01", "http:///csdcSddWD", "DWEfweBARBDVADB ADFCBVvavsevE"));
        itemXmls.add(new ItemXml("GVRAA02", "http:///csdcDDSddWD", "DWEfwevC FD C DAXCavsevE"));
        itemXmls.add(new ItemXml("bhVRBSBSBadu03", "http:///csdcS33ddWD", "DWEfw FDJHXCV HEJD evavsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
        itemXmls.add(new ItemXml("bhBARBABABAEBEadu04", "http:///csdcVDSVSDSddWD", "DWEfweva KDF CKDXC KvsevE"));
    }

    public ItemXmlAdapter(ArrayList<ItemXml> list){
        itemXmls = list;
    }

    @Override
    public int getCount() {
        return itemXmls.size();
    }

    @Override
    public Object getItem(int position) {
        //return itemXmls.get(position);
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemXml itemXml = itemXmls.get(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        TextView titleView = (TextView) convertView.findViewById(R.id.xml_title);
        TextView linkView = (TextView) convertView.findViewById(R.id.link);
        TextView descView = (TextView) convertView.findViewById(R.id.description);

        titleView.setText(itemXml.getName());
        linkView.setText(itemXml.getLink());
        descView.setText(itemXml.getDescription());

        return convertView;
    }
}
