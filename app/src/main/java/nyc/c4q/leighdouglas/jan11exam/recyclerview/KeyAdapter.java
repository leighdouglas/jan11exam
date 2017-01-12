package nyc.c4q.leighdouglas.jan11exam.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.jan11exam.model.KeyObject;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class KeyAdapter extends RecyclerView.Adapter<KeyListItem> {

    List<KeyObject> keyList = new ArrayList<>();

    @Override
    public KeyListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(KeyListItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setKeyList(List<KeyObject> list) {
        keyList = list;
        notifyDataSetChanged();
    }
}
