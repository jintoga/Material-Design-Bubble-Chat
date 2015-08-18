package com.dat.test9patch;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by DAT on 8/12/2015.
 */
public class MyChatAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Message> data;

    public MyChatAdapter(Context context, ArrayList<Message> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        } else
            return 0;
    }

    @Override
    public Message getItem(int position) {
        if (data != null) {
            return data.get(position);
        } else
            return null;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Message msg = getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chat_item_layout, viewGroup, false);
            viewHolder = createViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        boolean isFromMe = msg.isFrom();
        if (isFromMe == Message.isFromMe) {
            viewHolder.avatar.setImageResource(R.drawable.avatar);
            viewHolder.message.setText(getItem(position).getContent());
            viewHolder.message.setBackgroundResource(R.drawable.bubright);

            RelativeLayout.LayoutParams layoutParamsContainer = (RelativeLayout.LayoutParams) viewHolder.container.getLayoutParams();
            layoutParamsContainer.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            viewHolder.container.setLayoutParams(layoutParamsContainer);

            LinearLayout.LayoutParams layoutParamsAvatar = (LinearLayout.LayoutParams) viewHolder.avatar.getLayoutParams();
            layoutParamsAvatar.gravity = Gravity.RIGHT;
            viewHolder.avatar.setLayoutParams(layoutParamsAvatar);

            LinearLayout.LayoutParams layoutParamsMsg = (LinearLayout.LayoutParams) viewHolder.message.getLayoutParams();
            layoutParamsMsg.gravity = Gravity.RIGHT;
            layoutParamsMsg.rightMargin = 20;
            viewHolder.message.setLayoutParams(layoutParamsMsg);
        } else {
            viewHolder.avatar.setImageResource(R.drawable.girl);
            viewHolder.message.setText(getItem(position).getContent());
            viewHolder.message.setBackgroundResource(R.drawable.bubleft);

            RelativeLayout.LayoutParams layoutParamsContainer = (RelativeLayout.LayoutParams) viewHolder.container.getLayoutParams();
            layoutParamsContainer.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            viewHolder.container.setLayoutParams(layoutParamsContainer);

            LinearLayout.LayoutParams layoutParamsAvatar = (LinearLayout.LayoutParams) viewHolder.avatar.getLayoutParams();
            layoutParamsAvatar.gravity = Gravity.LEFT;
            viewHolder.avatar.setLayoutParams(layoutParamsAvatar);

            LinearLayout.LayoutParams layoutParamsMsg = (LinearLayout.LayoutParams) viewHolder.message.getLayoutParams();
            layoutParamsMsg.gravity = Gravity.LEFT;
            layoutParamsMsg.leftMargin = 20;
            viewHolder.message.setLayoutParams(layoutParamsMsg);
        }
        return convertView;
    }

    private ViewHolder createViewHolder(View view) {
        ViewHolder holder = new ViewHolder();
        holder.message = (TextView) view.findViewById(R.id.textViewMsg);
        holder.avatar = (ImageView) view.findViewById(R.id.imageViewAvatar);
        holder.container = (LinearLayout) view.findViewById(R.id.linearLayoutContainer);
        return holder;
    }

    private static class ViewHolder {
        ImageView avatar;
        TextView message;
        LinearLayout container;
    }
}
