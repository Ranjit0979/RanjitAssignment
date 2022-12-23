package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.EntryException;
import com.masai.Repository.EntryRepo;
import com.masai.model.Entry;

@Service
public class EntryServiceImpl implements EntryService{

	@Autowired
	private EntryRepo erepo;
	
	
	@Override
	public Entry saveEntry(Entry entry) {
		// TODO Auto-generated method stub
		return erepo.save(entry);
	}

	@Override
	public List<Entry> getEntryByCategories() throws EntryException {
		List<Entry> entryList=erepo.findAll();
		if(entryList.isEmpty())
		{
			throw new EntryException("No entry found...");
		}
		else
		{
			return entryList;
		}
		
	}

	@Override
	public List<Entry> getEntryByHealth() throws EntryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry getRandomEntry() throws EntryException {
		// TODO Auto-generated method stub
		List<Entry> list=erepo.findAll();
		if(list.isEmpty()) throw new EntryException("No entry found");
		int max= list.size()-1;
		int min=0;	
		Integer id=(int) ((Math.random() * (max - min)) + min);
		Optional<Entry> opt=erepo.findById(id);
		if(opt.isPresent())
		{
			Entry entry=opt.get();
			return entry;
		}
		else
		{
			throw new EntryException("entry not found...");
		}
		
	}

	@Override
	public List<String> getEntryBydesc(String description) throws EntryException {
	List<Entry> list= erepo.findAll();
		
		
		
		List<String> entryList= new ArrayList<>();
		for(int i=0;i<list.size();i++)
		{
			String desc=list.get(i).getDescription();
			for(int j=0;j<desc.length();j++)
			{
				String sub="";
				for(int k=j;k<desc.length();k++) {
					sub=sub+desc.charAt(k);
					if(sub.equals(description))
					{
						entryList.add(desc);
					}
				}
			}
		}
		
		
		if(entryList.isEmpty()) {
			throw new EntryException("No Search found");
		}
		return entryList;
	}

}
