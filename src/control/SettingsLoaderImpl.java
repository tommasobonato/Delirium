package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class SettingsLoaderImpl implements SettingsLoader {
    
    private GameSettings gameSettings;
    
    public SettingsLoaderImpl() {
        //TODO crea classe loader per ottenere gli input stream?
        //TODO mettere eccezioni per mancato file load
        try (BufferedReader br = Files.newBufferedReader(Paths.get("res/storefiles/gameSettings.json"));){
            Gson gson = new Gson();
            this.gameSettings = gson.fromJson(br, GameSettingsImpl.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }
    
    
}