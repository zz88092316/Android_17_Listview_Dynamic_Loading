package com.example.android_17_listview_dynamic_loading;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt_ItemSelect;
    private ListView lsv_main; //ListView 宣告

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_ItemSelect = (TextView) findViewById(R.id.txt_ItemSelect);
        lsv_main = (ListView) findViewById(R.id.lsv_main);

        ArrayAdapter<CharSequence> arrAdap
                = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.list,  //設定清單內容資訊
                android.R.layout.simple_list_item_single_choice);

        lsv_main.setAdapter(arrAdap);

        lsv_main.setSelector(R.color.purple_200);
        lsv_main.setSelection(2);

        lsv_main.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lsv_main.setOnItemClickListener(listViewRegionOnItemClick);
    }

    private AdapterView.OnItemClickListener listViewRegionOnItemClick
            = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            // TODO Auto-generated method stub

            txt_ItemSelect.setText("你選擇了: " + ((TextView) view).getText());
        }
    };
}