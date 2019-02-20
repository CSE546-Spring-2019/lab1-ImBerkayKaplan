package nightcrawler.nightcrawler;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends SingleFragmentActivity{
    private static final String TAG = "MainActivity";

    @Override
    protected Fragment createFragment() {
        Log.d(TAG, "createFragment called");
        return new MainFragment();
    }

}
