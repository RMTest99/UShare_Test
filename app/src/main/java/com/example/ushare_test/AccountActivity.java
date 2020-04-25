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

public class AccountActivity extends AppCompatActivity {

    ListView listViewAccount;
    String settingName[] = {"Manage followers"};
    int images[] = {R.drawable.team};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        listViewAccount = findViewById(R.id.listViewAccount);

        AccountActivity.AccountAdapter adapter = new AccountActivity.AccountAdapter(this, settingName, images);
        listViewAccount.setAdapter(adapter);

        listViewAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(AccountActivity.this, ManageFollowersActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void backClicked(View view) {
        finish();
    }

    class AccountAdapter extends ArrayAdapter<String> {

        Context context;
        String mTitle[];
        int mImages[];

        AccountAdapter(Context c, String title[], int images[]) {
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
