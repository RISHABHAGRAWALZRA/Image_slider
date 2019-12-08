package com.example.imagesliderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView edtxtcty;
    private ViewPager vwpager;
    private TabLayout tablyt;
    private RadioGroup radgp;

    ArrayList<City> cities= new ArrayList<>();

    private City selectedCity;

    private ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtcty=findViewById(R.id.edtxtcty);
        vwpager=findViewById(R.id.vwpager);
        tablyt=findViewById(R.id.tablayt);
        radgp=findViewById(R.id.radgp);

        initialcity();


        vwpager.setAdapter(adapter);
        tablyt.setupWithViewPager(vwpager);


        cityChecked(R.id.rdbutn1);
        radgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cityChecked(i);
            }
        });

    }

    public void cityChecked(int id){
        switch (id){
            case R.id.rdbutn1:
                selectedCity=getCityByName("London");
                break;

            case R.id.rdbutn2:
                selectedCity=getCityByName("New York");
                break;

            case R.id.rdbutn3:
                selectedCity=getCityByName("Tokyo");
                break;

            case R.id.rdbutn4:
                selectedCity=getCityByName("Mumbai");
                break;

            default:break;

        }

        if(selectedCity != null){
            
            edtxtcty.setText(selectedCity.getName());

            ArrayList<CityImageFragment> fragments=new ArrayList<>();

            for(int i=0;i<selectedCity.getImgurl().size();i++){
                CityImageFragment imgFrag = new CityImageFragment();

                Bundle bundle = new Bundle();
                bundle.putString("imgurl", selectedCity.getImgurl().get(i));
                imgFrag.setArguments(bundle);

                fragments.add(imgFrag);

                Log.d(TAG, "cityChecked:" + selectedCity.getName() + i);
            }
            adapter.setFragments(fragments);
        }
    }

    public City getCityByName(String name){
        for(City city:cities){
            if(city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    public void initialcity(){

        ArrayList<String> urlLon=new ArrayList<>();
        urlLon.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Palace_of_Westminster_from_the_dome_on_Methodist_Central_Hall.jpg/1000px-Palace_of_Westminster_from_the_dome_on_Methodist_Central_Hall.jpg");

        urlLon.add("http://www.howtogetintograduateschool.com/wp-content/uploads/2016/05/1-University-of-Cambridge-UK.jpg");
        urlLon.add("http://www.victorianweb.org/art/architecture/pubs/51.jpg");
        urlLon.add("https://images.ladbible.com/thumbnail?type=jpeg&url=http://beta.ems.ladbiblegroup.com/s3/content/6c6b39e85c99c1ef73d5d76147d9831f.png&quality=70&width=720");


        cities.add(new City("London",urlLon));


        ArrayList<String> urlNew=new ArrayList<>();
        urlNew.add("https://thumbs.dreamstime.com/z/new-york-city-united-states-november-life-times-square-daytime-114391794.jpg");

        urlNew.add("https://28nwgk2wx3p52fe6o9419sg5-wpengine.netdna-ssl.com/wp-content/uploads/2015/10/url-skyline-2.jpg");
        urlNew.add("https://sourcemedia.brightspotcdn.com/dims4/default/226ecda/2147483647/strip/true/crop/570x380+0+0/resize/840x560!/quality/90/?url=https%3A%2F%2Fsourcemedia.brightspotcdn.com%2Fa1%2F75%2Fcc3e37b9469d9f11cd2dd0f1b528%2Fp1913acbct142v1fcife61iob14ei9.jpg");
        urlNew.add("http://4.bp.blogspot.com/_neWf5XLXl7Q/TNw6lmrneRI/AAAAAAAAAWg/4ZgRbXq075A/s1600/6-places_New_York_cityscape_wallpaper.jpg");


        cities.add(new City("New York",urlNew));


        ArrayList<String> urlTok=new ArrayList<>();
        urlTok.add("https://images.wallpaperscraft.com/image/night_city_street_umbrella_121639_2560x1080.jpg");

        urlTok.add("https://hipstersleek.files.wordpress.com/2013/04/url.jpeg");
        urlTok.add("https://d2908q01vomqb2.cloudfront.net/f1f836cb4ea6efb2a0b1b99f41ad8b103eff4b59/2017/08/08/tokyotower-1.jpg");
        urlTok.add("https://cdn.pixabay.com/photo/2016/12/11/21/31/tokyo-1900443__340.jpg");


        cities.add(new City("Tokyo",urlTok));


        ArrayList<String> urlInd=new ArrayList<>();
        urlInd.add("http://si.wsj.net/public/resources/images/BN-LM485_copind_G_20151130130832.jpg");

        urlInd.add("http://images.newindianexpress.com/uploads/user/imagelibrary/2018/5/20/w600X300/India_udaipur.jpg");
        urlInd.add("https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2018/01/30/Pictures/_a42b739a-05ba-11e8-8132-ce8c29606b52.jpg");
        urlInd.add("https://dailypost.in/wp-content/uploads/2018/01/18-13.jpg");


        cities.add(new City("Mumbai",urlInd));
    }
}
