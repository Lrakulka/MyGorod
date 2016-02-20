package com.myandroid.mygorod.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.myandroid.mygorod.fragments.OgorodFragment;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.fragments.PlantsFragment;



import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    private static final String APP_PREFERENCES = "preferences";
    private static final String APP_PREFERENCES_LOGIN = "login";
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;

    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        sharedpreferences = this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        login = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPass);
        final Button button_authorization = (Button) findViewById(R.id.button_authorization);

        if (!sharedpreferences.getString(APP_PREFERENCES_LOGIN, "login").equals("1")) {
            login.setVisibility(View.VISIBLE);
            button_authorization.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);

            button_authorization.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkAuthorization()) {
                        editor = sharedpreferences.edit();
                        editor.putString(APP_PREFERENCES_LOGIN, login.getText().toString());
                        editor.apply();

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(password.getWindowToken(), 0);

                        login.setVisibility(View.GONE);
                        button_authorization.setVisibility(View.GONE);
                        password.setVisibility(View.GONE);
                        logInSuccess();
                    } else {
                        login.setText("");
                        password.setText("");
                        Toast.makeText(getBaseContext(), "Неправильний логін або пароль!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            logInSuccess();
        }
    }

    private void logInSuccess() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new OgorodFragment())
                .commit();
        setNavigationDrawer();
    }

    private boolean checkAuthorization() {
        if (login.getText().toString().equals("1")) {
            return true;
        } else
            return false;
    }

    private void setNavigationDrawer() {

        AccountHeader accountHeaderResult = initializeAccountHeader();

        new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(accountHeaderResult)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(false)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_gorods)
                                .withIdentifier(1)
                                .withIcon(R.drawable.gorods),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_workers)
                                .withIdentifier(2)
                                .withIcon(R.drawable.workers),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_plants)
                                .withIdentifier(3)
                                .withIcon(R.drawable.pine_tree),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_help)
                                .withIdentifier(3)
                                .withIcon(R.drawable.help_circle),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_settings)
                                .withIdentifier(4)
                                .withIcon(R.drawable.settings),
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_item_about)
                                .withIdentifier(5)
                                .withIcon(R.drawable.information)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        setOnDrawerItemClickListener(position);
                        return false;
                    }
                })
                .build();
    }

    private AccountHeader initializeAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.garden_logo)
                .build();
    }

    private void setOnDrawerItemClickListener(int position) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 1:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                transaction.replace(R.id.container, new OgorodFragment());
                transaction.addToBackStack(null);

                break;
            case 2:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();

                transaction.replace(R.id.container, new PlantsFragment());
                transaction.addToBackStack(null);

                break;
            case 4:
                Log.v(LOG_TAG, "clicked on DividerDrawerItem = IMPOSSIBLE!!!");
                break;
            case 5:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
                logInOnServer();
                break;
            default:
                Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void logInOnServer(){
        //new PostRequest(this).execute();
    }
//
//    private class PostRequest extends AsyncTask<String, Void, Void> {
//
//        private final Context context;
//
//        public PostClass(Context c){
//            this.context = c;
//        }
//
//        protected void onPreExecute(){
//            progress = new ProgressDialog(this.context);
//            progress.setMessage("Loading");
//            progress.show();
//        }
//
//        @Override
//        protected Void doInBackground(String... params) {
//            try {
//
//                final TextView outputView = (TextView) findViewById(R.id.showOutput);
//                URL url = new URL("Your URL");
//
//                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//                String urlParameters = "fizz=buzz";
//                connection.setRequestMethod("POST");
//                connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
//                connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");
//                connection.setDoOutput(true);
//                DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
//                dStream.writeBytes(urlParameters);
//                dStream.flush();
//                dStream.close();
//                int responseCode = connection.getResponseCode();
//
//                final StringBuilder output = new StringBuilder("Request URL " + url);
//                output.append(System.getProperty("line.separator") + "Request Parameters " + urlParameters);
//                output.append(System.getProperty("line.separator")  + "Response Code " + responseCode);
//                output.append(System.getProperty("line.separator")  + "Type " + "POST");
//                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String line = "";
//                StringBuilder responseOutput = new StringBuilder();
//                System.out.println("output===============" + br);
//                while((line = br.readLine()) != null ) {
//                    responseOutput.append(line);
//                }
//                br.close();
//
//                output.append(System.getProperty("line.separator") + "Response " + System.getProperty("line.separator") + System.getProperty("line.separator") + responseOutput.toString());
//
//                MainActivity.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        outputView.setText(output);
//                        progress.dismiss();
//                    }
//                });
//
//            } catch (MalformedURLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

}
