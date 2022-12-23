package com.masai.service;

import java.util.List;

import com.masai.Exceptions.EntryException;
import com.masai.model.Entry;

public interface EntryService {

	public Entry saveEntry(Entry entry);
	public List<Entry> getEntryByCategories() throws EntryException;
	public List<Entry> getEntryByHealth() throws EntryException;
	public Entry getRandomEntry() throws EntryException;
	public List<String> getEntryBydesc(String description) throws EntryException;
}
