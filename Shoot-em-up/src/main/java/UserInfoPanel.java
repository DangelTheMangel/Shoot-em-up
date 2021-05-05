import javax.swing.*;

public class UserInfoPanel {
    JFrame f;
    String name;
    UserInfoPanel(){
        f=new JFrame();
        name= JOptionPane.showInputDialog(f,"Enter Name");
    }
    public static void main(String[] args) {
        new UserInfoPanel();
    }
}
