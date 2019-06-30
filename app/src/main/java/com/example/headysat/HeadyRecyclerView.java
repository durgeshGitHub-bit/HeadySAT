package com.example.headysat;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HeadyRecyclerView extends RecyclerView.Adapter<HeadyRecyclerView.HeadyViewHolder>
{
    MainActivity mainActivity;
    List<MyModel> myModels;


    public HeadyRecyclerView(MainActivity mainActivity, List<MyModel> myModels)
    {
        this.mainActivity = mainActivity;
        this.myModels = myModels;
    }

    @NonNull
    @Override
    public HeadyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_layout,viewGroup,false);

        return new HeadyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadyViewHolder headyViewHolder, int position)
    {
        MyModel myModel = myModels.get(position);
        headyViewHolder.section.setText(myModel.getSection());
        headyViewHolder.title.setText(myModel.getTitle());
        headyViewHolder.tv_abstract.setText(myModel.getStrAbstract());
        headyViewHolder.byline.setText(myModel.getByline());
        headyViewHolder.tv_url.setText(myModel.getUrlLink());
        headyViewHolder.publishDate.setText(myModel.getPublishDate());
        String imageLink = myModel.getImage();
        Glide.with(mainActivity).load(imageLink).into(headyViewHolder.imageView);


    }

    @Override
    public int getItemCount()
    {
        return myModels.size();
    }


    public class HeadyViewHolder extends RecyclerView.ViewHolder
    {
        TextView section,title,tv_abstract,byline,tv_url,publishDate;
        ImageView imageView;
        public HeadyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            section = (TextView) itemView.findViewById(R.id.tv_section);
            title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_abstract = (TextView)itemView.findViewById(R.id.tv_abstract);
            byline = (TextView)itemView.findViewById(R.id.tv_byline);
            tv_url = (TextView)itemView.findViewById(R.id.tv_urlLink);
            publishDate = (TextView)itemView.findViewById(R.id.tv_publishDate);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
