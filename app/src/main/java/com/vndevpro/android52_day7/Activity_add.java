package com.vndevpro.android52_day7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_add extends AppCompatActivity {
    private EditText txtName,txtDes,txtPrice,txtDiscount,txtRating,txtStock,txtBrand,txtCategory,txtThumbnail,txtImage;
    private SqliteHelper mSqliteHelper;
    private Button btnaccept;
    private static final String TAG = "Activity_add";
    private ArrayList<Product> mListProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initdata();

        btnaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity_add.this,MainActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick: Add Thanh Cong");
            }
        });
    }


    private void insertdata() {
        mSqliteHelper = new SqliteHelper(Activity_add.this);
        Product product = new Product();
        product.setTitle(txtName.getText().toString());
        product.setDescription(txtDes.getText().toString());
        product.setPrice(Integer.parseInt(txtPrice.getText().toString()));
        product.setDiscountPercentage(Double.parseDouble(txtDiscount.getText().toString()));
        product.setRating(Double.parseDouble(txtRating.getText().toString()));
        product.setStock(Integer.parseInt(txtStock.getText().toString()));
        product.setBrand(txtBrand.getText().toString());
        product.setCategory(txtCategory.getText().toString());
        product.setThumbnail(txtThumbnail.getText().toString());
        product.setImages(txtImage.getText().toString());
        mSqliteHelper.insertNewProduct(product);

    }

    private void initdata() {
        btnaccept = findViewById(R.id.btnAccept);
        txtName = findViewById(R.id.txtName);
        txtDes = findViewById(R.id.txtDes);
        txtPrice = findViewById(R.id.txtPrice);
        txtDiscount = findViewById(R.id.txtDiscount);
        txtRating = findViewById(R.id.txtRating);
        txtStock = findViewById(R.id.txtStock);
        txtBrand = findViewById(R.id.txtBrand);
        txtCategory = findViewById(R.id.txtCategory);
        txtThumbnail = findViewById(R.id.txtThumbnail);
        txtImage = findViewById(R.id.txtImages);


    }


//    Product product1 = product;
//        product1.setTitle("Iphone 8");
//        mSqliteHelper.updateNewProduct(3, product1);
//
//    Product product2 = product;
//        product1.setTitle("Iphone 7");
//        mSqliteHelper.updateNewProduct(4, product2);
//
//          mSqliteHelper.deleteProduct(1);
}