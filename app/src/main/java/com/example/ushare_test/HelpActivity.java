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

public class HelpActivity extends AppCompatActivity {

    ListView listViewHelp;
    String settingName[] = {"Contact Us", "App info"};
    int images[] = {R.drawable.contact, R.drawable.info};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        listViewHelp = findViewById(R.id.listViewHelp);

        HelpActivity.HelpAdapter adapter = new HelpActivity.HelpAdapter(this, settingName, images);
        listViewHelp.setAdapter(adapter);

        listViewHelp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(HelpActivity.this, ContactUsActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(HelpActivity.this, AppInfoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void backClicked(View view) {
        finish();
    }

    class HelpAdapter extends ArrayAdapter<String> {

        Context context;
        String mTitle[];
        int mImages[];

        HelpAdapter(Context c, String title[], int images[]) {
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
