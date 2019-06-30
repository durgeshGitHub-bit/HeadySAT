package com.example.headysat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public final String url="https://api.nytimes.com/svc/topstories/v2/travel.json?api-key=czLe9QAh4jZnmjNiAqV2LEfcVDTGgxJf";
    RecyclerView recyclerView;
    List<MyModel> myModels;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    JSONObject jsonObject,jsonObjectMultimedia;
    JSONArray jsonArray,jsonArrayMultimedia;
    MyModel myModel;
    HeadyRecyclerView headyRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        myModels = new ArrayList<>();
        setUpVolley();

    }

    private void setUpVolley()
    {
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    jsonArray = response.getJSONArray("results");

                    for (int i=0;i<jsonArray.length();i++)
                    {
                        jsonObject = jsonArray.getJSONObject(i);

                        myModel = new MyModel();
                        myModel.setSection(jsonObject.getString("section"));
                        myModel.setTitle(jsonObject.getString("title"));
                        myModel.setStrAbstract(jsonObject.getString("abstract"));
                        myModel.setByline(jsonObject.getString("byline"));
                        myModel.setUrlLink(jsonObject.getString("url"));
                        myModel.setPublishDate(jsonObject.getString("published_date"));

                        jsonArrayMultimedia = jsonObject.getJSONArray("multimedia");

                        for (int j=0;j<jsonArrayMultimedia.length();j++)
                        {
                            jsonObjectMultimedia = jsonArrayMultimedia.getJSONObject(j);
                            myModel.setImage(jsonObjectMultimedia.getString("url"));
                        }


                        myModels.add(myModel);
                    }
                    setUpRecyclerView(myModels);


                } catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }


    private void setUpRecyclerView(List<MyModel> myModels)
    {
        headyRecyclerView = new HeadyRecyclerView(MainActivity.this,myModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(headyRecyclerView);
    }
}
