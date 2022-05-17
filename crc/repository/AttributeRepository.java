package repository;

import domain.Attribute;

public interface AttributeRepository {

    public int createAttribute(Attribute attribute);
    public void readAttribute(Attribute attribute);
    public void editAttribute(Attribute attribute);
    public void deleteAttribute(Attribute attribute);
}
