package dades;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CtrlDadesUsuari {

    public Map<String, Integer> getUsuarisRanking(){

        Map<String, Integer> usersFiles = new HashMap<>();

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
