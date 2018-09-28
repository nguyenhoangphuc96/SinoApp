package com.sino.sinoapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sino.sinoapp.Model.MainScreenWithImageModel;
import com.sino.sinoapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainscreenRecyclerViewAdapter extends RecyclerView.Adapter<MainscreenRecyclerViewAdapter.ViewHolder> {

    private List<MainScreenWithImageModel> ExhibitList;
    private Context mContext;
    private PostItemListener mItemListener;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvName, tvAge,tvHeight,tvPrice;
        public ImageView imvAvatar;
        private ProgressBar progressBar;
        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvAge = itemView.findViewById(R.id.tvItemAge);
            tvHeight = itemView.findViewById(R.id.tvHeight);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            imvAvatar = itemView.findViewById(R.id.imvItemImage);
            progressBar = itemView.findViewById(R.id.pbItemMainScreen);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            MainScreenWithImageModel item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getId());

            /*notifyDataSetChanged();*/
        }
    }

    public MainscreenRecyclerViewAdapter(Context context, List<MainScreenWithImageModel> posts, PostItemListener itemListener) {
        ExhibitList = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public MainscreenRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_recyclerview_mainscreen, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainscreenRecyclerViewAdapter.ViewHolder holder, int position) {

        MainScreenWithImageModel item = ExhibitList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvAge.setText(item.getAges());
        holder.tvHeight.setText(item.getHeight());
        holder.tvPrice.setText(item.getPrice());

       /* //get ID and load image by id
        id = item.getEXHID();
        loadImage(id,holder);*/

        if (item.getAvatar() != null) {
            holder.progressBar.setVisibility(View.GONE);
            showImage(item.getAvatar(), holder);
        } else {
            holder.progressBar.setVisibility(View.VISIBLE);
            holder.imvAvatar.setImageDrawable(null);
        }
        if(item.getAvatar()==""){
            holder.progressBar.setVisibility(View.GONE);
            holder.imvAvatar.setImageDrawable(mContext.getResources().getDrawable(R.drawable.img_no_image));
        }
    }


    @Override
    public int getItemCount() {
        return ExhibitList.size();
    }

    public void updateAnswers(List<MainScreenWithImageModel> items) {
        ExhibitList = items;
        notifyDataSetChanged();
    }


    public void updateMoreAnswers(List<MainScreenWithImageModel> items) {
        ExhibitList.addAll(items);
        notifyDataSetChanged();
    }

    private MainScreenWithImageModel getItem(int adapterPosition) {
        return ExhibitList.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }

    public List<MainScreenWithImageModel> getTestList() {
        return ExhibitList;
    }

    private void showImage(String imageString, ViewHolder holder) {
        try {
            Picasso.with(mContext).load(imageString).into(holder.imvAvatar);
            /*Bitmap bmp = Util.StringToBitMap(imageString);
            holder.imvBook.setImageBitmap(bmp);*/
        } catch (Exception ex) {
            ex.getMessage();
        }
    }


}