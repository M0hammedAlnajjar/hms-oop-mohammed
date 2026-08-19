package services;

import interfaces.Manageable;
import interfaces.Searchable;

public class RecordService implements Manageable, Searchable {
    @Override
    public void add(Object entity) {

        if (entity instanceof MedicalRecord) {
            records[recordCount] = (MedicalRecord) entity;
            recordCount++;
        }
    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public Object[] search(String keyword) {
        return new Object[0];
    }

    @Override
    public Object searchById(String id) {
        return null;
    }


}