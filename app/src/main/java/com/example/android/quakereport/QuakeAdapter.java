package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Gamal Ghanem on 7/31/2018.
 */

public class QuakeAdapter extends ArrayAdapter<Quake> {

    public QuakeAdapter(Activity context, ArrayList<Quake> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        if(listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Quake currentQuake = getItem(position);

        TextView strengthView = (TextView) listViewItem.findViewById(R.id.strengthView);
        double strength = currentQuake.getStrength();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(strength);
        strengthView.setText(output);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) strengthView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getStrength());
        int circleColor = ContextCompat.getColor(getContext(), magnitudeColor);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(circleColor);

        String firstLocation = getFirstLocation(currentQuake.getLocation());
        TextView firstLocationView = (TextView) listViewItem.findViewById(R.id.firstLocationView);
        firstLocationView.setText(firstLocation);

        String secondLocation = getSecondLocation(currentQuake.getLocation());
        TextView secondLocationView = (TextView) listViewItem.findViewById(R.id.secondLocationView);
        secondLocationView.setText(secondLocation);

        TextView dateView = (TextView) listViewItem.findViewById(R.id.dateView);
        Date dateObject = new Date(currentQuake.getDate());
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView)  listViewItem.findViewById(R.id.timeView);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listViewItem;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(date);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(date);
    }

    /*
    returns the first part of the location from the full location
     */
    private String getFirstLocation(String fullLocation) {
        int indx = fullLocation.indexOf("of");
        String first = fullLocation.substring(0, indx + 2);
        return first;
    }

     /*
    returns the first part of the location from the full location
     */
     private String getSecondLocation(String fullLocation) {
         int indx = fullLocation.indexOf("of");
         String second = fullLocation.substring(indx + 2);
         return second;
     }

    /*
    returns the color value of the magnitude circle
     */
    private int getMagnitudeColor(double mag) {
        int magnitude = (int) mag;
        int res;
        switch (magnitude) {
            case 0:
            case 1: res = R.color.magnitude1;
                break;
            case 2: res = R.color.magnitude2;
                break;
            case 3: res = R.color.magnitude3;
                break;
            case 4: res = R.color.magnitude4;
                break;
            case 5: res = R.color.magnitude5;
                break;
            case 6: res = R.color.magnitude6;
                break;
            case 7: res = R.color.magnitude7;
                break;
            case 8: res = R.color.magnitude8;
                break;
            case 9: res = R.color.magnitude9;
                break;
            default:    res = R.color.magnitude10plus;
        }
        return res;
    }


}
