package com.pinch.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.pinch.android.model.Cause;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private CausesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("MNF", "WELCOME");

        Firebase.setAndroidContext(this);

        Firebase myFirebaseRef = new Firebase("https://pinchdev.firebaseio.com/");

        list = (RecyclerView)findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        adapter = new CausesAdapter(this);
        list.setAdapter(adapter);

        myFirebaseRef.child("causes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot snapshot) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.v("MNF", "onDataChange " + snapshot.getValue());
                        List<Cause> causes = new ArrayList<>();
                        for (DataSnapshot snap : snapshot.getChildren()) {
                            int res = 0;
                            Cause cause = snap.getValue(Cause.class);
                            causes.add(cause);
                            Log.v("MNF", "" + cause.toString());
                        }
                        adapter.setCauses(causes);
                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
    }


}
