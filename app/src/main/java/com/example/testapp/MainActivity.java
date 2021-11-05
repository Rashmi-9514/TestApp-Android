package com.example.testapp;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.clevertap.android.sdk.CleverTapAPI;
<<<<<<< HEAD
=======
import com.clevertap.android.sdk.inbox.CTInboxMessage;
>>>>>>> cf983c8 (Adding App persontion, app inbox)
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> cf983c8 (Adding App persontion, app inbox)
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
<<<<<<< HEAD
=======

import org.json.JSONArray;
import org.json.JSONObject;

>>>>>>> cf983c8 (Adding App persontion, app inbox)
public class MainActivity extends AppCompatActivity implements CTInboxListener{

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
<<<<<<< HEAD
=======
    private static final String TAG = "MyActivity";

>>>>>>> cf983c8 (Adding App persontion, app inbox)


    @RequiresApi(api = Build.VERSION_CODES.O)


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        CleverTapAPI.setDebugLevel(3);
        CleverTapAPI cleverTapDefaultInstance;

        {
            cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(this);
        }

           if (cleverTapDefaultInstance != null) {
            //Set the Notification Inbox Listener
            cleverTapDefaultInstance.setCTNotificationInboxListener(this);
            //Initialize the inbox and wait for callbacks on overridden methods
            cleverTapDefaultInstance.initializeInbox();
        }
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
<<<<<<< HEAD
=======
        clevertapDefaultInstance.enablePersonalization();
>>>>>>> cf983c8 (Adding App persontion, app inbox)
// each of the below mentioned fields are optional
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "Test ");    // String

        profileUpdate.put("Email", "t@gmail.com"); // Email address of the user
        profileUpdate.put("Gender", "M");             // Can be either M or F
        profileUpdate.put("DOB", new Date());         // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate.put("MSG-email", false);        // Disable email notifications
        profileUpdate.put("MSG-push", true);          // Enable push notifications
        profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
        profileUpdate.put("MSG-whatsapp", true);      // Enable WhatsApp notifications
        ArrayList<String> stuff = new ArrayList<String>();
        stuff.add("bag");
        stuff.add("shoes");
        profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
        String[] otherStuff = {"Jeans","Perfume"};
        profileUpdate.put("MyStuff", otherStuff);                   //String Array
        clevertapDefaultInstance.onUserLogin(profileUpdate);
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"1","test","YourChannelDescription", NotificationManager.IMPORTANCE_MAX,true);

        clevertapDefaultInstance.pushEvent("Call Inapp");
<<<<<<< HEAD
=======

        // To access a scalar-value user profile property:
        // If the property is not available, this call will return null



        // To access a multi-value user profile property:
        // If the property is not available, this call will return null
        // To support multi-value user profile properties, cleverTap.profile.getProperty(key) returns an Object.


>>>>>>> cf983c8 (Adding App persontion, app inbox)
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Snackbar.make(view, "Opening App Inbox", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               clevertapDefaultInstance.pushEvent("Open App-Inbox");
               inboxDidInitialize();
=======
                String name = (String) clevertapDefaultInstance.getProperty("Name");
                JSONObject myStuff = (JSONObject) clevertapDefaultInstance.getProperty("MyStuff");
                Snackbar.make(view, "Opening App Inbox", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               //clevertapDefaultInstance.pushEvent("Open App-Inbox");
               inboxDidInitialize();
             ArrayList<CTInboxMessage> ct1 =   clevertapDefaultInstance.getAllInboxMessages();
                Log.d(TAG, "onClick: ");
>>>>>>> cf983c8 (Adding App persontion, app inbox)
               //cleverTapDefaultInstance.showAppInbox(); //Opens activity tith Tabs

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }




@Override
    public void inboxDidInitialize() {

        ArrayList<String> tabs = new ArrayList<>();
        tabs.add("Promotions");
        tabs.add("Offers");
        tabs.add("Others");//We support upto 2 tabs only. Additional tabs will be ignored

        CTInboxStyleConfig styleConfig = new CTInboxStyleConfig();
        styleConfig.setFirstTabTitle("First Tab");//By default, name of the first tab is "ALL"
        styleConfig.setTabs(tabs);//Do not use this if you don't want to use tabs
        styleConfig.setTabBackgroundColor("#FF0000");//provide Hex code in string ONLY
        styleConfig.setSelectedTabIndicatorColor("#0000FF");
        styleConfig.setSelectedTabColor("#000000");
        styleConfig.setUnselectedTabColor("#FFFFFF");
        styleConfig.setBackButtonColor("#FF0000");
        styleConfig.setNavBarTitleColor("#FF0000");
        styleConfig.setNavBarTitle("MY INBOX");
        styleConfig.setNavBarColor("#FFFFFF");
        styleConfig.setInboxBackgroundColor("#00FF00");

        CleverTapAPI.getDefaultInstance(getApplicationContext()).showAppInbox(styleConfig); /* Opens activity with Tabs */
        //OR
        //cleverTapDefaultInstance.showAppInbox();//Opens Activity with default style config
    }



    @Override
    public void inboxMessagesDidUpdate() {

    }
}