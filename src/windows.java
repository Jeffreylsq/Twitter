import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
public class windows extends JFrame {
    
	JList jlist;
	DefaultListModel <String>singleUser;
	

    JPanel jll2,jll1;
	JSplitPane jsp;
	JTextArea userId=null;
	JTextArea groupId=null;
	JTextField user = null;
	JTextField group = null;
	JTextArea  jta= null;
	
	JButton addUser = null;
	JButton addGroup = null;
	JButton openUser = null;
	JButton userTotal =null;
	JButton messageTotal = null;
	JButton groupTotal = null;
	JButton percentage = null;
	
    JLabel image = null;
    static int u =0;
    static int g =0;
    
  

	public windows(){

		
		
		
		// set panel 1,2
		jll1 = new JPanel();
		jll2 = new JPanel();
		
		//tree-------------------------------Name--------
		
		JLabel name = new JLabel("  Tree View   " );
		
		name.setFont(new Font("SimSun", Font.BOLD, 13));
		jll1.add(name);
		
		// set panel 1,2 location size and add in this
		jll1.setLocation(0,0);
		jll1.setSize(50,300);
		getContentPane().add(jll1);
		
		jll2.setLocation(200,0);
		jll2.setSize(10,300);
		getContentPane().add(jll2);
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jll1,jll2);
		
		

		
		// list  , default list model 
		
		singleUser = new DefaultListModel();
		
		jlist = new JList(singleUser);
		 
		jll1.add(jlist);
		
		
		
		
		/*	jlist.addMouseListener((MouseListener) new MouseAdapter() {  
		   
		    public  void mouseClicked(MouseEvent e) {  
		    	int n = jlist.locationToIndex(e.getPoint());
		    	 number = n;
		        jlist.setSelectedIndex(n);  
		    }  
		});  */
		
		
		JLabel win1 = new JLabel();
		 MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		         
		             int n = jlist.locationToIndex(e.getPoint());
		             
