import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class taskGUI{
    DefaultListModel<String> taskModel=new DefaultListModel<>();
    JList<String> tasklist=new JList<>(taskModel);
    JTextField taskfeild=new JTextField(20);
    public taskGUI(){
        JFrame frame=new JFrame("task traker");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel toppanel=new JPanel();
        JButton addButton=new JButton("ADD");
        toppanel.add(taskfeild);
        toppanel.add(addButton);
        JScrollPane scrollpane=new JScrollPane(tasklist);
        JPanel bottompanel =new JPanel();
        JButton deletebutton=new JButton("Delete");
        JButton complete=new JButton("complete");
        bottompanel.add(deletebutton);
        bottompanel.add(complete);
        frame.add(toppanel,BorderLayout.NORTH);
        frame.add(scrollpane,BorderLayout.CENTER);
        frame.add(bottompanel,BorderLayout.SOUTH);
        addButton.addActionListener(e->addtask());
        deletebutton.addActionListener(e->deletetask());
        complete.addActionListener(e->complete());
        frame.setVisible(true);
    }
        void addtask(){
            String task=taskfeild.getText().trim();
            if(!task.isEmpty()){
                taskModel.addElement("[ ]"+task);
                taskfeild.setText("");
            }
         }
         void deletetask(){
            int index=tasklist.getSelectedIndex();
            if(index!=-1){
                taskModel.remove(index);

            }
         }
         void complete(){
            int index=tasklist.getSelectedIndex();
            if(index!=-1){
                String task=taskModel.get(index);
                if(!task.startsWith("[\u2714]")){
                    taskModel.set(index,task.replace("[ ]","[\u2714]"));
                }
            }
         }
         public static void main(String[] args) {
            SwingUtilities.invokeLater(taskGUI::new);
         }


    

}