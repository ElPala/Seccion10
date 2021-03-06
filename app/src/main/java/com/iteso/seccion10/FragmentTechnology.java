package com.iteso.seccion10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.seccion10.beans.ItemProduct;
import com.iteso.seccion10.database.DataBaseHandler;
import com.iteso.seccion10.database.ItemProductControl;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTechnology extends Fragment {


    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    static ArrayList<ItemProduct> myDataSet;

    public FragmentTechnology() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_technology_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ItemProductControl itemProductControl = new ItemProductControl();
        myDataSet = itemProductControl.getProductsWhere(
                "0", DataBaseHandler.KEY_PRODUCT_ID + " ASC",
                DataBaseHandler.getInstance(getActivity()));
        mAdapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    public static void notifyDataSetChanged(ItemProduct itemProduct){
        myDataSet.add(itemProduct);
        mAdapter.notifyDataSetChanged();
    }
}

