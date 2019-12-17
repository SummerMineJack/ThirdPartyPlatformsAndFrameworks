package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;


public class ListViewGroups extends Activity {

    ArrayList<Group> groups;
    ExpandableListView listView;
    EListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_groups);

        groups = new ArrayList();
        getJSONObject();
        listView = findViewById(R.id.listView);
        adapter = new EListAdapter(this, groups);
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(adapter);
    }

    /**
     * 解悉 JSON 字串
     */
    private void getJSONObject() {

        ArrayList<Child> children=new ArrayList<>();
        for (int i = 0; i <4; i++) {
            Group group = new Group();
            group.setId(i+"");
            group.setTitle("问题标题"+i);
            for (int j = 0; j < 4; j++) {
                Child child = new Child();
                child.setUserid(j+"");
                child.setFullname("用户名"+j);
                child.setUsername("完整的用户名"+j);
                children.add(child);
                group.setChildren(children);
            }
            groups.add(group);
        }
        String jsonStr = "{\"CommunityUsersResult\":[\n" +
                "{\"CommunityUsersList\":[\n" +
                "{\"fullname\":\"a111\",\"userid\":11,\"username\":\"a1\"},{\"fullname\":\"b222\",\"userid\":12,\"username\":\"b2\"},\n" +
                "{\"fullname\":\"a111\",\"userid\":11,\"username\":\"a1\"},{\"fullname\":\"b222\",\"userid\":12,\"username\":\"b2\"}\n" +
                "],\"id\":1,\"title\":\"人事部\"},\n" +
                "{\"CommunityUsersList\":[\n" +
                "{\"fullname\":\"a111\",\"userid\":11,\"username\":\"a1\"},{\"fullname\":\"b222\",\"userid\":12,\"username\":\"b2\"},\n" +
                "{\"fullname\":\"a111\",\"userid\":11,\"username\":\"a1\"},{\"fullname\":\"b222\",\"userid\":12,\"username\":\"b2\"}\n" +
                "],\"id\":1,\"title\":\"人事部\"},\n" +
                "{\"CommunityUsersList\":[\n" +
                "{\"fullname\":\"a111\",\"userid\":11,\"username\":\"a1\"},{\"fullname\":\"b222\",\"userid\":12,\"username\":\"b2\"},\n" +
                "{\"fullname\":\"a111\",\"userid\":11,\"username\":\"a1\"},{\"fullname\":\"b222\",\"userid\":12,\"username\":\"b2\"}\n" +
                "],\"id\":1,\"title\":\"人事部\"},\n" +
                "{\"CommunityUsersList\":[\n" +
                "{\"fullname\":\"c333\",\"userid\":13,\"username\":\"c3\"},{\"fullname\":\"d444\",\"userid\":14,\"username\":\"d4\"},{\"fullname\":\"d444\",\"userid\":14," +
                "\"username\":\"d4\"},{\"fullname\":\"d444\",\"userid\":14,\"username\":\"d4\"}\n" +
                "],\"id\":2,\"title\":\"開發部\"}]}";

        /*try {
            JSONObject CommunityUsersResultObj = new JSONObject(jsonStr);
            JSONArray groupList = CommunityUsersResultObj.getJSONArray("CommunityUsersResult");

            for (int i = 0; i < groupList.length(); i++) {
                JSONObject groupObj = (JSONObject) groupList.get(i);
                Group group = new Group();
                group.setId(groupObj.optString("id"));
                group.setTitle(groupObj.optString("title"));
                JSONArray childrenList = groupObj.getJSONArray("CommunityUsersList");

                for (int j = 0; j < childrenList.length(); j++) {
                    JSONObject childObj = (JSONObject) childrenList.get(j);
                    Child child = new Child();
                    child.setUserid(childObj.optString("userid"));
                    child.setFullname(childObj.optString("fullname"));
                    child.setUsername(childObj.optString("username"));
                    group.addChildrenItem(child);
                }

                groups.add(group);
            }
        } catch (JSONException e) {
            Log.d("allenj", e.toString());
        }*/
    }
}