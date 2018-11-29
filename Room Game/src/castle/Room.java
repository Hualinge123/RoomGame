package castle;

import java.util.HashMap;

public class Room {
	
	
	HashMap<String,Room> exits=new HashMap<>();
	private String description;
	
   
    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(String str,Room room) 
    {
       exits.put(str, room);
    }
    public void roomDisc()
    {
    	StringBuffer dir =new StringBuffer();
    	for (String str : exits.keySet()) {
			dir.append(str);
			dir.append(" ");
		}
    	System.out.println(dir);
    }
    
    public Room getExits(String direction)
    {
    	return exits.get(direction);

    }

    @Override
    public String toString()
    {
        return description;
    }
    
    
        
}
