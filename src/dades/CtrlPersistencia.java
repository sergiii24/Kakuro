package dades;

import domini.Partida;
import domini.Registrat;
import domini.Tauler;
import domini.Usuari;

import java.io.*;

public class CtrlPersistencia {
	
    /*public static void main(String args[]) throws IOException {
    	
    	Casella[][] casellas = new Casella[3][3];		
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    				if(i == 0){
    						if(j == 0) casellas[i][j] = new Negre(3,3);
    						else  casellas[i][j] = new Negre(3,0);
    				}
    				else if(j == 0) casellas[i][j] = new Negre(0,3);
    				else casellas[i][j] = new Blanc(0);
    		}
    	}
    	Tauler tau1 = new Tauler(1532, casellas);
    	Tauler tau2 = new Tauler(6205, casellas);
    	Tauler tau3 = new Tauler(5663, casellas);
    	Tauler tau4 = new Tauler(5612, casellas);
    	Tauler tpriv = new Tauler(6000, casellas);
    	Tauler tpriv2 = new Tauler(6034, casellas);
    	Usuari usu1 = new Usuari("Nuria");
    	Usuari usu2 = new Usuari("Adria");
    	Usuari usu3 = new Usuari("Sergi");
    	Usuari usu4 = new Usuari("Oriol");
    	Partida par1 = new Partida("Adria", new Mode(TipusMode.NORMAL), tau1, 0);
    	Partida par2 = new Partida("Adria", new Mode(TipusMode.NORMAL), tau2, 20);
    	
    	//carpetes inicials
    	iniData();
    
    	//afegir fitxers
    	addKakuro(tau1);
    	addKakuro(tau2);
    	addKakuro(tau3);
    	addKakuro(tau4);
    	addUser(usu1);
    	addUser(usu2);
    	addUser(usu3);
    	addUser(usu4);
    	addKakuroToUser(tpriv, usu2);
    	addKakuroToUser(tpriv2, usu2);
    	addGame(par1);
    	addGame(par2);
    	
    	//llegir fitxers
    	String resK = readKakuro(tau3);
    	System.out.print("resultat de read kakuro:\n");
    	System.out.print(resK);
    	String resU = readUserPasword(usu3);
    	System.out.print("resultat de read user:\n");
    	System.out.print(resU);
    	String resGK = readGameKakuro(par1);
    	String resGM = readGameMode(par1);
    	String resGT = String.valueOf(readGameTime(par1));
    	System.out.print("resultat de read game:\n");
    	System.out.print(resGK);
    	System.out.print(resGM);
    	System.out.print("\n");
    	System.out.print(resGT);
    	
    	//eliminiar fitxers
    	removeKakuro(tau1); 
    	removeUser(usu1);
    	removeKakuroFromUser(tpriv2, usu2);
    	removeGame(par2);
    	
    	
    	//actualizar game
    	par1.setTemps(650);
    	addGame(par1);
    }*/

	public void iniData() {
    	File data = new File("data");
        if (!data.exists()) {
            data.mkdirs();
        }
        
        File users = new File("data/users");
        if (!users.exists()) {
        	users.mkdirs();
        }
        
        File kakuro = new File("data/kakuro");
        if (!kakuro.exists()) {
            kakuro.mkdirs();
        }
    }
    
