package ru.gb.jseminar;

import ru.gb.jseminar.data.Notebook;

import java.util.*;
import java.util.logging.Logger;

public class Homework {

    // 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    // 2) Создать множество ноутбуков.
    // 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
    //      ноутбуки, отвечающие фильтру.
    //      Пример: 1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет
    // 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
    public static void main(String[] args) {

        Homework hw = new Homework();

        Map<String, String> result = new HashMap<>();
        result.put("OS".toLowerCase(), "windows");

        hw.printNotebookList(hw.filter(result, hw.initListNotebooks()));

    }

    public List<Notebook> initListNotebooks(){

        Notebook notebook1 = new Notebook("HP", "4525s", 512, 16, "brown", "Windows");
        Notebook notebook2 = new Notebook("Lenovo", "Legion", 1024, 32, "black", "Windows");
        Notebook notebook3 = new Notebook("Asus", "Vivobook", 256, 16, "black", "Linux");
        Notebook notebook4 = new Notebook("HP", "Pavilion", 256, 8, "silver", "Linux");

        List<Notebook> notebookList = new ArrayList<>();
        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);
        notebookList.add(notebook4);

        return notebookList;
    }

    public List<Notebook> filter(Map<String, String> params, List<Notebook> notebookList){
        List<Notebook> filteredList = new ArrayList<>();
        boolean flag = true;

        for (Notebook notebook: notebookList) {
            Map<String, String> specification = notebook.getSpecification();
            for (String item: params.keySet()) {
                if (specification.containsKey(item)) {
                    if (!params.get(item).equals(specification.get(item))) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                filteredList.add(notebook);
            }
        }

        return filteredList;
    }

    public void printNotebookList(List<Notebook> notebookList) {
        Logger log = Logger.getLogger(Homework.class.getName());

        for (Notebook item: notebookList) {
            log.info(item.toString());
        }
    }

}
