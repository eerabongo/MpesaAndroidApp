package com.esau.mpesatrial;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private List<String> items;
    private Context context;
    private Dialog myDialog;
    PriceTransfer priceTransfer;
    private List<String> item_prices = new ArrayList<>();
    private ArrayList<Integer> prices = new ArrayList<>();

    public CartListAdapter(Context context, List<String> items, List<String> item_prices, PriceTransfer priceTransfer) {
        this.items = items;
        this.context = context;
        this.item_prices = item_prices;
        this.priceTransfer = priceTransfer;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.item_name.setText(items.get(position));
        viewHolder.btn_add_to_cart.setText("Add Kshs " + item_prices.get(position));
        viewHolder.item_description.setText(items.get(position) + " fresh and healthy now available.");

        if (items.get(position).equals("Tomatoes"))
            viewHolder.item_image.setImageDrawable(context.getResources().getDrawable(R.drawable.tomatoes));
        else if (items.get(position).equals("Apples"))
            viewHolder.item_image.setImageDrawable(context.getResources().getDrawable(R.drawable.apples));
        else if (items.get(position).equals("Bananas"))
            viewHolder.item_image.setImageDrawable(context.getResources().getDrawable(R.drawable.bananas));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView item_image;
        TextView item_name, item_description;
        Button btn_add_to_cart;

        public ViewHolder(View view) {
            super(view);

            item_image = (ImageView) view.findViewById(R.id.item_image);
            item_name = (TextView) view.findViewById(R.id.item_name);
            item_description = (TextView) view.findViewById(R.id.item_description);
            btn_add_to_cart = (Button) view.findViewById(R.id.btn_add_to_cart);

            btn_add_to_cart.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (view.getId() == R.id.btn_add_to_cart) {
                prices.add(Integer.valueOf(btn_add_to_cart.getText().toString().replace("Add Kshs ", "")));
                Toast.makeText(context, String.valueOf("Added: " + items.get(position)), Toast.LENGTH_SHORT).show();
                Log.e("value added to list", btn_add_to_cart.getText().toString().replace("Add Kshs ", ""));
                //Calling a class priceTransfer.java
                priceTransfer.setPrices(prices);
            }
        }
    }
}
