package nyc.c4q.leighdouglas.jan11exam.recyclerview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.jan11exam.Activities.KeyImageActivity;
import nyc.c4q.leighdouglas.jan11exam.KeyConstants;
import nyc.c4q.leighdouglas.jan11exam.R;
import nyc.c4q.leighdouglas.jan11exam.model.KeyObject;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class KeyAdapter extends RecyclerView.Adapter<KeyViewHolder> {

    List<KeyObject> keyList = new ArrayList<>();

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.key_view_holder, parent, false);
        return new KeyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KeyViewHolder holder, int position) {
        final KeyObject keyObject = keyList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), KeyImageActivity.class);
                intent.putExtra(KeyConstants.EXTRA_IMAGE_URL, keyObject.getUrl());
                view.getContext().startActivity(intent);
            }
        });

        holder.bind(keyObject);
    }

    @Override
    public int getItemCount() {
        return keyList.size();
    }

    public void setKeyList(List<KeyObject> list) {
        keyList = list;
        notifyDataSetChanged();
    }
}
