package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", false, "La Rochelle", "0601010101", "www.facebook.fr/Caroline", "Caroline Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e", true, "Puilboreau", "0602020202", "www.facebook.fr/Jack", "Jack Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", true, "Lagord", "0603030303", "www.facebook.fr/Chloé", "Chloé Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a", true, "Aytré", "0604040404", "www.facebook.fr/Vincent", "Vincent Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b", false, "Angoulins", "0605050505", "www.facebook.fr/Elodie", "Elodie Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", false, "Rochefort", "0606060606", "www.facebook.fr/Sylvain", "Sylvain Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d", false, "Nieul-sur-mer", "0607070707", "www.facebook.fr/Laetitia", "Laetitia Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b", false, "Port-Neuf", "0608080808", "www.facebook.fr/Dan", "Dan Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d", true, "Laleu", "0609090909", "www.facebook.fr/Joseph", "Joseph Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d", false, "La Pallice", "0610101010", "www.facebook.fr/Emma", "Emma Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", false, "Andilly", "0611111111", "www.facebook.fr/Patrick", "Patrick Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim."),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d", false, "Périgny", "0612121212", "www.facebook.fr/Ludovic", "Ludovic Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam finibus varius lorem. Ut quis lacus sit amet mi egestas vulputate nec at enim.")
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}
