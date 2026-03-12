package com.example.demoview.services;
import com.example.demoview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PersonFileRepository {

    PersonFileRepository repo =new PersonFileRepository();

    public List<String>loadForListView(){

        List<String> lines =repo.readAdllines();
        List<String> list=new ArrayList<>();
        for(String line:lines){
            if(line == null || line.isBlank())continue;

            String[] parts =line.split(",");
            String name=parts[0];
            String email=parts[1];
            result.add(name+"-"+email);
        }
        return result;
    }PUBLIC VOID addPerson(String name, String email) throws IDException{
        repo.assNewLine(name","+email);
    }
    private void
}
