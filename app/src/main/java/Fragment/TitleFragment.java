package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yuxuan.fragmentscreen.ContentActivity;
import com.yuxuan.fragmentscreen.R;

import Model.TestData;
import Util.MyUtil;

public class TitleFragment extends Fragment {

    //M
    private String[] datas = TestData.TITLES;

    //V
    private ListView listView;

    //C
    private ArrayAdapter<String> adapter;

    private MyUtil util;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        util = new MyUtil();
        listView = new ListView(this.getActivity());
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获得标题对应的内容
                String content = TestData.CONTENTS[position];
                Intent intent = new Intent(getActivity(), ContentActivity.class);

                //判断当前是横屏还是竖屏
                if (util.isScreenChange(getActivity())) {
                    ContentFragment contentFragment =(ContentFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fm_content);
                    contentFragment.settext(content);
                } else {
                    intent.putExtra("content",content);
                    getActivity().startActivity(intent);
                }
            }
        });

        return listView;
    }
}
