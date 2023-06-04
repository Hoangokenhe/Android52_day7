package com.vndevpro.android52_day7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView rvDemo;
    private ArrayList<Product> mListProduct;
    private ProductAdapter mProductAdapter;
    private SqliteHelper mSqliteHelper;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = findViewById(R.id.btnadd);

        initData();
        initView();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_add.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        rvDemo = findViewById(R.id.rvDemo);
        mProductAdapter = new ProductAdapter(mListProduct);
        mProductAdapter.setCallback(clickListener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvDemo.setLayoutManager(linearLayoutManager);
        rvDemo.setHasFixedSize(true);
//        rvDemo.setItemViewCacheSize(10);
        rvDemo.setAdapter(mProductAdapter);
    }

    private IItemClickListener clickListener = new IItemClickListener() {
        @Override
        public void onItemClick(int pos) {

        }

        @Override
        public void onChangeWishList(int position) {
            Product productModel = mListProduct.get(position);
            productModel.setWish(!productModel.isWish());
            mListProduct.set(position, productModel);
//            mProductAdapter.notifyDataSetChanged();
            mProductAdapter.notifyItemChanged(position);
        }

        @Override
        public void onDelete(int position) {
            mListProduct.remove(position);
//            mProductAdapter.notifyDataSetChanged();
            mProductAdapter.notifyItemRemoved(position);

        }

        @Override
        public void onUpdate(int position) {
            Product product = mListProduct.get(position);
            product.setTitle(product.getTitle() + " new");
            mListProduct.set(position, product);
            mProductAdapter.notifyDataSetChanged();
        }
    };

    private void initData() {
        mListProduct = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product=new Product();
            product.setId(i);
            product.setTitle("Product " + i);
            product.setDescription("An apple mobile which is nothing like apple");
            product.setPrice(549);
            product.setDiscountPercentage(12.96);
            product.setRating(4.69);
            product.setStock(94);
            product.setBrand("Apple");
            product.setThumbnail("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
            product.setImages("https://i.dummyjson.com/data/products/1/1.jpg");


            mListProduct.add(product);
        }

    }
}