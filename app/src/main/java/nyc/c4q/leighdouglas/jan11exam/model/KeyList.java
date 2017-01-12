package nyc.c4q.leighdouglas.jan11exam.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leighdouglas on 1/11/17.
 */

public class KeyList {

    @SerializedName("available keys")
    public List<KeyObject> availableKeys;

    public List<KeyObject> getAvailableKeys() {
        return availableKeys;
    }
}
