package com.example.physiofit;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatListFragment extends Fragment {

    private ChatListAdapter chatListAdapter;
    private List<Chat> chatList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Toolbar toolbar = view.findViewById(R.id.chat_list_toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.title_bar);
        toolbarTitle.setText("Chats");


        chatList = new ArrayList<>();
        // Populate chatList with data (this should be replaced with actual data fetching logic)
        chatList.add(new Chat("Ahmed Naveed", "Hello!"));
        chatList.add(new Chat("John Doe", "How are you?"));

        chatListAdapter = new ChatListAdapter(chatList);
        recyclerView.setAdapter(chatListAdapter);

        chatListAdapter.setOnItemClickListener(new ChatListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });

        SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });

        return view;
    }

    private void filter(String text) {
        List<Chat> filteredList = new ArrayList<>();
        for (Chat chat : chatList) {
            if (chat.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(chat);
            }
        }
        chatListAdapter.setChatList(filteredList);
    }
}
