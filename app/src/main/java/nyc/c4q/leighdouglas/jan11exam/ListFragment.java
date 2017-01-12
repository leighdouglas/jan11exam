package nyc.c4q.leighdouglas.jan11exam;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;

import nyc.c4q.leighdouglas.jan11exam.model.KeyList;
import nyc.c4q.leighdouglas.jan11exam.recyclerview.KeyAdapter;
import nyc.c4q.leighdouglas.jan11exam.service.KeyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class ListFragment extends Fragment {
    static String TAG = "Retrofit:";
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

    @Override
    public void onStart() {
        super.onStart();
        runRetrofitCall();
    }


    private void runRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KeyService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KeyService service = retrofit.create(KeyService.class);
        Call<KeyList> call = service.getListOfKeys();

        call.enqueue(new Callback<KeyList>() {
            @Override
            public void onResponse(Call<KeyList> call, Response<KeyList> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success");
                        keyAdapter.setKeyList(response.body().getAvailableKeys());
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                        Toast.makeText(getActivity(), "Error downloading data",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<KeyList> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getActivity(), "Unable to download please connect to internet",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}