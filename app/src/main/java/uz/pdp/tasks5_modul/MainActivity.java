package uz.pdp.tasks5_modul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ArrayList<Page> pages;
    private TextView tv_skip;
    private Button btn_start;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_intro);

        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);

        tv_skip = findViewById(R.id.tv_skip);
        btn_start = findViewById(R.id.btn_start);

        pages = new ArrayList<>();
        addPages();

        refreshAdapter();

        controlPage();

    }

    private void controlPage() {
        tv_skip.setOnClickListener(v -> {
            if (gridLayoutManager.findLastCompletelyVisibleItemPosition() < adapter.getItemCount() - 1) {
                gridLayoutManager.scrollToPosition(gridLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1) {
                    btn_start.setVisibility(View.VISIBLE);
                } else {
                    btn_start.setVisibility(View.GONE);
                }
            }
        });
    }

    private void refreshAdapter() {
        adapter = new MainAdapter(pages);
        recyclerView.setAdapter(adapter);
    }

    private void addPages() {
        pages.add(new Page(R.drawable.communication, "Say Hello to Global-Top Up", "Send mobile top-up to more than 500 networks in over 140 countries"));
        pages.add(new Page(R.drawable.secure, "Safe, Trusted & Fully Secure", "Encrypted transactions mean your payments & Privacy and protected"));
        pages.add(new Page(R.drawable.easy_to_share, "Easy to Use", "Pick a number, choose an account, send your Top-up. Simple"));
    }
}