package com.kelvearagao.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CLEIDE on 02/11/2016.
 */

public class FriendAdapter extends BaseAdapter {
    private final Context context;
    private final List<User> users;

    public FriendAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users != null ? users.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_friends, parent, false);

        TextView t = (TextView) view.findViewById(R.id.friendName);

        User friend = users.get(i);
        t.setText(friend.getNome());

        return view;
    }
}
