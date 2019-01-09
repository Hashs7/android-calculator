package com.gmail.pro.glagouy.example.listeners;

import com.gmail.pro.glagouy.example.modeles.Planet;

public interface PlanetListener {
    void onSelect(Planet planet);
    void onShare(Planet planet);
}
