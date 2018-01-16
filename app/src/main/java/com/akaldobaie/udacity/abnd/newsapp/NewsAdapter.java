package com.akaldobaie.udacity.abnd.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/*
 * Created by Abdullah Aldobaie (akdPro) on 1/14/18 at 5:51 PM.
 */

class NewsAdapter extends ArrayAdapter<News>
{
	
	/**
	 * Constructor
	 *
	 * @param context
	 * 	 The current context.
	 * @param resource
	 * 	 The resource ID for a layout file containing a TextView to use when
	 * 	 instantiating views.
	 * @param objects
	 * 	 The objects to represent in the ListView.
	 */
	NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects)
	{
		super(context, resource, objects);
	}
	
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
	{
		ViewHolder holder;
		
		if (convertView == null)
		{
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
			
			holder = new ViewHolder();
			holder.sectionTextView = convertView.findViewById(R.id.section_textview);
			holder.dateTextView = convertView.findViewById(R.id.date_textview);
			holder.titleTextView = convertView.findViewById(R.id.title_textview);
			holder.authorsLabelTextView = convertView.findViewById(R.id.authors_label_textview);
			holder.authorsTextView = convertView.findViewById(R.id.authors_textview);
			
			convertView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		News currentNews = getItem(position);
		
		if (currentNews == null)
		{
			return convertView;
		}
		
		holder.sectionTextView.setText(currentNews.getSectionName());
		holder.dateTextView.setText(currentNews.getFormattedDate());
		holder.titleTextView.setText(currentNews.getTitle());
		
		if (!currentNews.getAuthors().isEmpty())
		{
			holder.authorsLabelTextView.setVisibility(View.VISIBLE);
			holder.authorsTextView.setVisibility(View.VISIBLE);
			holder.authorsTextView.setText(currentNews.getAuthors());
			
		} else
		{
			holder.authorsLabelTextView.setVisibility(View.GONE);
			holder.authorsTextView.setVisibility(View.GONE);
		}
		
		return convertView;
	}
	
	private static class ViewHolder
	{
		
		private TextView sectionTextView;
		private TextView dateTextView;
		private TextView titleTextView;
		private TextView authorsLabelTextView;
		private TextView authorsTextView;
	}
}
