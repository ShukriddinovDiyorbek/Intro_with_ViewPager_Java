package uz.pdp.tasks5_modul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Page> pages;
    private ViewPager viewPager;
    private TextView tv_skip;
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.vp_intro);
        TabLayout tabLayout = findViewById(R.id.tab_intro);
        tv_skip = findViewById(R.id.tv_skip);
        btn_start = findViewById(R.id.btn_start);

        pages = new ArrayList<>();
        addPages();

        refreshAdapter();

        tabLayout.setupWithViewPager(viewPager);

        controlPage();
    }

    private void refreshAdapter() {
        PagerAdapter pagerAdapter = new PageAdapter(pages, this);
        viewPager.setAdapter(pagerAdapter);
    }

    private void controlButton(int position) {
        if (position != 2) {
            btn_start.setVisibility(View.GONE);
            tv_skip.setVisibility(View.VISIBLE);
        } else {
            tv_skip.setVisibility(View.GONE);
            btn_start.setVisibility(View.VISIBLE);
        }
    }

    private void controlPage() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                controlButton(position);

                tv_skip.setOnClickListener(v -> {
                    viewPager.setCurrentItem(position + 1);
                });
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void addPages() {
        pages.add(new Page(R.drawable.communication, "Say Hello to Global-Top Up", "Send mobile top-up to more than 500 networks in over 140 countries"));
        pages.add(new Page(R.drawable.secure, "Safe, Trusted & Fully Secure", "Encrypted transactions mean your payments & Privacy and protected"));
        pages.add(new Page(R.drawable.easy_to_share, "Easy to Use", "Pick a number, choose an account, send your Top-up. Simple"));
    }
}