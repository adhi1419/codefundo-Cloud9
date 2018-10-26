package io.codefundo.cloud9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Random;


public class ChatroomFragment extends Fragment {
    private EditText editText;
    private ImageButton sendBtn;
    private ListView messagesView;
    private MessageAdapter messageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_chatroom, container, false);
        editText = (EditText) rootView.findViewById(R.id.editText);
        sendBtn = (ImageButton) rootView.findViewById(R.id.img_snd_btn);
        messageAdapter = new MessageAdapter(getContext());
        messagesView = (ListView) rootView.findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);

        MemberData mb1 = new MemberData(getRandomName(), getRandomColor());
        Message m1 = new Message("Hello! Hope you are safe. Please meet at the safe spot.", mb1, false);
        MemberData mb2 = new MemberData(getRandomName(), getRandomColor());
        Message m2 = new Message("Hi " + mb1.getName() + "! I am taking the safe route to that place, will reach in 30 mins.", mb2, false);
        MemberData mb3 = new MemberData("Drone A", getRandomColor());
        Message m3 = new Message("The supplies have reached the safety spot.", mb3, false);

        messageAdapter.add(m1);
        messageAdapter.add(m3);
        messageAdapter.add(m2);
        messagesView.setSelection(2);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                Message m = new Message(msg, new MemberData("Cloud9 User", getRandomColor()), true);
                editText.getText().clear();
                messageAdapter.add(m);
                messagesView.setSelection(messagesView.getCount() - 1);
            }
        });

        return rootView;
    }

    private String getRandomName() {
        String[] adjs = {"autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark", "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter", "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue", "billowing", "broken", "cold", "damp", "falling", "frosty", "green", "long", "late", "lingering", "bold", "little", "morning", "muddy", "old", "red", "rough", "still", "small", "sparkling", "throbbing", "shy", "wandering", "withered", "wild", "black", "young", "holy", "solitary", "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine", "polished", "ancient", "purple", "lively", "nameless"};
        String[] nouns = {"waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning", "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter", "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook", "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "firefly", "feather", "grass", "haze", "mountain", "night", "pond", "darkness", "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder", "violet", "water", "wildflower", "wave", "water", "resonance", "sun", "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper", "frog", "smoke", "star"};
        return (
                adjs[(int) Math.floor(Math.random() * adjs.length)] +
                        "_" +
                        nouns[(int) Math.floor(Math.random() * nouns.length)]
        );
    }

    private String getRandomColor() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer("#");
        while (sb.length() < 7) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 7);
    }
}
