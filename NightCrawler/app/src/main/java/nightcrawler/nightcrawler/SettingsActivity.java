package nightcrawler.nightcrawler;

import android.support.v4.app.Fragment;
import android.util.Log;

public class SettingsActivity extends SingleFragmentActivity {
    private static final String TAG = "SettingsActivity";
    @Override
    protected Fragment createFragment() {
        Log.d(TAG, "createFragment called");
        return new SettingsFragment();
    }
}
