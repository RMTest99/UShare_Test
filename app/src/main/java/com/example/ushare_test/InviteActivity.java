package com.example.ushare_test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class InviteActivity extends AppCompatActivity {

    ListView listViewInvite;
    String settingName[] = {"Invite friends by email"};
    int images[] = {R.drawable.email};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        listViewInvite = findViewById(R.id.listViewInvite);

        InviteAdapter adapter = new InviteAdapter(this, settingName, images);
        listViewInvite.setAdapter(adapter);

        listViewInvite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(InviteActivity.this, "Invite friends by email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void backClicked(View view) {
        finish();
    }

    class InviteAdapter extends ArrayAdapter<String> {

        Context context;
        String mTitle[];
        int mImages[];

        InviteAdapter(Context c, String title[], int images[]) {
            super(c, R.layout.invite_row, title);
            this.context = c;
            this.mTitle = title;
            this.mImages = images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.invite_row, parent, false);
            ImageView images = row.findViewById(R.id.setting_image);
            TextView settingName = row.findViewById(R.id.setting_name);

            images.setImageResource(mImages[position]);
            settingName.setText(mTitle[position]);

            return row;
        }
    }
}
