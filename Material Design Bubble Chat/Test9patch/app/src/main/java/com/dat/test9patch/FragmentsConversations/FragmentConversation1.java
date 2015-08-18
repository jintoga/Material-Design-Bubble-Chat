package com.dat.test9patch.FragmentsConversations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.dat.test9patch.Message;
import com.dat.test9patch.MyChatAdapter;
import com.dat.test9patch.R;

import java.util.ArrayList;

/**
 * Created by DAT on 8/18/2015.
 */

public class FragmentConversation1 extends Fragment {
    MyChatAdapter myChatAdapter;
    ArrayList<Message> listMsg = new ArrayList<>();
    ListView listViewChat;
    EditText editTextMsgContent;
    ImageButton imageButtonSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conversation1, container, false);
        getIDs(view);
        setEvents();
        return view;
    }

    private void getIDs(View view) {
        listViewChat = (ListView) view.findViewById(R.id.listViewChat);
        editTextMsgContent = (EditText) view.findViewById(R.id.editTextMsg);
        imageButtonSend = (ImageButton) view.findViewById(R.id.imageButtonSend);
    }

    private void setEvents() {
        myChatAdapter = new MyChatAdapter(getActivity(), listMsg);
        listViewChat.setAdapter(myChatAdapter);
        imageButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg();
                editTextMsgContent.setText("");
            }
        });


    }

    private void sendMsg() {
        String msgContent = editTextMsgContent.getText() + "";
        Message message = new Message();
        message.setContent(msgContent);
        message.setFrom(Message.isFromMe);
        listMsg.add(message);
        Message message2 = new Message();

        if (msgContent.toLowerCase().contains("гайдук")) {
            msgContent = "да он же пидор";
        }
        message2.setContent(msgContent);

        listMsg.add(message2);
        myChatAdapter.notifyDataSetChanged();
    }

}
