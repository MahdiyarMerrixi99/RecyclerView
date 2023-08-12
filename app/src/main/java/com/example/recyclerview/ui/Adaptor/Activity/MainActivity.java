package com.example.recyclerview.ui.Adaptor.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.OnItemClickListener;
import com.example.recyclerview.ui.Adaptor.Utilitis.Const;
import com.example.recyclerview.R;
import com.example.recyclerview.ui.Adaptor.Adapter.CountryAdaptor;
import com.example.recyclerview.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView recyclerView;
    private CountryAdaptor countryAdaptor;
    private List<CountryModel> countryModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview_country_list);

        countryModelList=new ArrayList<>();
        countryModelList.add(new CountryModel(Const.AUSTRALIA_FLAG_IMAGE_URL,"Australi","English","25.9","25.9"));
        countryModelList.add(new CountryModel(Const.EGYPT_FLAG_IMAGE_URL, "EGYPT", "Arabic",
                "109.3 million", "Pond"));
        countryModelList.add(new CountryModel(Const.SPAIN_FLAG_IMAGE_URL, "SPAIN",
                "Spanish", "22 million", "Euro"));
        countryModelList.add(new CountryModel(Const.ITALY_FLAG_IMAGE_URL, "ITALY",
                "Italian", "39.5 million", "Euro"));
        countryModelList.add(new CountryModel(Const.FRANC_FLAG_IMAGE_URL, "FRANC",
                "French", "67.75 million", "Euro"));
        countryModelList.add(new CountryModel(Const.CHINA_FLAG_IMAGE_URL, "CHINA",
                "Mandarin", "1.412 billion", "Yowan"));
        countryModelList.add(new CountryModel(Const.CYPRUS_FLAG_IMAGE_URL, "CYPRUS",
                "Greek", "1.1 million", "Euro"));
        countryModelList.add(new CountryModel(Const.BRAZIL_FLAG_IMAGE_URL, "BRAZIL",
                "Spanish", "214.3 million", "rial"
        ));




        countryAdaptor =new CountryAdaptor(countryModelList, this );
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
        recyclerView.setAdapter(countryAdaptor);
    }

    @Override
    public void OnItemClick(CountryModel countryModel) {
        Intent intent=new Intent(this,DetailsActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString(Const.COUNTRY_IMAGE_KEY, countryModel.getImageURL());
        bundle.putString(Const.COUNTRY_IMAGE_KEY,countryModel.getImageURL());
        bundle.putString(Const.COUNTRY_NAME_KEY,countryModel.getCountryName());
        bundle.putString(Const.COUNTRY_CURRENCY_KEY,countryModel.getCountryCurrency());
        bundle.putString(Const.COUNTRY_POPULATION_KEY,countryModel.getCountryPopulation());
        bundle.putString(Const.COUNTRY_LANGUAGE_KEY,countryModel.getCountryLanguage());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}