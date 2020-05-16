package com.home.myhomebussinessdemo.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.home.myhomebussinessdemo.Interface.ItemClickListner;
import com.home.myhomebussinessdemo.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtProductName,txtProductPrice,txtProductDescription;
    public ImageView imageView;
    public ItemClickListner listner;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView =itemView.findViewById(R.id.product_image_imageId);
        txtProductName =itemView.findViewById(R.id.product_name_nameId);
        txtProductPrice =itemView.findViewById(R.id.product_price_priceId);
        txtProductDescription =itemView.findViewById(R.id.product_description_descriptionId);
    }
    public void setItemCliclListner(ItemClickListner listner){
        this.listner = listner;
    }


    @Override
    public void onClick(View view) {
        listner.onClick(view, getAdapterPosition(), false);
    }
}
