package repository;

import domain.Feature;

import java.sql.Connection;

public class FeatureRepositoryJDBC implements FeatureRepository {

    Connection connection ;


    public  FeatureRepositoryJDBC(Connection connection){
        this.connection =connection;
    }

    @Override
    public int createFeature(Feature feature) {
        return 0;
    }

    @Override
    public void editFeature(Feature feature) {

    }

    @Override
    public void readFeature(Feature feature) {

    }

    @Override
    public void deleteFeature(Feature feature) {

    }
}
