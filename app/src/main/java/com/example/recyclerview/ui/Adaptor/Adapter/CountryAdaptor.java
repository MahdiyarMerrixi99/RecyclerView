package com.example.recyclerview.ui.Adaptor.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.OnItemClickListener;
import com.example.recyclerview.R;
import com.example.recyclerview.model.CountryModel;
import com.example.recyclerview.ui.Adaptor.Activity.DetailsActivity;
import com.example.recyclerview.ui.Adaptor.Utilitis.Const;

import java.util.List;

public class CountryAdaptor extends RecyclerView.Adapter<CountryAdaptor.ViewHolder>{
    private List<CountryModel>countryModelList;
    private OnItemClickListener onItemClickListener;

    public CountryAdaptor(List<CountryModel> countryModelList, OnItemClickListener onItemClickListener) {
        this.countryModelList = countryModelList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CountryModel countryModel = countryModelList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(countryModel.getImageURL())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageviewCountryFlag);
        holder.textviewCountryName.setText(countryModel.getCountryName());

        holder.itemView.setOnClickListener(view -> {
            //second way
            onItemClickListener.OnItemClick(countryModel);

            //first way
//            Context context =view.getContext();
//            Intent intent=new Intent(view.getContext(),DetailsActivity.class);
//            intent.putExtra(Const.COUNTRY_IMAGE_KEY,countryModel.getImageURL());
//            intent.putExtra(Const.COUNTRY_NAME_KEY,countryModel.getCountryName());
//            intent.putExtra(Const.COUNTRY_CURRENCY_KEY,countryModel.getCountryCurrency());
//            intent.putExtra(Const.COUNTRY_POPULATION_KEY,countryModel.getCountryPopulation());
//            intent.putExtra(Const.COUNTRY_LANGUAGE_KEY,countryModel.getCountryLanguage());
//            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return countryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView imageviewCountryFlag;
        AppCompatTextView textviewCountryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageviewCountryFlag=itemView.findViewById(R.id.imageview_country_flag);
            textviewCountryName=itemView.findViewById(R.id.textview_country_name);
        }
    }
}
