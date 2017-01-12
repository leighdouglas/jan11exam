package nyc.c4q.leighdouglas.jan11exam.recyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.leighdouglas.jan11exam.R;
import nyc.c4q.leighdouglas.jan11exam.model.KeyObject;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class KeyViewHolder extends RecyclerView.ViewHolder {
    private TextView keyText;

    public KeyViewHolder(View itemView) {
        super(itemView);
        keyText = (TextView) itemView.findViewById(R.id.list_key_text);

    }

    public void bind(KeyObject key){
        keyText.setText(key.getName());
        keyText.setTextColor(Color.parseColor(key.getTextColor()));
    }
}
