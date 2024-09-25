package com.prothes.baseadapterwithlayoutinflater;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomBaseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int[] flag;
    private String[] countryName,countryDetails;
    public CustomBaseAdapter(MainActivity mainActivity, int[] flag, String[] countryName, String[] countryDetails) {
        this.context = mainActivity;
        this.flag = flag;
        this.countryName = countryName;
        this.countryDetails = countryDetails;
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.items_layout_design,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView1 = convertView.findViewById(R.id.textView1);
        TextView textView2 = convertView.findViewById(R.id.textView2);
        imageView.setImageResource(flag[position]);
        textView1.setText(countryName[position]);
        textView2.setText(countryDetails[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = countryDetails[position];
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Text",getData);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied Details", Toast.LENGTH_SHORT).show();
            }
        });
        

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = countryDetails[position];
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,getData);
                intent.setType("text/plain");

                Intent shareText = Intent.createChooser(intent,null,null);
                context.startActivity(shareText);
            }
        });


        return convertView;
    }
}
