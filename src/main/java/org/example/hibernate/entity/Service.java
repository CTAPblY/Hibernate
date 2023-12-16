package org.example.hibernate.entity;

import java.util.List;

public class Service {

    private NumbDao numbDao = new NumbDao();

    public void save(Numb numb){
        numbDao.save(numb);
    }

    public void delete(Numb numb){
        numbDao.delete(numb);
    }

    public void update(Numb numb){
        numbDao.update(numb);
    }

    public List<Numb> getAll(){
        return numbDao.getAll();
    }
}
