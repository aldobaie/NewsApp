package com.akaldobaie.udacity.abnd.newsapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Created by Abdullah Aldobaie (akdPro) on 1/14/18 at 5:44 PM.
 */
class News
{
	
	private String title = "";
	private String publicationDate = "";
	private String url = "";
	private String sectionName = "";
	private String sectionID = "";
	private String formattedDate = "";
	private String authors;
	
	/**
	 * News model constructor
	 *
	 * @param title
	 * 	 News article title
	 * @param publicationDate
	 * 	 News article publication date
	 * @param url
	 * 	 News article website
	 * @param sectionName
	 * 	 News article section
	 * @param sectionID
	 * 	 News article section ID
	 */
	News(String title, String publicationDate, String url, String sectionName, String sectionID, String authors)
	{
		this.title = title;
		this.publicationDate = publicationDate;
		this.url = url;
		this.sectionName = sectionName;
		this.sectionID = sectionID;
		this.authors = authors;
		this.formattedDate = formatDate(publicationDate);
	}
	
	String getTitle()
	{
		return title;
	}
	
	String getUrl()
	{
		return url;
	}
	
	String getSectionName()
	{
		return sectionName;
	}
	
	String getSectionID()
	{
		return sectionID;
	}
	
	String getFormattedDate()
	{
		return formattedDate;
	}
	
	String getAuthors()
	{
		return authors;
	}
	
	private String formatDate(String publicationDate)
	{
		DateFormat desiredDateFormat = new SimpleDateFormat("LLL dd, yyyy");
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
		Date date = null;
		try
		{
			date = currentDateFormat.parse(this.publicationDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		if (date != null)
		{
			return desiredDateFormat.format(date);
		}
		// if not able to format return input
		return publicationDate;
	}
}
