package th2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> listStudents=new ArrayList<>();
        String PATH_FILE="src/th2/list.txt";
        listStudents.add(new Student(1, "Trịnh Đức Toàn", "Hà Nội"));
        listStudents.add(new Student(2, "Lê Việt Dũng", "Phú Thọ"));
        listStudents.add(new Student(3, "Phùng Trung Dũng", "Đà Nẵng"));
        listStudents.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        listStudents.add(new Student(5, "Nguyễn Đồng Chính", "Hải Dương"));
        writeToFile(PATH_FILE,listStudents);
        List<Student> listStdFromReadFile=readDataFromFile(PATH_FILE);
        for (Student i:listStdFromReadFile
             ) {
            System.out.println(i);
        }
    }
    public static void writeToFile(String path , List<Student>list){
        try {
            FileOutputStream fo=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fo);
            oos.writeObject(list);
            oos.close();
            fo.close();
        }catch (Exception i){
            i.printStackTrace();
        }
    }
    public  static List<Student> readDataFromFile(String path){
        List<Student> list=new ArrayList<>();
        try {
          FileInputStream fis=new FileInputStream(path);
          ObjectInputStream ois=new ObjectInputStream(fis);
          list= (List<Student>) ois.readObject();
          ois.close();
          fis.close();
        }catch (Exception i){
            i.printStackTrace();
        }
        return list;
    }
}
