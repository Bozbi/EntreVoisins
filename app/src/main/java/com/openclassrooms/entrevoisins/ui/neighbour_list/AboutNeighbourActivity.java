package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.neighbour_name_txt_view)
    public TextView mNeighbourName;
    @BindView(R.id.neighbour_picture)
    public ImageView mNeighbourPicture;
    @BindView(R.id.back_arrow)
    public ImageView mBackArrow;
    @BindView(R.id.favorite_button)
    public FloatingActionButton mFavoriteButton;
    @BindView(R.id.name_in_card_text_view)
    public TextView mNeighbourName2;
    @BindView(R.id.location_text_view)
    public TextView mLocation;
    @BindView(R.id.phone_text_view)
    public TextView mPhoneNumber;
    @BindView(R.id.internet_text_view)
    public TextView mInternetSite;
    @BindView(R.id.about_me_text_view)
    public TextView mAboutMe;


    private NeighbourApiService mApiService = DI.getNeighbourApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_neighbour);
        ButterKnife.bind(this);

        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra(ListNeighbourActivity.KEY_FOR_NEIGHBOUR_INTENT_EXTRA);

        mNeighbourName.setText(neighbour.getName());
        Glide.with(this).load(neighbour.getAvatarUrl()).apply(RequestOptions.centerCropTransform()).into(mNeighbourPicture);
        mInternetSite.setText(neighbour.getInternetAddress());
        mAboutMe.setText(neighbour.getAbout());
        mNeighbourName2.setText(neighbour.getName());
        mLocation.setText(neighbour.getAddress());
        mPhoneNumber.setText(neighbour.getPhoneNumber());

        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListNeighbourActivity.class);
                startActivity(intent);
            }
        });

        if (neighbour.isFavorite()) {
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
        } else {
            mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        }
        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (neighbour.isFavorite()) {
                    mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    mApiService.removeFromFavorite(neighbour);
                    neighbour.setFavorite(false);
                } else {
                    mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
                    mApiService.addToFavorite(neighbour);
                    neighbour.setFavorite(true);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ListNeighbourActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
