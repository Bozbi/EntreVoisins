package com.openclassrooms.entrevoisins.service;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }


    @Override
    public void removeFromFavorite(Neighbour neighbour) {
        for (Neighbour iNeighbour : neighbours) {
            if (iNeighbour.equals(neighbour)){
                iNeighbour.setFavorite(false);
            }
        }
    }

    @Override
    public void addToFavorite(Neighbour neighbour) {
        for (Neighbour iNeighbour : neighbours) {
            if (iNeighbour.equals(neighbour)){
                iNeighbour.setFavorite(true);
            }
        }
    }
}
