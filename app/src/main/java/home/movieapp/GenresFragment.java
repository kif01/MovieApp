package home.movieapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenresFragment extends Fragment {
    private GridLayoutManager lLayout;




    public GenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ArrayList<Genre> rowListItem = getAllItemList();

        View rootView = inflater.inflate(R.layout.fragment_genres, container, false);
        lLayout = new GridLayoutManager(getActivity(), 4);

        final RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);

        rView.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(),rView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {



                Intent intent = new Intent(view.getContext(),
                        ChosenGenreActivity.class);
               intent.putExtra("genre",position);
                view.getContext().startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));






        return rootView;
    }

    public ArrayList<Genre> getAllItemList() {
        ArrayList<Genre> allItems = new ArrayList<Genre>();
        allItems.add(new Genre("Science Fiction", R.drawable.scifi));
        allItems.add(new Genre("Comedy", R.drawable.comedy));
        allItems.add(new Genre("Action", R.drawable.action));
        allItems.add(new Genre("Horror", R.drawable.horror));
        allItems.add(new Genre("Animation", R.drawable.animation2));
        allItems.add(new Genre("Adventure", R.drawable.adventure));
        allItems.add(new Genre("Drama", R.drawable.drama));
        allItems.add(new Genre("Documentary", R.drawable.documentary));




        return allItems;
    }
}
