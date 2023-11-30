package com.example.teachersms;


import sources.ClassTeacher;
import sources.Teacher;
import sources.TeacherCondition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML private void close() {
        System.exit(0);
    }
    //dwie tabele
    @FXML TableView<Teacher> teacherTable;
    @FXML TableView<ClassTeacher> classteacherTable;

    //kolumny w teacherTable
    @FXML private TableColumn<Teacher, String> imieColumn = new TableColumn<>("Imie");
    @FXML private TableColumn<Teacher, String> nazwiskoColumn = new TableColumn<>("Nazwisko");
    @FXML private TableColumn<Teacher, Double> salaryColumn = new TableColumn<>("Wynagrodzenie");
    @FXML private TableColumn<Teacher, Integer> YearColumn = new TableColumn<>("Rok");
    @FXML private TableColumn<Teacher, TeacherCondition> conditionColumn = new TableColumn<>("Stan");
    //kolumny w classteacherTable
    @FXML TableColumn<ClassTeacher, String> nazwaColumn = new TableColumn<>("Nazwa");
    @FXML TableColumn<ClassTeacher, Double> maksColumn = new TableColumn<>("Maks");
    @FXML TableColumn<ClassTeacher, Double> iloscColumn = new TableColumn<>("Zapełnienie");

    //pola tekstowe
    @FXML public TextField textfieldName;
    @FXML private TextField  textfieldSurname;
    @FXML private TextField  textfieldSalary;
    @FXML private TextField  textfieldYear;
    @FXML private ChoiceBox<TeacherCondition>  textfieldCondition;
    @FXML private TextField filterField;
    @FXML private ComboBox comboGroup;
    @FXML private  ObservableList<ClassTeacher> groups = FXCollections.observableArrayList();
    @FXML private  ObservableList<Teacher> teachers = FXCollections.observableArrayList();



    public void initialize() {

        //teacherTable
        teachers.add(new Teacher("Snow", TeacherCondition.PRESENT, "White", 1988, 4000));
        teachers.add(new Teacher("Mickey", TeacherCondition.SICK, "Mouse", 1947, 2000));
        teachers.add(new Teacher("Johnny", TeacherCondition.HOLIDAYS, "Bravo", 1987, 25000));
        teachers.add(new Teacher("Scooby", TeacherCondition.PRESENT, "Doo", 2002, 2100));
        teachers.add(new Teacher("Ariel", TeacherCondition.DELEGATION, "TheMermaid", 1968, 2060));
        teachers.add(new Teacher("Jerry", TeacherCondition.ABSENT, "TheMouse", 1939, 3000));
        teachers.add(new Teacher("Olinek", TeacherCondition.PRESENT, "Okraglinek", 1962, 10000));
        teachers.add(new Teacher("John", TeacherCondition.SICK, "Doe", 1980, 2005));
        teachers.add(new Teacher("Alice", TeacherCondition.PRESENT, "Smith", 1990, 23010));
        teachers.add(new Teacher("Bob", TeacherCondition.DELEGATION, "Johnson", 1975, 7015));
        teachers.add(new Teacher("Ella", TeacherCondition.PRESENT, "Davis", 2000, 1022));

        imieColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Name"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Surname"));
        conditionColumn.setCellValueFactory(new PropertyValueFactory<Teacher, TeacherCondition>("Condition"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Double>("Salary"));
        YearColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("year_of_birth"));
        teacherTable.getColumns().addAll(imieColumn, nazwiskoColumn, salaryColumn, YearColumn, conditionColumn);

        teacherTable.setItems(teachers);
        teacherTable.setEditable(true);

        //filtrowanie w teacherTable
        FilteredList<Teacher> filteredData = new FilteredList<>(teachers, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(teacher -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (teacher.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (teacher.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(teacher.getSalary()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
        });

        SortedList<Teacher> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(teacherTable.comparatorProperty());
        teacherTable.setItems(sortedData);


        textfieldCondition.getItems().addAll(TeacherCondition.values());

        //classteacherTable
        groups.add(new ClassTeacher("...", 1000));
        groups.add(new ClassTeacher("Polonisci", 10));
        groups.add(new ClassTeacher("Matematycy", 10));
        groups.add(new ClassTeacher("Biolodzy", 10));
        groups.add(new ClassTeacher("Historycy", 10));
        groups.add(new ClassTeacher("Fizycy", 10));

        try {
            groups.get(1).addTeacher(teachers.get(0));
            groups.get(1).addTeacher(teachers.get(1));
            groups.get(2).addTeacher(teachers.get(2));
            groups.get(3).addTeacher(teachers.get(3));
            groups.get(4).addTeacher(teachers.get(4));
            groups.get(5).addTeacher(teachers.get(5));
            groups.get(1).addTeacher(teachers.get(6));
            groups.get(2).addTeacher(teachers.get(7));
            groups.get(3).addTeacher(teachers.get(8));
            groups.get(4).addTeacher(teachers.get(9));
            groups.get(2).addTeacher(teachers.get(10));
            groups.get(3).addTeacher(teachers.get(0));

            groups.get(0).addTeacher(teachers.get(0));
            groups.get(0).addTeacher(teachers.get(1));
            groups.get(0).addTeacher(teachers.get(2));
            groups.get(0).addTeacher(teachers.get(3));
            groups.get(0).addTeacher(teachers.get(4));
            groups.get(0).addTeacher(teachers.get(5));
            groups.get(0).addTeacher(teachers.get(6));
            groups.get(0).addTeacher(teachers.get(7));
            groups.get(0).addTeacher(teachers.get(8));
            groups.get(0).addTeacher(teachers.get(9));
            groups.get(0).addTeacher(teachers.get(10));



        } catch (Exception e) {
            System.out.println(e);
        }


        nazwaColumn.setCellValueFactory(new PropertyValueFactory<ClassTeacher, String>("group_name"));
        maksColumn.setCellValueFactory(new PropertyValueFactory<ClassTeacher, Double>("max_amount"));
        iloscColumn.setCellValueFactory(new PropertyValueFactory<ClassTeacher, Double>("ilosc"));

        classteacherTable.getColumns().addAll(nazwaColumn,maksColumn, iloscColumn);

        comboGroup.setItems(groups);
        classteacherTable.setItems(groups);
    }


    public void buttonRemove(ActionEvent event){
        ObservableList<Teacher> allteachers, singleteacher;
        allteachers= teacherTable.getItems();
        singleteacher= teacherTable.getSelectionModel().getSelectedItems();
        singleteacher.forEach(allteachers::remove);
    }

    //obsluga przyciskow
    public void buttonAdd(ActionEvent event){
        Teacher teacher = new Teacher(textfieldName.getText(), textfieldCondition.getValue(), textfieldSurname.getText(), Integer.parseInt(textfieldYear.getText()), Double.parseDouble(textfieldSalary.getText()));
        teacherTable.getItems().add(teacher);
        groups.get(0).addTeacher(teacher);
    }

    @FXML
    public void submit(ActionEvent e){
        ObservableList<Teacher> currentTableData = teacherTable.getItems();
        String currteachername = textfieldSurname.getText();

        for(Teacher teach: currentTableData) {
            if (teach.getSurname().equals(currteachername)) {
                teach.setSurname(textfieldSurname.getText());
                teach.setName(textfieldName.getText());
                teach.setSalary(Double.parseDouble(textfieldSalary.getText()));
                teach.setCondition(textfieldCondition.getValue());

                teacherTable.setItems(currentTableData);
                teacherTable.refresh();
                break;
            }
        }

    }

    //obsluga nacisniecia na kolumne w teacherTable
    public void rowClicked(MouseEvent e){
        Teacher clickedTeacher = teacherTable.getSelectionModel().getSelectedItem();
        textfieldName.setText(String.valueOf(clickedTeacher.getName()));
        textfieldSurname.setText(String.valueOf(clickedTeacher.getSurname()));
        textfieldSalary.setText(String.valueOf(clickedTeacher.getSalary()));
        textfieldYear.setText(String.valueOf(clickedTeacher.getYear_of_birth()));
    }

    //wyswietlenie nauczycieli z poszczegolnych grup w teacherTable
    public void displayGroups(ActionEvent event) {

        ObservableList<ClassTeacher> currentTableData = classteacherTable.getItems();
        String selectedClassTeacher =  comboGroup.getSelectionModel().getSelectedItem().toString();
        System.out.println(selectedClassTeacher);
        ObservableList<Teacher> newtemp = FXCollections.observableArrayList();
        for(ClassTeacher clas: currentTableData){
            System.out.println(clas.getTeachers());
            if (selectedClassTeacher.equals(clas.getGroup_name())) {
                for(Teacher teach: clas.getTeachers()){
                    newtemp.add(teach);
                }

                teacherTable.setItems(newtemp);
                teacherTable.refresh();
                break;
            }
        }

    }
}