    public void addKakuro(Tauler tau) throws IOException {
        String id = tau.getId();
        String ruta = "data/kakuro/" + id + ".txt";
        String contingut = tau.toString();

        File kakuro = new File(ruta);
        if (!kakuro.exists()) {
            kakuro.createNewFile();
        }

        FileWriter fw = new FileWriter(kakuro);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contingut);
        bw.close();
    }

    public boolean addUser(String id, String password) {

        File usuari = new File("data/users/" + id);
        if (!usuari.exists()) {

            try {

                if(!usuari.mkdirs()) return false;
                String ruta = "data/users/" + id + "/data.txt";
                File datausu = new File(ruta);
                datausu.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(datausu));
                bw.write(password+"\n");
                bw.write(0+"\n");
                bw.write(0+"\n");
                File games = new File("data/users/" + id + "/games");
                games.mkdirs();
                File kakuros = new File("data/users/" + id + "/kakuros");
                kakuros.mkdirs();
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;

        } else return false;

    }

    public boolean login(String id, String password, Registrat usuari) {

        File usuariPath = new File("data/users/" + id);
        if (usuariPath.exists()) {

            String ruta = "data/users/" + id + "/data.txt";
            File datausu = new File(ruta);

            try (BufferedReader bw = new BufferedReader(new FileReader(datausu))){

                String pass = bw.readLine();
                if(pass.compareTo(password) == 0) {
                    usuari.setId(id);
                    usuari.setPuntuacioTot(Integer.parseInt(bw.readLine()));
                    usuari.setKakuroResolts(Integer.parseInt(bw.readLine()));
                    //TODO Falta carregar partides i dades extres


                    return true;
                } else return false;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;

    }

    
    public static void addKakuroToUser(Tauler tau, Usuari usu) throws IOException {
        String idu = usu.getId();
        String idk = tau.getId();

        File usuari = new File("data/users/" + idu);
        if (!usuari.exists()) System.out.print("La carpeta usuari no existeix");

        usuari = new File("data/users/" + idu + "/kakuros");
        if (!usuari.exists()) System.out.print("La carpeta kakuros no existeix");

        String ruta = "data/users/" + idu + "/kakuros/" + idk + ".txt";
        String contingut = tau.toString();
    	
    	File kakuro = new File(ruta);
        if (!kakuro.exists()) {
        	kakuro.createNewFile();
        }
        
        FileWriter fw = new FileWriter(kakuro);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contingut);
        bw.close();
    }
    
    private static void addGame(Partida par) throws IOException {
        String idu = par.getUser();
        Tauler tau = par.getTauler();
        String idk = tau.getId();

        File usuari = new File("data/users/" + idu);
        if (!usuari.exists()) System.out.print("La carpeta usuari no existeix");

        usuari = new File("data/users/" + idu + "/games");
        if (!usuari.exists()) System.out.print("La carpeta games no existeix");

        File game = new File("data/users/" + idu + "/games/" + idk);
        if (!game.exists()) {
            game.mkdirs();
        }
        
        String ruta = "data/users/"+idu+"/games/"+idk+"/tauler.txt";
    	String contingut = tau.toString();
    	
    	File fitxer = new File(ruta);
        fitxer.createNewFile();

        
        FileWriter fw = new FileWriter(fitxer);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contingut);
        
        bw.close();
        
        ruta = "data/users/"+idu+"/games/"+idk+"/mode.txt";
    	contingut = par.getMode().getMode().toString();
    	
    	File fitxer2 = new File(ruta);
        if (!fitxer.exists()) {
        	fitxer.createNewFile();
        }
        
        FileWriter fw2 = new FileWriter(fitxer2);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        bw2.write(contingut);
        
        bw2.close();
        
        ruta = "data/users/"+idu+"/games/"+idk+"/temps.txt";
    	contingut = String.valueOf(par.getTemps());
    	
    	File fitxer3 = new File(ruta);
        fitxer.createNewFile();
        
        FileWriter fw3 = new FileWriter(fitxer3);
        BufferedWriter bw3 = new BufferedWriter(fw3);
        bw3.write(contingut);
        
        bw3.close();
	}
    
	public static String readKakuro(Tauler tau) throws IOException {
        String id = tau.getId();
        String linea;
		String res = "";
        FileReader fr = new FileReader("data/kakuro/"+id+".txt");
        BufferedReader br = new BufferedReader(fr);
        while((linea = br.readLine()) != null) {
            linea += "\n";
            res += linea;
        }
        br.close();
        
        return res;
	}
	
	public static String readUserPasword(Usuari usu) throws IOException {
		String id = usu.getId();
		String linea;
		String res = "";
        FileReader fr = new FileReader("data/users/"+id+"/data.txt");
        BufferedReader br = new BufferedReader(fr);
        while((linea = br.readLine()) != null) {
            linea += "\n";
            res += linea;
        }
        br.close();
        
        return res;
	}
	
	public static String readGameKakuro(Partida par) throws IOException {
        String idu = par.getUser();
        Tauler tau = par.getTauler();
        String idk = tau.getId();

        String linea;
        String res = "";
        FileReader fr = new FileReader("data/users/" + idu + "/games/" + idk + "/tauler.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((linea = br.readLine()) != null) {
            linea += "\n";
            res += linea;
        }
        br.close();
        
        return res;
	}
	
	public static String readGameMode(Partida par) throws IOException {
		String idu = par.getUser();
        Tauler tau = par.getTauler();
        String idk = tau.getId();
    	
		String linea;
		String res = "";
        FileReader fr = new FileReader("data/users/"+idu+"/games/"+idk+"/mode.txt");
        BufferedReader br = new BufferedReader(fr);
        while((linea = br.readLine()) != null) {
        	res += linea;
        }
        br.close();
       
        return res;
	}
	
	public static int readGameTime(Partida par) throws IOException {
		String idu = par.getUser();
        Tauler tau = par.getTauler();
        String idk = tau.getId();
    	
		String linea;
		String res = "";
        FileReader fr = new FileReader("data/users/"+idu+"/games/"+idk+"/temps.txt");
        BufferedReader br = new BufferedReader(fr);
        while((linea = br.readLine()) != null) {
        	res += linea;
        }
        br.close();
        
        return Integer.parseInt(res);
	}
	
	public static void removeKakuro(Tauler tau) {
        String id = tau.getId();
        File kakuro = new File("data/kakuro/" + id + ".txt");
        kakuro.delete();
    }
	
	public static void removeUser(Usuari usu) {
		String id = usu.getId();
		File user = new File("data/users/"+id);
		
		borraDirectori(user);
        user.delete();
	}
	
	public static void removeKakuroFromUser(Tauler tau, Usuari usu) {
        String idu = usu.getId();
        String idk = tau.getId();
        File kakuro = new File("data/users/" + idu + "/kakuros/" + idk + ".txt");
        kakuro.delete();
	}
	
	public static void removeGame(Partida par) {
		String idu = par.getUser();
        Tauler tau = par.getTauler();
        String idk = tau.getId();
        File game = new File("data/users/" + idu + "/games/" + idk);
        
    	borraDirectori(game);
    	game.delete();
	}

	private static void borraDirectori(File dir) {
		File[] fitxers = dir.listFiles();
		for (int i = 0; i < fitxers.length; i++) {
			if (fitxers[i].isDirectory()) {
				borraDirectori(fitxers[i]);
			}
			fitxers[i].delete();
		}
	}
}