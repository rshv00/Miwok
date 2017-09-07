package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Рома on 3/28/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

int mColorResourceId;
    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId=colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        RelativeLayout playButton = (RelativeLayout) itemView.findViewById(R.id.play_button_layout);
        TextView miwokTextView = (TextView) itemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = (TextView) itemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
playButton.setBackgroundResource(mColorResourceId);
miwokTextView.setBackgroundResource(mColorResourceId);
        defaultTextView.setBackgroundResource(mColorResourceId);
         ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        return itemView;
        }
    }
