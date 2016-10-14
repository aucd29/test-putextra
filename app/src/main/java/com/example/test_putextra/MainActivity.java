package com.example.test_putextra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.list)
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initList();
    }

    private void initList() {
        String[] dataList = getResources().getStringArray(R.array.data_list);

        Log.d(TAG, "list = " + mList);

        mList.setAdapter(new ListAdapter(dataList));
        mList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, SubActivity.class);
            intent.putExtra("pos", position);

            startActivity(intent);
        });
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    //
    // ADAPTER
    //
    ////////////////////////////////////////////////////////////////////////////////////
    
    class ViewHolder {
        TextView title;
    }

    class ListAdapter extends BaseAdapter {
        String[] dataList;

        public ListAdapter(String[] dataList) {
            this.dataList = dataList;
        }

        @Override
        public int getCount() {
            if (dataList == null) {
                return 0;
            }

            return dataList.length;
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
            ViewHolder vh;
            
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_list_item, null);

                vh = new ViewHolder();
                vh.title = ButterKnife.findById(convertView, R.id.title);

                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.title.setText(dataList[position]);
            
            return convertView;
        }
    }
}
