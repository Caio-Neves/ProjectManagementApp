/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DeadlineColumnsCellRenderer extends DefaultTableCellRenderer{
   
    ///esse metodo devolve o componente que vai ser renderizado la na tela.
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        JLabel label;
        
        ///pega da classe pai o componente padrao que vai ser renderizado
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        ///CUSTOMIZAÇÕES
        
        ///alinha a label no centro 
        label.setHorizontalAlignment(CENTER);
        
        ///pega o modelo da tabela
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        
        ///pega as tarefas do modelo
        Task task = taskModel.tasks.get(row);
        
        ///método que altera a cor do background do deadline dependendo se está ou não completo
        //////pega o prazo, cria uma nova data que é a data de hoje e coloca o after.
        ///"se o prazo e depois de hoje"
        if (task.getDeadline().after(new Date())){
            label.setBackground(Color.GREEN);          
        } else{
            label.setBackground(Color.RED);
        }
    return label; ///retorna  label para a tela.
    }
    ///Chamar um objeto dessa classe no método decorateTableTasks para implementar as alterações.

}
