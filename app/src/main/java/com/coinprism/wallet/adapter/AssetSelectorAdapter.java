package com.coinprism.wallet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.coinprism.model.AssetBalance;
import com.coinprism.model.AssetDefinition;
import com.coinprism.wallet.R;

import java.util.List;

public class AssetSelectorAdapter extends ArrayAdapter<AssetDefinition>
{
    private final Context context;
    private final List<AssetDefinition> values;

    public AssetSelectorAdapter(Context context, List<AssetDefinition> values)
    {
        super(context, R.layout.asset_selector_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView rowView = (TextView)inflater.inflate(R.layout.asset_selector_item, parent, false);

        AssetDefinition item = values.get(position);

        if (item == null)
            rowView.setText("Bitcoin");
        else
            rowView.setText(item.getName());

        return rowView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        return getView(position, convertView, parent);
    }
}
