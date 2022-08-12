package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtomColumnCellRenderer extends DefaultTableCellRenderer {
    
     private String buttonType;

    public ButtomColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    ///devolve o componente que será mostrado na tabela
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        ///pega da classe pai o componente que vai ser renderizado
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        ///CUSTOMIZAÇÕES
        
        ///Alinha a label no centro
        label.setHorizontalAlignment(JLabel.CENTER);
        
        ///seta um icone, criando uma nova imagem pegando o icone de uma pasta.
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png"))); ///buttonType e o nome do arquivo png.

        //Return the JLabel which renders the cell.
        return label;
    }
    
}