		              String userName = singleUser.get(n);
		              win1.setText(userName);
		     }
		 };
		 jlist.addMouseListener(mouseListener);
		 Nob element = new Nob();
		

		
		//user id and add user button                   ----------fist line
		user = new JTextField(20);
		user.setText("User ID");
		jll2.add(user);
		
		addUser = new JButton("Add User");
		
		//addUser Button action listener 
		addUser.addActionListener(new ActionListener() {                   
			public void actionPerformed(ActionEvent arg0) {
				addUserActionPerformend(arg0);
			}

			private void addUserActionPerformend(ActionEvent arg0) {
		  //addUser Button action --------------
				if(arg0.getSource()== addUser)
			{  
					if(win1.getText().contains("Group"))//singleUser.get(index)
				{
					if(!singleUser.contains(" " + "- " +user.getText()))
					{
					singleUser.addElement(" " +"- " + user.getText());
					u++;
					}
				}
				 
					else if(singleUser.isEmpty())	
				{	
					singleUser.addElement("Root");
				  singleUser.addElement("- "+user.getText());
				  u++;
				}
					else if(!singleUser.contains("- "+ user.getText())&&!singleUser.isEmpty())	//----------------
				{	singleUser.addElement("- "+user.getText());
				u++;
				}
				
				
				
				else if(win1.getText().startsWith("Root")&&!singleUser.contains("- "+ user.getText()))
				{
					singleUser.addElement("- "+ user.getText());
				}
				else
				{
				                                          //------------------ 
				}
			}
			}
		});
		
		
		
		
		  // -------------------------------         设置button 大小
		Dimension preferredSize = new Dimension(100,20);      
        addUser.setPreferredSize(preferredSize);
		jll2.add(addUser);
		
		//Group id and add group button                       ------------second line
      	group = new JTextField(20);
		group.setText("Group ID");
        jll2.add(group);
        
        addGroup = new JButton("Add group");
        addGroup.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		jlist.addMouseListener(mouseListener);
        		addGroupActionPerformend(arg0);
        		
        	}
        	
        	private void addGroupActionPerformend(ActionEvent arg0)
        	{
        		
        		if(arg0.getSource()== addGroup)
        		{
        			 if(win1.getText().startsWith("- Group"))//singleUser.get(index)
    				{
    					if(!singleUser.contains(" " +"- Group "+ group.getText()))
    					singleUser.addElement(" " +"- Group " + group.getText());
    				}
        			
        			
        			
        			else if(singleUser.isEmpty())
        			{
        				
        				singleUser.addElement("Root");
        				singleUser.addElement("- Group "+ group.getText());
        				g++;
        				
        			}
        			else if (!singleUser.contains("- Group "+ group.getText())&& !singleUser.isEmpty())
        			{
        				singleUser.addElement("- Group "+ group.getText());
        				g++;
        			}
        			
        			
    				else if(win1.getText().startsWith("Root")&&!singleUser.contains("- Group "+ group.getText())) 
    				{
    					singleUser.addElement("- Group "+ group.getText());
    					g++;
    				}
        			else
        			{
        				
        			}
        			
        			
        		}
        	}
        	
        	
        });
        
        
        
        
        
        
        Dimension preferredSize1 = new Dimension(100,20);
        addGroup.setPreferredSize(preferredSize1);
        jll2.add(addGroup);
        
        
		// 设置 open user view 按钮                                         ----------------------
        openUser = new JButton("Open User View");
        
        
        
        
        
        openUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		
        		jlist.addMouseListener(mouseListener);
        		JFrame frame1 = new JFrame(win1.getText()); 
        		//new window
        		
        		   
 		
        		     JPanel jll3 = new JPanel();
        		      jll3.setLocation(0,0);
        		      jll3.setSize(300,30);
        		      
        		      JPanel jll4 = new JPanel(); 
        		      jll4.setLocation(3, 40);
        		      jll4.setSize(300,140);
        		      
        		      jll4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));   // set border
        		      
        		      
        		      JPanel jll5 = new JPanel(); 
        		      jll5.setLocation(0, 200);
        		      jll5.setSize(300,30);
        		      
        		      JPanel jll6 = new JPanel(); 
        		      jll6.setLocation(3, 240);
        		      jll6.setSize(300,140);
        		      jll6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));  // set border
        		      
        		      
        		      
        		      JPanel jll7 = new JPanel();
        		      jll7.setLocation(0,350);
        		      jll7.setSize(300,5);
        		    		  
        		  /*    frame1.getContentPane().add(jll3);
        		      frame1.getContentPane().add(jll4);
        		      frame1.getContentPane().add(jll5);
        		      frame1.getContentPane().add(jll6);
        		      frame1.getContentPane().add(jll7);
        		      */
            // //  --------------------------------------------------------- J list	
          			// list  default list model 
          				JLabel ListName = new JLabel("List View ",JLabel.LEFT);
          				
          				
          				ListName.setFont(new Font("SimSun", Font.BOLD, 10));
          				jll4.add(ListName);
          				
          				DefaultListModel <String> friend= new DefaultListModel<String>();
          				
          				JList jlist2 = new JList(friend);
          				 
          				jll4.add(jlist2);
        		      
               //设置第四行 ---------------------------------
        				JLabel ListMo = new JLabel("List View ",JLabel.LEFT);
        				ListMo.setFont(new Font("SimSun", Font.BOLD, 10));
        				jll6.add(ListMo);
        				
        				DefaultListModel <String>listView= new DefaultListModel<String>();
        				 
        				  JList jlist3 = new JList(listView);
        				  
        				   jll6.add(jlist3);
        		      
        		      
        		      
        		      
         //  设置第一行           ---------------------------------------第一行 TextArea ID Button
        		    
        		      //--------------------------------TextField
        		      JTextField ID = new JTextField(10);                 
        				ID.setText("User ID");
        				jll3.add(ID);
        			  // --------------------------------JButton 设置
        		      JButton followUser = new JButton("Follow User");
        		     
         // 第一行中的button编辑 ------------------------------------frame1.addMouseListener(mouseListener1); 
        		      followUser.addActionListener(new ActionListener() {                   
        					
							public void actionPerformed(ActionEvent arg0) {
        						
        						followUserActionPerformend(arg0);
        					 
        					}
        					
        			private void followUserActionPerformend(ActionEvent arg0) {
        		      
        		           if(arg0.getSource()== followUser)
                         {
        		        	  if(singleUser.contains("- " +ID.getText())&& !win1.getText().contains("- "+ID.getText()))
        		        	  {
        		        		  if(!friend.contains(ID.getText()))
        		        		  {    
        		        			 
        		        			  friend.addElement(ID.getText());
        		        			  
        		        			
        		        			  element.setName(ID.getText());
        		        			  
        		        			  element.addObserver(new Nobserver(win1.getText()));
        		        			  element.addObserver(new Nobserver("- " + ID.getText()));
        		        		  
        		        		  }
        		        	  }
  
        		        	   
        		           }
        		      
        		      
        		      
        		}
        		      
        		      
        	});
        		      
 
        		      Dimension preferredSize2 = new Dimension(150,20);      
        		        followUser.setPreferredSize(preferredSize2);
        				jll3.add(followUser);
        		      
        		     
			
        				
        				
       //  Button-----------------------------------  Button 
        				
        				JTextField txt = new JTextField(10);                 
        				txt.setText("Tweet Message");
        				jll5.add(txt);
        			  // --------------------------------JButton 设置
        		      JButton post = new JButton("Post Tweet");
        		      
        		      
        		      
         //Button----------------------------------------------------------------  listener-    		      
        		      
        		      post.addActionListener(new ActionListener() {                   
      					public void actionPerformed(ActionEvent arg0) {
      						
      					PostActionPerformend(arg0);
      					
      					}
      					
      			private void PostActionPerformend(ActionEvent arg0) {
      		     
      				
      				       element.setMoment(txt.getText());
      				     
      				   
      					listView.addElement(win1.getText() + ":" + element.getMoment());
      						 
      				
      		      
      		}
      		      
      		      
      	}); 
        		      
        		      
        		      
        		      
	      
        		      
        		      Dimension preferredSize3 = new Dimension(170,20);      
        		        post.setPreferredSize(preferredSize3);
        				jll5.add(post);
        				
        		   
        				
        				  frame1.setSize(320, 450);  
            		      frame1.setLocationRelativeTo(null);  //放中间
            		      frame1.setVisible(true);
        				  frame1.getContentPane().add(jll3);
            		      frame1.getContentPane().add(jll4);
            		      frame1.getContentPane().add(jll5);
            		      frame1.getContentPane().add(jll6);
            		      frame1.getContentPane().add(jll7);
        				  
            		      
            		      
        		      
        		
        	}
        });
        
        
        
        
        
        
        
        
        
        Dimension preferredSize2 = new Dimension(280,20);
        openUser.setPreferredSize(preferredSize2);

        jll2.add(openUser);
        
        // -----------------------------------------------------picture
        
        image = new JLabel(new ImageIcon("image/twitter5.jpg"));
        jll2.add(image);
        
        
        // ----------------------------------------------------Jtext
        
           jta = new JTextArea(5,30);
           jll2.add(jta);
        
        

        

        
         // 4button                                  --------------------
        
        userTotal = new JButton("Show User Total");

       
        //  Show user button
        userTotal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		userTotalActionPerformend(arg0);
        	}
        	
        	private void userTotalActionPerformend(ActionEvent arg0)
        	{
        		
        		String s ="The total number of Twittwer Users is ";
        		jta.append(s);
        		
        		jta.append(Integer.toString(u)+ "\n");
        		
        	}
        	
        	
        	
        	
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        userTotal.setBounds(200,250, 20,20);
        jll2.add(userTotal);
        groupTotal = new JButton("Show Group Total");
        
        
        
   // Define the groupTotal button ----------------------------------     
        groupTotal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		groupTotalActionPerformend(arg0);
            	
            	
        	}
        	private void groupTotalActionPerformend(ActionEvent arg0)
        	{
        		
        		String s ="The total number of Twittwer Groups is ";
        		jta.append(s);
        		
        		jta.append(Integer.toString(g)+ "\n");
        		
        	}
        	
        });
        
        
        
        
        
        
        jll2.add(groupTotal);
        messageTotal = new JButton("Show message Total");
        jll2.add(messageTotal);
        percentage = new JButton("Show positive Percentage");
        jll2.add(percentage);
        
        

		//size 
		getContentPane().add(jsp);
		this.setSize(500,400);
		this.setLocation(200, 200);
		this.setVisible(true);
		
		
	}
	
	
	
	public static void main(String[]args)
	{
		windows w1 = new windows();
	}

}
