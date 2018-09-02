package com.example.arpit.getwel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdaptor extends RecyclerView.Adapter<ExampleAdaptor.ExampleviewHolder> {
    private static ArrayList<exampleitem> mlist;
    private OnItemClickListener mlisten;


public interface OnItemClickListener
{
    void onItemClick(int i);
    void onIncrease(int i, ArrayList<exampleitem> mlis);
    void onDecrease(int i, ArrayList<exampleitem> mlis);
}
public void setOnItemClickListener(OnItemClickListener listener)
    {
    mlisten=listener;
}
    public static class ExampleviewHolder extends RecyclerView.ViewHolder {
        public ImageView img, icon1, icon2;
        public TextView txt1, txt2, txt3, txt4,txt5;

        public ExampleviewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            icon1 = itemView.findViewById(R.id.add);
            icon2 = itemView.findViewById(R.id.minus);
            txt1 = itemView.findViewById(R.id.pro_name);
            txt2 = itemView.findViewById(R.id.pro_price);
            txt3 = itemView.findViewById(R.id.pro_gm);
            txt4 = itemView.findViewById(R.id.item);
            txt5 = itemView.findViewById(R.id.rs);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if(listener!=null)
                   {
                       int i=getAdapterPosition();
                       if(i!= RecyclerView.NO_POSITION)
                       {
                           listener.onItemClick(i);
                       }
                   }

                }
            });
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int i=getAdapterPosition();
                        if(i!= RecyclerView.NO_POSITION)
                        {
                            listener.onIncrease(i,mlist);
                        }
                    }
                }
            });
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int i=getAdapterPosition();
                        if(i!= RecyclerView.NO_POSITION)
                        {
                            listener.onDecrease(i,mlist);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdaptor(ArrayList<exampleitem> exampleitems) {
        mlist = exampleitems;


    }

    @NonNull
    @Override
    public ExampleviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_list, viewGroup, false);
        ExampleviewHolder vh = new ExampleviewHolder(v,mlisten);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleviewHolder exampleviewHolder, int i) {
        exampleitem current=mlist.get(i);
        exampleviewHolder.img.setImageResource(current.getImg1());
        exampleviewHolder.icon1.setImageResource(current.getIcon1());
        exampleviewHolder.icon2.setImageResource(current.getIcon2());
        exampleviewHolder.txt1.setText(current.getTxt1());
        exampleviewHolder.txt2.setText(current.getTxt2());
        exampleviewHolder.txt3.setText(current.getTxt3());
        exampleviewHolder.txt4.setText(current.getTxt4());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
