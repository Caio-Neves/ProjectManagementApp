package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
    ///extende para a classe AbstractTableModel.
    public class TaskTableModel extends AbstractTableModel {
    
    ///Editamos nossa coluna que é um vetor de Strings.
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa concluída", "Editar", "Excluir"};
    
    ///criamos uma nova lista de tarefas
    List<Task> tasks = new ArrayList<>();
    
    ///override significa que estamos sobrescrevendo um metodo existente.
    @Override
    public int getRowCount() { ///quantas linhas vai ter nossa tabela
        return tasks.size(); ///pega as listas e seta ali.
    }
    
    @Override
    public int getColumnCount() { ///quantas colunas vai ter nossa jtable
        return columns.length; ///tamanho do nosso vetor.
    }
    
    @Override
    public String getColumnName(int columnIndex){ ///da nome as colunas
        
        return columns[columnIndex]; ///valor setado no vetor String.   
    }
    
    ///metodo que permite colunas a serem editadas.
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 3;
        }
        
    ///metodo que troca o valor booleanoString para um botao de marcacao.
    ///nesse caso ao inves de escrever falso ou verdadeiro coloca um botao.
    @Override
    public Class<?>getColumnClass(int columnIndex){ 
        
        if (tasks.isEmpty()) {/// se a lista for vazia
            return Object.class; ///n exiba nada
        }
            return this.getValueAt(0, columnIndex).getClass(); ///retorna a classe do dado que pegamos da jtable
            ///nesse caso coloca um check no lugar da palavra
    }

    ///metodo que permite a funcionalidade do botao de marcacao.
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){ ///quando clica no botao ele chama esse metodo
        tasks.get(rowIndex).setCompleted((boolean) aValue); ///permite editar o botao boolean
    }
    
    ///metodo que pega os dados com base na coluna e na linha.
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex){
            case 0: 
                return tasks.get(rowIndex).getName(); /// quando a coluna for 1 pega o nome
            case 1:     
                return tasks.get(rowIndex).getDescription(); ///caso 2 pega a descricao
            case 2:
               ///retorna a data para esse formato.
                SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isCompleted();
            case 4:
                return "";
            case 5: 
                return "";
            default: 
                return "Dados não encontrados";      
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
    

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }     
}
