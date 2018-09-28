package com.sino.sinoapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.sino.sinoapp.Adapter.MainscreenRecyclerViewAdapter;
import com.sino.sinoapp.Model.MainScreenWithImageModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TextView tvTitleToolbar, tvSearch, tvNoResult, tvAdvanceSearch;
    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText edtSearch;
    Spinner spinnerSearch;
    ImageView imvLogo;
    Boolean isSearched = false;
    String category = "any";
    //RecyclerView api
    private MainscreenRecyclerViewAdapter mAdapter;
    ArrayList<MainScreenWithImageModel> listExhibit;
    //
    LinearLayout loAdvanceSearch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        actionBar();
        dropDownSpinner();
        showDataToRecyclerView();
        initData();
        addEvent();



    }
    @Override
        public void onWindowFocusChanged(boolean hasFocus){

            // set toolbar logo to center programmatically
            int offset = (toolbar.getWidth() / 2) - (imvLogo.getWidth() / 2);
            // set
            imvLogo.setX(offset);

        }
    private void initData() {
        listExhibit = new ArrayList<>();
        listExhibit.add(new MainScreenWithImageModel(1,"Mint Nguyễn","1994","165cm","45kg","92-60-90",
                "$99","https://hinhanhdephd.com/wp-content/uploads/2016/01/tai-hinh-girl-xinh-lam-avatar-de-thuong-nhat-22.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"Mai Thy","1995","159cm","43kg","93-58-93",
                "$95","https://1.bp.blogspot.com/-RFJj37ND0MY/WE1VC8wA8CI/AAAAAAAAjf4/F8G1C1bl9YYe5vlrGeTtWoDJbS6z1zrQACEw/s1600/15319063_1870502259827840_8901988026005563692_n.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"Lily Tran","18","163cm","47kg","91-61-90",
                "$110","https://cdn.pose.com.vn/legacy/images/baiviet/201510//18540_1_x.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"Kim Anh","1993","157cm","45kg","92-60-90",
                "$59","https://image2.tin247.com/pictures/2016/05/19/yyr1463596408.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"Thư Thư","1999","165cm","45kg","92-60-90",
                "$99","https://i.ytimg.com/vi/ijWyCnz9RzM/maxresdefault.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"Ánh Tiên","1999","163cm","44kg","95-58-95",
                "$120","https://4.bp.blogspot.com/-HV5ApB5gtpY/WOehpkmZnII/AAAAAAAAmKk/HvpSXxZTvO49J5fMT108cD7HfSq4DrpswCLcB/s640/10518967_230893784052255_6364055155881827342_n.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"ViVy Cao","1997","165cm","45kg","92-60-90",
                "$99","http://2sao.vietnamnetjsc.vn/images/2016/12/10/20/09/2.jpg",null));
        listExhibit.add(new MainScreenWithImageModel(1,"Khánh Linh Hera","2000","167cm","45kg","98-60-99",
                "$199","http://xemanhdep.com/wp-content/uploads/2016/04/anh-girl-xinh-9x-de-thuong.jpg",null));

        mAdapter.updateAnswers(listExhibit);
    }

    private void showDataToRecyclerView() {
        mAdapter = new MainscreenRecyclerViewAdapter(this, new ArrayList<MainScreenWithImageModel>(0), new MainscreenRecyclerViewAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {

            }
        });
        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        /*EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (isFilter) {
                    showMoreResultByStuffId(page, size, stuffId);
                } else {
                    loadMoreAnswers(page, size);

                }
            }
        };
        recyclerView.addOnScrollListener(scrollListener);*/
    }



    private void addEvent() {

    }

    private void dropDownSpinner() {
        spinnerSearch = findViewById(R.id.spinnerSearch);

        String[] items = new String[]{ "Tên","Giá","Chiều cao","Số đo"};
        /*final String[] arrCategory = new String[]{"ANY", "EXHIBITNAME", "OTHERNAME",
                "CODEID", "NUMBER", "ELEMENT", "AGES"};*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearch.setAdapter(adapter);

        spinnerSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getChildAt(0) != null) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                    ((TextView) parent.getChildAt(0)).setTextSize(13);
                }
                //category = arrCategory[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void addControl() {
        toolbar = findViewById(R.id.toolbarMainscreen);
        recyclerView = findViewById(R.id.rcvMainScreen);
        pbSearch = findViewById(R.id.pbItemMainScreen);
        edtSearch = findViewById(R.id.edtSearchNormal);
        imvLogo = findViewById(R.id.imvLogo);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}