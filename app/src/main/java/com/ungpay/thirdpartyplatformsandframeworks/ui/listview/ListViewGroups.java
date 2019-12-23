package com.ungpay.thirdpartyplatformsandframeworks.ui.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;


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
        String jsonStr = "{\n" +
                "    \"bookquestionList\": [\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 2\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 3\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 4\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 5\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 7\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 8\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 9\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"bookQuestionTitle\": \"测试问题标题1\",\n" +
                "            \"isSingleChoice\": false,\n" +
                "            \"answerList\": [\n" +
                "                \"选项A\",\n" +
                "                \"选项B\",\n" +
                "                \"选项C\",\n" +
                "                \"选项D\"\n" +
                "            ],\n" +
                "            \"bookid\": 11\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        try {
            JSONObject CommunityUsersResultObj = new JSONObject(jsonStr);
            JSONArray groupList = CommunityUsersResultObj.getJSONArray("bookquestionList");

            for (int i = 0; i < groupList.length(); i++) {
                JSONObject groupObj = (JSONObject) groupList.get(i);
                Group group = new Group();
                group.setId(groupObj.optString("bookid"));
                group.setTitle(groupObj.optString("bookQuestionTitle"));
                JSONArray childrenList = groupObj.getJSONArray("answerList");

                for (int j = 0; j < childrenList.length(); j++) {
                    Child child = new Child();
                    child.setUserid("1");
                    child.setFullname(childrenList.optString(j));
                    child.setUsername("2");
                    group.addChildrenItem(child);
                }

                groups.add(group);
            }
        } catch (JSONException e) {
            Log.d("~~~~~~~allenj", e.toString());
        }

    }


    /**
     * Gson解析对象
     */
    public LinkedHashMap<String, String> json2HashMap(JSONObject jsonObject) throws JSONException {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        Iterator<String> it = jsonObject.keys();
        while (it.hasNext()) {
            String key = it.next();
            String value = jsonObject.getString(key);
            hashMap.put(key, value);
        }
        return hashMap;
    }
}