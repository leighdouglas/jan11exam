package nyc.c4q.leighdouglas.jan11exam;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.leighdouglas.jan11exam.recyclerview.KeyAdapter;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class ListFragment extends Fragment {
    private KeyAdapter keyAdapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        keyAdapter = new KeyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(keyAdapter);
        return view;
    }
}