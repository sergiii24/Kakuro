package dades;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CtrlDadesUsuari {

    public Map<String, Integer> getUsuarisRanking(){

        Map<String, Integer> usersFiles = new HashMap<String, Integer>();

        try{
            File file = new File("data/users");
            String[] usersInFolder = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir, name).isDirectory();
                }
            });

            for(String f : usersInFolder) {
                File aux = new File("data/users/" + f + "/data.txt");
                System.out.println(f);
                BufferedReader br = new BufferedReader(new FileReader(aux));
                System.out.println(br.readLine());
                usersFiles.put(f, Integer.parseInt(br.readLine()));
                System.out.println(usersFiles.keySet().toString());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return usersFiles;
    }
}
