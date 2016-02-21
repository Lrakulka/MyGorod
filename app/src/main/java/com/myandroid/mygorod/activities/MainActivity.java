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
import com.myandroid.mygorod.entities.Worker;
import com.myandroid.mygorod.fragments.OgorodFragment;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.fragments.PlantsFragment;

import android.app.ProgressDialog;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    private static final String APP_PREFERENCES = "preferences";
    private static final String APP_PREFERENCES_LOGIN = "login";
    private static final String APP_PREFERENCES_PASS = "pass";
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;

    private EditText loginEditText;
    private EditText passwordEditText;
    private ProgressDialog progress;
    private Button button_authorization;
    
    private String workerId;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        sharedpreferences = this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        loginEditText = (EditText) findViewById(R.id.editTextLogin);
        passwordEditText = (EditText) findViewById(R.id.editTextPass);
        button_authorization = (Button) findViewById(R.id.button_authorization);

        if (!sharedpreferences.getString(APP_PREFERENCES_LOGIN, "login").equals("1")
                || !sharedpreferences.getString(APP_PREFERENCES_PASS, "pass").equals("1")) {
            loginEditText.setVisibility(View.VISIBLE);
            button_authorization.setVisibility(View.VISIBLE);
            passwordEditText.setVisibility(View.VISIBLE);

            button_authorization.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    editor = sharedpreferences.edit();
                    editor.putString(APP_PREFERENCES_LOGIN, loginEditText.getText().toString());
                    editor.putString(APP_PREFERENCES_PASS, passwordEditText.getText().toString());
                    editor.apply();

                    if (checkAuthorization()) {

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(passwordEditText.getWindowToken(), 0);

                        loginEditText.setVisibility(View.GONE);
                        button_authorization.setVisibility(View.GONE);
                        passwordEditText.setVisibility(View.GONE);
                        logInSuccess();
                    } else {
                        loginEditText.setText("");
                        passwordEditText.setText("");
                    }
                }
            });
        } else {
            logInSuccess();
        }
    }

    private void logInSuccess() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new OgorodFragment(new Worker(workerId, null)))
                .commit();
        setNavigationDrawer();
    }

    private boolean checkAuthorization() {
        logInOnServer();
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
                transaction.replace(R.id.container, new OgorodFragment(null));
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

    private void logInOnServer() {
        new PostRequest(this).execute();
    }

    private class PostRequest extends AsyncTask<String, Void, Void> {

        private final Context context;
        private int responseCode;

        public PostRequest(Context c) {
            this.context = c;
        }

        protected void onPreExecute() {
            progress = new ProgressDialog(this.context);
            progress.setMessage("Loading");
            progress.show();
        }

        @Override
        protected Void doInBackground(String... params) {

            final StringBuilder output = new StringBuilder("Request URL ");

            try {
                URL url = new URL("http://192.168.31.71:8080/api/auth/login");
                output.append(url);

                String urlParameters = "username=" + sharedpreferences.getString(APP_PREFERENCES_LOGIN, "login")
                        + "&password=" + sharedpreferences.getString(APP_PREFERENCES_PASS, "pass");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                //connection.setFixedLengthStreamingMode(param.getBytes().length);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setDoOutput(true);


                DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
                dStream.writeBytes(urlParameters);
                dStream.flush();
                dStream.close();
                responseCode = connection.getResponseCode();
                Log.v(LOG_TAG, "response code  = " + connection.getResponseCode());
                if (connection.getResponseCode() == 200) {
                    output.append(System.getProperty("line.separator") + "Request Parameters " + urlParameters);
                    output.append(System.getProperty("line.separator") + "Response Code " + responseCode);
                    output.append(System.getProperty("line.separator") + "Type " + "POST");
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line = "";
                    StringBuilder responseOutput = new StringBuilder();
                    System.out.println("output===============" + br);
                    while ((line = br.readLine()) != null) {
                        responseOutput.append(line);
                    }
                    br.close();



                    workerId = connection.getHeaderField("Set-Cookie").substring(connection.getHeaderField("Set-Cookie").indexOf("=") + 1, connection.getHeaderField("Set-Cookie").indexOf(";"));

                    output.append(System.getProperty("line.separator") + "Response " + connection.getHeaderField("Set-Cookie") + System.getProperty("line.separator") + System.getProperty("line.separator") + responseOutput.toString());
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responseCode == 200) {

                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(passwordEditText.getWindowToken(), 0);

                            loginEditText.setVisibility(View.GONE);
                            button_authorization.setVisibility(View.GONE);
                            passwordEditText.setVisibility(View.GONE);
                            logInSuccess();
                            // Toast.makeText(context, "output = " + output, Toast.LENGTH_SHORT).show();
                            Log.v(LOG_TAG, "output = " + output);
                            progress.dismiss();
                        } else {
                            if (responseCode == 401) {
                                Toast.makeText(getBaseContext(), "Неправильний логін або пароль!", Toast.LENGTH_SHORT).show();
                                progress.dismiss();
                            } else {
                                Toast.makeText(getBaseContext(), "Помилка", Toast.LENGTH_LONG).show();
                                progress.dismiss();
                            }
                        }
                    }
                });

                return null;
            }
        }
    }
}
