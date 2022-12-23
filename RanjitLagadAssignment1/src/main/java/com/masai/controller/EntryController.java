package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.EntryException;
import com.masai.model.Entry;
import com.masai.service.EntryServiceImpl;

@RequestMapping("/home")
@RestController
public class EntryController {
	
	@Autowired
	private EntryServiceImpl entryServiceImpl;
	
	@PostMapping("/create")
    public ResponseEntity<Entry> saveEnrty(@RequestBody Entry entry){

        Entry entry1= entryServiceImpl.saveEntry(entry);
        return new ResponseEntity<Entry>(entry1,HttpStatus.OK);

    }
	
	@GetMapping("/category")
    public ResponseEntity<List<Entry>> getEntryByCategories() throws EntryException{
    	List<Entry> entryList =entryServiceImpl.getEntryByCategories();
    	
    	return new ResponseEntity<List<Entry>>(entryList,HttpStatus.OK);
    }
	
	@GetMapping("/random")
    public ResponseEntity<Entry> getRandomEntry() throws EntryException{
        Entry entry= entryServiceImpl.getRandomEntry();
        return new ResponseEntity<Entry>(entry,HttpStatus.OK);

    }
	
	@GetMapping("/searchbyat")
    public ResponseEntity<List<String>> getEntryBydesc(@RequestParam String desc) throws EntryException{
        List<String> entryList=entryServiceImpl.getEntryBydesc(desc);
        return new ResponseEntity<List<String>>(entryList,HttpStatus.OK);

    }
	

}
