package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import javax.security.auth.login.LoginException;

public class AboutNeighbourActivity extends AppCompatActivity {

    private TextView mNeighbourName;
    private ImageView mNeighbourPicture;
    private ImageView mBackArrow;
    private FloatingActionButton mFavoriteButton;
    private TextView mNeighbourName2;
    private TextView mLocation;
    private TextView mPhoneNumber;
    private TextView mInternetSite;
    private TextView mAboutMe;


    private NeighbourApiService mApiService = DI.getNeighbourApiService();

    public static final String KEY_FOR_NEIGHBOUR_INTENT_EXTRA = "KEY_FOR_NEIGHBOUR_INTENT_EXTRA";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_neighbour);



        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra(KEY_FOR_NEIGHBOUR_INTENT_EXTRA);

        mNeighbourName =  findViewById(R.id.neighbour_name_txt_view);
        mNeighbourName.setText(neighbour.getName());

        mNeighbourPicture =  findViewById(R.id.neighbour_picture);
        Glide.with(this).load(neighbour.getAvatarUrl()).apply(RequestOptions.centerCropTransform()).into(mNeighbourPicture);

        mBackArrow = findViewById(R.id.back_arrow);
        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListNeighbourActivity.class);
                startActivity(intent);
            }
        });

        mFavoriteButton = findViewById(R.id.favorite_button);
        if (neighbour.isFavorite()){
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
        }else{
            mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        }
        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (neighbour.isFavorite()){
                    mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    mApiService.removeFromFavorite(neighbour);
                    neighbour.setFavorite(false);
                }else{
                    mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
                    mApiService.addToFavorite(neighbour);
                    neighbour.setFavorite(true);
                }
            }
        });


        mNeighbourName2 = findViewById(R.id.name_in_card_text_view);
        mNeighbourName2.setText(neighbour.getName());

        mLocation = findViewById(R.id.location_text_view);
        mLocation.setText(neighbour.getAddress());


        mPhoneNumber = findViewById(R.id.phone_text_view);
        mPhoneNumber.setText(neighbour.getPhoneNumber());
        mPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + neighbour.getPhoneNumber()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        mInternetSite = findViewById(R.id.internet_text_view);
        mInternetSite.setText(neighbour.getInternetAddress());

        mAboutMe = findViewById(R.id.about_me_text_view);
        mAboutMe.setText(neighbour.getAbout());




    }
}
