package com.nikvay.sumotors.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.activity.LoginActivity;
import com.nikvay.sumotors.ui.fragment.HRMSFragment;
import com.nikvay.sumotors.ui.fragment.HomeFragment;
import com.nikvay.sumotors.ui.fragment.ProductListFragment;

import es.dmoral.toasty.Toasty;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawer;
    ImageView iv_menu_toolbar;
    TextView tv_title_name;
    String fName;
    Fragment fragmentInstance;
    FragmentManager fragmentManager;

    LinearLayout ll_nav_home, ll_nav_hrms, ll_nav_product, ll_nav_sales, ll_nav_purchase, ll_nav_customer, ll_nav_report,
            ll_nav_log_out;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        find_All_IDs();

        tv_title_name.setText("SU Motors");
        replaceFragment(new HomeFragment());

        // ========== Custom Menu Item click Listener ========================
        iv_menu_toolbar.setOnClickListener(this);
        ll_nav_home.setOnClickListener(this);
        ll_nav_hrms.setOnClickListener(this);
        ll_nav_product.setOnClickListener(this);
        ll_nav_sales.setOnClickListener(this);
        ll_nav_purchase.setOnClickListener(this);
        ll_nav_customer.setOnClickListener(this);
        ll_nav_report.setOnClickListener(this);
        ll_nav_log_out.setOnClickListener(this);
    }

    private void find_All_IDs() {
        iv_menu_toolbar = findViewById(R.id.iv_menu_toolbar);
        tv_title_name = findViewById(R.id.tv_title_name);
        drawer = findViewById(R.id.drawer_layout);

        ll_nav_home = findViewById(R.id.ll_nav_home);
        ll_nav_hrms = findViewById(R.id.ll_nav_hrms);
        ll_nav_product = findViewById(R.id.ll_nav_product);
        ll_nav_sales = findViewById(R.id.ll_nav_sales);
        ll_nav_purchase = findViewById(R.id.ll_nav_purchase);
        ll_nav_customer = findViewById(R.id.ll_nav_customer);
        ll_nav_report = findViewById(R.id.ll_nav_report);
        ll_nav_log_out = findViewById(R.id.ll_nav_log_out);
    }


    @Override
    public void onClick(View view) {
        View view1 = this.getCurrentFocus();
        if (view1 != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view1.getWindowToken(), 0);
            }
        }

        int id = view.getId();
        if (id == R.id.iv_menu_toolbar) {
            drawer.openDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_home) {
            replaceFragment(new HomeFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_hrms) {
            replaceFragment(new HRMSFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_product) {
            replaceFragment(new ProductListFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_sales) {
            replaceFragment(new ProductListFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_purchase) {
            replaceFragment(new ProductListFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_customer) {
            replaceFragment(new ProductListFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_report) {
            replaceFragment(new ProductListFragment());
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.ll_nav_log_out) {
            logOut();
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    private void logOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog_logout, null);
        builder.setView(dialogView);
        builder.setCancelable(false);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        TextView btn_not_now = dialogView.findViewById(R.id.btn_not_now);
        TextView btn_yes = dialogView.findViewById(R.id.btn_yes);

        btn_not_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putString(SharedPreference.ISLOGIN, "false");
//                editor.apply();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                finish();
            }
        });
    }


    public void replaceFragment(Fragment fragment) {
        fragmentInstance = fragment;

        fName = fragment.getClass().getSimpleName();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out);
        fragmentTransaction.commit();

//        fragmentTransaction.detach(fragment);
//        fragmentTransaction.attach(fragment);
//        fragmentTransaction.commit();


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fName.equals(fragmentInstance.getClass().getSimpleName())) {
                if (fName.equals("HomeFragment")) {
//                super.onBackPressed();
                    doubleBackPressLogic();
                } else
                    replaceFragment(new HomeFragment());
            }
        }
    }

    // ============ End Double tab back press logic =================
    private void doubleBackPressLogic() {
        if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toasty.info(this, "Please click back again to exit !!", Toast.LENGTH_SHORT, true).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 1000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
