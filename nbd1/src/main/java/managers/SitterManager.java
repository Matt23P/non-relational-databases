package managers;

import repositories.SitterRepository;

public class SitterManager {
    SitterRepository sitterRepository;

    public SitterManager(SitterRepository sitterRepository1) {
        this.sitterRepository = sitterRepository1;
    }
}
