package com.example.mekpark.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mekpark.R;

import static com.example.mekpark.R.drawable.coin_added;
import static com.example.mekpark.R.drawable.coindeduced;

public class mekCoinAdp extends RecyclerView.Adapter<mekCoinAdp.ProgrammingViewHolder> {

    private int[] amt;
    public mekCoinAdp(int[] amt){
        this.amt = amt;

    }


    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.list_items_layout,parent,false);


        return new mekCoinAdp.ProgrammingViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {

        int amountCurrent= amt[position];
        if(amountCurrent > 0) {
            holder.img.setBackgroundResource(coin_added);
            holder.title.setText("Money added");
        }else if(amountCurrent< 0 ){
            holder.img.setBackgroundResource(coindeduced);
            holder.title.setText("Money deduced");


        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class ProgrammingViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            img= (ImageView)itemView.findViewById(R.id.imageAddDeduce);
            title=(TextView)itemView.findViewById(R.id.MoneyaddDed);
        }
    }
}