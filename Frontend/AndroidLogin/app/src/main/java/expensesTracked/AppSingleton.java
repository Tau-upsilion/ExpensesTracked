package expensesTracked;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppSingleton {
    private static AppSingleton mAppSingletonInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;
    private static CurrentUser cUser;
    
    /**
     * Default constructor
     *
     * @param context - Application context
     */
    private AppSingleton(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }
    
    /**
     * Getter method to get the instance of the Application Singleton
     *
     * @param context Application context
     * @return Instance of the Application Singleton
     */
    public static synchronized AppSingleton getInstance(Context context) {
        if (mAppSingletonInstance == null) {
            mAppSingletonInstance = new AppSingleton(context);
        }
        return mAppSingletonInstance;
    }
    
    /**
     * Private method to get the {@code RequestQueue}
     *
     * @return The {@code RequestQueue}
     */
    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }
    
    /**
     * Public method to add a request to the RequestQueue
     *
     * @param req Request to be added
     * @param tag Tag for the request
     * @param <T> Type of the request
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(tag);
        getRequestQueue().add(req);
    }
    
    /**
     * Getter method to get the token
     *
     * @param context Application context
     * @param key Key for each specific token
     * @return The String token taht corresponds to the token at the specific key
     */
    public String getToken(Context context, String key) {
        android.content.SharedPreferences settings;
        String text;
        settings = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        text = settings.getString(key, null);
        
        return text;
    }
    
}
