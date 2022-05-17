package repository;

import domain.Attribute;

import java.sql.Connection;

public class AttributeRepositoryJDBC implements AttributeRepository {
    Connection connection;

    public AttributeRepositoryJDBC(Connection connection){
        this.connection =connection;
    }

    @Override
    public int createAttribute(Attribute attribute) {
        return 0;
    }

    @Override
    public void readAttribute(Attribute attribute) {

    }

    @Override
    public void editAttribute(Attribute attribute) {

    }

    @Override
    public void deleteAttribute(Attribute attribute) {

    }
}
