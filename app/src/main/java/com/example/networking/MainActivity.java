package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    private ArrayList<Mountain> mountainList;
    RecyclerViewAdapter adapter;
    private RecyclerView view;

    ArrayList<RecyclerViewItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mountainList = new ArrayList<Mountain>();
        adapter = new RecyclerViewAdapter();
        view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
        new JsonFile(this, this).execute(JSON_FILE);
    }
    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        ArrayList<Mountain> list = gson.fromJson(json, type);
      Log.d("Tomten", String.valueOf(list.size()));

        for (Mountain mountain : list) {
            Log.d("Tomten", mountain.getName());
           adapter.addMountain(mountain);
        }


    }
}