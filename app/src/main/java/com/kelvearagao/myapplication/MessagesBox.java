package com.kelvearagao.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CLEIDE on 02/11/2016.
 */

public class MessagesBox extends AppCompatActivity {

    private DatabaseReference users_root;
    private String userId;
    private ListView listView;
    private List<User> users = new ArrayList<>();
    private BaseAdapter friendAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_box);

        listView = (ListView) findViewById(R.id.chat_list);
        friendAdapter = new FriendAdapter(this, users);

        listView.setAdapter(friendAdapter);

        userId = "sdsfsdf";
        users_root = FirebaseDatabase.getInstance().getReference().child("users");
        DatabaseReference user_root = users_root.child(userId);

        users_root.addValueEventListener(getUsersValueEventListener());
        user_root.addValueEventListener(getUserValueEventListener());
    }

    private ValueEventListener getUserValueEventListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                System.out.println("-----------------------");
                System.out.println(user.getNome());
                System.out.println("-----------------------");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao carregar o usuário");
            }
        };
    }

    private ValueEventListener getUsersValueEventListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users.clear();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);

                    if( user == null ) {
                        System.out.println("!!Usuario vazio!!!");
                        continue;
                    }

                    users.add(user);

                    System.out.println("-----------------------");
                    System.out.println(user.getNome());
                    System.out.println("-----------------------");
                }

                friendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Erro ao carregar os usuários");
            }
        };
    }

}
