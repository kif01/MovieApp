package home.movieapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Khalil on 6/12/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private ArrayList<Genre> itemList;
    private Context context;

    //private OnLoadMoreListener mOnLoadMoreListener;

    public RecyclerViewAdapter(Context context, ArrayList<Genre> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.type.setText(itemList.get(position).getName());
        holder.genreImage.setImageResource(itemList.get(position).getPhoto());
    }

   // public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
       // this.mOnLoadMoreListener = mOnLoadMoreListener;
   // }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}