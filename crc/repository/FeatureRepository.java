package repository;

import domain.Feature;

public interface FeatureRepository {

    public int createFeature(Feature feature);
    public void editFeature(Feature feature);
    public void readFeature(Feature feature);
    public void deleteFeature(Feature feature);
}
