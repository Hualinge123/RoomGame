package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private Room nextRoom;
    
    HashMap<String,Handler> handlers=new HashMap<>();
            
    public Game() 
    {
        createRooms();
        
        handlers.put("go", new Handler() {
        	@Override
    		public void doCmd(String word) {
    			
    			goRoom(word);
    		}
        });
        
        handlers.put("bye", new Handler() {
        	@Override
        	public boolean isBye() {
        		return true;
        	}

        });
        
        handlers.put("help", new Handler() {
        	@Override
        	public void doCmd(String word) {
        		System.out.println("迷路了吗？你可以做的命令有：go bye help");
                System.out.println("如：go east");
        	}
        });
        
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        
        outside.setExits("east", lobby);
        outside.setExits("south",study);
        outside.setExits("west", pub);
        lobby.setExits("west", outside);
        pub.setExits("east", outside);
        study.setExits("north", outside);
        study.setExits("east", bedroom);
        bedroom.setExits("west", study);
        lobby.setExits("up", pub);
        pub.setExits("down", lobby);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
       currentRoom.roomDisc();
    }

    // 以下为用户命令

 

    public void goRoom(String direction) 
    {
         nextRoom = currentRoom.getExits(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("你在" + currentRoom);
            System.out.print("出口有: ");
            currentRoom.roomDisc();
           
        }
    }
    
    private void play() {
    	
    	Scanner in = new Scanner(System.in);
    	 
    	while ( true ) {
      		String line = in.nextLine();
      		String[] words = line.split(" ");
      		Handler handler=handlers.get(words[0]);
      		String value="";
      		
      		if( handler!=null) {
      			if(handler.isBye()) {
          			break;
          		}
      			
      			if(words.length>1) {
          			value=words[1];
          		}
      			handler.doCmd(value);
          		
          		
      		}
      		
      }
    	
    	in.close();
    }
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.play();
        System.out.println("感谢您的光临。再见！");
        
	}

	
	
	
}
