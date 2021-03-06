package hw3;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GameConnection {
	private File f;
	private Map<String, Player> playerMap;
	
	@SuppressWarnings("unchecked")
	public GameConnection(String fileName){
		f = new File(fileName);
		if (!f.exists())
			playerMap = new HashMap<String, Player>();
		else{
			try{
				InputStream is = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(is);
				playerMap = (Map<String, Player>) ois.readObject();
				ois.close();
			}
			catch (IOException ex){
				System.out.println(ex);
				throw new RuntimeException("File is corrupt");
			}
			catch (ClassNotFoundException ex){
				System.out.println(ex);
				throw new RuntimeException("Serialization problem");
			}
		}
	}
	public Map<String, Player> getMap(){
		return playerMap;
	}
	public void saveMap(Map<String, Player> m){
		try{
			OutputStream os = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			oos.close();
		}
		catch (Exception ex){
			throw new RuntimeException("File is corrupt");
		}
	}
}
